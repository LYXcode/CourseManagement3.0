package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    private ObjectMapper mapper=new ObjectMapper();
    private Object obj;
	@RequestMapping(value="/",method=GET)
	public String getUserCourses() throws JsonProcessingException{
		return mapper.writeValueAsString(obj);
	}
	/**
	 * 创建课程
	 * @author 吕柏翰
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/",method=POST)
	public String createCourse() throws JsonProcessingException{
		return mapper.writeValueAsString(obj);
	}
	/**
	 * 按ID获取课程
	 * @author 吕柏翰
	 * @param courseId 需获取课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}",method=GET)
	public String getCourseById(Integer courseId) throws JsonProcessingException{
		return mapper.writeValueAsString(obj);
	}
	/**
	 * 按ID删除课程
	 * @author 吕柏翰
	 * @param courseId 需删除课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}",method=DELETE)
	public String deleteCourseById(Integer courseId) throws JsonProcessingException{
		return mapper.writeValueAsString(obj);
	}
}
