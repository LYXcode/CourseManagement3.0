package controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/group")
public class GroupController {
    private ObjectMapper mapper=new ObjectMapper();
    private Object obj;
    
    /**
     * 按小组Id获得小组详情
     * @author 艾星
     * @param groupId
     * @return
     * @throws JsonProcessingException 
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
