package com.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.SuccessKilled;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled() throws Exception {
		long id = 1L;
		long phone = 15866671703L;
		int insertCount = successKilledDao.insertSuccessKilled(id, phone);
		System.out.println("InsertCount"+insertCount);
		
	}
	
	@Test
	public void testQueryByIdWithSeckill() throws Exception {
		long id = 2L;
		long phone = 15866671703L;
		SuccessKilled successKilled = successKilledDao.queryBuIdWithSeckill(id, phone);
		System.out.println("查询结果"+successKilled+"&&"+successKilled.getSeckill());		
	}
	
}
