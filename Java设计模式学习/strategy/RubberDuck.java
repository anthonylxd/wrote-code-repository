package com.strategy;

public class RubberDuck extends Duck{

	public RubberDuck() {
		super();
		super.setFlyingStragety(new FlyNoWay());
	}
	@Override
	public void display() {
		System.out.println("橡胶鸭");
	}
	
	public void quack() {
		System.out.println("呱呱呱");
	}

}
