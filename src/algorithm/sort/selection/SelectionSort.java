package algorithm.sort.selection;

import java.util.Arrays;

public class SelectionSort {

	
	public static void main(String[] args) {
		int[] input = {1, 4, 3, 2, 5, 1, 3, 4, 5, 9, 2};
		sort(input);
		System.out.println(Arrays.toString(input));
	}
	
	/**
	 * 选择排序， 从小到大
	 * 时间复杂度：O(n^2)
	 * 
	 * @param input
	 */
	public static void sort(int[] input) {
		int length = input.length;
		for(int i = 0, k = 0; i < length; i++, k = i) {
			for(int j = i + 1; j < length; j++) {
				if (input[k] > input[j]) {
					k = j;
				}
			}
			
			if (k != i) {
				int temp = input[i];
				input[i] = input[k];
				input[k] = temp;
			}
		}
	}

}
