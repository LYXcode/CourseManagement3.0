package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.User;

/**
 * MeController class
 * 用户个人信息Controller层
 * @author 吕柏翰
 * @date 2017/11/27
 */
@Controller
@RequestMapping("/")
public class MeController {
	/**
	 * 获取当前用户
	 * @author 吕柏翰
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
    private ObjectMapper mapper=new ObjectMapper();
    private Object obj;
	@RequestMapping(value="/me",method=GET)
	@ResponseBody
	public Object getCurrentUser() throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
	    User user=new User();
	    user.setEmail("21445");
	    user.setName("fdh");
	    user.setPhone("1877653……");
	    user.setNumber("1877653……");
	    return user;
	}
	/**
	 * 修改当前用户
	 * @author 吕柏翰
     * @param user 前端传回的数据
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/me",method=PATCH)
	@ResponseBody
	public String updateCurrentUser(@RequestBody User user) throws JsonProcessingException{
	      System.out.println(user.getPhone());
	        System.out.println(user.getName());
	        System.out.println(user.getSchool());
	        System.out.println(user.getEmail());
	        return "teacher_user.html";
	}
	   /**
     * 修改/绑定当前用户
     * @author 艾星
     * @param user 前端传回的数据
     * @return String 返回Json数据
     * @throws JsonProcessingException Json处理异常
     */
    @RequestMapping(value="/me",method=PUT)
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
	public String signinWechat(String code,String state,String successUrl) throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
		return mapper.writeValueAsString("{\"id\": 3486, \"type\": \"student\", \"name\": \"\u5F20\u4E09\", \"jwt\": \"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJPQTAwMDEiLCJpYXQiOjE0ODI2NTcyODQyMjF9.TeJpy936w610Vrrm+c3+RXouCA9k1AX0Bk8qURkYkdo=\"}");
	}
	
	
	@RequestMapping(value="/register",method=POST)
	@ResponseBody
	public String createNewUser(@RequestBody User user){
	    System.out.println(user.getPhone());
	    System.out.println(user.getPassword());
	    System.out.println(user.getName());
	    System.out.println(user.getSchool());
	    System.out.println(user.getEmail());
	    return "";
	}
}
