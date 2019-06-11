package com.lin.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lin.mybatis.simple.mapper.UserMapper;
import com.lin.mybatis.simple.model.SysUser;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 这样配置有问题，待解决
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
//		SqlSession sqlSession = sqlSessionFactory.openSession();
		
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		SysUser sysUser = new SysUser();
//		sysUser.setUserName("test2");
//		sysUser.setUserPassword("123456");
//		sysUser.setUserEmail("test@qq.com");
//		sysUser.setHeadImg(new byte[] {1, 2, 3});
////		sysUser.setCreateTime(new Date(0));
//		
//		int result = userMapper.insert(sysUser);
//		
//		System.out.println(result);
		
	}

}