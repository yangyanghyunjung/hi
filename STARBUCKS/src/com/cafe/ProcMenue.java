package com.cafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ProcMenue {

	public void run(ArrayList<Goods>basket) {
//		ArrayList<Goods> basket =new ArrayList<>();
		Command cmd = new Command();
		
		kkk:
		while(true) {
			String c = cmd.geco("메뉴를 선택하세요.[1:음료 / 2:디저트 /3:악세서리 / c:계산 / b:뒤로가기]");
			switch(c) {
			case"1"://음료
				System.out.println("음료를 선택하였습니다.");
				ProcDrink pd =new ProcDrink();
				pd.run(basket);
				break;
			case"2"://디저트
				System.out.println("디저트를 선택하였습니다.");
				ProcDessert pds =new ProcDessert();
				pds.run(basket);
				break;
			case"3"://악세서리
				System.out.println("악세서리를 선택하였습니다.");
				ProcAccessory pa =new ProcAccessory();
				pa.run(basket);
				break;
			case"c"://계산
				System.out.println("=========================계산==============================");
				//선택한거 모두 출력
				System.out.println("장바구니:[");
				for(int i =0; i<basket.size();i++) {
					System.out.println(basket.get(i).name);
				}System.out.println("]");
				
				//계산
				System.out.println("<<총 금액:");
				int sum =0;
				for(int i =0; i<basket.size();i++) {
					sum = sum+basket.get(i).price;
				}System.out.println(sum +"원>>");
				
				
				break;
			
			case"b":
				System.out.println("뒤로가기");
				break kkk;
			}
		}
	}
}
