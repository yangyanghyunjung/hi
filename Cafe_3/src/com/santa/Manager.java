package com.santa;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	public void run(ArrayList<BASKET>basket,ArrayList<D_OrderList> order, ArrayList<Ds_OrderList> order2 ,ArrayList<A_OrderList> order3,ArrayList<TotalPrice> tp,ArrayList<TotalSales> ts) {
		Scanner sc = new Scanner(System.in);
			mmm:
			while(true) {
			System.out.println("메뉴를 선택하세요.[1:총매출 / 2:메뉴삭제 / b:뒤로가기");
			String cmd = sc.next();
			switch(cmd) {
			case"1"://총매출----수정해야함 총매출,품목 받는 리스트 각각 만들어서 받고 그걸 출력시키기
				System.out.println("=================매출장부===============");
				System.out.println("\t");
				System.out.println("----------------금일 총 매출--------------");
				int sum =0;
				for(int i =0; i<tp.size(); i++ ) {
					sum =sum+tp.get(i).total_sum;
				}System.out.println(sum+" 원");
				
				//총 판매 품목
				System.out.println("--------------금일 판매 리스트 ------------");
				for(int i =0; i<tp.size(); i++ ) {
					System.out.println(ts.get(i).total_sales);
				}
				System.out.println("=================================");

				break;
			case"2"://메뉴삭제
				MDEL del = new MDEL();
				del.run(order, order2, order3);
				break;
			case"b"://뒤로가기
				break mmm;
			}
		}
	}
}
