package it.polito.tdp.yelp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.*;

public class DBConnect {
	
	//public static Connection getConnection() throws SQLException {
	//	String jdbcURL = "jdbc:mariadb://localhost/yelp?user=root&password=1234" ;
	//	Connection conn = DriverManager.getConnection(jdbcURL) ;
	//	return conn;
	//}
	
	static HikariDataSource dataSource; //singleton
	
	public static Connection getConnection() throws SQLException {
		if(dataSource==null) {
			//crea la data source
			dataSource = new HikariDataSource();
			dataSource.setJdbcUrl("jdbc:mariadb://localhost/yelp");
			dataSource.setUsername("root");
			dataSource.setPassword("1234");
		}
		return dataSource.getConnection();
	}
}
