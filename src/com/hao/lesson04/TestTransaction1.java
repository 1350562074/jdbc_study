package com.hao.lesson04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import utils.JdbcUtils;

public class TestTransaction1 {

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			
			//�ر����ݿ���Զ��ύ���Զ��Ὺ������
			conn.setAutoCommit(false);//��������
			
			String sql = "update users set `password`='111111' where `id` = 2";
			st = conn.prepareStatement(sql);
			st.executeUpdate();
			
			int x = 1/0;
			
			String sql2 = "update users set `password`='222222' where `id` = 3";
			st = conn.prepareStatement(sql2);
			st.executeUpdate();
			
			conn.commit();
			System.out.println("�����ɹ���");
			
		}catch (SQLException e){
			try {//Ĭ�����ʧ����ع�����Ҳ������ʾд����
				conn.rollback();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, st, rs);
		}
 	}

}
