package algorithm.sort.bubble;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
		
		
		try {
//			int[] input = {1, 4, 3, 2, 5, 1, 3, 4, 5, 9, 2};
			int[] input = {};
			if (input.length <= 0)
				throw new Exception("ddddddderror!");
			sort(input);
			System.out.println(Arrays.toString(input));
			
			
		} catch (Exception e) {
			System.out.println("------>" + e);
		}
	}

	/**
	 * 冒泡排序，从小到大
	 * 时间复杂度： O(n^2)
	 * 
	 * @param input
	 * 
	 * @author Frank
	 */
	public static void sort(int[] input) {
		int length = input.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (input[i] > input[j]) {
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
	}
}
