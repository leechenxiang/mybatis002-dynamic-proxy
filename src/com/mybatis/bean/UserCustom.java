package com.mybatis.bean;

/**
 * 扩展User的自定义类
 * 扩展对象以'XxxxCustom'的格式命名
 * 
 * @author leechenxiang
 * @date 2016年3月5日
 *
 */
public class UserCustom extends User {
	
	private String youngOrOld;

	public String getYoungOrOld() {
		return youngOrOld;
	}

	public void setYoungOrOld(String youngOrOld) {
		this.youngOrOld = youngOrOld;
	}
	
}
