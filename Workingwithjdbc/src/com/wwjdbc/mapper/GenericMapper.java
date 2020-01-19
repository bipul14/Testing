package com.wwjdbc.mapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class GenericMapper {
	public static Object rowtoattributesMapper(ResultSet rs,Properties prop,String classname) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IllegalArgumentException, InvocationTargetException {
		Class cls=null;
		String column;
		String value;
		Method method;
		String setter;
		Object obj;
		cls=Class.forName(classname);
		obj=cls.newInstance();
		for(Object entity:prop.keySet()) {
			setter=prop.getProperty((String) entity);
			value=rs.getString((String)entity);
			try {
				method=cls.getDeclaredMethod(setter, String.class);
				method.invoke(obj, value);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		return obj;
	}

}
