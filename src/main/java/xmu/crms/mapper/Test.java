package xmu.crms.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import xmu.crms.entity.*;
import xmu.crms.service.*;

/**
 * XXX class
 * 
 * @author 吕柏翰
 * @date 2017/12/20
 */
public class Test {

	public static void main(String[] args) {
		/*
		School temp=new School();
		temp.setId(BigInteger.valueOf(1));
		School school=SchoolMapper.getSchoolBySchoolId((temp));
		System.out.println(school.getCity());
		List<School> schools;
		schools=SchoolMapper.listSchoolByCity(school.getCity());
		System.out.println(schools.get(0).getName());
		school=new School();
		school.setProvince("福建");
		school.setCity("厦门");
		school.setName("厦门大学");
		System.out.println(SchoolMapper.insertSchool(school));
		*/
		
		/*
		User user=new User();
		user.setPhone("15720335800");
		user.setPassword("BE8791B8BE6DEC10");
		user=UserMapper.signInPhone(user);
		System.out.println(user.getSchool().getName());
		//System.out.println(UserMapper.signUpPhone(user));
		*/
		
		/*
		Attendance attendance=new Attendance();
		User user=new User();
		user.setId(BigInteger.valueOf(1));
		attendance.setStudent(user);
		ClassInfo classinfo=new ClassInfo();
		classinfo.setId(BigInteger.valueOf(1));
		attendance.setClassInfo(classinfo);
		Seminar seminar=new Seminar();
		seminar.setId(BigInteger.valueOf(1));
		attendance.setSeminar(seminar);
		attendance.setAttendanceStatus(1);
		AttendanceMapper.insertAttendanceById(attendance);
		*/
		
		/*
		List<Attendance> attendances=AttendanceMapper.listAttendanceById(null, BigInteger.valueOf(1));
		attendances=AttendanceMapper.listAttendanceById(BigInteger.valueOf(3), BigInteger.valueOf(1));
		System.out.println(attendances.size());
		*/
		
		/*
		User user=UserMapper.getUserByUserId(BigInteger.valueOf(1));
		System.out.println(user.getName());
		*/
		
		/*
		List<BigInteger> user=UserMapper.listUserIdByUserName("邱明");
		System.out.println(user.size());
		*/
		
		/*
		User user=new User();
		user.setId(BigInteger.valueOf(1));
		user.setPhone("1");
		user.setPassword("BE8791B8BE6DEC10");
		UserMapper.updateUserByUserId(BigInteger.valueOf(1), user);
		*/
		
		/*
		List<User> user=UserMapper.listUserByClassId(BigInteger.valueOf(1), "", "");
		System.out.println(user.size());
		*/
		
		/*
		List<User> user=UserMapper.listUserByUserName("邱明");
		System.out.println(user.size());
		*/
		
		/*
		List<Attendance>attendances=AttendanceMapper.listAttendanceById(BigInteger.valueOf(3), BigInteger.valueOf(1));
		System.out.println(attendances.size());
		*/
	    
	}

}
