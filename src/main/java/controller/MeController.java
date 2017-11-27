package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 * @return String 返回网页的文件名
	 */
	@RequestMapping(value="/me",method=GET)
	public String getCurrentUser(){
		return "";
	}
	/**
	 * 修改当前用户
	 * @author 吕柏翰
	 * @return String 返回网页的文件名
	 */
	@RequestMapping(value="/me",method=PUT)
	public String updateCurrentUser(){
		return "";
	}
	/**
	 * 微信小程序/OAuth2登录
	 * @author 吕柏翰
	 * @param code 微信小程序/OAuth2授权的Code
	 * @param state 微信OAuth2授权的state 对于小程序 值恒为 MiniProgram
	 * @param success_url 微信OAuth2授权后跳转到的网址
	 * @return String 返回网页的文件名
	 */
	@RequestMapping(value="/signin",method=GET)
	public String signinWechat(String code,String state,String successUrl){
		return "";
	}
}
