package Datas;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnectionData {
	public Connection connect;
	public SqlConnectionData() throws Exception{
		String hostName = "localhost";
		String dbName = "qlbanhang";
		String userName = "root";
		String password = "1903";
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		//Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection(connectionURL, userName, password);
		
	}
}
