package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import entity.*;
import entity.Class;

/**
 * CourseController class
 * 课程信息Controller层
 * @author 吕柏翰
 * @date 2017/11/27
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    
    /**
     * 获取与当前用户相关联的课程列表
     * @author 吕柏翰
     * @return String 返回Json数据
     * @throws JsonProcessingException Json处理异常
     */
	@RequestMapping(method=GET)
	@ResponseBody
	public Object getUserCourses() throws JsonProcessingException{
	    List<Course> courses=new ArrayList<Course>();
	    
	    Calendar calendar=Calendar.getInstance();
	    Date date=calendar.getTime();
	    
	    Course course1=new Course();
		course1.setName("OOAD");
		course1.setClassNum(3);
		course1.setStuNum(80);
		course1.setStartTime(date);
		course1.setEndTime(date);
		
		courses.add(course1);
		
	    Course course2=new Course();
	    course2.setName("OOAD");
	    course2.setClassNum(3);
	    course2.setStuNum(80);
	    course2.setStartTime(date);
	    course2.setEndTime(date);

	    courses.add(course2);
	    return course1;
	}
	/**
	 * 创建课程
	 * @author 艾星
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(method=POST)
	@ResponseBody
	public String createCourse(@RequestBody Course course) throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
	    System.out.println(course.getPro().geta());
		return "";
	}
	/**
	 * 按ID获取课程
	 * @author 吕柏翰
	 * @param courseId 需获取课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}",method=GET)
	@ResponseBody
	public Object getCourseById(@PathVariable String courseId) throws JsonProcessingException{
		Course course=new Course();
		course.setId(courseId);
		course.setName("OOAD");
		course.setDescription("OOAD是门……");
		return course;
	}
	/**
	 * 修改课程
	 * @author 吕柏翰
	 * @param courseId 需修改课程的ID
	 * @param request 传递过来的request信息
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}",method=PUT)
	public String updateCourse(Integer courseId,String request) throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
		return "";
	}
	/**
	 * 按ID删除课程
	 * @author 吕柏翰
	 * @param courseId 需删除课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId:\\d+}",method=DELETE)
	@ResponseBody
	public String deleteCourseById(@PathVariable int courseId) throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
	    System.out.println(courseId);
		return"";
	}
	/**
	 * 按ID获取课程的班级列表
	 * @author 吕柏翰
	 * @param courseId 需获取班级的课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}/class",method=GET)
	public Object getClassesByCourseId(@PathVariable String courseId) throws JsonProcessingException{
		System.out.println("c");
	    Class cla=new Class();
		cla.setId(6);
		cla.setName("周三一二节");
	    return cla;
		}
	/**
	 * 在指定ID的课程创建班级
	 * @author 吕柏翰
	 * @param courseId 待创建班级的课程的ID
	 * @param request 传递过来的request信息
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}/class",method=POST)
	@ResponseBody
	public Object createClassByCourseId(@PathVariable int courseId,@RequestBody Class cla) throws JsonProcessingException{
		cla.setId(6);
		System.out.println(cla.getPro().geta());
		return cla;
		}
	/**
	 * 按ID获取课程的讨论课
	 * @author 吕柏翰
	 * @param courseId 需获取讨论课的课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}/seminar",method=GET)
	@ResponseBody
	public Object getSeminarsByCourseId(@PathVariable int courseId) throws JsonProcessingException{
	    System.out.println("s");
	    Seminar se=new Seminar();
		se.setId(8);
		se.setName("界面原型设计");
		se.setDescription("完成相应的界面设计……");
		return se;
		}
	/**
	 * 在指定ID的课程创建讨论课
	 * @author 吕柏翰
	 * @param courseId 待创建讨论课的课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}",method=POST)
	public String createSeminarByCourseId(Integer courseId) throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
		return "";
		}
}
