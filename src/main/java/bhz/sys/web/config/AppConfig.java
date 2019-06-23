package bhz.sys.web.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//SpringMVCֻɨ��Controller��������
//useDefaultFilters=false ����Ĭ�ϵĹ��˹���
@ComponentScan(value="bhz",includeFilters={
		@Filter(type=FilterType.ANNOTATION,value={Controller.class})
},useDefaultFilters=false)
@EnableWebMvc
@PropertySource(value={"classpath:/config.properties"})
public class AppConfig  extends WebMvcConfigurerAdapter  {
	//��ͼ������
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		//Ĭ�����е�ҳ�涼�� /WEB-INF/ xxx .jsp
		registry.viewResolver(new InternalResourceViewResolver());
	//	registry.
		registry.order(1);
		registry.jsp("/WEB-INF/pages/", ".jsp");
	}
	
	//��̬��Դ����
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}
	
	//������
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//super.addInterceptors(registry);
	//	registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
	}

}
