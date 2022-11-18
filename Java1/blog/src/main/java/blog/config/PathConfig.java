package blog.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/17 9:49
 */
@Component
@ConfigurationProperties(prefix = "blogserver")
public class Path {
	@Value("blogserver.serverIP")
	private static String serverIP;
	@Value("blogserver.dataPath")
	private static String dataPath;
	@Value("blogserver.imgPath")
	private static String imgPath;
	@Value("blogserver.articlePath")
	private static String articlePath;

	public Path() {
	}

	public static String getServerIP() {
		return serverIP;
	}

	public static void setServerIP(String serverIP) {
		Path.serverIP = serverIP;
	}

	public static String getDataPath() {
		return dataPath;
	}

	public static void setDataPath(String dataPath) {
		Path.dataPath = dataPath;
	}

	public static String getImgPath() {
		return imgPath;
	}

	public static void setImgPath(String imgPath) {
		Path.imgPath = imgPath;
	}

	public static String getArticlePath() {
		return articlePath;
	}

	public static void setArticlePath(String articlePath) {
		Path.articlePath = articlePath;
	}


}
