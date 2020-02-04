package com.capgemini.jdbcapp.common;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class Deletejdbc2 {

	public static void main(String[] args) {
		Connection conn= null;
		Statement stmt=null;
		try {
		Driver	driver = new Driver();
		DriverManager.registerDriver(driver);
		//Step 2:establish connectivity
		
		String dburl="jdbc:mysql://localhost:3306/cg_db";
		conn=DriverManager.getConnection(dburl,"root","root");
		//Step 3:
		FileOutputStream stream=new FileOutputStream("saras.properties");
		Properties pro=new Properties();
		pro.setProperty("name", "Saraswathi");
		pro.setProperty("mobileno", "9141418080");
		pro.store(stream,"new file");
		System.out.println(" operation done");
		
		String query= " delete from emp_info where ename='saraswathi' or ename='sony';";
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
