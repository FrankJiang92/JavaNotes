package designpattern.strategy;

/**
 * 选择排序策略类
 * @author FrankJiang
 */
public class SelectionSortStrategy implements SortStrategy {

	@Override
	public void sort(int[] input) {
		System.out.println("----->选择排序");
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
