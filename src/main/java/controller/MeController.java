package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    //private Object obj;
	@RequestMapping(value="/me",method=GET)
	public String getCurrentUser() throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
		return mapper.writeValueAsString("{\"id\": 3486, \"type\": \"student\", \"name\": \"\u5F20\u4E09\", \"number\": \"23320152202333\", \"phone\": \"18911114514\", \"email\": \"23320152202333@stu.xmu.edu.cn\", \"gender\": \"male\", \"school\": {\"id\": 32, \"name\": \"\u53A6\u95E8\u5927\u5B66\"}, \"title\": \"\", \"avatar\": \"/avatar/3486.png\"}");
	}
	/**
	 * 修改当前用户
	 * @author 吕柏翰
	 * @param request 传递过来的request信息
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 */
	@RequestMapping(value="/me",method=PUT)
	public String updateCurrentUser(String request) throws JsonProcessingException{
		//return mapper.writeValueAsString(obj);
		return mapper.writeValueAsString("{}");
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
}
