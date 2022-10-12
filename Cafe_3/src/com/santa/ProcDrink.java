package com.santa;

import java.util.ArrayList;
import java.util.Scanner;

public class ProcDrink {
	public void run(ArrayList<BASKET> basket, ArrayList<D_OrderList> order ) {
		 
		Scanner sc = new Scanner(System.in);

		// 고르기를 리스트 출력으로 고르게 하기
//		order.add(new Drink("[아메리카노]", 5000));
//		order.add(new Drink("[프라푸치노]", 5000));
//		order.add(new Drink("[말차라떼]", 5000));
//		order.add(new Drink("[루이보스티]", 5000));
		bbb:
			while (true) {
				
				System.out.println("========음료를 선택하세요=======");
				for (int i = 0; i < order.size(); i++) {
					System.out.println(order.get(i).name);
				}
				System.out.println("b:뒤로가기");
				
				System.out.println("============================");
			String cmd = sc.next();
			switch (cmd) {
			case "아메리카노":
				basket.add(new BASKET(order.get(0).name, order.get(0).price));
				break;
			case "프라푸치노":
				basket.add(new BASKET(order.get(1).name, order.get(1).price));
				break;
			case "말차라떼":
				basket.add(new BASKET(order.get(2).name, order.get(2).price));
				break;
			case "루이보스티":
				basket.add(new BASKET(order.get(3).name, order.get(3).price));
				break;
			case"b"://뒤로가기
			break bbb;	
			
			}
		}
	}
}
