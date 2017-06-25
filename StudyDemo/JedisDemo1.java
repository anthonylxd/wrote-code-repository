package com.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/*
 * Jedis测试
 */
public class JedisDemo1 {

	@Test
	public void demo1() {
		//1、设置IP地址和端口
		Jedis jedis = new Jedis("127.0.0.1",6379);
		//2、保存数据
		jedis.set("name", "StudyJedis");
		//3、获取数据
		String name = jedis.get("name");
		System.out.println("取得值："+name);
		//4、释放资源
		jedis.close();
	}
	
	/*
	 *连接池方式连接 
	 */
	@Test
	public void demo2() {
		//获得连接池的配置对象
		JedisPoolConfig config = new JedisPoolConfig();
		//设置最大连接数
		config.setMaxTotal(30);
		//设置最大空闲连接数
		config.setMaxIdle(10);
		
		//获得连接池
		JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);
		//获得核心对象
		Jedis jedis = null;
		try {
			//通过连接池获得连接
			jedis = jedisPool.getResource();
			//设置数据
			jedis.set("name", "李晓东");
			//获取数据
			String name = jedis.get("name");
			System.out.println("通过连接池方式获得值："+name);
		} catch (Exception e) {

		}finally {
			//释放资源
			if(jedis != null) {
				jedis.close();
			}
			if(jedisPool != null) {
				jedisPool.close();
			}
		}
		
	}
}
