package com.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dto.Exposer;
import com.dto.SeckillExecution;
import com.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class SeckillServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SeckillService SeckillService;

	@Test
	public void testGetSeckillList() throws Exception {
		List<Seckill> list = SeckillService.getSeckillList();
		logger.info("list={}", list);
	}

	@Test
	public void testGetById() throws Exception {
		long id = 1;
		Seckill seckill = SeckillService.getById(id);
		logger.info("seckill={}", seckill);
	}

	@Test
	public void testExportSeck() throws Exception {
		long id = 1;
		Exposer exposer = SeckillService.exportSeckillUrl(id);
		if (exposer.isExposed()) {
			logger.info("exposer={}", exposer);
			long phone = 13578941244L;
			String md5 = exposer.getMd5();
			SeckillExecution execution = SeckillService.executeSeckill(id, phone, md5);
			logger.info("result={}", execution);
		}
	}

//	@Test
//	public void testExecuteSeckill() throws Exception {
//		long id = 1;
//		long phone = 13578941234L;
//		String md5 = "6c67aaa0b78b790d5dd65d56c474661c";
//		SeckillExecution execution = SeckillService.executeSeckill(id, phone, md5);
//		logger.info("result={}", execution);
//	}

}
