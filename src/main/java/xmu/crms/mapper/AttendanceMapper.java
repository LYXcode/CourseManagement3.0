package xmu.crms.mapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import xmu.crms.entity.*;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.SchoolService;
import xmu.crms.service.UserService;
/**
 * AttendanceMapper class
 * 
 * @author 吕柏翰
 * @date 2017/12/21
 */
public class AttendanceMapper {
	/**
	 * 添加学生签到信息.
	 * <p>根据班级id，讨论课id，学生id进行签到<br>
	 * @author 吕柏翰
	 * @param Attendance 考勤信息
	 * @return 考勤Id
	 */
	public static BigInteger insertAttendanceById(Attendance attendance)
	{
		SqlSession session = MyBatisUtils.getSqlSession();
		BigInteger result=BigInteger.valueOf(-1);
        try {
            result=BigInteger.valueOf(session.insert("xmu.crms.mapper.AttendanceMapper.insertAttendanceById", attendance));
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        return result;
	}
	
	/**
	 * 获取学生签到信息.
	 * <p>根据班级id，讨论课id获取当堂课签到信息<br>
	 * @author 吕柏翰
	 * @param classId 班级的id
	 * @param seminarId 讨论课id
	 * @return list 当堂课签到信息
	 */
	public static List<Attendance> listAttendanceById(BigInteger seminarId,BigInteger classId)
	{
		//TODO 这里有错 无法改正 需要等和其他部分合并才能修改
		Attendance attendance=new Attendance();
		ClassInfo classinfo=new ClassInfo();
		classinfo.setId(classId);
		attendance.setClassInfo(classinfo);
		Seminar seminar=new Seminar();
		seminar.setId(seminarId);
		attendance.setSeminar(seminar);
		List<Attendance> result=null;
		SqlSession session = MyBatisUtils.getSqlSession();
        try {
            result=session.selectList("xmu.crms.mapper.AttendanceMapper.listAttendanceById", attendance);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
		return result;
	}
	
	/**
	 * 获取讨论课所在的班级的出勤学生名单.
	 * <p>根据ID获取讨论课所在的班级的出勤学生名单<br>
	 * @author 吕柏翰
	 * @param seminarId 讨论课ID
	 * @param classId 班级ID
	 * @return list 处于出勤状态的学生的列表
	 */
	public static List<Attendance> listPresentStudent(BigInteger seminarId, BigInteger classId)
	{
		//TODO 这里有错 无法改正 需要等和其他部分合并才能修改
		Attendance attendance=new Attendance();
		ClassInfo classinfo=new ClassInfo();
		classinfo.setId(classId);
		attendance.setClassInfo(classinfo);
		Seminar seminar=new Seminar();
		seminar.setId(seminarId);
		attendance.setSeminar(seminar);
		List<Attendance> result=null;
		SqlSession session = MyBatisUtils.getSqlSession();
        try {
            result=session.selectList("xmu.crms.mapper.AttendanceMapper.listPresentStudent", attendance);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
		return result;
	}
	
	/**
	 * 获取讨论课所在班级缺勤学生名单.
	 * <p>获取讨论课所在班级缺勤学生名单<br>
	 * @author 吕柏翰
	 * @param seminarId 讨论课ID
	 * @param classId 班级ID
	 * @return list 处于缺勤状态的学生列表
	 */
	public static List<Attendance> listAbsenceStudent(BigInteger seminarId,BigInteger classId)
	{
		//TODO 这里有错 无法改正 需要等和其他部分合并才能修改
		Attendance attendance=new Attendance();
		ClassInfo classinfo=new ClassInfo();
		classinfo.setId(classId);
		attendance.setClassInfo(classinfo);
		Seminar seminar=new Seminar();
		seminar.setId(seminarId);
		attendance.setSeminar(seminar);
		List<Attendance> result=null;
		SqlSession session = MyBatisUtils.getSqlSession();
        try {
            result=session.selectList("xmu.crms.mapper.AttendanceMapper.listAbsenceStudent", attendance);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
		return result;
	}
	
	/**
	 * 获取讨论课所在班级迟到学生名单.
	 * <p>获取讨论课所在班级迟到学生名单<br>
	 * @author 吕柏翰
	 * @param seminarId 讨论课ID
	 * @param classId 班级ID
	 * @return list 处于迟到状态的学生列表
	 */
	public static List<Attendance> listLateStudent(BigInteger seminarId,BigInteger classId)
	{
		//TODO 这里有错 无法改正 需要等和其他部分合并才能修改
		Attendance attendance=new Attendance();
		ClassInfo classinfo=new ClassInfo();
		classinfo.setId(classId);
		attendance.setClassInfo(classinfo);
		Seminar seminar=new Seminar();
		seminar.setId(seminarId);
		attendance.setSeminar(seminar);
		List<Attendance> result=null;
		SqlSession session = MyBatisUtils.getSqlSession();
        try {
            result=session.selectList("xmu.crms.mapper.AttendanceMapper.listLateStudent", attendance);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
		return result;
	}
}
