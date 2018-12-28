package com.dao;

import org.apache.ibatis.annotations.Param;

import com.entity.SuccessKilled;

public interface SuccessKilledDao {

	//插入购买明细，可过滤重复
	int insertSuccessKilled(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
	
	//根据id查询SuccessKilled并携带秒杀产品对象实体
	SuccessKilled queryBuIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
}
