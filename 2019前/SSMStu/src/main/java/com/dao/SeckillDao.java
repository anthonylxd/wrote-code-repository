package com.dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Seckill;

public interface SeckillDao {

	//减库存
	int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime);
	
	//根据Id查询秒杀商品
	Seckill queryById(long seckillId);
	
	//根据偏移量查询秒杀商品列表
	List<Seckill> queryAll(@Param("offset")int offet,@Param("limit")int limit);
}
