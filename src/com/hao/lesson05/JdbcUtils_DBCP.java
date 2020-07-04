package com.hao.lesson05;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class JdbcUtils_DBCP{
	
	private static DataSource dataSource = null;
	//src下的东西都可以通过反射拿到
	static {
		try {
			InputStream in = JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties properties =new Properties();
			properties.load(in);
			
			//创建数据源 工厂模式
			dataSource = BasicDataSourceFactory.createDataSource(properties);
						
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取链接
	public static Connection getConnection() throws Exception {
		return dataSource.getConnection();
	}

	//释放链接资源
	
	public static void release(Connection conn, Statement st, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(st!=null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
