package com.asd.framework.db;

import com.asd.framework.QueryPageInfo;

public interface PageSqlParser
{
	public String parse(String sql, QueryPageInfo pageInfo);
}
