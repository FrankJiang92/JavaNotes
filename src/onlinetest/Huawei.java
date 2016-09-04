package onlinetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Huawei {

	public static final String TYPE_P = "p";
	public static final String TYPE_B = "b";
	
	public static void main(String[] args) {
		
		//init money and goods
		Map<String, Good> goodList = new HashMap<String, Good>();
		goodList.put("A1", new Good("A1", 2, 5));
		goodList.put("A2", new Good("A2", 3, 10));
		goodList.put("A3", new Good("A3", 4, 14));
		
		Map<String, Money> moneyList = new HashMap<String, Money>();
		moneyList.put("1", new Money(1, 5));
		moneyList.put("2", new Money(2, 5));
		moneyList.put("5", new Money(5, 3));
	
		System.out.println("===============================");
		System.out.print("A1 " + goodList.get("A1").num + ",");
		System.out.print("A2 " + goodList.get("A1").num + ",");
		System.out.print("A3 " + goodList.get("A1").num + ";");
		System.out.print("1 " + moneyList.get("1").num + ",");
		System.out.print("2 " + moneyList.get("2").num + ",");
		System.out.println("5 " + moneyList.get("5").num);
		
		
		Scanner scan = new Scanner(System.in);
		
		List<String> buyList = new ArrayList<String>();
		
		int allMoney = 0;
		
		String input = scan.nextLine();
		scan.close();
		
		String[] strList = input.split(",");
		
		for (int i = 0; i < strList.length; i++) {
			String temp = strList[i];
			String[] tempList = temp.split(" ");
			String type = tempList[0];
			String name = tempList[1];
			if (type.equals(TYPE_P)) {
				Money moneyName = moneyList.get(name);
				moneyName.num++;
				moneyList.put(name, moneyName);
				allMoney += Integer.parseInt(name);
			} else if (type.equals(TYPE_B)) {
				buyList.add(name);
			}
			
		}
		
		System.out.println("---->" + allMoney);
		int needMoney = 0;
		for (String string : buyList) {
			System.out.println("--------->" + string);
			Good buyGood = goodList.get(string);
			needMoney += buyGood.price;
			buyGood.num--;
			goodList.put(string, buyGood);
		}
		
		int otherMoney = allMoney - needMoney;
		while(otherMoney > 0) {
			if(otherMoney >= 5) {
				otherMoney -= 5;
				Money tempMoney = moneyList.get("5");
				tempMoney.num--;
				moneyList.put("5", tempMoney);
			} else if (otherMoney >= 2){
				otherMoney -= 2;
				Money tempMoney = moneyList.get("2");
				tempMoney.num--;
				moneyList.put("2", tempMoney);
			} else if (otherMoney >= 1){
				otherMoney -= 1;
				Money tempMoney = moneyList.get("1");
				tempMoney.num--;
				moneyList.put("1", tempMoney);
			}
		}
		
		System.out.println("===============================");
		System.out.print("A1 " + goodList.get("A1").num + ",");
		System.out.print("A2 " + goodList.get("A2").num + ",");
		System.out.print("A3 " + goodList.get("A3").num + ";");
		System.out.print("1 " + moneyList.get("1").num + ",");
		System.out.print("2 " + moneyList.get("2").num + ",");
		System.out.println("5 " + moneyList.get("5").num);
	}
	
	public static class Good {
		
		public Good(String name, int price, int num) {
			this.name = name;
			this.price = price;
			this.num = num;
		}
		public String name;
		public int price;
		public int num;
		
		
		
		@Override
		public String toString() {
			return "Good [name=" + name + "]";
		}
		
		
	}

	public static class Money {
		
		public Money(int name, int num) {
			super();
			this.name = name;
			this.num = num;
		}
		public int name;
		public int num;
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
