package com.hao.lesson01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


// 我的第一个JDBC程序
public class jdbcFirstDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.加载驱动
		Class.forName("com.mysql.cj.jdbc.Driver");//固定写法
		
		//2.用户信息和url
		//?useUnicode=true&characterEncoding=utf8&useSSL=false
		String url = "jdbc:mysql://localhost:3306/jdbcstudy?serverTimezone=GMT%2B8";
		String username = "root";
		String password = "1350562074Hl";
		
		
		//3.链接成功，数据库对象
		Connection connection = DriverManager.getConnection(url,username,password);
		
		
		//4.执行SQL对象 statement 执行sql对象
		Statement statement = connection.createStatement();
		
		//5.执行SQL，可能存在结果，查看返回结果
		String sql = "select* from users";
		ResultSet resultset = statement.executeQuery(sql); //返回的结果集
		//返回的结果集，结果集集中封装了我们全部的查询出来的结果
		
		
		while(resultset.next()) {
			System.out.println("id="+resultset.getObject("id"));
			System.out.println("id="+resultset.getObject("NAME"));
			System.out.println("id="+resultset.getObject("PASSWORD"));
			System.out.println("id="+resultset.getObject("email"));
			System.out.println("id="+resultset.getObject("birthday"));
			
		}
		
		//6.释放连接
		resultset.close();
		statement.close();
		connection.close();
		
	}

}
