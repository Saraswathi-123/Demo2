package com.capgemini.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class UpdateJdbc2 {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;

		try{
			//load the driver
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			//establish connection via driver
			String dburl="jdbc:mysql://localhost:3306/cg_db";
			conn=DriverManager.getConnection(dburl,"root","root");
			//issue sql query via connection
			String query=" update movie_info set name='kom' where id=165 or id=112 ;";//give one space after
			stmt = conn.createStatement();
			int count=stmt.executeUpdate(query);
			System.out.println(count);



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


			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
