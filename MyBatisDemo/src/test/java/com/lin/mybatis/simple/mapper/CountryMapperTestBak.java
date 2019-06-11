package com.lin.mybatis.simple.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lin.mybatis.simple.model.Country;

public class CountryMapperTestBak {
	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void init() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			List<Country> countryList = sqlSession.selectList("selectAll");
			System.out.println(countryList);
		} finally {
			sqlSession.close();
		}
	}	
	
}
