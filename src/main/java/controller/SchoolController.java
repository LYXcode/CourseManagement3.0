package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/school")
public class SchoolController {
    private ObjectMapper mapper=new ObjectMapper();
    private Object obj;
    
    /**
     * 获取学校列表
     * @author 艾星
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value="/",method=GET)
    public String getSchoolList() throws JsonProcessingException{
        return mapper.writeValueAsString(obj);
    }
    
    /**
     * 添加学校
     * @author 艾星
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value="/",method=POST)
    public String addSchool() throws JsonProcessingException{
        return mapper.writeValueAsString(obj);
    }
}
