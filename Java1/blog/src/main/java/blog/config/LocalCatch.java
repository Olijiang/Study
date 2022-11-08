package blog.config;

import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/6 16:50
 */
@Component
public class LocalCatch {
	private static final ExpiringMap<String, Object> map = ExpiringMap.builder().expiration(3600, TimeUnit.SECONDS)
			.expirationPolicy(ExpirationPolicy.ACCESSED)
			.build();

	public static void put(String key, Object value){
		map.put(key, value);
	}

	public static void get(String key){
		map.get(key);
	}



}
