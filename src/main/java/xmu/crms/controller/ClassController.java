package xmu.crms.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import xmu.crms.entity.*;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.FixGroupNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.*;
import xmu.crms.vo.Class;
import xmu.crms.vo.*;

/**
 * 
 * ClassController class
 * 班级信息 controller层
 * @author 艾星
 * @date 2017/11/28
 *  
 */
@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ClassService classService;
    @Autowired
    private UserService userService;
    @Autowired
    private FixGroupService fixGroupService;
    /**
     * 获取与当前用户相关的或者符合条件的班级列表
     * @author 艾星
     * @return 与用户相关的班级列表
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="?courseName=*&teacherName=*",method=GET)
    @ResponseBody
    public Object getClassListByParam(@PathVariable String courseName,String teacherName) throws JsonProcessingException{
        //从数据库中取出对应类obj
        List<ClassInfo> classes=new ArrayList<ClassInfo>();
        ClassServiceImpl csi=new ClassServiceImpl();
        List<xmu.crms.vo.Class> classesVO=new ArrayList<xmu.crms.vo.Class>();
        try {
			classes=csi.listClassByName(courseName,teacherName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        for(int i=0;i<classes.size();++i)
        {
        	xmu.crms.vo.Class cla=new xmu.crms.vo.Class(classes.get(i));
        	classesVO.add(cla);
        }
        return classesVO;
    }
    
    /**
     * 得到学生选的所有课
     * @author 艾星
     * @return 与用户相关的班级列表
     * @throws JsonProcessingException 
     */
    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object getClassList() throws JsonProcessingException{
        //以下为获取用户Id
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
        //取出与学生相关的班级
        	List<ClassInfo> classes=new ArrayList<ClassInfo>();
        	List<Class> cla=new ArrayList<Class>();
        	try {
        		classes=classService.listClassByUserId(user.getId());
        	} catch (Exception e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	} 
        	for(int i=0;i<classes.size();++i)
        		cla.add(new Class(classes.get(i))); 
        	
        	return cla;
    }
    
    /**
     * 按ID获取班级详情
     * @author 艾星
     * @return 班级详情
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{classId}",method=GET)
    @ResponseBody
    public Object getClass(@PathVariable int classId) throws JsonProcessingException{        
        xmu.crms.entity.ClassInfo cla=new xmu.crms.entity.ClassInfo();
        ClassServiceImpl csi=new ClassServiceImpl();
        try {
			cla=csi.getClassByClassId(BigInteger.valueOf(classId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return cla;
    }
    
    /**
     * 按ID删除班级
     * @author 艾星
     * @return 
     */
    @RequestMapping(value="/{classId}",method=DELETE)
    @ResponseBody
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteClass(@PathVariable Integer classId){
    	ClassServiceImpl csi=new ClassServiceImpl();
    	try {
			csi.deleteClassByClassId(BigInteger.valueOf(classId));
		} catch (ClassesNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * 按ID修改班级
     * @author 艾星
     * @return 
     */
    @RequestMapping(value="/{classId}",method=PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    @ResponseBody
    public void updateClass(@PathVariable int classId,@RequestBody String JsonString){
        String name,classTime;
        int a,b,c,report,presentation;
        
        name=JsonString.substring(JsonString.indexOf("name")+7,JsonString.indexOf("classTime")-3);
        classTime=JsonString.substring(JsonString.indexOf("classTime")+11, JsonString.indexOf("c")-3);
        c=Integer.parseInt(JsonString.substring(JsonString.indexOf("c"),JsonString.indexOf("b")-3));
        b=Integer.parseInt(JsonString.substring(JsonString.indexOf("b"), JsonString.indexOf("a")-3));
        a=Integer.parseInt(JsonString.substring(JsonString.indexOf("a"),JsonString.indexOf("report")-3));
        report=Integer.parseInt(JsonString.substring(JsonString.indexOf("report")+9,JsonString.indexOf("presentation")-3));
        presentation=Integer.parseInt(JsonString.substring(JsonString.indexOf("presentation")+15, JsonString.indexOf("\"")));
        
        xmu.crms.entity.ClassInfo ci=new xmu.crms.entity.ClassInfo();
        ci.setName(name);
        ci.setClassTime(classTime);
        ci.setFivePointPercentage(new Integer(a));
        ci.setFourPointPercentage(new Integer(b));
        ci.setThreePointPercentage(new Integer(c));
        ci.setReportPercentage(report);
        ci.setPresentationPercentage(presentation);
        
        ClassServiceImpl csi=new ClassServiceImpl();
        
        try {
			csi.updateClassByClassId(BigInteger.valueOf(classId),ci);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * 按班级ID查找学生列表
     * @author 艾星
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{classId}/student",method=GET)
    @ResponseBody
    public Object getStudentList(@PathVariable Integer classId,String numBeginWith,String nameBeginWith) throws JsonProcessingException{
        //取学生列表
        List<xmu.crms.entity.User> users=new ArrayList<xmu.crms.entity.User>();
        List<xmu.crms.vo.User> usersVO=new ArrayList<xmu.crms.vo.User>();
        try {
        	users=userService.listUserByClassId(BigInteger.valueOf(classId.intValue()), numBeginWith.equals("null")?"":numBeginWith, nameBeginWith.equals("null")?"":nameBeginWith);
        	for(int i=0;i<users.size();++i)
				usersVO.add(new xmu.crms.vo.User(users.get(i)));
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        return usersVO;
    }
    
    /**
     * 学生按ID选班级
     * @author 艾星
     * @param classId
     * @return
     * @throws JsonProcessingException
     * @throws MalformedURLException 
     */
    @RequestMapping(value="/{classId}/student",method=POST)
    @ResponseStatus(value=HttpStatus.CREATED)
    @ResponseBody
    public void chooseClass(@RequestBody String userId,@PathVariable Integer classId) throws JsonProcessingException, MalformedURLException{
    	String str=userId.substring(userId.indexOf("id")+5);
    	try {
			classService.insertCourseSelectionById(BigInteger.valueOf(Integer.parseInt(str.substring(0,str.indexOf("\"")+1))),BigInteger.valueOf(classId.intValue()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    /**
     * 学生按ID取消选择班级
     * @author 艾星
     * @param classId
     * @param StudentId
     * @return
     */
    @RequestMapping(value="/{classId}/student/{studentId}",method=DELETE)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    @ResponseBody
    public void cancelClass(@PathVariable Integer classId,Integer studentId){
    	try {
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
            classService.deleteCourseSelectionById(BigInteger.valueOf(user.getId().intValue()),BigInteger.valueOf(classId.intValue()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    /**
     * 按ID获取班级签到状态
     * @author 艾星
     * @param classId
     * @param showPresent
     * @param showLate
     * @param showAbsent
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value="/{classId}/attendance",method=GET)
    @ResponseBody
    public Object getCallingSituationById(@PathVariable int classId,boolean showPresent,boolean showLate,boolean showAbsent) throws JsonProcessingException{
    	ClassServiceImpl csi=new ClassServiceImpl();
    	Object obj=new Object();
        try {
			xmu.crms.entity.Location location=csi.getCallStatusById(BigInteger.valueOf(classId),null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//entity ClassInfo
        return obj;
    }
    
    /**
     * 签到
     * @author 艾星
     * @param classId
     * @param studentId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{classId}/attendance/{studentId}",method=PUT)
    @ResponseBody
    public Object callTheRoll(@PathVariable int classId,int studentId) throws JsonProcessingException{
        Object obj=new Object();
        //UserService.insertAttendanceById(classId,seminarId,
        //userId, longitude, latitude));
        return obj;
    }
    
    /**
     * 按ID获取班级小组
     * @author 艾星
     * @param classId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{classId}/classgroup",method=GET)
    @ResponseBody
    public Object getClassGroup(@PathVariable int classId) throws JsonProcessingException{

    	ClassGroup cg=null;
        //获取用户Id
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
        //获取固定小组信息
    	try {
			xmu.crms.entity.FixGroup fg=fixGroupService.getFixedGroupById(user.getId(),BigInteger.valueOf(classId));
			List<xmu.crms.entity.User> list=fixGroupService.listFixGroupMemberByGroupId(fg.getId());
			List<xmu.crms.entity.User> member=new ArrayList<xmu.crms.entity.User>();
			for(int i=0;i<list.size();++i)
				if(list.get(i).getId().intValue()!=fg.getLeader().getId().intValue())
				{
					member.add(list.get(i));
				}
			cg=new ClassGroup(fg,member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        return cg;
    }
    
    /**
     * 按ID修改班级小组
     * @author 艾星
     * @param classId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{classId}/classgroup",method=PUT)
    @ResponseBody
    public void editClassGroup(@PathVariable int classId) throws JsonProcessingException{
        int userId=2;
    	FixGroupServiceImpl fsi=new FixGroupServiceImpl();
        try {
			xmu.crms.entity.FixGroup fg=fsi.getFixedGroupById(BigInteger.valueOf(userId), BigInteger.valueOf(classId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        //fsi.updateFixGroupByGroupId(fg.getId());
    }
}