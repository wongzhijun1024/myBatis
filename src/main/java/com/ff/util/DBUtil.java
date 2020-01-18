package com.ff.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	private static SqlSessionFactory factory = null;
	public static SqlSessionFactory getSqlSessionFactory() {
		try {
			if (factory == null) {
				SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
				InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis.xml");
				factory = builder.build(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return factory;
	}
}
