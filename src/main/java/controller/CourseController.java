package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 * @return String 返回网页的文件名
	 */
	@RequestMapping(value="/",method=GET)
	public String getUserCourses(){
		return "";
	}
	/**
	 * 创建课程
	 * @author 吕柏翰
	 * @return String 返回网页的文件名
	 */
	@RequestMapping(value="/",method=POST)
	public String createCourse(){
		return "";
	}
	/**
	 * 按ID获取课程
	 * @author 吕柏翰
	 * @param courseId 需获取课程的ID
	 * @return String 返回网页的文件名
	 */
	@RequestMapping(value="/{courseId}",method=GET)
	public String getCourseById(Integer courseId){
		return "";
	}
	/**
	 * 按ID删除课程
	 * @author 吕柏翰
	 * @param courseId 需删除课程的ID
	 * @return String 返回网页的文件名
	 */
	@RequestMapping(value="/{courseId}",method=DELETE)
	public String deleteCourseById(Integer courseId){
		return "";
	}
}
