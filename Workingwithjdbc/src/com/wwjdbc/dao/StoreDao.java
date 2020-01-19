package com.wwjdbc.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.wwjdbc.connection.MsqlDataSource;
import com.wwjdbc.connection.MysqlDbconnection;
import com.wwjdbc.entity.Store;
import com.wwjdbc.mapper.GenericMapper;

public class StoreDao {
	private  final static String query="select * from store";

	public void selectAll() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException {
		MysqlDbconnection conn=new MsqlDataSource();
		Connection con=conn.newConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		List<Store> store=new ArrayList<Store>();
		Properties prop=new Properties();
		prop.load(new FileReader("META-INF/store.properties"));
		while(rs.next()) {
			store.add((Store)GenericMapper.rowtoattributesMapper(rs, prop, "com.wwjdbc.entity.Store"));
		}
		System.out.println(store.get(1).getStore_name());
		
		
	}
}
