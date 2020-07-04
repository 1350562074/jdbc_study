package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestInsert {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();//获取数据库连接
			st = conn.createStatement();
			String sql = " insert into users(id,`NAME`,`PASSWORD`,`email`,`birthday`)"+
					"values(4,'haohao','123456','1350562074@qq.com','2020-01-01')";
			int i = st.executeUpdate(sql);
			if(i > 0) {
				System.out.println("插入成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, st, rs);
		}
		
	}

}
