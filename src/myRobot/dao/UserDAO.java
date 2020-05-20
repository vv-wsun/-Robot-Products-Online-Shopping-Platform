package myRobot.dao;

import myRobot.vo.*;

public interface UserDAO {
	public int queryByUsername(User user) throws Exception;
	public int queryUnique(User user) throws Exception;
	public int add(User user) throws Exception;
	public int identifyEmailAddress(User user) throws Exception;
	public int modifyPassword(String password,String username) throws Exception;
}
