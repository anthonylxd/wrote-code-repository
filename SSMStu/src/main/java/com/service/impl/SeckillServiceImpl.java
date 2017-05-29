package com.service.impl;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import com.dao.SeckillDao;
import com.dao.SuccessKilledDao;
import com.dto.Exposer;
import com.dto.SeckillExecution;
import com.entity.Seckill;
import com.entity.SuccessKilled;
import com.enums.SeckillStatEnum;
import com.service.SeckillService;
import exception.RepeatKillException;
import exception.SeckillCloseException;
import exception.SeckillException;
@Service
public class SeckillServiceImpl implements SeckillService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	//注入Service依赖
	@Autowired
	private SeckillDao seckillDao;
	
	@Autowired
	private SuccessKilledDao successKilledDao;
	
	// md5盐值字符串，用于混淆MD5
	private final String salt = "a1234567890b";

	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 4);
	}

	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		if (seckill == null) {
			return new Exposer(false, seckillId);
		}
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		// 系统当前时间
		Date nowTime = new Date();
		if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
			return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
		}
		// 转化特定字符串的过程，不可逆
		// String md5 = null;//TODO，之后完成
		String md5 = getMD5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	private String getMD5(long seckillId) {
		String base = seckillId + "/" + salt;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

	@Transactional
	/*
	 * 使用注解控制事务办法的优点：
	 * 1、开发团队达成一致的约定，明确标注事务方法的编程风格
	 * 2、保证事务方法的执行时间尽可能短。不要穿插其它网络操作RPC/HTTP请求或者剥离到事务方法外部
	 * 3、不是所有方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
	 */
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		System.out.println(getMD5(seckillId));
		try {
			if (md5 == null || !md5.equals(getMD5(seckillId))) {
				throw new SeckillException("seckill data rewrite");
			}
			// 执行秒杀逻辑：减库存 - 记录购买行为
			Date nowTime = new Date();

			// 减库存
			int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
			if (updateCount <= 0) {
				// 没有更新到记录,秒杀结束
				throw new SeckillCloseException("seckill is closed");
			} else {
				// 减库存成功，记录购买行为
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				// 唯一验证
				if (insertCount <= 0) {
					// 重复秒杀
					throw new RepeatKillException("seckill is repeated");
				} else {
					// 秒杀成功
					SuccessKilled successKilled = successKilledDao.queryBuIdWithSeckill(seckillId, userPhone);
					return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
				}
			}
		} catch(SeckillCloseException el) {
			throw el;
		}catch (RepeatKillException el2) {
			throw el2;
		}	
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			// 所有编译器异常，转化为运行期异常
			throw new SeckillException("seckill inner error" + e.getMessage());
		}
	}
}
