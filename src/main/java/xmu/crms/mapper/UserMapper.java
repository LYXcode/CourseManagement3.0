package xmu.crms.mapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import xmu.crms.entity.School;
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.CourseService;
import xmu.crms.service.SchoolService;

/**
 * UserMapper class
 * 
 * @author 吕柏翰
 * @date 2017/12/21
 */
public class UserMapper {
	/**
	 * 微信登录.
	 * <p>微信登录<br> 
	 * @author 吕柏翰
	 * @param userId 用户Id
	 * @param code 微信小程序/OAuth2授权的Code
	 * @return user 该用户信息
	 */
	public static User signInWeChat(BigInteger userId, String code){
		User result=null;
		User user=new User();
		user.setId(userId);
		user.setWechatId(code);
		SqlSession session = MyBatisUtils.getSqlSession();
        try {
            result = (User) session.selectOne("xmu.crms.mapper.UserMapper.signInWeChat", user);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        return result;
	}
	
	/**
	 * 用户解绑.
	 * <p>解绑账号(j2ee使用)<br>
	 * @author 吕柏翰
	 * @param userId 用户id
	 */
	public static void deleteAccount(BigInteger userId){
		User user=new User();
		SqlSession session = MyBatisUtils.getSqlSession();
		user.setId(userId);
        try {
            session.update("xmu.crms.mapper.UserMapper.deleteAccount", user);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	/**
	 * 手机号登录.
	 * <p>手机号登录 (.Net使用),User中只有phone和password，用于判断用户名密码是否正确<br>
	 * @author 吕柏翰 
	 * @param user 用户信息(手机号Phone和密码Password)
	 * @return user 该用户信息
	 */
	public static User signInPhone(User user)
	{
		User result=null;
		SqlSession session = MyBatisUtils.getSqlSession();
        try {
            result = (User) session.selectOne("xmu.crms.mapper.UserMapper.signInPhone", user);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        return result;
	}
	
	/**
	 * 手机号注册.
	 * <p>手机号注册 (.Net使用),User中只有phone和password，userId是注册后才有并且在数据库自增<br> 
	 * @author 吕柏翰
	 * @param user 用户信息(手机号Phone和密码Password)
	 * @return boolean 是否注册成功
	 */
	public static boolean signUpPhone(User user)
	{
		int key=0;
		SqlSession session = MyBatisUtils.getSqlSession();
        try {
            key=session.insert("xmu.crms.mapper.UserMapper.signUpPhone", user);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        if(key>0) {
        	return true;
        }
        else{
        	return false;
        }
	}
	
	/**
	 * 根据用户Id获取用户的信息.
	 * <p>根据用户Id获取用户的信息<br> 
	 * @author 吕柏翰
	 * @param userId 用户Id
	 * @return user 用户信息
	 */
	public static User getUserByUserId(BigInteger userId)
	{
		User result=null;
		SqlSession session = MyBatisUtils.getSqlSession();
        try {
            result = (User) session.selectOne("xmu.crms.mapper.UserMapper.getUserByUserId", userId);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        return result;
	}
	
	/**
	 * 根据用户名获取用户ID.
	 * <p>根据用户名获取用户ID<br>
	 * @author 吕柏翰
	 * @param userName 用户名
	 * @return userId 用户ID
	 */
	public static List<BigInteger> listUserIdByUserName(String userName)
	{
		List<User> users=null;
		List<BigInteger> result=new ArrayList<BigInteger>();
		SqlSession session = MyBatisUtils.getSqlSession();
        try {
            users = session.selectList("xmu.crms.mapper.UserMapper.listUserIdByUserName", userName);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        for(int i=0;i<users.size();i++){
        	User user=users.get(i);
        	result.add(user.getId());
        }
		return result;
	}
	
	/**
	 * 根据用户ID修改用户信息.
	 * <p>根据用户ID修改用户信息<br> 
	 * @author 吕柏翰
	 * @param userId 用户Id
	 * @param user 用户信息
	 */
	public static void updateUserByUserId(BigInteger userId, User user) 
	{
		SqlSession session = MyBatisUtils.getSqlSession();
		user.setId(userId);
        try {
            session.update("xmu.crms.mapper.UserMapper.updateUserByUserId", user);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	/**
	 * 按班级ID、学号开头、姓名开头获取学生列表.
	 * <p>按班级ID、学号开头、姓名开头获取学生列表<br> 
	 * @author 吕柏翰
	 * @param classId 班级ID
	 * @param numBeginWith 学号开头
	 * @param nameBeginWith 姓名开头
	 * @return list 用户列表
	 */
	public static List<User> listUserByClassId(BigInteger classId,String numBeginWith,
			 String nameBeginWith)
	{
		List<User> result=null;
		SqlSession session = MyBatisUtils.getSqlSession();
		User user=new User();
		user.setId(classId);
		user.setNumber(numBeginWith);
		user.setName(nameBeginWith);
        try {
            result=session.selectList("xmu.crms.mapper.UserMapper.listUserByClassId", user);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
		return result;
	}
	
	/**
	 * 根据用户名获取用户列表.
	 * <p>根据用户名获取用户列表<br> 
	 * @author 吕柏翰
	 * @param userName 用户名
	 * @return list 用户列表
	 */
	public static List<User> listUserByUserName(String userName)
	{
		List<User> users=null;
		SqlSession session = MyBatisUtils.getSqlSession();
        try {
            users = session.selectList("xmu.crms.mapper.UserMapper.listUserIdByUserName", userName);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
		return users;
	}
}
