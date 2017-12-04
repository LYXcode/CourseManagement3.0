package controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.*;

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
    /**
     * 按ID获取讨论课话题
     * @author 艾星
     * @param topicId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{topicId}",method=GET)
    @ResponseBody
    public Object getTopicById(@PathVariable int topicId) throws JsonProcessingException{
        Topic topic=new Topic();
        topic.setId(6);
        topic.setSerial("XXXX");
        topic.setDescription("该题目……");
        topic.setGroupLimit(10);
        topic.setGroupMemberLimit(5);
        topic.setGroupLeft(3);
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
        Group group=new Group();
        group.setId(6);
        group.setName("XXX小组");
        groups.add(group);
        return groups;
    }
    
}