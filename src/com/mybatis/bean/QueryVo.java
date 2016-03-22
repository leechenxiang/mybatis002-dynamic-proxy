package com.mybatis.bean;

import java.util.List;

/**
 * 查询的封装类
 * 
 * @author leechenxiang
 * @date 2016年3月5日
 *
 */
public class QueryVo {

	private User user;
	
	private UserCustom uc;
	
	private List<Integer> ids;

	public UserCustom getUc() {
		return uc;
	}

	public void setUc(UserCustom uc) {
		this.uc = uc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

}
