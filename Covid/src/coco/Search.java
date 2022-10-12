package coco;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Search {

	public void run(Statement st, ResultSet result) {
		Scanner sc = new Scanner(System.in);
		sss: while (true) {
			System.out.println("[1:나라별 검색 / 2:대륙별 검색 / b:뒤로가기]");
			String cmd = sc.next();
			switch (cmd) {
			case "1": // 나라로 검색
				System.out.println("------------------------------검색하실 나라 이름을 입력해주세요.-----------------------------");
				String serch_n = sc.next();
				try {
					result = st.executeQuery("select * from COVID where c_nation='" + serch_n + "'");
					while (result.next()) {
						String no = result.getString("c_no");
						String nation = result.getString("c_nation");
						String week = result.getString("c_week");
						String total = result.getString("c_total");
						System.out.println(
								no + "." + "[" + nation + "]" + " 일주일 평균:" + week + "명 /" + " 총:" + total + "명");
						System.out.println("-----------------------------------------------------------------------");
					}
				} catch (Exception e) {
					System.out.println("SQLException:" + e.getMessage());
//					 System.out.println("SQLState: " + e.getSQLState());
				}
			case "2": // 대륙으로 검색
				System.out.println(
						"-----------------------------------검색하실 대륙을 입력해주세요--------------------------------------.");
				String search_c = sc.next();
				try {
					result = st.executeQuery("select * from COVID where c_continent like '%"+ search_c +"%' ");
					System.out.println("["+search_c+"]");
					while (result.next()) {
						String no = result.getString("c_no");
						String nation = result.getString("c_nation");
						String week = result.getString("c_week");
						String total = result.getString("c_total");
						System.out.println(
								no + "." + "[" + nation + "]" + " 일주일 평균:" + week + "명 /" + " 총:" + total + "명");
						System.out.println("-----------------------------------------------------------------------");
					}
				} catch (Exception e) {
					System.out.println("SQLException:" + e.getMessage());
//						System.out.println("SQLState:"+e.getSQLState());
				}
			case"b":
				break sss;
				
			}
		}

	}
}
