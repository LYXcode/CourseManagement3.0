package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.*;
import entity.Class;

/**
 * CourseController class
 * 课程信息Controller层
 * @author 吕柏翰
 * @date 2017/11/27
 */
@RestController
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
	public Object getCourses() throws JsonProcessingException{
	    List<Course> courses=new ArrayList<Course>(); 
	    Course course1=new Course();
	    course1.setId(9);
		course1.setName("OOAD");
		course1.setNumClass(3);
		course1.setNumStudent(30);
		course1.setStartTime("开始时间");
		course1.setEndTime("结束时间");
		
		courses.add(course1);
		
	    Course course2=new Course();
	    course2.setId(7);
	    course2.setName("J2EE");
	    course2.setStartTime("开始时间");
	    course2.setEndTime("结束时间");

	    courses.add(course2);
	    return courses;
	}
	/**
	 * 创建课程
	 * @author 艾星
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(method=POST)
	@ResponseBody
	@ResponseStatus(value=HttpStatus.CREATED)
	public Object newCourse(@RequestBody String JsonString) throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
	    Course cour=new Course();
	    cour.setId(9);
		return cour;
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
	public Object getCourse(@PathVariable Integer courseId) throws JsonProcessingException{
		CourseDetail courseDetail=new CourseDetail();
		courseDetail.setId(9);
		courseDetail.setTeacherEmail("XXX@XXX.com");
		courseDetail.setTeacherName("XXX老师");
		courseDetail.setName("OOAD");
		courseDetail.setDescription("OOAD是门……");
		return courseDetail;
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
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateCourses(@PathVariable Integer courseId,@RequestBody String JsonString) throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
	}
	/**
	 * 按ID删除课程
	 * @author 吕柏翰
	 * @param courseId 需删除课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId:\\d+}",method=DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@ResponseBody
	public void deleteCourses(@PathVariable int courseId) throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
	    System.out.println(courseId);
	}
	/**
	 * 按ID获取课程的班级列表
	 * @author 吕柏翰
	 * @param courseId 需获取班级的课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}/class",method=GET)
	@ResponseBody
	public Object selectClasses(@PathVariable String courseId) throws JsonProcessingException{
		System.out.println("c");
		List<Class> classes=new ArrayList<Class>();
	    Class cla=new Class();
		cla.setId(6);
		cla.setName("周三一二节");
		classes.add(cla);
	    return classes;
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
	@ResponseStatus(value=HttpStatus.CREATED)
	public Object createClass(@PathVariable int courseId,@RequestBody String JsonString) throws JsonProcessingException{
	        Class cla=new Class();
	        cla.setId(10);
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
	public Object selectSeminars(@PathVariable int courseId) throws JsonProcessingException{
	    System.out.println("s");
	    List<Seminar> seminar=new ArrayList<Seminar>();
	    Seminar se=new Seminar();
		se.setId(8);
		se.setName("界面原型设计");
		se.setDescription("完成相应的界面设计……");
		se.setGroupingMethod(GroupingEnum.random);
		se.setStartTime("开始时间");
		se.setEndTime("结束时间");
		seminar.add(se);
		return seminar;
		}
	/**
	 * 在指定ID的课程创建讨论课
	 * @author 吕柏翰
	 * @param courseId 待创建讨论课的课程的ID
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/{courseId}/seminar",method=POST)
	@ResponseBody
	@ResponseStatus(value=HttpStatus.CREATED)
	public Object createSeminar(String JsonString,@PathVariable Integer courseid) throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
	    Seminar seminar=new Seminar();
	    seminar.setId(8);
	    //System.out.println(seminar.getName());
	    //System.out.println(seminar.getGroupingMethod());
		return seminar;
		}
	
	 /**
     * 获得正在进行的讨论课
     * @author 吕柏翰
     * @param courseId 待创建讨论课的课程的ID
     * @return String 返回Json数据
     * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/{courseId}/seminar/current",method=GET)
    @ResponseBody
    public Object getCurrentSeminar(@PathVariable int courseId) throws JsonProcessingException{
        SeminarClasses se=new SeminarClasses();
        Class[] classes=new Class[5];
        se.setId(8);
        se.setName("XXXX");
        se.setGroupingMethod(GroupingEnum.random);
        se.setStartTime(new Date().toString());
        se.setEndTime(new Date().toString());
        se.setClasses(classes);
        return se;
        }
	
    @RequestMapping(value="/{courseId}/grade")
    @ResponseBody
    public Object getSeminarGrade(@PathVariable int courseId){
        List<SeminarGradeDetail> grades=new ArrayList<SeminarGradeDetail>();
        SeminarGradeDetail grade=new SeminarGradeDetail();
        grade.setSeminarName("XXX讨论课");
        grade.setGroupName("XXX小组");
        grade.setLeaderName("XXX组长");
        grade.setPresentationGrade(89);
        grade.setReportGrade(70);
        grade.setGrade(89);
        grades.add(grade);
        return grades;
    }
}
