package com.capgemini.jdbcapp.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyFirstJDBC {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
//load the driver	
		try{
		//	Driver driver= new Driver();
			//DriverManager.registerDriver(driver);
			Class.forName("com.mysql.jdbc.Driver").newInstance(); //2 nd method to load driver
//establish connection via driver
			//String dburl="jdbc:mysql://localhost:3306/cg_db?user=root&password=root";
			 //conn=DriverManager.getConnection(dburl);
			String dburl="jdbc:mysql://localhost:3306/cg_db";
			conn=DriverManager.getConnection(dburl,"root","root");
//isue query
			String query=" select * from movie_info";
			 stmt = conn.createStatement();
			 rs=stmt.executeQuery(query);
//4process result from sql 
			while(rs.next()){
			int mid=rs.getInt("mid");
		    String name=rs.getString("name");
			String rating=rs.getString("rating");
			
							
			System.out.println("mid= "+ mid);
			System.out.println("moviename= "+ name);
			System.out.println("rating= "+ rating);
			System.out.println("-----");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null){
					conn.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(rs!=null){
					rs.close();
				}
					
				}catch(Exception e){
					e.printStackTrace();
			}
		}
	}
}


