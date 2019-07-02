package bhz.sys.web;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.Log4jConfigListener;
import org.springframework.web.util.Log4jWebConfigurer;

import bhz.sys.web.config.AppConfig;
import bhz.sys.web.config.MyFirstFilter;
import bhz.sys.web.config.RootConfig;
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		super.onStartup(servletContext);
		servletContext.setInitParameter("webAppRootKey", "bhz-sys.root");
		servletContext.setInitParameter(Log4jWebConfigurer.CONFIG_LOCATION_PARAM, "/WEB-INF/classes/log4j.properties");
		servletContext.addListener(Log4jConfigListener.class);
	}

	//获取根容器的配置类；（Spring的配置文件:进行事物、监听器、数据库连接等与web无关的配置）   父容器；
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{RootConfig.class};
	}

	//获取web容器的配置类（SpringMVC配置文件:进行web的一些配置，比如视图解析器，拦截器等的配置）  子容器；
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{AppConfig.class};
	}

	//获取DispatcherServlet的映射信息
	//  /：拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括*.jsp；
	//  /*：拦截所有请求；连*.jsp页面都拦截；jsp页面是tomcat的jsp引擎解析的；
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return new Filter[] {new MyFirstFilter()};
	}
}
