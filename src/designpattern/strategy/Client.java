package designpattern.strategy;

import java.util.Arrays;

/**
 * 客户类
 * @author FrankJiang
 */
public class Client {

	public static void main(String[] args) {
		int[] input1 = {2, 4, 1, 9, 0, 3, 3, 2, 8, 6};
		int[] input2 = {2, 4, 1, 9, 0, 3, 3, 2, 8, 6};
		// 使用默认策略类排序
		SortContext context = new SortContext();
		context.sort(input1);
		System.out.println(Arrays.toString(input1));
		
		// 设置选择排序类
		context.setStrategy(new SelectionSortStrategy());
		context.sort(input2);
		System.out.println(Arrays.toString(input2));
	}

}
