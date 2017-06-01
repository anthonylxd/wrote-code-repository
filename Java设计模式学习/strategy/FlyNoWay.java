package com.strategy;

public class FlyNoWay implements FlyingStragety {

	@Override
	public void performFly() {
		System.out.println("不会飞行");
	}

}
