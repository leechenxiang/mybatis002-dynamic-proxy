package com.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.bean.QueryVo;
import com.mybatis.bean.User;
import com.mybatis.bean.UserCustom;
import com.mybatis.mapper.UserMapper;

public class UserMapperTest {

	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 加载配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据mytais的配置创建SqlSessionFactory

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过sqlSession创建代理对象(接口的实现类对象)
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user= userMapper.findUserById(1001);
		System.out.println(user);
	}

	@Test
	public void testFindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过sqlSession创建代理对象(接口的实现类对象)
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserList("lee");
		
		if (!list.isEmpty()) {
			for (User u : list) {
				System.out.println(u.toString());
			}
		}
	}
	
	@Test
	public void insertUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User u1 = new User("nathan.lee.salvatore", 18, "男");
		User u2 = new User("nathan", 22, "男");
		User u3 = new User("leechenxiang", 20, "男");
		User u4 = new User("李晨翔", 19, "男");
		
		userMapper.insertUser(u1);
		userMapper.insertUser(u2);
		userMapper.insertUser(u3);
		userMapper.insertUser(u4);
		
		sqlSession.commit();
	}

	@Test
	public void deleteUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUser(1017);
		
		sqlSession.commit();
	}
	
	@Test
	public void updateUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = new User("李梓琪", 1, "女");
		user.setId(1001);
		userMapper.updateUser(user);
		
		sqlSession.commit();
	}
	
	@Test
	public void testFindUserByBean() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过sqlSession创建代理对象(接口的实现类对象)
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User("lee", 1, "男");
		List<User> list = userMapper.findUserByBean(user);
		
		if (!list.isEmpty()) {
			for (User u : list) {
				System.out.println(u.toString());
			}
		}
	}

	@Test
	public void testFindUserByMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过sqlSession创建代理对象(接口的实现类对象)
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "lee");
		map.put("age", 10);
		List<User> list = userMapper.findUserByMap(map);
		
		if (!list.isEmpty()) {
			for (User u : list) {
				System.out.println(u.toString());
			}
		}
	}
	
	@Test
	public void testFindUserByCustom() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		QueryVo vo = new QueryVo();
		
		User user = new User("lee", 1, "");
		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1001);
		ids.add(1003);
		ids.add(1005);
		ids.add(1007);
		ids.add(1009);
		
		vo.setUser(user);
		vo.setIds(ids);
		
		List<User> list = userMapper.findUserByCustom(vo);
		
		if (!list.isEmpty()) {
			for (User u : list) {
				System.out.println(u.toString());
			}
		}
	}
	
//	@Test
//	public void testFindUserMapByCustom() throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//通过sqlSession创建代理对象(接口的实现类对象)
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//		QueryVo vo = new QueryVo();
//		User user = new User("lee", 1, "男");
//		vo.setUser(user);
//		
//		Map map = userMapper.findUserMapByCustom(vo);
//		for (Object o : map.keySet()) {
//			System.out.println("key=" + o + " value=" + map.get(o));
//		}
//	}
	
	@Test
	public void testUpdateUserSet() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User("lee1", 0, "");
		user.setId(1001);
		userMapper.updateUserSet(user);
		sqlSession.commit();
	}
	
}
