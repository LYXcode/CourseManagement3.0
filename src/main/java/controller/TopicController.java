package controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * TopicController class
 * 讨论课话题信息 controller层
 * @author 艾星
 * @date 2017/11/28
 * 
 */
@Controller
@RequestMapping("/topic")
public class TopicController {
    ObjectMapper mapper=new ObjectMapper();
    Object obj;
    
    /**
     * 按ID获取讨论课话题
     * @author 艾星
     * @param topicId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{topicId}",method=GET) 
    public String getTopicById(int topicId) throws JsonProcessingException{
        return mapper.writeValueAsString(obj);
    }
    
    /**
     * 按Id删除讨论课话题
     * @author 艾星
     * @param topicId
     * @return
     */
    @RequestMapping(value="/{topicId}",method=DELETE)
    public String deleteTopicById(int topicId){
        return "";
    }
    
    /**
     * 按ID修改话题
     * @author 艾星
     * @param topicId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{topicId}/grade",method=PUT)
    public String editTopic(int topicId) throws JsonProcessingException{
        return mapper.writeValueAsString(obj);
    }
    
    /**
     * 按ID获取选择了该话题的小组
     * @author 艾星
     * @param topicId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{topicId}/group",method=GET)
    public String getGroupByTopic(int topicId) throws JsonProcessingException{
        return mapper.writeValueAsString(obj); 
    }
    
    /**
     * 小组按ID选择话题
     * @author 艾星
     * @param topicId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{topicId}/group",method=POST)
    public String groupSelectTopic(int topicId) throws JsonProcessingException{
        return mapper.writeValueAsString(obj);
    }
    
    /**
     * 小组按ID取消选择话题
     * @author 艾星
     * @param topicId
     * @param groupId
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/{topicId}/group/{groupId}",method=DELETE)
    public String groupCancelTopic(int topicId,int groupId) throws JsonProcessingException{
        return mapper.writeValueAsString(obj);
    }
    
    
}