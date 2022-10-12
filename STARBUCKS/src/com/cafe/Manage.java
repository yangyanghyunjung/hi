package com.cafe;

import java.util.ArrayList;

public class Manage {

	public void run(ArrayList<Goods>basket) {

		Command cmd = new Command();
		
		eee:
		while(true) {
			String c = cmd.geco("어떤 서비스를 이용하시겠습니까?? [1:총 판매수량 / 2:총 매출  /p:메뉴추가/ b:뒤로가기/e:마감] ");
			switch(c) {
			
			case"1":
				System.out.println("=======================오늘의 판매수량====================");
				System.out.println(basket.size());
				break;
			case"2":
				System.out.println("======================총매출========================");
				int sum =0;
				for(int i =0; i<basket.size();i++) {
					sum = sum+basket.get(i).price;
				}System.out.println(sum +"원");
				break;
			case"p":
//				String cc =cmd.geco("메뉴추가[1:딸기/2:바나나]");
			case"b":
				System.out.println("뒤로가기");
				break  eee;
			case"e":
				System.out.println("**************************마감******************************");
				break eee;
				
			}
		}
	}
}
