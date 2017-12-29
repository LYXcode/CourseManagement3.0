package xmu.crms.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.auth0.jwt.internal.com.fasterxml.jackson.core.JsonParseException;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.JsonMappingException;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.auth0.jwt.internal.org.bouncycastle.util.encoders.Base64Encoder;
import com.fasterxml.jackson.core.JsonProcessingException;

import net.minidev.json.JSONObject;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.*;
import xmu.crms.vo.*;
/**
 * MeController class
 * 用户个人信息Controller层
 * @author 吕柏翰
 * @date 2017/11/27
 */
@RestController
public class MeController {
	
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private LoginService loginService;
	/**
	 * 获取当前用户
	 * @author 吕柏翰
	 * @return String 返回Json数据
	 * @throws JsonProcessingException Json处理异常
	 * @throws UserNotFoundException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="/me",method=GET)
	@ResponseBody
	public Object getCurrentUser() throws JsonProcessingException, IllegalArgumentException, UserNotFoundException{
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        xmu.crms.entity.User user=new xmu.crms.entity.User();
        //user=Jwt.unsign(map.get("token"), xmu.crms.entity.User.class);
        
	    BigInteger userId = user.getId();
		//UserServiceImpl usi=new UserServiceImpl();
		xmu.crms.entity.User userEntity=userService.getUserByUserId(userId); 
		xmu.crms.vo.User userVo=new xmu.crms.vo.User(userService.getUserByUserId(userId));
		return userVo;
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
	public void updateCurrentUser(@RequestBody String user_str) throws JsonProcessingException{	      
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        xmu.crms.entity.User user=new xmu.crms.entity.User();
        user.setId(BigInteger.valueOf(3));
        //Jwt.unsign(map.get("type"), xmu.crms.entity.User.class).getType();
	    BigInteger userId=user.getId();
	    System.out.println(user_str);
		/* us.setPassword("123456");
		us.setPhone("23");*/
	   String gender,name,phone,number,email,title,userName;
	   userName=user_str.substring(user_str.indexOf("userName")+11,user_str.indexOf("phone")-3);
	    phone=user_str.substring(user_str.indexOf("phone")+8,user_str.indexOf("gender")-3);
	    gender=user_str.substring(user_str.indexOf("gender")+9,user_str.indexOf("name")-3);
        name=user_str.substring(user_str.indexOf("name")+7,user_str.indexOf("school")-3);
        //school=user.substring(user.indexOf("school")+9,user.indexOf("title")-3);
        title=user_str.substring(user_str.indexOf("title")+8,user_str.indexOf("number")-3);
        number=user_str.substring(user_str.indexOf("number")+9,user_str.indexOf("email")-3);
        email=user_str.substring(user_str.indexOf("email")+8);
        
    
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setNumber(number);
        user.setTitle(title.equals("学生")?0:1);
        user.setGender(gender.equals("男")?0:1);
	    
        
	    try {
			userService.updateUserByUserId(userId,user);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
        //LoginService.getUserByUserId(userId);//得到用户是学生还是老师
        //LoginService.deleteStudentAccount(userId);
        //LoginService.deleteTeacherAccount(userId);
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
	    //LoginService.signInWeChat(userId,code,state,success_url);   
	    User user=new User();
	        user.setId(8);
	        user.setType(UserEnum.teacher);
	        user.setName("教师XXXX");
	        user.setEmail("21445");
	        user.setName("fdh");        
	        user.setGender(GenderEnum.female);
	        //user.setSchool(new School());
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
	    public String[] loginUser(@RequestBody String new_user){
		       String[] re=new String[2];
		   String phone=new_user.substring(new_user.indexOf("user")+7,new_user.indexOf("password")-3),
		               password=new_user.substring(new_user.indexOf("password")+11);
		       
		    xmu.crms.entity.User user=new xmu.crms.entity.User();
	        user.setPhone(phone);
	        user.setPassword(password.substring(0,password.indexOf("\"")));
	        
	       //验证用户名密码是否正确
	       try {
            user=loginService.signInPhone(user);
            re[0]=user.getType().toString();
            re[1] = Jwt.sign(user, 60L* 1000L* 30L);
            
	       } 
	       catch (UserNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	       }
	       return re;
	    }
	
	/**
	 * 
	 * @param new_user
	 * @return
	 */
	@RequestMapping(value="/register",method=POST)
	@ResponseBody
	public void createNewUser(String new_user) throws UserNotFoundException{
		xmu.crms.entity.User us=new xmu.crms.entity.User();
		//us.setPassword("123456");
		//us.setPhone("23");
	    LoginServiceImp lsi=new LoginServiceImp();
	    lsi.signUpPhone(us); 

	}
	
	public static String MD5(String s) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] bytes = md.digest(s.getBytes("utf-8"));
	        return toHex(bytes);
	    }
	    catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

	private static String toHex(byte[] bytes) {

	    final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
	    StringBuilder ret = new StringBuilder(bytes.length * 2);
	    for (int i=0; i<bytes.length; i++) {
	        ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
	        ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
	    }
	    return ret.toString().substring(8,24);
	}
}