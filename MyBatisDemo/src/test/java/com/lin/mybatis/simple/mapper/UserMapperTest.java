package com.lin.mybatis.simple.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.lin.mybatis.simple.model.SysRole;
import com.lin.mybatis.simple.model.SysUser;


public class UserMapperTest extends BaseMapperTest {
//	@Test
//	public void testSelectById() {
//		SqlSession sqlSession = getSqlSession();
//		try {
//			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			SysUser user = userMapper.selectById((long) 1);
//			System.out.println(user);
//			Assert.assertNotNull(user);
//			Assert.assertEquals("admin", user.getUserName());
//		} finally {
//			sqlSession.close();
//		}
//	}
//
//	@Test
//	public void testSelectAll() {
//		SqlSession sqlSession = getSqlSession();
//		try {
//			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			List<SysUser> users = userMapper.selectAll();
//			System.out.println(users);
//			Assert.assertNotNull(users);
//			Assert.assertTrue(users.size()>0);
//		} finally {
//			sqlSession.close();
//		}
//	}
//	
//	@Test
//	public void testSelectRolesByUserId() {
//		SqlSession sqlSession = getSqlSession();
//		try {
//			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			List<SysRole> roles = userMapper.selectRolesByUserId((long) 1);
//			System.out.println(roles);
//			Assert.assertNotNull(roles);
//			Assert.assertTrue(roles.size()>0);
//		} finally {
//			sqlSession.close();
//		}
//	}
	
//	@Test
//	public void testInsert() {
//		SqlSession sqlSession = getSqlSession();
//		try {
//			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			
//			SysUser user = new SysUser();
//			user.setUserName("test1");
//			user.setUserPassword("123456");
//			user.setUserEmail("test@qq.com");
//			user.setUserInfo("test info");
//			user.setHeadImg(new byte[] {1,2,3});
//			user.setCreatedAt(new Date(0));
//			System.out.println("hello world");
//			
//			int result = userMapper.insert(user);
//			System.out.println(result);
//			
//			Assert.assertEquals(1, result);
//			Assert.assertNull(user.getId());
//			
//		} finally {
//			// TODO: handle exception
//			sqlSession.commit(); // 先回滚
//			sqlSession.close();
//		}
//	}
	
//	@Test
//	public void testInsert2() {
//		SqlSession sqlSession = getSqlSession();
//		try {
//			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			SysUser sysUser = new SysUser();
//			sysUser.setUserName("test2");
//			sysUser.setUserPassword("123456");
//			sysUser.setUserEmail("test2@qq.com");
//			sysUser.setUserInfo("test2 info");
//			sysUser.setHeadImg(new byte[] {1, 2, 3});
//			sysUser.setCreatedAt(new Date());
//			int result = userMapper.insert2(sysUser);
//			
//			Assert.assertEquals(1, result);
//			Assert.assertNotNull(sysUser.getId());
//			
//		} finally {
//			sqlSession.commit();
//			sqlSession.close();
//		}
//	}
	
//	@Test
//	public void testInsert3() {
//		SqlSession sqlSession = getSqlSession();
//		try {
//			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			SysUser sysUser = new SysUser();
//			sysUser.setUserName("test3");
//			sysUser.setUserPassword("123456");
//			sysUser.setUserEmail("test3@qq.com");
//			sysUser.setUserInfo("test3 info");
//			sysUser.setHeadImg(new byte[] {1, 2, 3});
//			sysUser.setCreatedAt(new Date());
//			int result = userMapper.insert2(sysUser);
//			
//			Assert.assertEquals(1, result);
//			Assert.assertNotNull(sysUser.getId());
//			
//		} finally {
////			sqlSession.commit();
//			sqlSession.rollback();
//			sqlSession.close();
//		}
//	}
	
//	@Test
//	public void testUpdateById() {
//		SqlSession sqlSession = getSqlSession();
//		
//		try {
//			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			SysUser sysUser = userMapper.selectById(1L);
//			
//			Assert.assertEquals("admin", sysUser.getUserName());
//			
//			sysUser.setUserName("admin_test");
//			sysUser.setUserEmail("admin_test@qq.com");
//			sysUser.setCreatedAt(new Date());
//			
//			int result = userMapper.updateById(sysUser);
//			
//			Assert.assertEquals(1, result);
//			
//			sysUser = userMapper.selectById(1L);
//			
//			Assert.assertEquals("admin_test", sysUser.getUserName());
//			
//		} finally {
//			// TODO: handle finally clause
//			System.out.println("hello world");
//			sqlSession.rollback();
//			sqlSession.close();
//		}
//	}
	
	@Test
	public void testDeleteById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user1 = userMapper.selectById(1L);
			
			Assert.assertNotNull(user1);
			Assert.assertEquals(1, userMapper.deleteById(1L));
			Assert.assertNull(userMapper.selectById(1L));
			
			SysUser user2 = userMapper.selectById(1001L);
			
			Assert.assertNotNull(user2);
			Assert.assertEquals(1, userMapper.deleteById(user2));
			
			Assert.assertNull(userMapper.selectById(1001L));
			
			
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserIdAndRoleEnabled() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysRole> userList = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
			Assert.assertNotNull(userList);
			Assert.assertTrue(userList.size()>0);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByUser() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 只查询用户名
			SysUser query = new SysUser();
			query.setUserName("ad");
			List<SysUser> userList = userMapper.selectByUser(query);
			Assert.assertTrue(userList.size() > 0);
			
			// 只查询用户邮箱时
			query = new SysUser();
			query.setUserEmail("test@qq.com");
			userList = userMapper.selectByUser(query);
			Assert.assertTrue(userList.size() > 0);
			
			//同时查询用户和邮箱时
			query = new SysUser();
			query.setUserName("ad");
			query.setUserEmail("test@qq.com");
			userList = userMapper.selectByUser(query);
			Assert.assertTrue(userList.size() == 0);
			
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateByIdSelective() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setId(1L);
			sysUser.setUserEmail("test@qq.com");	
			int result =  userMapper.updateByIdSelective(sysUser);
			Assert.assertEquals(1, result);
			
			sysUser = userMapper.selectById(1L);
			Assert.assertEquals("admin", sysUser.getUserName());
			Assert.assertEquals("test@qq.com", sysUser.getUserEmail());
			
			
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert2Selective() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("test-selective");
			sysUser.setUserPassword("123456");
			sysUser.setUserInfo("test info");
			sysUser.setCreatedAt(new Date());
			userMapper.insert2Selective(sysUser);
			
			sysUser = userMapper.selectById(sysUser.getId());
			Assert.assertEquals("test@qq.com", sysUser.getUserEmail());
			
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	
	@Test
	public void testSelectByIdOrUserName() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			SysUser query = new SysUser();
			query.setId(1L);
			query.setUserName("admin");
			SysUser sysUser = userMapper.selectByIdOrUserName(query);
			Assert.assertNotNull(sysUser);
			
			query.setId(null);
			sysUser = userMapper.selectByIdOrUserName(query);
			Assert.assertNotNull(sysUser);
			
			query.setUserName(null);
			sysUser = userMapper.selectByIdOrUserName(query);
			Assert.assertNull(sysUser);
		} finally {

			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByIdList() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<Long> idList = new ArrayList<Long>();
			idList.add(1L);
			idList.add(1001L);
			
			List<SysUser> userList = userMapper.selectByIdList(idList);
			Assert.assertEquals(2,  userList.size());
			
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsertList() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> sysUsers = new ArrayList<SysUser>();
			for(int i = 0; i < 2;  i++) {
				SysUser sysUser = new SysUser();
				sysUser.setUserName("test" + i);
				sysUser.setUserPassword("123456");
				sysUser.setUserEmail("test@qq.com");
				sysUsers.add(sysUser);
			}
			int result = userMapper.insertList(sysUsers);
			Assert.assertEquals(2, result);
			
			for(SysUser user : sysUsers) 
			{
				System.out.println(user.getId());
			}
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateByMap() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", 1L);
			map.put("user_email", "'test123@qq.com'");
			map.put("user_password", "21312");
			userMapper.updateByMap(map);
			
			SysUser sysUser = userMapper.selectById(1L);
			Assert.assertEquals("test@qq.com", sysUser.getUserEmail());
			
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
}
