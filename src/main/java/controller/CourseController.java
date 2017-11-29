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
    /**
     * 获取与当前用户相关联的课程列表
     * @author 吕柏翰
     * @return String 返回Json数据
     * @throws JsonProcessingException Json处理异常
     */
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
	 * 修改课程
	 * @author 吕柏翰
	 * @param courseId 需修改课程的ID
	 * @param request 传递过来的request信息
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}",method=PUT)
	public String updateCourse(Integer courseId,String request) throws JsonProcessingException{
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
	/**
	 * 按ID获取课程的班级列表
	 * @author 吕柏翰
	 * @param courseId 需获取班级的课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}/class",method=GET)
	public String getClassesByCourseId(Integer courseId) throws JsonProcessingException{
		return mapper.writeValueAsString(obj);
	}
	/**
	 * 在指定ID的课程创建班级
	 * @author 吕柏翰
	 * @param courseId 待创建班级的课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}/class",method=POST)
	public String createClassByCourseId(Integer courseId) throws JsonProcessingException{
		return mapper.writeValueAsString(obj);
	}
	/**
	 * 按ID获取课程的讨论课
	 * @author 吕柏翰
	 * @param courseId 需获取讨论课的课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}/seminar",method=GET)
	public String getSeminarsByCourseId(Integer courseId) throws JsonProcessingException{
		return mapper.writeValueAsString(obj);
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
		return mapper.writeValueAsString(obj);
	}
}
