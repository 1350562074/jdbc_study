package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelect {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		//因为在catch中不能捕捉try局部变量
		
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql="select * from users where id = 1";
			rs = st.executeQuery(sql);//查询完毕返回一个数据集
			
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
