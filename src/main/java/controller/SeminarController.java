package controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import entity.Group;
import entity.GroupingEnum;
import entity.Seminar;
import entity.SeminarDetail;
import entity.StudentSeminar;
import entity.Topic;
import entity.User;
/**
 * 
 * SeminarController class
 * 讨论课信息 controller层
 * @author 艾星
 * @date 2017/11/28
 * 
 */
@RestController
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
        Topic[] topics=new Topic[2];
        topics[0]=new Topic();
        topics[0].setId(8);
        topics[0].setName("XXX题目");
        sem.setId(78);
        sem.setName("后台来的讨论课");
        sem.setGroupingMethod(GroupingEnum.random);
        sem.setStartTime("24");
        sem.setEndTime("67");
        sem.setTopics(topics);
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
    
    @RequestMapping(value="/{seminarId}/detail",method=GET)
    @ResponseBody
    public Object getSeminarDetailById(){
        SeminarDetail seminar=new SeminarDetail();
        seminar.setId(7);
        seminar.setName("后台的讨论课");
        seminar.setSite("海韵219");
        seminar.setTeacherEmail("XX@XX.com");
        seminar.setStartTime("2154tg");
        seminar.setEndTime("235t");
        seminar.setTeacherName("XX老师");
        return seminar;
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
    @ResponseBody
    public Object getSeminarTopicById(@PathVariable Integer seminarId) throws JsonProcessingException{
        List<Topic> topics=new ArrayList<Topic>();
        Topic topic=new Topic();
        topic.setId(6);
        topic.setSerial("XXXX");
        topic.setDescription("该题目……");
        topic.setGroupLimit(10);
        topic.setGroupMemberLimit(5);
        topic.setGroupLeft(3);
        topics.add(topic);
        //return topics;
        return topic;
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
    
    @RequestMapping(value="/{seminarId}/my",method=GET)
    @ResponseBody
    public Object getSeminarByUser(@PathVariable Integer seminarId){
        StudentSeminar seminar=new StudentSeminar();
        seminar.setId(7);
        seminar.setName("后台的讨论课");
        seminar.setGroupingMethod(GroupingEnum.fixed);
        seminar.setClassCalling(0);
        seminar.setStartTime("2154tg");
        seminar.setEndTime("235t");
        seminar.setCourseName("J2EE");
        seminar.setLeader(false);
        seminar.setAreTopicsSelected(false);
        return seminar;
    }
    
    /**
     * 按用户查找小组
     * @author 艾星
     * @param seminarId
     * @param studentId
     * @param gradeable
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value="/{seminarId}/group/my",method=GET)
    public Object getGroupByUser(@PathVariable Integer seminarId,Integer studentId) throws JsonProcessingException{
        Group group=new Group();
        group.setId(28);
        group.setName("用户XXX的小组");
        User leader=new User();
        leader.setId(8888);
        leader.setName("张三");
        User[] members=new User[2];
        
        User member1=new User();
        member1.setId(5324);
        member1.setName("李四");
        members[0]=member1;
        
        User member2=new User();
        member2.setId(5678);
        member2.setName("王五");
        members[1]=member2;
        
        //group.setLeader(leader);
        group.setMembers(members);
        
        Topic[] topics=new Topic[1];
        Topic topic1=new Topic();
        topic1.setId(257);
        topic1.setName("领域模型与模块");
        topics[0]=topic1;
        
        group.setTopics(topics);
        
        return group;
    }
    /**
     * 按讨论课ID查找用户小组
     * @author 艾星
     * @param seminarId
     * @param studentId
     * @param gradeable
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value="/{seminarId}/group",method=GET)
    public Object getGroupBySeminarId(@PathVariable Integer seminarId,Integer studentId) throws JsonProcessingException{
        Group group=new Group();
        group.setId(28);
        group.setName("讨论课"+seminarId+"的小组");
        User leader=new User();
        leader.setId(8888);
        leader.setName("张三");
        User[] members=new User[2];
        
        User member1=new User();
        member1.setId(5324);
        member1.setName("李四");
        members[0]=member1;
        
        User member2=new User();
        member2.setId(5678);
        member2.setName("王五");
        members[1]=member2;
        
        //group.setLeader(leader);
        group.setMembers(members);
        
        Topic[] topics=new Topic[1];
        Topic topic1=new Topic();
        topic1.setId(257);
        topic1.setName("领域模型与模块");
        topics[0]=topic1;
        
        group.setTopics(topics);
        
        return group;
    }
}
