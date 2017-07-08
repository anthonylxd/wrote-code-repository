package com.sort;

/**学自慕课网
 * 选择排序
 * 简单理解
 *对比数组中前一个元素跟后一个元素的大小，
 *如果后面的元素比前面的元素小则用一个变量k来记住他的位置，
 *接着第二次比较，前面“后一个元素”现变成了“前一个元素”，
 *继续跟他的“后一个元素”进行比较如果后面的元素比他要小则用变量k记住它在数组中的位置(下标)，
 *等到循环结束的时候，我们应该找到了最小的那个数的下标了，
 *然后进行判断，如果这个元素的下标不是第一个元素的下标，
 *就让第一个元素跟他交换一下值，这样就找到整个数组中最小的数了。
 *然后找到数组中第二小的数，让他跟数组中第二个元素交换一下值，
 *以此类推。
 */
public class SelectionSort {

	private SelectionSort() {
	}

	public static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			// 寻找（i，n）区间里最小值的索引
			int minIndex = i;
			for (int j = i + 1; j < n; j++){
				if (arr[j] < arr[minIndex]){
					minIndex = j;
				}
		}
			swap(arr, i, minIndex);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void main(String arg[]) {
		int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		SelectionSort.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
	}
}
