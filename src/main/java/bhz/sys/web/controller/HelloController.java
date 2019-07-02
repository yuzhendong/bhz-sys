package bhz.sys.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(){
		String hello ="sysindex";
		return hello;
	}
	
	//  /WEB-INF/views/success.jsp
	@RequestMapping("/suc")
	public String success(){
		return "success";
	}
}
