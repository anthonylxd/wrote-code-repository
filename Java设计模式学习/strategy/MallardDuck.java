package com.strategy;

public class MallardDuck extends Duck {

	public MallardDuck() {
		super();
		super.setFlyingStragety(new FlyWithWin());
	}
	
	@Override
	public void display() {
		System.out.println("脖子是绿色的");
	}

}
