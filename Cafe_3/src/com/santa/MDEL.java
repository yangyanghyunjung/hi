package com.santa;

import java.util.ArrayList;
import java.util.Scanner;

public class MDEL {

	public void run(ArrayList<D_OrderList> order, ArrayList<Ds_OrderList> order2, ArrayList<A_OrderList> order3) {
		Scanner sc = new Scanner(System.in);
		ddd: while (true) {
			System.out.println("어떤 메뉴를 삭제하시겠습니까?[1:음료 / 2:디저트 / 3:악세서리 / b:뒤로가기]");
			String c = sc.next();
			switch (c) {

			case "1": // 음료 삭제
				System.out.println("삭제하실 메뉴 번호를 선택하세요.[0:아메리카노 / 1:프라푸치노 / 2:말차라떼 / 3:루이보스티");
				int c1 = sc.nextInt();
				order.remove(c1);
				break;
			case "2":// 디저트 삭제
				System.out.println("삭제하실 메뉴 번호를 선택하세요.[0:당근케잌 / 1:초코머핀 / 2:시저샐러드 / 3:밀트푸딩");
				int c2 = sc.nextInt();
				order2.remove(c2);
				break;
			case "3":// 악세서리 삭제
				System.out.println("삭제하실 메뉴 번호를 선택하세요.[0:자유의여신상텀블러 / 1:에코백 / 2:머그컵 / 3:할머니키링");
				int c3 = sc.nextInt();
				order3.remove(c3);
				break;
			case "b":
				break ddd;
			}
		}
	}

}