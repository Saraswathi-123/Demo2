package com.capgemini.jdbcapp.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class DeleteRecord {
	
	public static void main(String[] args) {
		Connection conn= null;
		Statement stmt=null;
		try {
			Driver	driver = new Driver();
			DriverManager.registerDriver(driver);

			//using property file we are doing operation
			FileInputStream input = new FileInputStream("komala.properties");
			Properties pro = new Properties();
			pro.load(input);

			//2
			String dburl="jdbc:mysql://localhost:3306/cg_db";
			conn=DriverManager.getConnection(dburl,"root","root");
			//3

			String query= " delete from emp1 where ename='pooja';";
			stmt=conn.createStatement();
			int count=stmt.executeUpdate(query);
			System.out.println(count);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null) {
					conn.close();
				}
				if (stmt!=null) {
					stmt.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
