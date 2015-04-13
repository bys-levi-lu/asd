package com.asd.framework.db;

public interface PkGenerator
{
	Object getNextPrimaryKey(Class modelClass);
}
