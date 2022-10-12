package com.santa;

import java.util.ArrayList;
import java.util.Scanner;

public class ProcDessert {

	public void run(ArrayList<BASKET> basket,ArrayList<Ds_OrderList> order2) {
		
		Scanner sc = new Scanner(System.in);

		// 고르기를 리스트 출력으로 고르게 하기
//		order2.add(new Dessert("[당근케잌]", 4000));
//		order2.add(new Dessert("[초코머핀]", 1500));
//		order2.add(new Dessert("[시저샐러드]", 6000));
//		order2.add(new Dessert("[밀크푸딩]", 2000));

		bbb:
		while (true) {
			System.out.println("========디저트를 선택하세요=======");
			for (int i = 0; i < order2.size(); i++) {
				System.out.println(order2.get(i).name);
			}
			System.out.println("b:뒤로가기");
			
			System.out.println("============================");
			String cmd = sc.next();
			switch (cmd) {
			case "당근케잌":
				basket.add(new BASKET(order2.get(0).name, order2.get(0).price));
				break;
			case "초코머핀":
				basket.add(new BASKET(order2.get(1).name, order2.get(1).price));
				break;
			case "시저샐러드":
				basket.add(new BASKET(order2.get(2).name, order2.get(2).price));
				break;
			case "밀크푸딩":
				basket.add(new BASKET(order2.get(3).name, order2.get(3).price));
				break;
			case"b"://뒤로가기
			break bbb;	
			}
		}
	}
}
