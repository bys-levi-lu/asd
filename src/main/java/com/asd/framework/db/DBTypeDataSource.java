package com.asd.framework.db;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class DBTypeDataSource implements DataSource, DBType
{
	private DataSource dataSource;
	
	private String dbType;

	@Override
	public PrintWriter getLogWriter() throws SQLException
	{
		return dataSource.getLogWriter();
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException
	{
		dataSource.setLogWriter(out);
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException
	{
		dataSource.setLoginTimeout(seconds);
	}

	@Override
	public int getLoginTimeout() throws SQLException
	{
		return dataSource.getLoginTimeout();
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException
	{
		return dataSource.getParentLogger();
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException
	{
		return dataSource.unwrap(iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException
	{
		return dataSource.isWrapperFor(iface);
	}

	@Override
	public String getDBType()
	{
		return dbType;
	}
	
	public void setDbType(String dbType)
	{
		this.dbType = dbType;
	}

	@Override
	public Connection getConnection() throws SQLException
	{
		return dataSource.getConnection();
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException
	{
		return dataSource.getConnection(username, password);
	}

	public DataSource getDataSource()
	{
		return dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

}
