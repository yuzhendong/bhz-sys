package bhz.sys.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.plugins.server.sun.http.HttpServerRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author bhz（KZJSS_YZD）
 * @since 2019年7月2日
 */
@Controller
public class SysIndexController {

/**
 * 
 * <B>方法名称：</B><BR>
 * <B>概要说明：</B><BR>
 * @param request
 * @param response
 * @return
 */
@RequestMapping("/sysindex.html")
public ModelAndView index() {
	ModelAndView ret=new ModelAndView();
	return ret;
}

}

