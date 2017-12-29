package xmu.crms.controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.math.BigInteger;
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

import com.fasterxml.jackson.core.JsonProcessingException;

import xmu.crms.exception.TopicNotFoundException;
import xmu.crms.service.*;
import xmu.crms.vo.*;

/**
 * 
 * TopicController class
 * 讨论课话题信息 controller层
 * @author 艾星
 * @date 2017/11/28
 * 
 */
@RestController
@RequestMapping("/topic")
public class TopicController {  
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private TopicService topicService;
	@Autowired
	private SeminarGroupService seminarGroupService;
    /**
     * 按ID获取讨论课话题
     * @author 艾星
     * @param topicId
     * @return
     */
    @RequestMapping(value="/{topicId}",method=GET)
    @ResponseBody
    public Object getTopicById(@PathVariable int topicId) throws JsonProcessingException{
        xmu.crms.vo.Topic topic=null;
        try {
			topic=new xmu.crms.vo.Topic(topicService.getTopicByTopicId(BigInteger.valueOf(topicId)),
			seminarGroupService.listGroupByTopicId(BigInteger.valueOf(topicId)).size());
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return topic;
    }
    
    /**
     * 按Id修修改话题
     * @author 艾星
     * @param topicId
     * @return
     */
    @RequestMapping(value="/{topicId}",method=PUT)
    @ResponseBody
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void editTopicById(@PathVariable int topicId,@RequestBody String JsonString){
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
        try {
			tsi.updateTopicByTopicId(BigInteger.valueOf(topicId),topic);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * 按Id修删除话题
     * @author 艾星
     * @param topicId
     * @return
     */
    @RequestMapping(value="/{topicId}",method=DELETE)
    @ResponseBody
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteTopicById(@PathVariable int topicId){
    	TopicServiceImpl tsi=new TopicServiceImpl();
    	tsi.deleteTopicByTopicId(BigInteger.valueOf(topicId));
    }
    
    /**
     * 按ID获取选择了该话题的小组
     * @author 艾星
     * @param topicId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{topicId}/group",method=GET)
    //@ResponseBody
    public Object getGroupByTopic(@PathVariable int topicId) throws JsonProcessingException{
        List<Group> groups=new ArrayList<Group>();
        TopicServiceImpl tsi=new TopicServiceImpl();
        //似乎没相应方法
        return groups;
    }
    
}