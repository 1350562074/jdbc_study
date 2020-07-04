package com.hao.lesson03;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.PreparedStatement;

import utils.JdbcUtils;

public class TestInsert {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			conn = JdbcUtils.getConnection();
			//����
			//ʹ�ã�ռλ���������
			String sql = " insert into users(id,`NAME`,`PASSWORD`,`email`,`birthday`) values(?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			
			//�ֶ���������ֵ
			st.setInt(1,4); //id
			st.setString(2, "liuhao");
			st.setString(3, "123456");
			st.setString(4, "123456@qq.com");
			st.setDate(5, new java.sql.Date(new Date().getTime()));
			
			int i = st.executeUpdate();
			if(i > 0) {
				System.out.println("����ɹ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

}
