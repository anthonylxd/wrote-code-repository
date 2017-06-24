package com.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.dao.SeckillDao;
import com.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class RedisDaoTest {
	private long id = 1;
	@Autowired
	private RedisDao redisDao;
	
	@Autowired
	private SeckillDao seckillDao;
	
	@Test 
	public void testSeckill() throws Exception{
		//get and put
		Seckill seckill = redisDao.getSeckill(id);
		System.out.println("111");
		if(seckill == null) {
			System.out.println("222");
			seckill = seckillDao.queryById(id);
			System.out.println("333");
			if(seckill != null) {
				System.out.println("444"+seckill.getName());
				String result = redisDao.putSeckill(seckill);
				System.out.println("555"+result);
				seckill = redisDao.getSeckill(id);
				System.out.println("666"+seckill);
			}
		}
		
	}
	

}
