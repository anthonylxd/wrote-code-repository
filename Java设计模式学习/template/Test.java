package com.template;

public class Test {

	public static void main(String[] args) {
		System.out.println("开始");
		RefreshBeverage c = new Coffee();
		RefreshBeverage t = new Tea();
		c.prepareBeverageTemplate();
		System.out.println("********");
		t.prepareBeverageTemplate();
		System.out.println("结束");
	}
}
