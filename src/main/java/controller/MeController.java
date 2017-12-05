package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;

import entity.GenderEnum;
import entity.School;
import entity.User;
import entity.UserEnum;

/**
 * MeController class
 * 用户个人信息Controller层
 * @author 吕柏翰
 * @date 2017/11/27
 */
@RestController
public class MeController {
	/**
	 * 获取当前用户
	 * @author 吕柏翰
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/me",method=GET)
	@ResponseBody
	public Object getCurrentUser() throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
	    User user=new User();
	    user.setId(8);
	    user.setType(UserEnum.teacher);
	    user.setName("教师XXXX");
	    user.setEmail("21445");
	    user.setName("fdh");	    
	    user.setGender(GenderEnum.female);
	    user.setSchool(new School());
	    user.setPhone("1877653……");
	    user.setNumber("1877653……");
	    user.setTitle("");
	    user.setAvatar("//XXX//XXX");
	    return user;
	}
	/**
	 * 修改当前用户
	 * @author 吕柏翰
     * @param user 前端传回的数据
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/me",method=PUT)
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public String updateCurrentUser(String user) throws JsonProcessingException{
	      //System.out.println(user.getPhone());
	        //System.out.println(user.getName());
	        //System.out.println(user.getEmail());
	        return "";
	}
	   /**
     * 修改/绑定当前用户
     * @author 艾星
     * @param user 前端传回的数据
     * @return String 返回Json数据
     * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/me",method=PATCH)
    @ResponseBody
    public void bindCurrentUser(@RequestBody User user) throws JsonProcessingException{
          System.out.println(user.getPhone());
            System.out.println(user.getName());
            System.out.println(user.getSchool());
            System.out.println(user.getEmail());
    }
	/**
	 * 微信小程序/OAuth2登录
	 * @author 吕柏翰
	 * @param code 微信小程序/OAuth2授权的Code
	 * @param state 微信OAuth2授权的state 对于小程序 值恒为 MiniProgram
	 * @param successUrl 微信OAuth2授权后跳转到的网址
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/signin",method=GET)
	@ResponseBody
	public Object signinWechat(@RequestParam String code,@RequestParam String state,@RequestParam String success_url) throws JsonProcessingException{
	       User user=new User();
	        user.setId(8);
	        user.setType(UserEnum.teacher);
	        user.setName("教师XXXX");
	        user.setEmail("21445");
	        user.setName("fdh");        
	        user.setGender(GenderEnum.female);
	        user.setSchool(new School());
	        user.setPhone("1877653……");
	        user.setNumber("1877653……");
	        user.setTitle("");
	        user.setAvatar("//XXX//XXX");
	        user.setJwt("dsdgfdh");
	        return user;
	}
	
	/**
	 * 
	 * @param new_user
	 * @return
	 */
	   @RequestMapping(value="/signin",method=POST)
	    @ResponseBody
	    public Object loginUser(String new_user){
	        User user=new User();
	        user.setId(8);
	        user.setType(UserEnum.teacher);
	        user.setName("教师XXXX");
	        user.setEmail("21445");
	        user.setName("fdh");        
	        user.setGender(GenderEnum.female);
	        user.setSchool(new School());
	        user.setPhone("1877653……");
	        user.setNumber("1877653……");
	        user.setTitle("");
	        user.setAvatar("//XXX//XXX");
	        user.setJwt("dsdgfdh");
	        return user;
	    }
	
	/**
	 * 
	 * @param new_user
	 * @return
	 */
	@RequestMapping(value="/register",method=POST)
	@ResponseBody
	public Object createNewUser(String new_user){
        User user=new User();
        user.setId(8);
        user.setType(UserEnum.teacher);
        user.setName("教师XXXX");
        user.setEmail("21445");
        user.setName("fdh");        
        user.setGender(GenderEnum.female);
        user.setSchool(new School());
        user.setPhone("1877653……");
        user.setNumber("1877653……");
        user.setTitle("");
        user.setAvatar("//XXX//XXX");
        user.setJwt("dsdgfdh");
        return user;
	}
}
