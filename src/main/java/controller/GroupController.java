package controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * GroupController class
 * 小组Controller层
 * @author 艾星
 * @date 2017/11/28
 */
@Controller
@RequestMapping("/group")
public class GroupController {
    private ObjectMapper mapper=new ObjectMapper();
    private Object obj;
    
    /**
     * 按小组Id获得小组详情
     * @author 艾星
     * @param groupId
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/{groupId}",method=GET)
    public String getGroupInfoById(int groupId) throws JsonProcessingException{
        return mapper.writeValueAsString(obj);
    }
    
    
    /**
     * 按小组ID修改小组
     * @author 艾星
     * @param groupId
     * @return
     */
    @RequestMapping(value="/{groupId}",method=PUT)
    public String editGroup(int groupId){
        return "";
    }
}
