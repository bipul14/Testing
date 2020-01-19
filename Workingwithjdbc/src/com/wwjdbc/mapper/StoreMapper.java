package com.wwjdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wwjdbc.entity.Store;

public class StoreMapper {

	public static Store mapStore(ResultSet rs) throws SQLException {
		Store store=new Store();
		store.setStore_name(rs.getString("store_name"));
		store.setContact_number(rs.getString("contact_number"));
		store.setEmail(rs.getString("email_address"));
		store.setAddress_line1(rs.getString("address_line1"));
		store.setAddress_line2(rs.getString("address-line2"));
		store.setCity(rs.getString("city"));
		store.setCountry(rs.getString("country"));
		store.setState(rs.getString("state"));
		store.setZip(rs.getString("zip"));
		
		
		
		return store;
	}
	
}
