package com.hao.lesson01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


// �ҵĵ�һ��JDBC����
public class jdbcFirstDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.��������
		Class.forName("com.mysql.cj.jdbc.Driver");//�̶�д��
		
		//2.�û���Ϣ��url
		//?useUnicode=true&characterEncoding=utf8&useSSL=false
		String url = "jdbc:mysql://localhost:3306/jdbcstudy?serverTimezone=GMT%2B8";
		String username = "root";
		String password = "1350562074Hl";
		
		
		//3.���ӳɹ������ݿ����
		Connection connection = DriverManager.getConnection(url,username,password);
		
		
		//4.ִ��SQL���� statement ִ��sql����
		Statement statement = connection.createStatement();
		
		//5.ִ��SQL�����ܴ��ڽ�����鿴���ؽ��
		String sql = "select* from users";
		ResultSet resultset = statement.executeQuery(sql); //���صĽ����
		//���صĽ��������������з�װ������ȫ���Ĳ�ѯ�����Ľ��
		
		
		while(resultset.next()) {
			System.out.println("id="+resultset.getObject("id"));
			System.out.println("id="+resultset.getObject("NAME"));
			System.out.println("id="+resultset.getObject("PASSWORD"));
			System.out.println("id="+resultset.getObject("email"));
			System.out.println("id="+resultset.getObject("birthday"));
			
		}
		
		//6.�ͷ�����
		resultset.close();
		statement.close();
		connection.close();
		
	}

}
