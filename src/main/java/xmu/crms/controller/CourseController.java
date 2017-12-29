package xmu.crms.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import xmu.crms.vo.Class;
import xmu.crms.entity.ClassInfo;
import xmu.crms.service.*;
import xmu.crms.vo.*;

/**
 * CourseController class
 * 课程信息Controller层
 * @author 吕柏翰
 * @date 2017/11/27
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassService classService;

    @Autowired
    private SeminarService seminarService;
    
    @Autowired
    private UserService userService;

    @Autowired
    private SeminarGroupService seminarGroupService;
    /**
     * 获取与当前用户相关联的课程列表
     * @author 吕柏翰
     * @return String 返回Json数据
     * @throws JsonProcessingException Json处理异常
     */
	@RequestMapping(method=GET)
	@ResponseBody
	public Object getCourses() throws JsonProcessingException{
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        xmu.crms.entity.User user=new xmu.crms.entity.User();
        String str=Jwt.unsign(map.get("token"), xmu.crms.entity.User.class);
        user.setId(BigInteger.valueOf(Integer.parseInt(str.substring(str.indexOf("id")+4,str.indexOf("phone")-2))));
        user.setType(new Integer(Integer.parseInt(str.substring(str.indexOf("type")+6,str.indexOf("number")-2))));
    	try {
			List<xmu.crms.entity.Course> courses=courseService.listCourseByUserId(user.getId());
			List<xmu.crms.vo.Course> coursesVO=new ArrayList<xmu.crms.vo.Course>();
			for(int i=0;i<courses.size();++i)
			{
				xmu.crms.vo.Course course=new xmu.crms.vo.Course();
				List<ClassInfo> list=classService.listClassByCourseId(courses.get(i).getId());
				course.setNumClass(list.size());
				int sum=0;
				for(int j=0;j<list.size();++j)
					sum+=userService.listUserByClassId(list.get(j).getId(),"","").size();
				course.setNumStudent(sum);
				coursesVO.add(course);
			}
			return coursesVO;
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
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
	public void newCourse(@RequestBody String JsonString) throws JsonProcessingException{
	    xmu.crms.entity.Course cour=new  xmu.crms.entity.Course();
	    cour.setName(JsonString.substring(JsonString.indexOf("name")+7,
	            JsonString.indexOf("description")-3));
	    cour.setDescription(JsonString.substring(JsonString.indexOf("description")+14,
                JsonString.indexOf("startTime")-3));
	    String str=JsonString.substring(JsonString.indexOf("startTime")+12,
                JsonString.indexOf("endTime")-3);
	    str+=" 00:00:00";
	    Date startDate=new Date();
	    try
	    {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        startDate = sdf.parse(str);
	    }
	    catch (ParseException e)
	    {
	        System.out.println(e.getMessage());
	    }
	    cour.setStartDate(startDate);

	    str=JsonString.substring(JsonString.indexOf("endTime")+10,
                JsonString.indexOf("pro")-3);
        str+=" 00:00:00";
        Date endDate=new Date();
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            endDate = sdf.parse(str);
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }
        cour.setEndDate(endDate);
        
	    cour.setThreePointPercentage(Integer.parseInt(JsonString.substring(JsonString.indexOf("pro")+14,
                JsonString.indexOf("prob")-3)));    
        cour.setFourPointPercentage(Integer.parseInt(JsonString.substring(JsonString.indexOf("prob")+7,
                JsonString.indexOf("proa")-3)));	  
        cour.setFivePointPercentage(Integer.parseInt(JsonString.substring(JsonString.indexOf("proa")+7,
                JsonString.indexOf("report")-3)));
        cour.setReportPercentage(Integer.parseInt(JsonString.substring(JsonString.indexOf("report")+9,
                JsonString.indexOf("presentation")-3)));    
        String string=JsonString.substring(JsonString.indexOf("presentation")+15
                );
        cour.setPresentationPercentage(Integer.parseInt(string.substring(0,string.indexOf("\""))));    
	    
        //CourseServiceImpl csi=new CourseServiceImpl();
        BigInteger userId=BigInteger.valueOf(2);
        courseService.insertCourseByUserId(userId,cour);
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
		xmu.crms.vo.Course cour=new xmu.crms.vo.Course();//CourseService.getCourseByCourseId(courseId));
		return cour;
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
	    xmu.crms.entity.Course cour=new  xmu.crms.entity.Course();
        
        cour.setName(JsonString.substring(JsonString.indexOf("name")+7,
                JsonString.indexOf("description")-3));
        cour.setDescription(JsonString.substring(JsonString.indexOf("description")+14,
                JsonString.indexOf("startTime")-3));
        String str=JsonString.substring(JsonString.indexOf("startTime")+12,
                JsonString.indexOf("endTime")-3);
        str+=" 00:00:00";
        Date startDate=new Date();
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startDate = sdf.parse(str);
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }
        cour.setStartDate(startDate);

        str=JsonString.substring(JsonString.indexOf("endTime")+10,
                JsonString.indexOf("pro")-3);
        str+=" 00:00:00";
        Date endDate=new Date();
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            endDate = sdf.parse(str);
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }
        cour.setEndDate(endDate);
        
        cour.setThreePointPercentage(Integer.parseInt(JsonString.substring(JsonString.indexOf("pro")+14,
                JsonString.indexOf("prob")-3)));    
        cour.setFourPointPercentage(Integer.parseInt(JsonString.substring(JsonString.indexOf("prob")+7,
                JsonString.indexOf("proa")-3)));      
        cour.setFivePointPercentage(Integer.parseInt(JsonString.substring(JsonString.indexOf("proa")+7,
                JsonString.indexOf("report")-3)));
        cour.setReportPercentage(Integer.parseInt(JsonString.substring(JsonString.indexOf("report")+9,
                JsonString.indexOf("presentation")-3)));    
        String string=JsonString.substring(JsonString.indexOf("presentation")+15
                );
        cour.setPresentationPercentage(Integer.parseInt(string.substring(0,string.indexOf("\""))));    
           	    
        //CourseServiceImpl csi=new CourseServiceImpl();
        courseService.updateCourseByCourseId(BigInteger.valueOf(courseId.intValue()),cour);
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
		//CourseServiceImpl csi=new CourseServiceImpl();
	    courseService.deleteCourseByCourseId(BigInteger.valueOf(courseId));
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
	public Object selectClasses(@PathVariable int courseId) throws JsonProcessingException{
		List<ClassInfo> classes=new ArrayList<ClassInfo>();
		//ClassServiceImpl csi=new ClassServiceImpl();
		try {		    
			classes=classService.listClassByCourseId(BigInteger.valueOf(courseId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    /*Class cla=new Class();
		cla.setId(6);
		cla.setName("周三一二节");
		classes.add(cla);*/
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
	public void createClass(@PathVariable int courseId,@RequestBody String JsonString) throws JsonProcessingException{
        String name,classTime;
        int a,b,c,report,presentation;
        name=JsonString.substring(JsonString.indexOf("name")+7,JsonString.indexOf("classTime")-3);
        classTime=JsonString.substring(JsonString.indexOf("classTime")+11, JsonString.indexOf("proc")-3);
        c=Integer.parseInt(JsonString.substring(JsonString.indexOf("proc")+7,JsonString.indexOf("prob")-3));
        b=Integer.parseInt(JsonString.substring(JsonString.indexOf("prob")+7, JsonString.indexOf("proa")-3));
        a=Integer.parseInt(JsonString.substring(JsonString.indexOf("proa")+7,JsonString.indexOf("report")-3));
        report=Integer.parseInt(JsonString.substring(JsonString.indexOf("report")+9,JsonString.indexOf("presentation")-3));
        String str=JsonString.substring(JsonString.indexOf("presentation")+15);
        presentation=Integer.parseInt(str.substring(0,str.indexOf("\"")));
        
        xmu.crms.entity.ClassInfo ci=new xmu.crms.entity.ClassInfo();
        ci.setName(name);
        ci.setClassTime(classTime);
        ci.setFivePointPercentage(new Integer(a));
        ci.setFourPointPercentage(new Integer(b));
        ci.setThreePointPercentage(new Integer(c));
        ci.setReportPercentage(report);
        ci.setPresentationPercentage(presentation);
        
        //ClassServiceImpl csi=new ClassServiceImpl();
	    try {
			classService.insertClassById(BigInteger.valueOf(courseId),ci);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
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
	    List<xmu.crms.entity.Seminar> seminar=new ArrayList<xmu.crms.entity.Seminar>();
	    List<xmu.crms.vo.Seminar> seminarVO=new ArrayList<xmu.crms.vo.Seminar>();
	    try {
            seminar=seminarService.listSeminarByCourseId(BigInteger.valueOf(courseId));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    for(int i=0;i<seminar.size();++i)
	    	seminarVO.add(new xmu.crms.vo.Seminar(seminar.get(i)));
		return seminarVO;
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
	public void createSeminar(@PathVariable int courseId,@RequestBody String JsonString) throws JsonProcessingException{

	    xmu.crms.entity.Seminar sem=new xmu.crms.entity.Seminar();
	    
        String name,description,fixed,startTime,endTime;
        int a,b,c,report,presentation;
        name=JsonString.substring(JsonString.indexOf("name")+7,JsonString.indexOf("description")-3);
        description=JsonString.substring(JsonString.indexOf("description")+14, JsonString.indexOf("startTime")-3);
        startTime=JsonString.substring(JsonString.indexOf("startTime")+12, JsonString.indexOf("endTime")-3);
        endTime=JsonString.substring(JsonString.indexOf("endTime")+10, JsonString.indexOf("proc")-3);
        c=Integer.parseInt(JsonString.substring(JsonString.indexOf("proc")+7,JsonString.indexOf("prob")-3));
        b=Integer.parseInt(JsonString.substring(JsonString.indexOf("prob")+7, JsonString.indexOf("proa")-3));
        a=Integer.parseInt(JsonString.substring(JsonString.indexOf("proa")+7,JsonString.indexOf("report")-3));
        report=Integer.parseInt(JsonString.substring(JsonString.indexOf("report")+9,JsonString.indexOf("presentation")-3));
        presentation=Integer.parseInt(JsonString.substring(JsonString.indexOf("presentation")+15, JsonString.indexOf("fixed")-3));
        fixed=JsonString.substring(JsonString.indexOf("fixed")+8);
        
        startTime+=" 00:00:00";
        endTime+=" 00:00:00";
        Date startDate=new Date();
        Date endDate=new Date();
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startDate = sdf.parse(startTime);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            endDate = sdf2.parse(endTime);
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }
        
        xmu.crms.entity.ClassInfo ci=new xmu.crms.entity.ClassInfo();
        sem.setName(name);
        sem.setDescription(description);
        sem.setStartTime(startDate);
        sem.setEndTime(endDate);
        sem.setFixed(fixed.substring(0,fixed.indexOf("\"")).equals("固定分组")?true:false);
        //SeminarServiceImpl ssi=new SeminarServiceImpl();
        try {
            seminarService.insertSeminarByCourseId(BigInteger.valueOf(courseId), sem);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
