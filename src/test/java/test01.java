import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import bhz.sys.web.config.MainConfigOfPropertyValues;
import bhz.sys.web.config.MultiparResolverConfig;

public class test01 {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
	@Test
	public void test(){
		System.out.println("=============");
		
		MultiparResolverConfig person = (MultiparResolverConfig) applicationContext.getBean(MultiparResolverConfig.class);
		System.out.println(person);
			
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("env.defaultEncoding");
		System.out.println(property);
		applicationContext.close();
	}
}

