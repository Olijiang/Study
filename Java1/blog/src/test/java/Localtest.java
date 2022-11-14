import blog.config.LocalCatch;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/11 13:50
 */
public class Localtest {

	public static void main(String[] args) {
		LocalCatch.put("code","2123");
		System.out.println(LocalCatch.get("code"));
		System.out.println(LocalCatch.get("co2de"));
	}

}
