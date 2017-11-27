package controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * MeController class
 *
 * @author 吕柏翰
 * @date 2017/11/27
 */
@Controller
@RequestMapping("/")
public class MeController {
	@RequestMapping(value="/me",method=GET)
	public String getCurrentUser(){
		return "";
	}
	@RequestMapping(value="/me",method=PUT)
	public String updateCurrentUser(){
		return "";
	}
}
