package com.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.domain.Product;

/*
 * 商品管理的dao类
 */
public class ProductDao extends HibernateDaoSupport{

	/*
	 * 保存商品
	 */
	public void save(Product product) {
		System.out.println("Dao中的保存商品的save方法执行了");
		this.getHibernateTemplate().save(product);
	}
}
