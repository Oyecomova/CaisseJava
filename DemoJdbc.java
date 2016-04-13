package com.objis.demojdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

public class DemoJdbc {

	public static void main(String[] args) {
		sauverEnBase("Jean DUPONT");
	}
	public static void sauverEnBase(String personne){
		String url = "jdbc:mysql://localhost/formation";
		String login = "root";
		String passwd = "";
		Connection cn =null;
		Statement st=null;
		ResultSet rs =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM javadb;";
			//System.out.println(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("personne"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
