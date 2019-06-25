package bhz.sys.web;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.Log4jConfigListener;
import org.springframework.web.util.Log4jWebConfigurer;

import bhz.sys.web.config.AppConfig;
import bhz.sys.web.config.RootConfig;
/*1、Servlet容器在启动的时候，会扫描每个jar包下的META-INF/services/javax.servlet.ServletContainerInitializer
spring-web-4.3.11.RELEASE.jar包的META-INF/services/javax.servlet.ServletContainerInitializer,该文件中包含org.springframework.web.SpringServletContainerInitializer
          该类上的注解为@HandlesTypes(WebApplicationInitializer.class)*/
//MyWebAppInitializer(自己创建的类继承AbstractAnnotationConfigDispatcherServletInitializer)
// AbstractAnnotationConfigDispatcherServletInitializer实现了抽象类 AbstractDispatcherServletInitializer
	// AbstractDispatcherServletInitializer 类的onStartup(ServletContext servletContext)调用了registerDispatcherServlet(servletContext);
			/*该方法实现：
			 *  WebApplicationContext servletAppContext = createServletApplicationContext(); //创建web容器
			 *  FrameworkServlet dispatcherServlet = createDispatcherServlet(servletAppContext);
				dispatcherServlet.setContextInitializers(getServletApplicationContextInitializers());	
				ServletRegistration.Dynamic registration = servletContext.addServlet(servletName, dispatcherServlet);
				registration.setLoadOnStartup(1);
				registration.addMapping(getServletMappings());//获取映射   该方法子类中实现
				registration.setAsyncSupported(isAsyncSupported());
				Filter[] filters = getServletFilters();
					if (!ObjectUtils.isEmpty(filters)) {
						for (Filter filter : filters) {
							registerServletFilter(servletContext, filter);//该方法子类中实现
						}
					}			
			*/
/*AbstractDispatcherServletInitializer实现了抽象类AbstractContextLoaderInitializer
 *   AbstractContextLoaderInitializer类的onStartup(ServletContext servletContext)方法调用了registerContextLoaderListener(servletContext);
 *      该想法实现：
 *      	WebApplicationContext rootAppContext = createRootApplicationContext();//创建根容器
			if (rootAppContext != null) {
				ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
				listener.setContextInitializers(getRootApplicationContextInitializers());
				servletContext.addListener(listener);
			}
 * */
/*1、AbstractDispatcherServletInitializer接口方法createRootApplicationContext()创建根容器：根容器配置文件通过 getRootConfigClasses()获取
	AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
	Class<?>[] configClasses = getServletConfigClasses();//该方法子类中实现
	rootAppContext.register(configClasses);*/
/*2、AbstractDispatcherServletInitializer接口方法createServletApplicationContext()创建web容器：web容器配置文件通过getServletConfigClasses()
 *AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
 *Class<?>[] configClasses = getRootConfigClasses();//该方法子类中实现
 *servletAppContext.register(configClasses);
*/
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		super.onStartup(servletContext);
		//servletContext.setAttribute(name, object);
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
		return new String[]{"*.html","*.json"};
	}
	
	/*@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return new Filter[] {new MyFirstFilter()};
	}*/
}
