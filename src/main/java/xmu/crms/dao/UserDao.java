package xmu.crms.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import xmu.crms.entity.*;
import xmu.crms.mapper.MyBatisUtils;
import xmu.crms.mapper.UserMapper;
/**
 * UserDao class
 * 
 * @author 吕柏翰
 * @date 2017/12/19
 */
public interface UserDao {
	/**
	 * 微信登录.
	 * <p>微信登录<br> 
	 * @author 吕柏翰
	 * @param userId 用户Id
	 * @param code 微信小程序/OAuth2授权的Code
	 * @return user 该用户信息
	 */
	public static User signInWeChat(BigInteger userId, String code){
		return UserMapper.signInWeChat(userId,code);
	}
	
	/**
	 * 用户解绑.
	 * <p>解绑账号(j2ee使用)<br>
	 * @author 吕柏翰
	 * @param userId 用户id
	 */
	public static void deleteAccount(BigInteger userId){
		UserMapper.deleteAccount(userId);
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
		return UserMapper.signInPhone(user);
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
		return UserMapper.signUpPhone(user);
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
		return UserMapper.getUserByUserId(userId);
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
		return UserMapper.listUserIdByUserName(userName);
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
		UserMapper.updateUserByUserId(userId, user);
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
		return UserMapper.listUserByClassId(classId, numBeginWith, nameBeginWith);
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
		return UserMapper.listUserByUserName(userName);
	}
}
