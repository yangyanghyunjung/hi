package coco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//1.번호 2.대륙 3.국가 4.일주일 5.총합
public class COCO {


		Scanner sc = new Scanner(System.in);
		Search s = new Search();
		Connection con = null;
		Statement st = null;
		ResultSet result = null;
		// 연동하기
public void run() throws SQLException {
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_board", "root", "admin");
		st = con.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		nnn: while (true) {
			System.out.println(
					"명령을 선택하세요.[1.전체보기 / 2.검색해서보기 / 3.추가하기 / 4.누적 확진자수 가장 높은 나라 / 5.대륙 랭킹 / 6.수정하기 / 7: 삭제하기]");
			String cmd = sc.next();
			switch (cmd) { // 1.전체보기 2.검색해서보기 3.추가하기 4.확진자수 가장 높은 나라 5.가장 적은 나라
			case "1": // 전체보기(select * form)
				System.out.println("----------------------------------전체 확진자 현황-----------------------------------");
				System.out.println("페이지를 입력하세요.");
				String a = sc.next();
				if (a.equals("1")) {
					paging("select * from COVID order by c_no limit 0,5");
				}else if(a.equals("2")) {
					paging("select * from COVID order by c_no limit 5,5");
				}else {
					paging("select * from COVID order by c_no limit 10,5");
				}

				// 페이징
				// 전체 글 수 확인
//					try {
//						result = st.executeQuery("select * from COVID");
//						while(result.next()) {
//							String no = result.getString("c_no");
//							String continent = result.getString("c_continent");
//							String nation = result.getString("c_nation");
//							String week = result.getString("c_week");
//							String total = result.getString("c_total");
//							System.out.println(no+"."+"("+continent+") "+"["+nation+"] "+week+"명 /"+total+"명");
//						}
//					}catch(Exception e) {
//						System.out.println("SQLException:"+e.getMessage());
////						System.out.println("SQLState:"+e.getSQLState());
//					}
				break;
			case "2": // 검색해서보기 (select * from where 검색어)
				s.run(st, result);
				break;
			case "3": // 추가하기 (insert into COVID c_cotinent,c_nation,c_week,c_total) <executeUpdate>
				System.out.println("===============================국가 등록===================================");
				System.out.println("등록할 대륙 입력");
				String up_continent = sc.next();
				System.out.println("등록할  국가 이름 입력");
				String up_nation = sc.next();
				System.out.println("일주일 평균 확진자수 입력");
				String up_week = sc.next();
				System.out.println("총 확진자수 입력");
				String up_total = sc.next();
				try {
					st.executeUpdate("insert into COVID (c_continent,c_nation,c_week,c_total) values('" + up_continent
							+ "','" + up_nation + "','" + up_week + "','" + up_total + "');");
				} catch (SQLException e) {
					System.out.println("SQLException:" + e.getMessage());
						System.out.println("SQLState:" + e.getSQLState());
				}
				break;
			case "4": // 확진자수 가장 높은 나라(select c_nation,c_total from COVID where c_total=
				System.out.println("------------------------------누적 확진자수 가장 많은 나라-----------------------------");
					result = st.executeQuery(
							"select c_nation,c_total from COVID where c_total =(select MAX(c_total) from COVID) ");
					while (result.next()) {
						String m_nation = result.getString("c_nation");
						String m_total = result.getString("c_total");
						System.out.println("[" + m_nation + "] " + "누적 확진자: " + m_total + " 명");
						System.out.println(
								"---------------------------------------------------------------------------------");
					}
				break;
			case "5": // 대륙별 랭킹 내림차순desc(select c_continent, SUM(c_total) from COVID group by
						// c_continent)
				try {
					int ranking = 0;
					result = st.executeQuery(
							"select c_continent, AVG(c_total) from COVID group by c_continent order by AVG(c_total) desc");
					while (result.next()) {
						String r_continent = result.getString("c_continent");
						String r_total = result.getString("AVG(c_total)");
						ranking = ranking + 1;
						System.out.println(ranking + "[" + r_continent + "] " + " " + r_total + " 명");
					}
				} catch (SQLException e) {
					System.out.println("SQLException:" + e.getMessage());
						System.out.println("SQLState:"+e.getSQLState());
				}
				break;
			case "6": // 수정하기(update)
				System.out.println("수정할 나라이름을 입력하세요");
				String re_nation = sc.next();
				System.out.println("수정할 대륙이름을 입력하세요");
				String re_continent = sc.next();
				System.out.println("수정할 일주일 평균 확진자수를 입력하세요");
				String re_week = sc.next();
				System.out.println("수정할 누적확진자수를 입력하세요");
				String re_total = sc.next();

				try {
					int resultCount = st.executeUpdate(
							"update COVID set c_continent='" + re_continent + "',c_nation='" + re_nation + "',c_week='"
									+ re_week + "',c_total='" + re_total + "' where c_nation='" + re_nation + "'");
					System.out.println("처리된 행 수:" + resultCount);
				} catch (SQLException e) {
					System.out.println("SQLException e:" + e.getMessage());
						System.out.println("SQLState:"+e.getSQLState());
				}
				break;
			case "7": // 삭제(delete from)
				System.out.println("삭제할 나라이름을 입력하세요.");
				String del_nation = sc.next();
				try {
					int resultCount = st.executeUpdate("delete from COVID where c_nation='" + del_nation + "'");
					System.out.println("처리된 행 수:" + resultCount);
				} catch (Exception e) {
					System.out.println("SQLException:" + e.getMessage());
//						System.out.println("SQLState:"+e.getSQLState());
				}
				break;

			}
		}
}
		private void paging(String query) {
			try {
				result = st.executeQuery(query);
				while (result.next()) {
					String no = result.getString("c_no");
					String continent = result.getString("c_continent");
					String nation = result.getString("c_nation");
					String week = result.getString("c_week");
					String total = result.getString("c_total");
					System.out.println(
							no + "." + "(" + continent + ") " + "[" + nation + "] " + week + "명 /" + total + "명");
				}
				System.out.println(
						"-------------------------------------------------------------------------------------");
			} catch (SQLException e) {
				System.out.println("SQLException:" + e.getMessage());
				System.out.println("SQLState:" + e.getSQLState());
			}
		}
}
