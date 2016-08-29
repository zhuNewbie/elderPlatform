package cn.elderPlatform.login.dao;
import cn.elderPlatform.login.*;
public interface UserDao {
	public boolean insert(User user);
	public User getUserById(int id);
	public User getUserByName(String name);

}
