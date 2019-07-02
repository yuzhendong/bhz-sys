package bhz.sys.web.config;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringValueResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import bhz.sys.web.controller.MyFirstInterceptor;
//SpringMVC只扫描Controller；子容器
//useDefaultFilters=false 禁用默认的过滤规则；
@ComponentScan(value="bhz",includeFilters={
		@Filter(type=FilterType.ANNOTATION,value={Controller.class})
},useDefaultFilters=false)
@EnableWebMvc
@PropertySource(value= {"classpath:/config.properties"})
public class AppConfig  extends WebMvcConfigurerAdapter{
	//@Autowired
	//private MultiparResolverConfig multiparResolverConfig;
	private StringValueResolver valueResolver;
	private String  driverClass;
	//视图解析器
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		//默认所有的页面都从 /WEB-INF/ xxx .jsp
		InternalResourceViewResolver viewResolver =new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(1);
		viewResolver.setViewClass(JstlView.class);
		registry.viewResolver(viewResolver);
	}
	
	//静态资源访问
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}
	
	//拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//super.addInterceptors(registry);
		registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
	}
	//配置文件上传解析器
	@Bean
public	MultipartResolver multipartResolver(MultiparResolverConfig multiparResolverConfig) {
		//通过直接调用getMultiparResolverConfig()获取bean的方式，无法通过@value注入配置文件的值
		//MultiparResolverConfig multiparResolverConfig = getMultiparResolverConfig();
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();	
		commonsMultipartResolver.setDefaultEncoding(multiparResolverConfig.getDefaultEncoding());
		commonsMultipartResolver.setMaxInMemorySize(Integer.parseInt(multiparResolverConfig.getMaxInMemorySize()));
		commonsMultipartResolver.setMaxUploadSize(Long.parseLong(multiparResolverConfig.getMaxUploadSize()));
		System.out.println(multiparResolverConfig.toString());
		try {
			commonsMultipartResolver.setUploadTempDir(new PathResource(multiparResolverConfig.getUploadTempDir()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonsMultipartResolver;
	}
	@Bean 
	public	MultiparResolverConfig getMultiparResolverConfig(){
		return new MultiparResolverConfig();
	}
}
