package bhz.sys.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
@PropertySource(value={"classpath:/config.properties"})
@ComponentScan(value="bhz")
@Configuration
public class MainConfigOfPropertyValues {	
	@Bean 
	public	MultiparResolverConfig getMultiparResolverConfig(){
		return new MultiparResolverConfig();
	}
}
