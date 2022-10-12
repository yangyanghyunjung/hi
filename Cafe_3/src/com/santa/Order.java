package com.santa;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	
	
	Scanner sc = new Scanner(System.in);

	public void run(ArrayList<BASKET> basket, ArrayList<D_OrderList> order, ArrayList<Ds_OrderList> order2 ,ArrayList<A_OrderList> order3,ArrayList<TotalPrice> tp,ArrayList<TotalSales> ts) {
		bbb:
		while (true) {
			System.out.println("어떤 종류를 선택하시겠습니까?[1.음료 / 2:디저트 / 3:악세서리 / c:계산 / b:뒤로가기");
			String cmd = sc.next();
			switch (cmd) {
			case "1":
				ProcDrink pd = new ProcDrink();
				pd.run(basket,order);
				break;
			case "2":
				ProcDessert ps = new ProcDessert();
				ps.run(basket,order2);
				break;
			case "3":
				ProcAcce pa = new ProcAcce();
				pa.run(basket,order3);
				break;
			case "c":
				System.out.println("================영수증=============");
				System.out.println("\t");
				System.out.println("<주문목록>");
				for(int i=0;i<basket.size();i++) {
					String bn = basket.get(i).name;
					ts.add(new TotalSales(bn));
					System.out.println(bn);
				}
				System.out.println("----------------------------------");
				System.out.println("\t");
				//결제비용
				int sum=0;
				System.out.println("<결제금액>");
				for(int i=0;i<basket.size();i++) {
					sum += basket.get(i).price;
					tp.add(new TotalPrice(sum));
				}
				System.out.println("결제하실 금액은 "+sum+" 원입니다.");
				System.out.println("\t");
				System.out.println("==================================");
				
				//결제끝.
				
				//결제내역을 매상기록
				//결제상품 기록
				
				//초기화 - 장바구니
				basket.clear();
				
				break;
			case"b"://뒤로가기
			break bbb;	
			}
		}
	}

}