package com.test;
@FunctionalInterface
interface m {
	public void p();
}

public class test {
	public static void main(String[] args) {
		m m = () -> System.out.println("123");
		m.p();
		
	}
}