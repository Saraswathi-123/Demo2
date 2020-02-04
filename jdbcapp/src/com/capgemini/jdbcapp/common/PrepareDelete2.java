package com.capgemini.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Driver;

public class PrepareDelete2 {

	public static void main(String[] args) {

		
		Connection conn=null;
		PreparedStatement pstmt =null;

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
			String query="delete from movie_info where id=? ;";
			//7
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,Integer.parseInt(args[0]));
			int count=pstmt.executeUpdate();
			System.out.println(count);
			//4process result from sql 

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


			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}

}


	


