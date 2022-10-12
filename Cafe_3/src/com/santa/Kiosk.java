package com.santa;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
	public void run() {
		Scanner sc = new Scanner(System.in);
		ArrayList<BASKET>basket = new ArrayList<>();
		
		ArrayList<D_OrderList> order = new ArrayList<>();
		
		order.add(new Drink("[아메리카노]", 5000));
		order.add(new Drink("[프라푸치노]", 5000));
		order.add(new Drink("[말차라떼]", 5000));
		order.add(new Drink("[루이보스티]", 5000));
		
		
		ArrayList<Ds_OrderList> order2= new ArrayList<>();
		
		order2.add(new Dessert("[당근케잌]", 4000));
		order2.add(new Dessert("[초코머핀]", 1500));
		order2.add(new Dessert("[시저샐러드]", 6000));
		order2.add(new Dessert("[밀크푸딩]", 2000));
		
		ArrayList<A_OrderList> order3= new ArrayList<>();
		
		order3.add(new Acce("[자유의여신상텀블러]", 8000));
		order3.add(new Acce("[에코백]", 3000));
		order3.add(new Acce("[머그컵]", 6000));
		order3.add(new Acce("[할머니키링]", 2000));
		
		//총 매출 리스트
		ArrayList<TotalPrice> tp =new ArrayList<>();
		ArrayList<TotalSales> ts =new ArrayList<>();
		kkk:
		while (true) {
			System.out.println("무엇을 도와드릴까요?.[1:주문하기 /2:관리자페이지 / e:종료]");
			String cmd = sc.next();
			switch (cmd) {
			case "1":// 주문하기
				Order o = new Order();
				o.run(basket,order,order2,order3,tp,ts);
				break;
			case "2":// 관리자 페이지1
				Manager manager = new Manager();
				manager.run(basket,order,order2,order3,tp,ts);
				break;
			case"e":
				System.out.println("********************이용해주셔서 감사합니다.****************");
				break kkk;

			}
		}
	}
}
