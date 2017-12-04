package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import entity.*;
import entity.Class;

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
    /**
     * 获取与当前用户相关的或者符合条件的班级列表
     * @author 艾星
     * @return 与用户相关的班级列表
     * @throws JsonProcessingException 
     */
    @RequestMapping(method=GET)
    @ResponseBody
    public Object getClassList(@PathVariable String courseName,String teacherName) throws JsonProcessingException{
        //从数据库中取出对应类obj
        System.out.println(courseName);
        List<Class> classes=new ArrayList<Class>();
        Class cla=new Class();
        cla.setId(5);
        cla.setName("周三12节");
        cla.setNumStudent(66);
        cla.setTime("周三12节，单周周一56节");
        cla.setSite("海韵206，公寓405");
        cla.setCourseName("OOAD(后台)");
        cla.setCourseTeacher("XX老师");
        classes.add(cla);
        return classes;
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
        Class cla=new Class();
        Proportions pro=new Proportions();
        pro.seta(50);
        pro.setb(30);
        pro.setc(20);
        pro.setReport(40);
        pro.setPresentation(60);
        
        cla.setId(5);
        cla.setName("周三12节");
        cla.setNumStudent(66);
        cla.setTime("周三12节，单周周一56节");
        cla.setSite("海韵206，公寓405");
        cla.setCalling(0);
        cla.setRoster("D://XXX//XXX");
        cla.setProportions(pro);
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
    public Object deleteClass(@PathVariable Integer classId){
        return classId;
    }
    
    /**
     * 按ID修改班级
     * @author 艾星
     * @return 
     */
    @RequestMapping(value="/{classId}",method=PUT)
    //@ResponseBody
    public void updateClass(@PathVariable int classId){
        //System.out.println("修改"+classId);
        return;
    }
    
    /**
     * 按班级ID查找学生列表
     * @author 艾星
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{classId}/student",method=GET)
    @ResponseBody//@PathVariable int classId
    public Object getStudentList(@PathVariable Integer classid) throws JsonProcessingException{
        //取学生列表
        List<User> useres=new ArrayList<User>();
        User user=new User();
        user.setId(8);
        user.setName("用户XXX");
        user.setNumber("1867745……");
        useres.add(user);
        return useres;
    }
    
    /**
     * 学生按ID选班级
     * @author 艾星
     * @param classId
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value="/{classId}/student",method=POST)
    @ResponseBody
    public Object chooseClass(@PathVariable Integer classid) throws JsonProcessingException{
        System.out.println("选课了");
        Class cla=new Class();
        return cla;
    }
    
    /**
     * 学生按ID取消选择班级
     * @author 艾星
     * @param classId
     * @param StudentId
     * @return
     */
    @RequestMapping(value="/{classId}/student/{studentId}",method=DELETE)
    @ResponseBody
    public void cancelClass(@PathVariable int classId,int studentId){
        //删除程序
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
        Object obj=new Object();
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
        Group group=new Group();
        User[] users=new User[2];
        users[0]=new User();
        users[0].setId(8);
        users[0].setName("用户XXX");
        users[0].setNumber("1876545……");
        group.setLeader(users[0]);
        group.setMembers(users);
        return group;
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
        
    }
}