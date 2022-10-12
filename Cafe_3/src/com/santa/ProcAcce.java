package com.santa;

import java.util.ArrayList;
import java.util.Scanner;

public class ProcAcce {

	public void run(ArrayList<BASKET> basket,ArrayList<A_OrderList> order3) {
		Scanner sc = new Scanner(System.in);

		// 고르기를 리스트 출력으로 고르게 하기
//		order3.add(new Acce("[자유의여신상텀블러]", 8000));
//		order3.add(new Acce("[에코백]", 3000));
//		order3.add(new Acce("[머그컵]", 6000));
//		order3.add(new Acce("[할머니키링]", 2000));

		bbb:
		while (true) {
			System.out.println("========디저트를 선택하세요=======");
			for (int i = 0; i < order3.size(); i++) {
				System.out.println(order3.get(i).name);
			}
			System.out.println("b:뒤로가기");
			
			System.out.println("============================");
			String cmd = sc.next();
			switch (cmd) {
			case "자유의여신상텀블러":
				basket.add(new BASKET(order3.get(0).name, order3.get(0).price));
				break;
			case "에코백":
				basket.add(new BASKET(order3.get(1).name, order3.get(1).price));
				break;
			case "머그컵":
				basket.add(new BASKET(order3.get(2).name, order3.get(2).price));
				break;
			case "할머니키링":
				basket.add(new BASKET(order3.get(3).name, order3.get(3).price));
				break;
			case"b"://뒤로가기
			break bbb;	
			}
		}
	}
}
