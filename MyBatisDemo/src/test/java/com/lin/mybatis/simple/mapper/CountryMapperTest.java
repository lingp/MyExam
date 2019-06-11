package com.lin.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.lin.mybatis.simple.model.Country;

public class CountryMapperTest extends BaseMapperTest {
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
			// 因为selectAll不唯一了，所以要加上命名空间
			List<Country> countries = sqlSession.selectList(
					"com.lin.mybatis.simple.mapper.CountryMapper.selectAll");
			System.out.println(countries);
		} finally {
			sqlSession.close();
		}
	}
}
