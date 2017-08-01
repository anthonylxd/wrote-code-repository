package com.action;

import com.domain.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.ProductService;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//模型驱动使用的类
	//模板方法把接受的参数存储在product中
	private Product product = new Product();
	@Override
	public Product getModel() {
		return product;
	}
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	/*
	 * 保存商品的执行的方法:save
	 */
	public String save(){
		System.out.println("Action中save方法执行了");
		productService.save(product);
		return NONE;
	}
	
}
