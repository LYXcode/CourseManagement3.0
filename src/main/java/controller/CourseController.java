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
		//return mapper.writeValueAsString(obj);
		return mapper.writeValueAsString("[\n  {\n    \"id\": 1,\n    \"name\": \"OOAD\",\n    \"numClass\": 3,\n    \"numStudent\": 60,\n    \"startTime\": \"2017-9-1\",\n    \"endTime\": \"2018-1-1\"\n  },\n  {\n    \"id\": 2,\n    \"name\": \"J2EE\",\n    \"numClass\": 1,\n    \"numStudent\": 60,\n    \"startTime\": \"2017-9-1\",\n    \"endTime\": \"2018-1-1\"\n  }\n]");
	}
	/**
	 * 创建课程
	 * @author 吕柏翰
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/",method=POST)
	public String createCourse() throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
		return mapper.writeValueAsString("{\n  \"name\": \"OOAD\",\n  \"description\": \"\u9762\u5411\u5BF9\u8C61\u5206\u6790\u4E0E\u8BBE\u8BA1\",\n  \"startTime\": \"2017-09-20\",\n  \"endTime\": \"2018-1-31\",\n  \"proportions\": {\n    \"3\": 20,\n    \"4\": 60,\n    \"5\": 20,\n    \"report\": 50,\n    \"presentation\": 50\n  }\n}");
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
		//return mapper.writeValueAsString(obj);
		return mapper.writeValueAsString("{\n  \"id\": 23,\n  \"name\": \"OOAD\",\n  \"description\": \"\u9762\u5411\u5BF9\u8C61\u5206\u6790\u4E0E\u8BBE\u8BA1\"\n}");
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
		return mapper.writeValueAsString("{}");
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
		//return mapper.writeValueAsString(obj);
		return mapper.writeValueAsString("{}");
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
		//return mapper.writeValueAsString(obj);
		return mapper.writeValueAsString("[\n  {\n    \"id\": 45,\n    \"name\": \"\u5468\u4E091-2\u8282\"\n  },\n  {\n    \"id\": 48,\n    \"name\": \"\u5468\u4E093-4\u8282\"\n  }\n]");
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
	public String createClassByCourseId(Integer courseId,String request) throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
		return mapper.writeValueAsString("{\n  \"id\": 45\n}");
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
		//return mapper.writeValueAsString(obj);
		return mapper.writeValueAsString("[\n  {\n    \"id\": 29,\n    \"name\": \"\u754C\u9762\u539F\u578B\u8BBE\u8BA1\",\n    \"description\": \"\u754C\u9762\u539F\u578B\u8BBE\u8BA1\",\n    \"groupingMethod\": \"fixed\",\n    \"startTime\": \"2017-09-25\",\n    \"endTime\": \"2017-10-09\"\n  },\n  {\n    \"id\": 32,\n    \"name\": \"\u6982\u8981\u8BBE\u8BA1\",\n    \"description\": \"\u6A21\u578B\u5C42\u4E0E\u6570\u636E\u5E93\u8BBE\u8BA1\",\n    \"groupingMethod\": \"fixed\",\n    \"startTime\": \"2017-10-10\",\n    \"endTime\": \"2017-10-24\"\n  }\n]");
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
		return mapper.writeValueAsString("{\n  \"name\": \"\u6982\u8981\u8BBE\u8BA1\",\n  \"description\": \"\u6A21\u578B\u5C42\u4E0E\u6570\u636E\u5E93\u8BBE\u8BA1\",\n  \"groupingMethod\": \"fixed\",\n  \"startTime\": \"2017-10-10\",\n  \"endTime\": \"2017-10-24\",\n  \"proportions\": {\n    \"3\": 20,\n    \"4\": 60,\n    \"5\": 20,\n    \"report\": 50,\n    \"presentation\": 50\n  }\n}");
	}
}
