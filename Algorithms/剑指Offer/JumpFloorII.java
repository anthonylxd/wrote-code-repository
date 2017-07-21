package com.offer;

public class JumpFloorII {
	public int jumpFloor1(int target) {
		if (target <= 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		int[] jf = { 0, 1, 2 };
		if (target < 3) {
			return jf[target];
		}
		return 2 * jumpFloor1(target - 1);
	}

	public static void main(String[] args) {
		JumpFloorII jfloor = new JumpFloorII();
		int size = jfloor.jumpFloor1(4);
		System.out.println(size);
	}
}
