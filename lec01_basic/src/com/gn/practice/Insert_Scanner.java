package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gn.study.model.vo.Test;
//이름 : **홍길동**
//===== test =====
//번호:10, 이름:홍길동, 등록일:2025-01-02 21:44:25
public class Insert_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		Connection conn = null;
		Statement stmt = null;		
		ResultSet rs = null;
		
		try {
			//DriverManager 등록
			Class.forName("org.mariadb.jdbc.Driver");
			//Connection 객채 생성
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			//StateMent 만들기
			stmt = conn.createStatement();
			//쿼리 실어 보내기
			String sql = "INSERT INTO test(t_name) VALUES ('"+name+"')";
			
			int result = stmt.executeUpdate(sql);
			//결과 확인
			if(result > 0) {
				System.out.println("성공");
				System.out.println("=== test ===");
				List<Test>list = new ArrayList<Test>();
				String sql2 = "SELECT * FROM test WHERE t_name ='"+name+"'";
				rs = stmt.executeQuery(sql2);
				while(rs.next()) {
					Test t = new Test(rs.getInt("t_no"),rs.getString("t_name"),rs.getTimestamp("t_date").toLocalDateTime());
					list.add(t)	;
				}
				System.out.println(list);
			}else {
				System.out.println("실패");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
