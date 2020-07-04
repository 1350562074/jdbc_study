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
	//src�µĶ���������ͨ�������õ�
	static {
		try {
			InputStream in = JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties properties =new Properties();
			properties.load(in);
			
			//��������Դ ����ģʽ
			dataSource = BasicDataSourceFactory.createDataSource(properties);
						
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��ȡ����
	public static Connection getConnection() throws Exception {
		return dataSource.getConnection();
	}

	//�ͷ�������Դ
	
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
