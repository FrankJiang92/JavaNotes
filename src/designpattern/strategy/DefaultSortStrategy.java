package designpattern.strategy;

/**
 * 默认策略类-冒泡排序
 * @author FrankJiang
 */
public class DefaultSortStrategy implements SortStrategy {

	@Override
	public void sort(int[] input) {
		System.out.println("----->冒泡排序");
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
