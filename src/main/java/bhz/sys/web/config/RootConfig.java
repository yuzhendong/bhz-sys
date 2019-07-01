package bhz.sys.web.config;

import javax.sql.DataSource;

import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Spring的容器不扫描controller;父容器
@ComponentScan(value="bhz",excludeFilters={
		@Filter(type=FilterType.ANNOTATION,value={Controller.class})
})
@EnableTransactionManagement
@EnableAspectJAutoProxy
//@PropertySource(value= {"classpath:/config.properties"})
public class RootConfig {
	//数据源
/*	@Bean
	public DataSource dataSource() throws Exception{
		JdbcConnectConfig jdbcConnectConfig = jdbcConnectConfig();
		ProxoolDataSource dataSource = new ProxoolDataSource();
		dataSource.setDriver(jdbcConnectConfig.getDriver());
		dataSource.setDriverUrl(jdbcConnectConfig.getDriverUrl());
		dataSource.setUser(jdbcConnectConfig.getUser());
		dataSource.setPassword(jdbcConnectConfig.getPassword());
		dataSource.setMinimumConnectionCount(jdbcConnectConfig.getMinimumConnectionCount());
		dataSource.setMaximumConnectionCount(jdbcConnectConfig.getMaximumConnectionCount());
		dataSource.setMaximumConnectionLifetime((int) jdbcConnectConfig.getMaximumConnectionLifetime());
		dataSource.setMaximumActiveTime(jdbcConnectConfig.getMaximumActiveTime());
		dataSource.setPrototypeCount(jdbcConnectConfig.getPrototypeCount());
		dataSource.setHouseKeepingTestSql(jdbcConnectConfig.getHouseKeepingTestSql());
		//dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
		//dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:ORA8");
		return dataSource;
	}*/
	
/*	@Bean
	public JdbcTemplate jdbcTemplate() throws Exception{
		//Spring对@Configuration类会特殊处理；给容器中加组件的方法，多次调用都只是从容器中找组件
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}*/
	//注册事务管理器在容器中
/*	@Bean
	public PlatformTransactionManager transactionManager() throws Exception{
		return new DataSourceTransactionManager(dataSource());
	}
	@Bean
	public JdbcConnectConfig jdbcConnectConfig(){
		return new JdbcConnectConfig();
	}*/
}
