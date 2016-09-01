package onlinetest;

import java.util.ArrayList;
import java.util.Scanner;

public class Huawei {

	public static void main(String[] args) {
		checkString1();
	}

	
	//测试括号成对出现
	public static void checkString1() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		
		char[] charList = input.toCharArray();
		ArrayList<String> stack = new ArrayList<String>();
		for (int i = 0; i < charList.length; i++) {
			if (charList[i] == '(') {
				stack.add(new String(charList, i, 1));
			} else if (charList[i] == ')') {
				if (stack.size() > 0) {
					stack.remove(0);
				} else {
					System.out.println("Error:Mid");
					return;
				}
			}
		}
		
		if (stack.size() > 0) {
			System.out.println("Error:Last");
		} else {
			System.out.println("Success");
		}
	}
	
	public static void checkString2() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		
		char[] charList = input.toCharArray();
		int a = 0;
		int b = 0;
		for(int i = 0; i < charList.length; i++) {
		}
		
	}
	
}
