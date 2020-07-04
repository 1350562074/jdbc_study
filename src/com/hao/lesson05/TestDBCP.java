package com.hao.lesson05;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class TestDBCP {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		
		
		try {
			conn = JdbcUtils_DBCP.getConnection();
			//区别
			//使用？占位符代替参数
			String sql = " insert into users(id,`NAME`,`PASSWORD`,`email`,`birthday`) values(?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			
			//手动给参数赋值
			st.setInt(1,5); //id
			st.setString(2, "刘好");
			st.setString(3, "123456");
			st.setString(4, "121212@qq.com");
			st.setDate(5, new java.sql.Date(new Date().getTime()));
			
			int i = st.executeUpdate();
			if(i > 0) {
				System.out.println("插入成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, st, null);
		}
	}

}
