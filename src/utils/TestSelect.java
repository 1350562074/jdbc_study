package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelect {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		//��Ϊ��catch�в��ܲ�׽try�ֲ�����
		
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql="select * from users where id = 1";
			rs = st.executeQuery(sql);//��ѯ��Ϸ���һ�����ݼ�
			
			while(rs.next()) {
				System.out.println(rs.getString("NAME"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

}
