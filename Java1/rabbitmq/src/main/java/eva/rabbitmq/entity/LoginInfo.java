package eva.rabbitmq.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ZGB
 * @version 1.0
 * @description: login验证信息
 * @date 2022/11/7 16:20
 */
@Component
@ConfigurationProperties(prefix = "logininfo")
public class LoginInfo {
	public String ESB_SDK_CLIENT_ENDPOINT;
	public String ESB_SDK_CLIENT_PASSWORD;
	public String ESB_SDK_SERVER_IP;
	public String ESB_SDK_SERVER_PORT;
	public String ESB_SDK_CLIENT_VERSION;
	public String CLIENT_IP;
	public String CLIENT_MAC;
	public String SERVICE_TYPE;

	public LoginInfo() {
	}

	public String getESB_SDK_CLIENT_ENDPOINT() {
		return ESB_SDK_CLIENT_ENDPOINT;
	}

	public void setESB_SDK_CLIENT_ENDPOINT(String ESB_SDK_CLIENT_ENDPOINT) {
		this.ESB_SDK_CLIENT_ENDPOINT = ESB_SDK_CLIENT_ENDPOINT;
	}

	public String getESB_SDK_CLIENT_PASSWORD() {
		return ESB_SDK_CLIENT_PASSWORD;
	}

	public void setESB_SDK_CLIENT_PASSWORD(String ESB_SDK_CLIENT_PASSWORD) {
		this.ESB_SDK_CLIENT_PASSWORD = ESB_SDK_CLIENT_PASSWORD;
	}

	public String getESB_SDK_SERVER_IP() {
		return ESB_SDK_SERVER_IP;
	}

	public void setESB_SDK_SERVER_IP(String ESB_SDK_SERVER_IP) {
		this.ESB_SDK_SERVER_IP = ESB_SDK_SERVER_IP;
	}

	public String getESB_SDK_SERVER_PORT() {
		return ESB_SDK_SERVER_PORT;
	}

	public void setESB_SDK_SERVER_PORT(String ESB_SDK_SERVER_PORT) {
		this.ESB_SDK_SERVER_PORT = ESB_SDK_SERVER_PORT;
	}

	public String getESB_SDK_CLIENT_VERSION() {
		return ESB_SDK_CLIENT_VERSION;
	}

	public void setESB_SDK_CLIENT_VERSION(String ESB_SDK_CLIENT_VERSION) {
		this.ESB_SDK_CLIENT_VERSION = ESB_SDK_CLIENT_VERSION;
	}

	public String getCLIENT_IP() {
		return CLIENT_IP;
	}

	public void setCLIENT_IP(String CLIENT_IP) {
		this.CLIENT_IP = CLIENT_IP;
	}

	public String getCLIENT_MAC() {
		return CLIENT_MAC;
	}

	public void setCLIENT_MAC(String CLIENT_MAC) {
		this.CLIENT_MAC = CLIENT_MAC;
	}

	public String getSERVICE_TYPE() {
		return SERVICE_TYPE;
	}

	public void setSERVICE_TYPE(String SERVICE_TYPE) {
		this.SERVICE_TYPE = SERVICE_TYPE;
	}

	@Override
	public String toString() {
		return "LoginInfo{" +
				"ESB_SDK_CLIENT_ENDPOINT='" + ESB_SDK_CLIENT_ENDPOINT + '\'' +
				", ESB_SDK_CLIENT_PASSWORD='" + ESB_SDK_CLIENT_PASSWORD + '\'' +
				", ESB_SDK_SERVER_IP='" + ESB_SDK_SERVER_IP + '\'' +
				", ESB_SDK_SERVER_PORT='" + ESB_SDK_SERVER_PORT + '\'' +
				", ESB_SDK_CLIENT_VERSION='" + ESB_SDK_CLIENT_VERSION + '\'' +
				", CLIENT_IP='" + CLIENT_IP + '\'' +
				", CLIENT_MAC='" + CLIENT_MAC + '\'' +
				", SERVICE_TYPE='" + SERVICE_TYPE + '\'' +
				'}';
	}
}
