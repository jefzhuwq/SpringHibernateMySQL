package main.java.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import main.java.utils.ConnectionHelper;

import org.jooq.DSLContext;

public class DaoBase {
	protected Connection conn =null;
	protected DSLContext create = null;
	
	public void initialize() throws SQLException, ClassNotFoundException {
		conn = ConnectionHelper.getInstance().getConnection();
		create = ConnectionHelper.getInstance().getContext(conn);
	}
}
