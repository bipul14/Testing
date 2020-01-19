package com.wwjdbc.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Dbconnection implements MysqlDbconnection {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		try {
			FileReader fr=new FileReader("META-INF/db.properties");
			Properties dbprop=new Properties();
			dbprop.load(fr);
			driver=dbprop.getProperty("db.driver");
			url=dbprop.getProperty("db.url");
			user=dbprop.getProperty("db.user");
			password=dbprop.getProperty("db.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public  Connection newConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, password);
		return con;
	}

}
