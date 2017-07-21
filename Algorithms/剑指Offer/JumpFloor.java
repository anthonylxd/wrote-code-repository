package com.offer;

/*
 * 一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloor {

	//递归
	public int jumpFloor1(int target) {
		if (target < 0) {
			return 0;
		}
		int[] jf = { 0, 1, 2 };
		if (target < 3) {
			return jf[target];
		}
		return jumpFloor1(target - 1) + jumpFloor1(target - 2);
	}
	//非递归
	public long jumpFloor2(int target) {
		if(target < 0){
			return 0;
		}
		int[] jf = { 0, 1, 2 };
		if (target < 3) {
			return jf[target];
		}
        long nReturn = 0L;
        long fibFirst=1L;
        long fibTow=2L;
        for (int i = 3; i <= target; i++)
        {
            nReturn = fibFirst + fibTow;
            fibFirst=fibTow ;
            fibTow = nReturn;
        }
        return nReturn;		
	}
	

	public static void main(String[] args) {
		JumpFloor jfloor = new JumpFloor();
		int size = jfloor.jumpFloor1(4);
		System.out.println(size);
		System.out.println(jfloor.jumpFloor2(4));
	}
}
