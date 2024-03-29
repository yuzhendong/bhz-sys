package bhz.sys.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class JdbcConnectConfig {
	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String driverUrl;
	@Value("${jdbc.username}")
	private String user;
	@Value("${jdbc.password}")
	private String password;
	@Value("${jdbc.minConnection}")
	private long maximumActiveTime;
	@Value("${jdbc.maxConnection}")
	private int maximumConnectionCount;
	@Value("${jdbc.maxConnectionLife}")
	private long maximumConnectionLifetime;
	@Value("${jdbc.maxActiveTime}")
	private int minimumConnectionCount;
	@Value("${jdbc.prototypeCount}")
	private int prototypeCount;
	@Value("${jdbc.testSql}")
	private String houseKeepingTestSql;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDriverUrl() {
		return driverUrl;
	}

	public void setDriverUrl(String driverUrl) {
		this.driverUrl = driverUrl;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMaximumActiveTime() {
		return maximumActiveTime;
	}

	public void setMaximumActiveTime(long maximumActiveTime) {
		this.maximumActiveTime = maximumActiveTime;
	}

	public int getMaximumConnectionCount() {
		return maximumConnectionCount;
	}

	public void setMaximumConnectionCount(int maximumConnectionCount) {
		this.maximumConnectionCount = maximumConnectionCount;
	}

	public long getMaximumConnectionLifetime() {
		return maximumConnectionLifetime;
	}

	public void setMaximumConnectionLifetime(long maximumConnectionLifetime) {
		this.maximumConnectionLifetime = maximumConnectionLifetime;
	}

	public int getMinimumConnectionCount() {
		return minimumConnectionCount;
	}

	public void setMinimumConnectionCount(int minimumConnectionCount) {
		this.minimumConnectionCount = minimumConnectionCount;
	}

	public int getPrototypeCount() {
		return prototypeCount;
	}

	public void setPrototypeCount(int prototypeCount) {
		this.prototypeCount = prototypeCount;
	}

	public String getHouseKeepingTestSql() {
		return houseKeepingTestSql;
	}

	public void setHouseKeepingTestSql(String houseKeepingTestSql) {
		this.houseKeepingTestSql = houseKeepingTestSql;
	}
}
