package main.java.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class ConnectionHelper {
	private static ConnectionHelper instance = null;
	
	private ConnectionHelper() {
		//TODO
	}
	
	public static ConnectionHelper getInstance() {
		if(instance == null) {
	        instance = new ConnectionHelper();
	     }
	     return instance;
	}
	
	public Connection getConnection() throws SQLException {
		String userName = "root";
        String password = "User@123";
        String url = "jdbc:mysql://localhost:3306/findpro?autoReconnect=true";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        Connection conn = DriverManager.getConnection(url, userName, password);
       return conn;
	}
	
	public DSLContext getContext(Connection conn) {
		DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
		return create;
	}
}
