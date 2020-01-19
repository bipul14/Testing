package com.wwjdbc.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;



import com.mysql.cj.jdbc.MysqlDataSource;


public class MsqlDataSource implements MysqlDbconnection {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	public static MysqlDataSource ds;
	
	static {
		try {
		FileReader fr=new FileReader("META-INF/db.properties");
		Properties dbprop=new Properties();
		dbprop.load(fr);
		ds=new MysqlDataSource();
		
	
		driver=dbprop.getProperty("db.driver");
		url=dbprop.getProperty("db.url");
		user=dbprop.getProperty("db.user");
		password=dbprop.getProperty("db.password");
		ds.setUrl(url);
		ds.setUser(user);
		ds.setPassword(password);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}


	@Override
	public Connection newConnection() throws ClassNotFoundException, SQLException {
		return ds.getConnection();
		
	}

}
