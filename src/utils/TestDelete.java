package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestDelete {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();//��ȡ���ݿ�����
			st = conn.createStatement();
			String sql = "delete from users where id = 4";
			int i = st.executeUpdate(sql);
			if(i > 0) {
				System.out.println("ɾ���ɹ���");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, st, rs);
		}
		
	}

}
