package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestUpdate {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();//��ȡ���ݿ�����
			st = conn.createStatement();
			String sql = "update users set `NAME`='hao',`email`='1350562074@qq.com' where id=1";
			int i = st.executeUpdate(sql);
			if(i > 0) {
				System.out.println("���³ɹ���");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, st, rs);
		}
		
	}

}
