package net.jreader.dao.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBManager {
	
	private static DBManager manager;
	private DataSource datasource = null;
	private Properties props = null;
	
	private DBManager () throws Exception {
		props = new Properties();
		InputStream inputStream = DBManager.class.getResourceAsStream("db.properties");
		props.load(inputStream);
		datasource = BasicDataSourceFactory.createDataSource(props);
	}
	
	public synchronized static DBManager getInstance() throws Exception {
		if (manager == null) {
			manager = new DBManager();
		}
		return manager;
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		if(manager.getDataSource() != null) {
			conn = manager.getDataSource().getConnection();
		}
		return conn;
	}
	
	private DataSource getDataSource() {
		return datasource;
	}

}
