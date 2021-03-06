package algorithm.sort.quick;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] input = {1, 4, 3, 2, 5, 1, 3, 4, 5, 9, 2, 5, 8, 7, 6, 4, 5};
		int length = input.length;
		divideSort(input, 0, length - 1);
		System.out.println(Arrays.toString(input));
	}
	
	/**
	 * 快速排序，从小到大
	 * 时间复杂度：O(nlogn)
	 * @param input
	 * @param start
	 * @param end
	 */
	public static void divideSort(int[] input, int start, int end) {
		int pivot = findPivot(input, start, end);
		if (pivot > start)
			divideSort(input, start, pivot - 1);
		if (pivot < end)
			divideSort(input, pivot + 1, end);
	}
	
	/**
	 * 寻找基准值下标
	 * @param input
	 * @param start
	 * @param end
	 * @return
	 */
	public static int findPivot(int[] input, int start, int end) {
		int k = start;
		int pivot = input[start]; //第一个值作为标准值
		
		while(start < end) {
			//从右向左扫描比pivot小的值，找到停止
			while(start < end && input[end] >= pivot) {
				end--;
			}
			
			//从左向右扫描比pivot大的值，找到停止
			while(start < end && input[start] <= pivot) {
				start++;
			}
			//左边第一个比pivot大的与右边第一个比pivot小的交换
			if (start < end) {
				swap(input, start, end);
			}
		}
		
		if (k != start)
			swap(input, k, start);
		
		return start;
	}
	
	public static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
