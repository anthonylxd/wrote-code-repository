package com.factory;

public class HairTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	
//		HairInterface left = new LeftHair();
//		left.draw();
		
		HairFactory factory = new HairFactory();
//		HairInterface left= factory.getHair("left");
//		left.draw();
		
//		HairInterface hair = factory.getHairClass("com.factory.RightHair");
//		hair.draw();
		HairInterface hair = factory.getHairClassKey("right");
		hair.draw();
}
}
