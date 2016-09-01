package onlinetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("=============读取行============");
		while(true) {
			String str = scaner.nextLine();
			System.out.println("---------->" + str);
			if (str.equals("!")) {
				break;
			}
			list.add(str);
		}
		System.out.println("----->" + list.size());
		for (String str : list) {
			System.out.println("--->" + str);
		}
		System.out.println("============读取数字============");
		while(true) {
			
		}
	}

}
