package com.cafe;

import java.util.ArrayList;
import java.util.HashMap;

public class ProcDessert {


	public void run(ArrayList<Goods>basket) {
		Command cmd = new Command();
		kkk:
		while(true) {
			String c = cmd.geco("디저트를 선택하세요.[1:당근케잌 / 2:말차마카롱 /3:샌드위치 / b:뒤로가기]");
			switch(c) {
			case"1":
				System.out.println("당근케잌을 선택하였습니다.");
				basket.add(new Dessert("당근케잌" ,3000));
				break;
			case"2":
				System.out.println("말차 마카롱을 선택하였습니다.");
				basket.add(new Dessert("말차마카롱" ,500));
				break;
			case"3":
				System.out.println("샌드위치를 선택하였습니다.");
				basket.add(new Dessert("샌드위치" ,6000));
				break;
			case"b":
				System.out.println("뒤로가기");
				break kkk;
			}
		}
	}
}
