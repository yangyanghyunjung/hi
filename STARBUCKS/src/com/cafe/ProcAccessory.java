package com.cafe;

import java.util.ArrayList;
import java.util.HashMap;

public class ProcAccessory {


	public void run(ArrayList<Goods>basket) {
		Command cmd = new Command();
		kkk:
		while(true) {
			String c = cmd.geco("메뉴를 선택하세요.[1:자유의여신상 텀블러 / 2:에코백 /3:머그잔 / b:뒤로가기]");
			switch(c) {
			case"1":
				System.out.println("자유의여신상 텀블러를 선택하였습니다.");
				basket.add(new Accessory("자유의여신상 텀블러" ,7000));
				break;
			case"2":
				System.out.println("에코백을 선택하였습니다.");
				basket.add(new Accessory("에코백" ,4000));
				break;
			case"3":
				System.out.println("머그잔을 선택하였습니다.");
				basket.add(new Accessory("머그잔" ,5000));
				break;
			case"b":
				System.out.println("뒤로가기");
				break kkk;
			}
		}
	}
}
