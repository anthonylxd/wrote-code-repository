package com.dao;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.entity.Seckill;
/*
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	
	//注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testReduceNumber() throws Exception {
		Date killTime = new Date();
		int updateCount =  seckillDao.reduceNumber(1,killTime);
		System.out.println("updateCount" + updateCount);
	}
	
	@Test
	public void testQueryById() throws Exception {
		long id = 1;
		Seckill seckill = seckillDao.queryById(id);	
		System.out.println("开始"+seckill.getName());
		System.out.println(seckill);
	}
	@Test
	public void testQueryAll() throws Exception {
		List<Seckill> seckills = seckillDao.queryAll(0, 100);
		for(Seckill seckill : seckills) {
			System.out.println(seckill);
		}
	}
}

