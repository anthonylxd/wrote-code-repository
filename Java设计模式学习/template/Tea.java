package com.template;

public class Tea extends RefreshBeverage {

	@Override
	protected void addCondiments() {
		System.out.println("放入柠檬");	
	}

	@Override
	protected void brew() {
		System.out.println("热水泡5分钟");	
	}
	/*
	 * 子类通过覆盖的形式选择挂载钩子函数
	 */
	protected boolean isWantsCondiments() {
		return false;
	}

}
