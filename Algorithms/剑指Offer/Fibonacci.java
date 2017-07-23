package com.offer;

/*
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列、
 * 因数学家列昂纳多·斐波那契
 * 以兔子繁殖为例子而引入，故又称为“兔子数列”，
 * 指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波纳契数列以如下被以递归的方法定义：
 * F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）
 * 现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项。
 */
public class Fibonacci {

	public int Fibonacci1(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return Fibonacci1(n - 1) + Fibonacci1(n - 2);
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(fibonacci.Fibonacci1(6));
	}
}
