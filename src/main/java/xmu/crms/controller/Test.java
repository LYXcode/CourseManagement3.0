package xmu.crms.controller;

import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import xmu.crms.vo.*;
import xmu.crms.entity.Attendance;
import xmu.crms.exception.UserNotFoundException;

/**
 * XXX class
 * 
 * @author 吕柏翰
 * @date 2017/12/24
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    /*
		UserServiceImp me=new UserServiceImp();
		try {
			//List<xmu.crms.entity.User> list=me.listCourseByTeacherName();
			//System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	    System.out.println(MeController.MD5("123"));
	}

}
