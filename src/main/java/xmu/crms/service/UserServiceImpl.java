package xmu.crms.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.crms.entity.*;
import xmu.crms.exception.*;
import xmu.crms.dao.*;

/**
 * UserServiceImp class
 * 实现UserService
 * @author 吕柏翰
 * @date 2017/12/22
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private SeminarService seminarService;
	@Autowired
	private ClassService classService;
	@Autowired
	private CourseService courseService;
	/**
	 * 获取学生签到信息.
	 * <p>根据班级id，讨论课id获取当堂课签到信息<br>
	 * @author 吕柏翰
	 * @param classId 班级的id
	 * @param seminarId 讨论课id
	 * @return list 当堂课签到信息
	 * @exception IllegalArgumentException 信息不合法，id格式错误
	 * @exception ClassesNotFoundException 未找到班级
	 * @exception SeminarNotFoundException 未找到讨论课
	 */
	@Override
	public List<Attendance> listAttendanceById(BigInteger classId, BigInteger seminarId)
			throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
		//查找class
		try {
			classService.getClassByClassId(classId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ClassesNotFoundException();
		}
		//查找seminar
		seminarService.getSeminarBySeminarId(seminarId);
		List<Attendance> attendances=AttendanceDao.listAttendanceById(seminarId, classId);
		return attendances;
	}

	/**
	 * 根据用户Id获取用户的信息.
	 * <p>根据用户Id获取用户的信息<br> 
	 * @author 吕柏翰
	 * @param userId 用户Id
	 * @return user 用户信息
	 * @see SchoolService#getSchoolBySchoolId(BigInteger schoolId)
	 * @exception IllegalArgumentException throws when 信息不合法，id格式错误 
	 * @exception UserNotFoundException throws when 未找到对应用户
	 */
	@Override
	public User getUserByUserId(BigInteger userId) throws IllegalArgumentException, UserNotFoundException {
		User user=UserDao.getUserByUserId(userId);
		if(user==null)
		{
			throw new UserNotFoundException();
		}
		return user;
	}

	public boolean testUserPhoneAndPassword(String phone,String password){
		
		return true;
	}
	/**
	 * 根据用户名获取用户ID.
	 * <p>根据用户名获取用户ID<br>
	 * @author 吕柏翰
	 * @param userName 用户名
	 * @return userId 用户ID
	 * @exception IllegalArgumentException throws when 信息不合法，id格式错误 
	 * @exception UserNotFoundException throws when 未找到对应用户
	 */
	@Override
	public List<BigInteger> listUserIdByUserName(String userName)
			throws IllegalArgumentException, UserNotFoundException {
		List<BigInteger> user=UserDao.listUserIdByUserName(userName);
		if(user.size()==0)
		{
			throw new UserNotFoundException();
		}
		return user;
	}

	/**
	 * 根据用户ID修改用户信息.
	 * <p>根据用户ID修改用户信息<br> 
	 * @author 吕柏翰
	 * @param userId 用户Id
	 * @param user 用户信息
	 * @exception UserNotFoundException throws when 未找到对应用户
	 */
	@Override
	public void updateUserByUserId(BigInteger userId, User user) throws UserNotFoundException {
		//检查是否存在用户
		getUserByUserId(userId);
		user.setId(userId);
		UserDao.updateUserByUserId(userId, user);
		
	}

	/**
	 * 按班级ID、学号开头、姓名开头获取学生列表.
	 * <p>按班级ID、学号开头、姓名开头获取学生列表<br> 
	 * @author 吕柏翰
	 * @param classId 班级ID
	 * @param numBeginWith 学号开头
	 * @param nameBeginWith 姓名开头
	 * @return list 用户列表
	 * @exception IllegalArgumentException throws when 信息不合法
	 * @exception ClassesNotFoundException throws when 未找到对应班级
	 */
	@Override
	public List<User> listUserByClassId(BigInteger classId, String numBeginWith, String nameBeginWith)
			throws IllegalArgumentException, ClassesNotFoundException {
		//查找class
		try {
			classService.getClassByClassId(classId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ClassesNotFoundException();
		}
		List<User> user=UserDao.listUserByClassId(classId, numBeginWith, nameBeginWith);
		return user;
	}

	/**
	 * 根据用户名获取用户列表.
	 * <p>根据用户名获取用户列表<br> 
	 * @author 吕柏翰
	 * @param userName 用户名
	 * @return list 用户列表
	 * @exception UserNotFoundException throws when 未找到对应用户
	 */
	@Override
	public List<User> listUserByUserName(String userName) throws UserNotFoundException {
		List<User> user=UserDao.listUserByUserName(userName);
		if(user.size()==0)
		{
			throw new UserNotFoundException();
		}
		return user;
	}

	/**
	 * 获取讨论课所在的班级的出勤学生名单.
	 * <p>根据ID获取讨论课所在的班级的出勤学生名单<br>
	 * @author 吕柏翰
	 * @param seminarId 讨论课ID
	 * @param classId 班级ID
	 * @return list 处于出勤状态的学生的列表
	 * @see UserService #listAttendanceById(BigInteger, BigInteger)
	 * @see UserService #getUserByUserId(BigInteger)
	 * @exception IllegalArgumentException throws when 信息不合法，id格式错误 
	 */
	@Override
	public List<User> listPresentStudent(BigInteger seminarId, BigInteger classId) throws IllegalArgumentException {
		List<Attendance>attendances=AttendanceDao.listAttendanceById(seminarId, classId);
		List<User>users=new ArrayList<User>();
		for(int i=0;i<attendances.size();i++)
		{
			Attendance attendance=attendances.get(i);
			users.add(attendance.getStudent());
		}
		return users;
	}

	/**
	 * 获取讨论课所在班级缺勤学生名单.
	 * <p>获取讨论课所在班级缺勤学生名单<br>
	 * @author 吕柏翰
	 * @param seminarId 讨论课ID
	 * @param classId 班级ID
	 * @return list 处于缺勤状态的学生列表
	 * @see UserService #listUserByClassId(BigInteger, String, String)
	 * @see UserService #listPresentStudent(BigInteger, BigInteger)
	 * @exception IllegalArgumentException throws when 信息不合法，id格式错误 
	 */
	@Override
	public List<User> listAbsenceStudent(BigInteger seminarId, BigInteger classId) throws IllegalArgumentException {
		List<Attendance>attendances=AttendanceDao.listAbsenceStudent(seminarId, classId);
		List<User>users=new ArrayList<User>();
		for(int i=0;i<attendances.size();i++)
		{
			Attendance attendance=attendances.get(i);
			users.add(attendance.getStudent());
		}
		return users;
	}

	/**
	 * 根据教师名称列出课程名称.
	 * <p>根据教师名称列出课程名称<br>
	 * @author 吕柏翰
	 * @param teacherName 教师名称
	 * @return list 课程列表
	 * @see UserService #listUserByUserName(String userName)
	 * @see CourseService #listCourseByUserId(BigInteger userId)
	 */
	@Override
	public List<Course> listCourseByTeacherName(String teacherName) {
		try {
			return courseService.listCourseByUserId(listUserByUserName(teacherName).get(0).getId());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加学生签到信息.
	 * <p>根据班级id，讨论课id，学生id，经度，纬度进行签到，在方法中通过班级id，讨论课id获取当堂课发起签到的位置<br>
	 * @author 吕柏翰
	 * @param classId 班级的id
	 * @param seminarId 讨论课的id
	 * @param userId 学生的id
	 * @param longitude 经度
	 * @param latitude 纬度
	 * @return id 该记录的id
	 * @exception IllegalArgumentException 信息不合法，id格式错误 
	 * @exception ClassesNotFoundException 未找到班级
	 * @exception SeminarNotFoundException 未找到讨论课
	 * @exception UserNotFoundException 未找到对应用户
	 */
	@Override
	public BigInteger insertAttendanceById(BigInteger classId, BigInteger seminarId, BigInteger userId,
			double longitude, double latitude)
			throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException, UserNotFoundException {
		//判断是否能签到
	    Location location=classService.getCallStatusById(classId, seminarId);
	    if(Math.abs(latitude-location.getLatitude())<=0.0005&&Math.abs(longitude-location.getLongitude())<=0.0005){
    		Attendance attendance=new Attendance();
    		User user=new User();
    		user.setId(userId);
    		attendance.setStudent(user);
    		ClassInfo classinfo=new ClassInfo();
    		classinfo.setId(classId);
    		attendance.setClassInfo(classinfo);
    		Seminar seminar=new Seminar();
    		seminar.setId(seminarId);
    		attendance.setSeminar(seminar);
    		//判断签到时间
    		attendance.setAttendanceStatus(location.getStatus());
    		return AttendanceDao.insertAttendanceById(attendance);
	    }
	    else{
	        return null;
	    }
	}

	/**
	 * 获取讨论课所在班级迟到学生名单.
	 * <p>获取讨论课所在班级迟到学生名单<br>
	 * @author 吕柏翰
	 * @param seminarId 讨论课ID
	 * @param classId 班级ID
	 * @return list 处于迟到状态的学生列表
	 * @see UserService #listAttendanceById(BigInteger, BigInteger)
	 * @see UserService #getUserByUserId(BigInteger)
	 * @exception IllegalArgumentException throws when 信息不合法，id格式错误
	 * @exception ClassesNotFoundException 未找到班级
	 * @exception SeminarNotFoundException 未找到讨论课 
	 */
	@Override
	public List<User> listLateStudent(BigInteger seminarId, BigInteger classId)
			throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
		List<Attendance>attendances=AttendanceDao.listLateStudent(seminarId, classId);
		List<User>users=new ArrayList<User>();
		for(int i=0;i<attendances.size();i++)
		{
			Attendance attendance=attendances.get(i);
			users.add(attendance.getStudent());
		}
		return users;
	}

}
