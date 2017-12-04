package controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.Seminar;
/**
 * 
 * SeminarController class
 * 讨论课信息 controller层
 * @author 艾星
 * @date 2017/11/28
 * 
 */
@Controller
@RequestMapping("/seminar")
public class SeminarController {
    /**
     * 按ID获取讨论课
     * @author 艾星
     * @param seminarId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{seminarId}",method=GET)
    @ResponseBody
    public Object getSeminarById(@PathVariable int seminarId) throws JsonProcessingException{
        Seminar sem=new Seminar();
        sem.setName("后台来的讨论课");
        return sem;
    }
    /**
     * 按Id修改讨论课
     * @author 艾星
     * @param seminarId
     */
    @RequestMapping(value="/{seminarId}",method=PUT)
    @ResponseBody
    public void editSeminarById(@PathVariable Integer seminarId){
        System.out.println("seminarId"+seminarId);
    }
    /**
     * 按Id删除讨论课
     * @author 艾星
     * @param seminarId
     * @return
     */
    @RequestMapping(value="/{seminarId}",method=DELETE)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    @ResponseBody
    public String deleteSeminarById(@PathVariable int seminarId){
        return "";
    }
    
    /**
     * 按ID获取与用户相关的讨论课成绩
     * @author 艾星
     * @param seminarId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{seminarId}/grade",method=GET)
    public String getSeminarGrade(int seminarId) throws JsonProcessingException{
        return "";
    }
    
    /**
     * 确定各小组的打分
     * @author 艾星
     * @param seminarId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{seminarId}/grade",method=PUT)
    public String sureGroupGrade(int seminarId) throws JsonProcessingException{
        return "";
    }
    
    /**
     * 提交对其他小组的打分
     * @author 艾星
     * @param seminarId
     * @param studentId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{seminarId}/grade/{studentId}",method=PUT)
    public String sureGroupGrade(int seminarId,int studentId) throws JsonProcessingException{
        return "";
    }
    
    /**
     * 按Id获取讨论课话题
     * @author 艾星
     * @param seminarId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{seminarId}/topic",method=GET)
    public String getSeminarTopicById(int seminarId) throws JsonProcessingException{
        return "";
    }
    
    /**
     * 在指定ID的讨论课创建话题
     * @author 艾星
     * @param seminarId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{seminarId}/topic",method=POST)
    @ResponseBody
    public void createNewTopic1(@PathVariable int seminarId) throws JsonProcessingException{
        
    }
    
    /**
     * 按讨论课ID查找小组
     * @author 艾星
     * @param seminarId
     * @param studentId
     * @param gradeable
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value="/{seminarId}/group",method=GET)
    public String getGroupBySeminarId(@PathVariable int seminarId,Integer studentId) throws JsonProcessingException{
        return "";
    }
}
