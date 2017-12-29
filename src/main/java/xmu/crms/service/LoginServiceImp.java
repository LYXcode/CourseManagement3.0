package xmu.crms.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import xmu.crms.entity.User;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.dao.UserDao;

/**
 * LoginServiceImp class
 * 实现LoginService
 * @author 吕柏翰
 * @date 2017/12/21
 */
@Service
public class LoginServiceImp implements LoginService{

	/**
	 * 微信登录.
	 * <p>微信登录<br> 
	 * @author 吕柏翰
	 * @param userId 用户Id
	 * @param code 微信小程序/OAuth2授权的Code
	 * @param state 微信OAuth2授权的state。对于小程序，值恒为 MiniProgram
	 * @param successUrl 微信OAuth2授权后跳转到的网址
	 * @return user 该用户信息
	 * @exception UserNotFoundException 登录失败时抛出
	 */
	@Override
	public User signInWeChat(BigInteger userId, String code, String state, String successUrl)
			throws UserNotFoundException {
		return null;
	}

	/**
	 * 手机号登录.
	 * <p>手机号登录 (.Net使用),User中只有phone和password，用于判断用户名密码是否正确<br>
	 * @author 吕柏翰 
	 * @param user 用户信息(手机号Phone和密码Password)
	 * @return user 该用户信息
	 * @exception UserNotFoundException 登录失败时抛出
	 */
	@Override
	public User signInPhone(User user) throws UserNotFoundException {
		User result=UserDao.signInPhone(user);
		if(result!=null)
		{
			return result;
		}
		else
		{
			throw new UserNotFoundException();
		}
	}

	/**
	 * 手机号注册.
	 * <p>手机号注册 (.Net使用),User中只有phone和password，userId是注册后才有并且在数据库自增<br> 
	 * @author 吕柏翰
	 * @param user 用户信息(手机号Phone和密码Password)
	 * @return user 该用户信息
	 */
	@Override
	public User signUpPhone(User user) {
		boolean success=UserDao.signUpPhone(user);
		if(success)
		{
			try {
				return signInPhone(user);
			} 
			catch (UserNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * 用户解绑.
	 * <p>教师解绑账号(j2ee使用)<br>
	 * @author 吕柏翰
	 * @param userId 用户id
	 * @see CourseService#listCourseByUserId(BigInteger userId)
	 * @see CourseService#deleteCourseByCourseId(BigInteger courseId)
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 * @exception UserNotFoundException 未找到对应用户
	 */
	@Override
	public void deleteTeacherAccount(BigInteger userId) throws IllegalArgumentException, UserNotFoundException {
		// TODO Auto-generated method stub
		
	}

	 /**
	 * 用户解绑.
	 * <p>学生解绑账号(j2ee使用)<br>
	 * @author 吕柏翰
	 * @param userId 用户id
	 * @see ClassService#deleteCourseSelectionById(BigInteger userId,BigInteger classId)
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 * @exception UserNotFoundException 未找到对应用户
	 */
	@Override
	public void deleteStudentAccount(BigInteger userId) throws IllegalArgumentException, UserNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
