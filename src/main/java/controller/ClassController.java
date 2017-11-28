package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    private ObjectMapper mapper=new ObjectMapper();
    private Object obj;
    /**
     * 获取与当前用户相关的或者符合条件的班级列表
     * @author 艾星
     * @return 与用户相关的班级列表
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/",method=GET)
    public String getClassAboutUser(String courseName,String teacherName) throws JsonProcessingException{
        //从数据库中取出对应类obj
        return mapper.writeValueAsString(obj);
    }
    
    /**
     * 按ID获取班级详情
     * @author 艾星
     * @return 班级详情
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{classId}",method=GET)
    public String getClassInfoById(int classId) throws JsonProcessingException{
        
        return mapper.writeValueAsString(obj);
    }
    
    /**
     * 按ID删除班级
     * @author 艾星
     * @return 
     */
    @RequestMapping(value="/{classId}",method=DELETE)
    public String deleteClassById(int classId){
        //删除操作
        return "";
    }
    
    /**
     * 按ID修改班级
     * @author 艾星
     * @return 
     */
    @RequestMapping(value="/{classId}",method=PUT)
    public String editClassInfo(int classId){
        return "";
    }
    
    /**
     * 按班级ID查找学生列表
     * @author 艾星
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{classId}/student",method=GET)
    public String getClassStudent(int classId) throws JsonProcessingException{
        //取学生列表
        return mapper.writeValueAsString(obj);
    }
    
    /**
     * 学生按ID选班级
     * @author 艾星
     * @param classId
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value="/{classId}/student",method=POST)
    public String studentSelectClass(int classId) throws JsonProcessingException{
        return mapper.writeValueAsString(obj);
    }
    
    /**
     * 学生按ID取消选择班级
     * @author 艾星
     * @param classId
     * @param StudentId
     * @return
     */
    @RequestMapping(value="/{classId}/student/{studentId}",method=DELETE)
    public String studentCancelClass(int classId,int studentId){
        return "";
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
    public String getCallingSituationById(int classId,boolean showPresent,boolean showLate,boolean showAbsent) throws JsonProcessingException{
        return mapper.writeValueAsString(obj);
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
    public String callTheRoll(int classId,int studentId) throws JsonProcessingException{
        return mapper.writeValueAsString(obj);
    }
    
    /**
     * 按ID获取班级小组
     * @author 艾星
     * @param classId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{classId}/classgroup",method=GET)
    public String getClassGroup(int classId) throws JsonProcessingException{
        return mapper.writeValueAsString(obj);
    }
    
    /**
     * 按ID修改班级小组
     * @author 艾星
     * @param classId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{classId}/classgroup",method=PUT)
    public String editClassGroup(int classId) throws JsonProcessingException{
        return mapper.writeValueAsString(obj);
    }
}