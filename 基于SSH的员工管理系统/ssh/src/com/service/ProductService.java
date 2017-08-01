package com.service;
/*
 * 商品管理的业务service类
 */

import org.springframework.transaction.annotation.Transactional;
import com.dao.ProductDao;
import com.domain.Product;

@Transactional
public class ProductService {

	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	/*
	 * 保存商品
	 */
	public void save(Product product) {
		System.out.println("Service中的save方法执行");
		productDao.save(product);
	}
	
}
