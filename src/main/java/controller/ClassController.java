package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import java.util.*;
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
@Controller
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
    public Object getClassAll(@PathVariable String courseName,String teacherName) throws JsonProcessingException{
        //从数据库中取出对应类obj
        System.out.println(courseName);
        List<Class> classes=new ArrayList<Class>();
        Class cla=new Class();
        cla.setName("后台传来的班级");
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
    public void getClassInfoById(@PathVariable int classId) throws JsonProcessingException{        
        System.out.println(classId);
    }
    
    /**
     * 按ID删除班级
     * @author 艾星
     * @return 
     */
    @RequestMapping(value="/{classId}",method=DELETE)
    @ResponseBody
    public void deleteClassById(@PathVariable int classId){
        //删除操作
        System.out.println(classId);
    }
    
    /**
     * 按ID修改班级
     * @author 艾星
     * @return 
     */
    @RequestMapping(value="/{classId}",method=PUT)
    @ResponseBody
    public void editClassInfo(@PathVariable int classId){
        System.out.println("修改"+classId);
    }
    
    /**
     * 按班级ID查找学生列表
     * @author 艾星
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{classId}/student",method=GET)
    @ResponseBody
    public Object getClassStudent(@PathVariable int classId) throws JsonProcessingException{
        //取学生列表
        List<User> useres=new ArrayList<User>();
        User user=new User();
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
    public Object studentSelectClass(@RequestBody Class cla) throws JsonProcessingException{
        System.out.println("选课了");
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
    public void studentCancelClass(@PathVariable int classId,int studentId){

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
        Object obj=new Object();
        return obj;
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