package com.cafe;

import java.util.ArrayList;

public class ProcDrink {
	int c_count =5;
	public void run(ArrayList<Goods> basket) {
		Command cmd = new Command();
		kkk: while (true) {
			String c = cmd.geco("음료를 선택하세요.[1:커피 / 2:프라푸치노 /3:티 / b:뒤로가기]");
			switch (c) {
			case "1":
				System.out.println("커피를 선택하였습니다.");
				if(c_count==0) {
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!품절!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					break;
				}
				basket.add(new Drink("커피", 4500));
				c_count= c_count-1;	
			
				break;
			case "2":
				System.out.println("프라푸치노를 선택하였습니다.");
				basket.add(new Drink("프라푸치노", 5500));
				break;
			case "3":
				System.out.println("티를 선택하였습니다.");
				basket.add(new Drink("티", 4500));
				break;
			case "b":
				System.out.println("뒤로가기");
				break kkk;

			}
		}
	}
}
