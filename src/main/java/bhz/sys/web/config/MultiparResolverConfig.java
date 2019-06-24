package bhz.sys.web.config;

import org.springframework.beans.factory.annotation.Value;

public class MultiparResolverConfig {
	@Value("${config.defaultEncoding}")
	private  String defaultEncoding;
	@Value("${config.maxMemSize}")
	private int maxInMemorySize;
	@Value("${config.maxFileSize}")
	private long maxUploadSize;
	@Value("${config.tempDir}")
	private String uploadTempDir;
	public String getDefaultEncoding() {
		return defaultEncoding;
	}
	public void setDefaultEncoding(String defaultEncoding) {
		this.defaultEncoding = defaultEncoding;
	}
	public int getMaxInMemorySize() {
		return maxInMemorySize;
	}
	public void setMaxInMemorySize(int maxInMemorySize) {
		this.maxInMemorySize = maxInMemorySize;
	}
	public long getMaxUploadSize() {
		return maxUploadSize;
	}
	public void setMaxUploadSize(long maxUploadSize) {
		this.maxUploadSize = maxUploadSize;
	}
	public String getUploadTempDir() {
		return uploadTempDir;
	}
	public void setUploadTempDir(String uploadTempDir) {
		this.uploadTempDir = uploadTempDir;
	}
}

