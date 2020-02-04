package com.capgemini.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Driver;

public class Prepare2jdb {

	public static void main(String[] args) {

		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		//load the driver
		try{
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);

			//establish connection via driver
			//String dburl="jdbc:mysql://localhost:3306/cg_db?user=root&password=root";
			//conn=DriverManager.getConnection(dburl);
			String dburl="jdbc:mysql://localhost:3306/cg_db";
			conn=DriverManager.getConnection(dburl,"root","root");
			//isue query
			String query="select * from movie_info where id=?";
			//7
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,Integer.parseInt(args[0]));
			rs=pstmt.executeQuery();
			//4process result from sql 
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String qwerty=rs.getString("qwerty");


				System.out.println("empid"+id);
				System.out.println("empname"+name);
				System.out.println("empqwerty"+qwerty);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null){
					conn.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(rs!=null){
					rs.close();
				}

			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}
}


