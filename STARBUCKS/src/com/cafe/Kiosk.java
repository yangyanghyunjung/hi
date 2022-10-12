package com.cafe;

import java.util.ArrayList;

public class Kiosk {

	public void run() {
		ArrayList<Goods> basket =new ArrayList<>();
		Command cmd = new Command();
		
		kkk:
		while(true) {
			String c = cmd.geco("옵션을 선택하세요.[1:메뉴주문 / 2:매장관리 / e:종료]");
			switch(c) {
			
			case"1":
				System.out.println("====================메뉴주문 페이지=======================");//Menue
				ProcMenue pm = new ProcMenue();
				pm.run(basket);
				break;
			case"2":
				System.out.println("====================매장관리 페이지=======================");//Manage
				Manage pg = new Manage();
				pg.run(basket);
				break;
			
			case"e":
				System.out.println("********************이용해주셔서 감사합니다.****************");
				break kkk;
			}
		}
	}
}
