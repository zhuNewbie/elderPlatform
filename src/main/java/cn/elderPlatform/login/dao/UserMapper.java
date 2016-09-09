package cn.elderPlatform.login.dao;

import org.apache.ibatis.annotations.Select;

import cn.elderPlatform.login.*;
public interface UserMapper {
	public boolean insert(User user);
	@Select("select * from user where id=#{id}")
	public User getUserById(int id);
	public User getUserByName(String name);

}
