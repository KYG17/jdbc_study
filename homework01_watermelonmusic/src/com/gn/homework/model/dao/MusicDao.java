package com.gn.homework.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

import com.gn.homework.model.vo.Music;

public class MusicDao {
	public int createId(Music mm) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "INSERT INTO wm_user(user_id ,user_pw ,user_name) " 
					+ "VALUES('"+mm.getUserId()+"' ,'"+mm.getUserPw()+"','"+mm.getUserName()+"')";
			result = stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return result;				
		}

}
