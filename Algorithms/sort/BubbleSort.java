package com.sort;
/*
 * 冒泡排序
 * 在要排序的一组数中，
 * 对当前还未排好序的范围内的全部数，
 * 自上而下对相邻的两个数依次进行比较和调整，
 * 让较大的数往下沉，较小的往上冒。
 * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，
 * 就将它们互换。
 */
public class BubbleSort {
	public static int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1]=temp;
				}
			}

		}

		return arr;
	}
}
