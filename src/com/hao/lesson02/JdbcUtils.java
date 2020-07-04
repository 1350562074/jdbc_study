package com.hao.lesson02;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class JdbcUtils {
	
	private static String driver=null;
	private static String url=null;
	private static String username=null;
	private static String password=null;
	
	//src下的东西都可以通过反射拿到
	static {
		try {
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties =new Properties();
			properties.load(in);
			
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			
			//1.驱动只用加载一次
			Class.forName(driver);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取链接
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url,username,password);
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
	public static void main(String[] args) {

	}

}
