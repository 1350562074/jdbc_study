package com.hao.lesson02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL×¢Èë{
	public static void login(String username, String password) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			
			
			//select * from users where `name`='' or '1=1' and 'password' = '123456';
			//select * from users where `name`='' or '1=1' and 'password' = '' or '1=1';
			String sql = "select * from users where `NAME`='"+username +"' and `password`='"+password+"'";
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("NAME"));
				System.out.println(rs.getString("password"));
				System.out.println("----------------");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}

}

	public static void main(String[] args) {
//		login("hao", "123456");
//		login("'or '1=1", "123456");
		login("'or '1=1", "' or '1=1");
		
	}

}
