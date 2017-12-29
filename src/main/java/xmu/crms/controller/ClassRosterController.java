package xmu.crms.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * ClassRosterController class
 * 
 * @author 吕柏翰
 * @date 2017/12/25
 */

@Controller
@RequestMapping("/upload")
public class ClassRosterController {
	 @RequestMapping(value="/classroster", method=POST)
	 public String processRegistration(@RequestPart("btn_file") MultipartFile profileList) throws IllegalStateException, IOException {
		 profileList.transferTo(new File("D://file.xls"));// /var/mywebapp/data 
		 return "teacher_course_index";
	 }
	 
	 @RequestMapping(value="/href",method=GET)
	 public String goToNewCourse(Model model){
		 return "teacher_class_new";
	 }
}