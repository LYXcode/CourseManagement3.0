package controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.Group;
import entity.PresentationGrade;
import entity.SeminarGrade;
import entity.Topic;
import entity.User;

/**
 * GroupController class
 * 小组Controller层
 * @author 艾星
 * @date 2017/11/28
 */
@Controller
@RequestMapping("/group")
public class GroupController {
    /**
     * 按小组Id获得小组详情
     * @author 吕柏翰
     * @param groupId
	 * @return Object 返回对象
	 * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/{groupId}",method=GET)
    @ResponseBody
    public Object getGroupInfoById(@PathVariable int groupId,boolean embedTopics,boolean embedGrade) throws JsonProcessingException{
    	Group group=new Group();
    	group.setId(28);
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
     * 组长辞职
     * @author 吕柏翰
     * @param groupId 小组的ID
     * @param request
	 * @return Object 返回对象
	 * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/{groupId}/resign",method=PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    @ResponseBody
    public Object resignGroupLeader(@PathVariable int groupId, @RequestBody String request) throws JsonProcessingException{
    	return null;
    }
    /**
     * 成为组长
     * @author 吕柏翰
     * @param groupId 小组的ID
     * @param request
	 * @return Object 返回对象
	 * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/{groupId}/assign",method=PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    @ResponseBody
    public Object assignGroupLeader(@PathVariable int groupId,@RequestBody String request) throws JsonProcessingException{
    	return null;
    }
    /**
     * 添加成员
     * @author 吕柏翰
     * @param groupId 小组的ID
     * @param request
	 * @return Object 返回对象
	 * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/{groupId}/add",method=PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    @ResponseBody
    public Object addGroupMember(@PathVariable Integer groupId,String request) throws JsonProcessingException{
    	System.out.println("添加");
        return null;
    }
    /**
     * 移除成员
     * @author 吕柏翰
     * @param groupId 小组的ID
     * @param request
	 * @return Object 返回对象
	 * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/{groupId}/remove",method=PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    @ResponseBody
    public Object removeGroupMember(@PathVariable int groupId,@RequestBody String request) throws JsonProcessingException{
        System.out.println("删除");
        return null;
    }
    /**
     * 小组按ID选择话题
     * @author 吕柏翰
     * @param groupId 小组的ID
     * @param request
	 * @return Object 返回对象
	 * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/{groupId}/topic",method=POST)
    @ResponseStatus(value=HttpStatus.CREATED)
    @ResponseBody
    public Object selectTopic(@PathVariable int groupId,@RequestBody String request) throws JsonProcessingException{
    	return null;
    }
    /**
     * 小组按ID取消选择话题
     * @author 吕柏翰
     * @param groupId 小组ID
     * @param topicId 取消选择的话题的ID
	 * @return Object 返回对象
	 * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/{groupId}/topic/{topicId}",method=DELETE)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    @ResponseBody
    public Object deselectTopic(@PathVariable int groupId,@PathVariable int topicId) throws JsonProcessingException{
    	return null;
    }
    /**
     * 按ID获取小组的讨论课成绩
     * @author 吕柏翰
     * @param groupId 需获取成绩的小组ID
	 * @return Object 返回对象
	 * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/{groupId}/grade",method=GET)
    @ResponseBody
    public Object getGradeByGroupId(@PathVariable int groupId) throws JsonProcessingException{
    	SeminarGrade grade=new SeminarGrade();
    	PresentationGrade[] presentation=new PresentationGrade[2];
    	presentation[0]=new PresentationGrade();
    	presentation[0].setGrade(4);
    	presentation[0].setTopicId(257);    	
    	
    	grade.setPresentationGrade(presentation);
    	grade.setReportGrade(3);
    	grade.setGrade(4);
    	return grade;
    }
    /**
     * 按ID设置小组的报告分
     * @author 吕柏翰
     * @param groupId 需设置成绩的小组ID
     * @param request
	 * @return Object 返回对象
	 * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/{groupId}/grade/report",method=PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    @ResponseBody
    public Object finalGradeByGroupId(@PathVariable int groupId,@RequestBody String request) throws JsonProcessingException{
    	return null;
    }
    /**
     * 提交对其他小组的打分
     * @author 吕柏翰
     * @param groupId 被打分的小组的ID
     * @param studentId 打分的学生的ID
     * @param request
	 * @return Object 返回对象
	 * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/{groupId}/grade/presentation/{studentId}",method=PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    @ResponseBody
    public Object submitGradeByGroupId(@PathVariable int groupId,@PathVariable int studentId,@RequestBody String request) throws JsonProcessingException{
    	return null;
    }
}
