package xmu.crms.controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.fasterxml.jackson.core.JsonProcessingException;

import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.exception.InvalidOperationException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.*;
import xmu.crms.vo.*;

/**
 * GroupController class
 * 小组Controller层
 * @author 艾星
 * @date 2017/11/28
 */
@Controller
@RequestMapping("/group")
public class GroupController {
	
	@Autowired
	private TopicService topicService;
	@Autowired
	private FixGroupService fixGroupService;
	@Autowired
	private HttpServletRequest request;
	
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
        xmu.crms.entity.SeminarGroup seminarGroup=new xmu.crms.entity.SeminarGroup();
        SeminarGroupServiceImpl sgsi=new SeminarGroupServiceImpl();
    	try {
			seminarGroup=sgsi.getSeminarGroupByGroupId(BigInteger.valueOf(groupId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	List<xmu.crms.entity.User> users=null;
		try {
			users = sgsi.listSeminarGroupMemberByGroupId(BigInteger.valueOf(groupId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	xmu.crms.vo.Group group=new xmu.crms.vo.Group(seminarGroup,users);
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
    public void addGroupMember(@PathVariable Integer groupId,@RequestBody String request) throws JsonProcessingException{
    	String str=request.substring(request.indexOf("id")+5);
    	int new_userId=Integer.parseInt(str.substring(0,str.indexOf("\"")));
    	try {
			fixGroupService.insertStudentIntoGroup(BigInteger.valueOf(new_userId),BigInteger.valueOf(groupId.intValue()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
    public void removeGroupMember(@PathVariable int groupId,@RequestBody String request) throws JsonProcessingException{
    	String str=request.substring(request.indexOf("id")+5);
    	int userId=Integer.parseInt(str.substring(0,request.indexOf("\"")+1));
    	try {
    		
    		fixGroupService.deleteFixGroupUserById(BigInteger.valueOf(groupId),BigInteger.valueOf(userId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
    public void selectTopic(@PathVariable int groupId,@RequestBody String request) throws JsonProcessingException{
    	BigInteger userId=BigInteger.valueOf(2);
    	BigInteger topicId=BigInteger.valueOf(2);
    	try {
    		seminarGroupService.insertTopicByGroupId(BigInteger.valueOf(groupId),topicId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
    public void deselectTopic(@PathVariable int groupId,@PathVariable int topicId) throws JsonProcessingException{
    	TopicServiceImpl tsi=new TopicServiceImpl();
    	tsi.deleteTopicBySeminarId(BigInteger.valueOf(groupId));
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
    	xmu.crms.vo.SeminarGradeDetail[] grade=null;
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
    	BigInteger grade=BigInteger.valueOf(3);
    	GradeServiceImpl gsi=new GradeServiceImpl();
    	try {
			gsi.updateGroupByGroupId(BigInteger.valueOf(groupId),grade);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
    	//GradeService.insertGroupGradeByUserId(topicId,userId,groupId,grade);
        return null;
    }
}
