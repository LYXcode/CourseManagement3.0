package xmu.crms.controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;

import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.service.*;
import xmu.crms.vo.*;
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
    @Autowired
    private HttpServletRequest request;
	@Autowired
	private SeminarService seminarService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private SeminarGroupService seminarGroupService;
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
        xmu.crms.entity.Seminar sem=new xmu.crms.entity.Seminar();
        xmu.crms.vo.Seminar seminar=null;
        try {
			sem=seminarService.getSeminarBySeminarId(BigInteger.valueOf(seminarId));
			List<xmu.crms.entity.Topic> topics=topicService.listTopicBySeminarId(BigInteger.valueOf(seminarId));
			List<xmu.crms.vo.Topic> topicsVO=new ArrayList<xmu.crms.vo.Topic>();
			xmu.crms.vo.Topic[] topic=new xmu.crms.vo.Topic[topics.size()];
			for(int i=0;i<topics.size();++i)
			{
				int groupCurrent=seminarGroupService.listGroupByTopicId(topics.get(i).getId()).size();
				topicsVO.add(new xmu.crms.vo.Topic(topics.get(i),groupCurrent));
				topic[i]=new xmu.crms.vo.Topic(topics.get(i),groupCurrent);
			}
			seminar=new xmu.crms.vo.Seminar(sem);
			seminar.setTopics(topic);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return seminar;
    }
    /**
     * 按Id修改讨论课
     * @author 艾星
     * @param seminarId
     */
    @RequestMapping(value="/{seminarId}",method=PUT)
    @ResponseBody
    public void editSeminarById(@PathVariable Integer seminarId,@RequestBody String JsonString){
	    xmu.crms.entity.Seminar seminar=new  xmu.crms.entity.Seminar();
        
        seminar.setName(JsonString.substring(JsonString.indexOf("name")+7,
                JsonString.indexOf("description")-3));
        seminar.setDescription(JsonString.substring(JsonString.indexOf("description")+14,
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
        seminar.setStartTime(startDate);

        str=JsonString.substring(JsonString.indexOf("endTime")+10,
                JsonString.indexOf("proc")-3);
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
        seminar.setEndTime(endDate);

        String string=JsonString.substring(JsonString.indexOf("groupingMethod")+17);
        if(string.substring(0,string.indexOf("\"")).equals("固定分组"))
        	seminar.setFixed(new Boolean(true));
        else
        	seminar.setFixed(new Boolean(false));
           	    
    	SeminarServiceImpl ssi=new SeminarServiceImpl();
    	try {
			ssi.updateSeminarBySeminarId(BigInteger.valueOf(seminarId),seminar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
    public void deleteSeminarById(@PathVariable int seminarId){
    	SeminarServiceImpl ssi=new SeminarServiceImpl();
        ssi.deleteSeminarBySeminarId(BigInteger.valueOf(seminarId));
    }
    
    @RequestMapping(value="/{seminarId}/detail",method=GET)
    @ResponseBody
    public Object getSeminarDetailById(@PathVariable int seminarId){
        SeminarDetail seminar=null;
    	SeminarServiceImpl ssi=new SeminarServiceImpl();
    	ClassServiceImpl csi=new ClassServiceImpl();
    	try {
			ssi.getSeminarBySeminarId(BigInteger.valueOf(seminarId));
			//需要seminar所属的classinfo
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
    @ResponseBody
    public Object getSeminarGrade(@PathVariable int seminarId) throws JsonProcessingException{
    	xmu.crms.vo.SeminarGradeDetail[] grade=null;
    	List<xmu.crms.entity.SeminarGroup> seminarGroups=new ArrayList<xmu.crms.entity.SeminarGroup>();    	
    	try {
    		seminarGroups=seminarGroupService.listSeminarGroupBySeminarId(BigInteger.valueOf(seminarId));
			grade=new xmu.crms.vo.SeminarGradeDetail[seminarGroups.size()];
    		for(int i=0;i<seminarGroups.size();++i)
				grade[i]=new xmu.crms.vo.SeminarGradeDetail(seminarGroups.get(i));
			
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return grade;
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
        //GradeService.insertGroupGradeByUserId(topciId,userId,groupId,grade);
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
        //GradeServiceinsertGroupGradeByUserId
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
        List<xmu.crms.entity.Topic> topics=new ArrayList<xmu.crms.entity.Topic>();
        List<xmu.crms.vo.Topic> topicsVO=new ArrayList<xmu.crms.vo.Topic>();
        topics=topicService.listTopicBySeminarId(BigInteger.valueOf(seminarId));
        for(int i=0;i<topics.size();++i)
        {
			int groupCurrent=seminarGroupService.listGroupByTopicId(topics.get(i).getId()).size();
        	topicsVO.add(new xmu.crms.vo.Topic(topics.get(i),groupCurrent));
        }
        return topicsVO;
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
    public void createNewTopic1(@PathVariable int seminarId,@RequestBody String JsonString) throws JsonProcessingException{
        String name,description;
        int groupLimit,numLimit;
        xmu.crms.entity.Topic topic=new xmu.crms.entity.Topic();
        
        name=JsonString.substring(JsonString.indexOf("name")+7,JsonString.indexOf("description")-3);
        description=JsonString.substring(JsonString.indexOf("description")+14, JsonString.indexOf("groupLimit")-3);
        groupLimit=Integer.parseInt(JsonString.substring(JsonString.indexOf("groupLimit")+9,JsonString.indexOf("numLimit")-3));
        numLimit=Integer.parseInt(JsonString.substring(JsonString.indexOf("numLimit")+11,JsonString.indexOf("\"")));
        
        topic.setName(name);
        topic.setDesciption(description);
        topic.setGroupNumberLimit(groupLimit);
        topic.setGroupStudentLimit(numLimit);
        TopicServiceImpl tsi=new TopicServiceImpl();
        tsi.insertTopicBySeminarId(BigInteger.valueOf(seminarId),topic);
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
        //获取用户ID
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
         
        xmu.crms.vo.Group group=null;
    	try {
			xmu.crms.entity.SeminarGroup seminarGroup=seminarGroupService.getSeminarGroupById(
					BigInteger.valueOf(seminarId.intValue()), user.getId());
			System.out.println(seminarId+" "+user.getId().intValue());
			List<SeminarGroupTopic> seminarGroupTopic=topicService.listSeminarGroupTopicByGroupId(seminarGroup.getId());
			xmu.crms.vo.Topic[] topic=new xmu.crms.vo.Topic[seminarGroupTopic.size()];
			for(int i=0;i<seminarGroupTopic.size();++i)
			{
				int groupCurrent=seminarGroupService.listGroupByTopicId(seminarGroupTopic.get(i).getTopic().getId()).size();
				topic[i]=new xmu.crms.vo.Topic(seminarGroupTopic.get(i).getTopic(),groupCurrent);
			}
			group=new xmu.crms.vo.Group(seminarGroup,seminarGroupService.
					listSeminarGroupMemberByGroupId(seminarGroup.getId()));
			group.setTopics(topic);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
        BigInteger userId=BigInteger.valueOf(2);
    	Group group=new Group();
        SeminarGroupServiceImpl sgsi=new SeminarGroupServiceImpl();
        try {
			sgsi.getSeminarGroupById(BigInteger.valueOf(seminarId.intValue()),userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         
        return group;
    }
}
