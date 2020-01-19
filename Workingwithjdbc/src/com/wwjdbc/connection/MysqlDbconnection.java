package com.wwjdbc.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface MysqlDbconnection {

	public  Connection newConnection() throws ClassNotFoundException, SQLException ;
}
