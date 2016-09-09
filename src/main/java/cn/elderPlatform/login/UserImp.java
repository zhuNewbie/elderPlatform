package cn.elderPlatform.login;

import org.apache.ibatis.session.SqlSession;

import cn.elderPlatform.login.dao.UserMapper;

public class UserImp implements UserMapper {
	
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	@Override
	public String toString() {
		return "UserImp [sqlSession=" + sqlSession + "]";
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		System.out.println("user insert>>>");
		
		int result = sqlSession.insert("cn.elderPlatform.login.dao.UserMapper.insertUser", user);
		System.out.println("user insert>>>"+result);
		return (result>0);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		System.out.println("user get by id:"+id+"...");
		return sqlSession.getMapper(UserMapper.class).getUserById(id);
		//return (User) this.sqlSession.selectOne("cn.elderPlatform.login.userMapper.getUserById",id);
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		System.out.println("user get by name...");
		return  (User) this.sqlSession.selectOne("cn.elderPlatform.login.dao.UserMapper.getUserByName",name);
		
	}

}
