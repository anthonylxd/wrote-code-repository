package com.strategy;

public class DuckTest {

	public static void main(String[] args) {
		System.out.println("开始测试");
		Duck duck = new MallardDuck();
		Duck duck2 = new RubberDuck();
		duck.display();
		duck.quack();
		duck.fly();
		duck2.display();
		duck2.quack();
		duck2.fly();
		System.out.println("结束测试");
	}

}
