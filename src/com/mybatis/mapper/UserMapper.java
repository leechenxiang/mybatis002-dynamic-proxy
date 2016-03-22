package com.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.mybatis.bean.QueryVo;
import com.mybatis.bean.User;

public interface UserMapper {
	
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserList(String name) throws Exception;
	
	public Integer insertUser(User user) throws Exception;
	
	public void deleteUser(int id) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public List<User> findUserByBean(User user) throws Exception;
	
	public List<User> findUserByMap(Map<String, Object> map) throws Exception;
	
	public List<User> findUserByCustom(QueryVo queryVo) throws Exception;
	
//	public Map findUserMapByCustom(QueryVo queryVo) throws Exception;
	
	public void updateUserSet(User user) throws Exception;
	
}
