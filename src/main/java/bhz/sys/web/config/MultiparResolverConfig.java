package bhz.sys.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
public class MultiparResolverConfig {
	@Value("${env.defaultEncoding}")
	private  String defaultEncoding;
	@Value("${upload.maxMemSize}")
	private String maxInMemorySize;
	@Value("${upload.maxFileSize}")
	private String maxUploadSize;
	@Value("${upload.tempDir}")
	private String uploadTempDir;
	public String getDefaultEncoding() {
		return defaultEncoding;
	}
	public void setDefaultEncoding(String defaultEncoding) {
		this.defaultEncoding = defaultEncoding;
	}
	public String getMaxInMemorySize() {
		return maxInMemorySize;
	}
	public void setMaxInMemorySize(String maxInMemorySize) {
		this.maxInMemorySize = maxInMemorySize;
	}
	public String getMaxUploadSize() {
		return maxUploadSize;
	}
	public void setMaxUploadSize(String maxUploadSize) {
		this.maxUploadSize = maxUploadSize;
	}
	public String getUploadTempDir() {
		return uploadTempDir;
	}
	public void setUploadTempDir(String uploadTempDir) {
		this.uploadTempDir = uploadTempDir;
	}
	@Override
	public String toString() {
		return "MultiparResolverConfig [defaultEncoding=" + defaultEncoding + ", maxInMemorySize=" + maxInMemorySize
				+ ", maxUploadSize=" + maxUploadSize + ", uploadTempDir=" + uploadTempDir + "]";
	}

}

