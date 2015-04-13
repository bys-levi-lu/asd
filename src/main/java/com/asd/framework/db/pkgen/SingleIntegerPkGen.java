package com.asd.framework.db.pkgen;

import java.lang.annotation.Annotation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

import com.asd.framework.db.DataProccessor;
import com.asd.framework.db.JdbcSupport;
import com.asd.framework.db.PkGenerator;

@Component(value="SingleIntegerPkGen")
public class SingleIntegerPkGen extends JdbcSupport implements PkGenerator
{
	public static final Integer FIRST_SEQ = 1;

	@Override
	public Object getNextPrimaryKey(Class modelClass)
	{
		Annotation annotation = modelClass.getAnnotation(Table.class);
		if (annotation == null)
		{
			throw new IllegalArgumentException("Cannot find @Table annotation on the Class:" + modelClass.getName());
		}
		Table table = (Table)annotation;
		String tableName = table.name();
		UniqueConstraint[] uniqueKeys = table.uniqueConstraints();
		if (uniqueKeys == null || uniqueKeys.length == 0 || uniqueKeys[0].columnNames().length == 0)
		{
			throw new IllegalArgumentException("Cannot find the Primary key difinition on the Class:" + modelClass.getName());
		}
		if (uniqueKeys.length > 1 || uniqueKeys[0].columnNames().length > 1)
		{
			throw new IllegalArgumentException("[SingleIntegerPkGen] don't support composite key");
		}
		
		String pkColumn = uniqueKeys[0].columnNames()[0];
		return getNextIntgerSeq(tableName, pkColumn);
	}
	
	private synchronized Integer getNextIntgerSeq(String table, String pkColumn)
	{
		String sql = "SELECT MAX(" + pkColumn + ") AS MAX_SEQ FROM " + table;
		List<String> results = select(sql, new DataProccessor<String>()
		{
			@Override
			public String populate(ResultSet rs) throws SQLException
			{
				return rs.getString("MAX_SEQ");
			}
		});
		
		if (results == null || results.size() == 0)
		{
			return FIRST_SEQ;
		}
		
		String maxSeqStr = results.get(0);
		Integer maxSeq = Integer.parseInt(maxSeqStr);
		return ++maxSeq;
	}

}
