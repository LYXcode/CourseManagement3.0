package xmu.crms.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import xmu.crms.entity.*;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.mapper.AttendanceMapper;
import xmu.crms.mapper.MyBatisUtils;
import xmu.crms.service.UserService;
/**
 * AttendanceDao class
 * 
 * @author 吕柏翰
 * @date 2017/12/19
 */
public interface AttendanceDao {
	/**
	 * 添加学生签到信息.
	 * <p>根据班级id，讨论课id，学生id进行签到<br>
	 * @author 吕柏翰
	 * @param attendance 考勤信息
	 * @return 考勤Id
	 */
	public static BigInteger insertAttendanceById(Attendance attendance){
		return AttendanceMapper.insertAttendanceById(attendance);
	}
	
	/**
	 * 获取学生签到信息.
	 * <p>根据班级id，讨论课id获取当堂课签到信息<br>
	 * @author 吕柏翰
	 * @param classId 班级的id
	 * @param seminarId 讨论课id
	 * @return list 当堂课签到信息
	 */
	public static List<Attendance> listAttendanceById(BigInteger seminarId,BigInteger classId){
		return AttendanceMapper.listAttendanceById(seminarId, classId);
	}
	
	/**
	 * 获取讨论课所在的班级的出勤学生名单.
	 * <p>根据ID获取讨论课所在的班级的出勤学生名单<br>
	 * @author 吕柏翰
	 * @param seminarId 讨论课ID
	 * @param classId 班级ID
	 * @return list 处于出勤状态的学生的列表
	 */
	public static List<Attendance> listPresentStudent(BigInteger seminarId, BigInteger classId){
		return AttendanceMapper.listPresentStudent(seminarId, classId);
	}
	
	/**
	 * 获取讨论课所在班级缺勤学生名单.
	 * <p>获取讨论课所在班级缺勤学生名单<br>
	 * @author 吕柏翰
	 * @param seminarId 讨论课ID
	 * @param classId 班级ID
	 * @return list 处于缺勤状态的学生列表
	 */
	public static List<Attendance> listAbsenceStudent(BigInteger seminarId,BigInteger classId){
		return AttendanceMapper.listAbsenceStudent(seminarId, classId);
	}
	
	/**
	 * 获取讨论课所在班级迟到学生名单.
	 * <p>获取讨论课所在班级迟到学生名单<br>
	 * @author 吕柏翰
	 * @param seminarId 讨论课ID
	 * @param classId 班级ID
	 * @return list 处于迟到状态的学生列表
	 */
	public static List<Attendance> listLateStudent(BigInteger seminarId, BigInteger classId){
		return AttendanceMapper.listLateStudent(seminarId, classId);
	}
}
