package eva.rabbitmq;

/**
 * @author ZGB
 * @version 1.0
 * @description: 重写ApplicationRunner的run方法，在springboot启动时添加 Listener
 * @date 2022/11/7 16:11
 */


import com.caacitc.esb.constants.EsbPropertyKeyConst;
import com.caacitc.esb.dto.ConsumerBootResult;
import com.caacitc.rabbitmq.client.EsbClient;
import eva.rabbitmq.entity.LoginInfo;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Properties;

@Component
@Slf4j
public class ApplicationRunnerImp implements ApplicationRunner {
	@Autowired
	private LoginInfo loginInfo;
	@Autowired
	private Listener listener;

	@Override
	public void run(ApplicationArguments args) throws NoSuchFieldException, IllegalAccessException, DocumentException {
		Properties properties = new Properties();
		properties.setProperty(EsbPropertyKeyConst.CLIENT_IP,loginInfo.CLIENT_IP);
		properties.setProperty(EsbPropertyKeyConst.CLIENT_MAC,loginInfo.CLIENT_MAC);
		properties.setProperty(EsbPropertyKeyConst.ESB_SDK_CLIENT_ENDPOINT,loginInfo.ESB_SDK_CLIENT_ENDPOINT);
		properties.setProperty(EsbPropertyKeyConst.ESB_SDK_CLIENT_PASSWORD,loginInfo.ESB_SDK_CLIENT_PASSWORD);
		properties.setProperty(EsbPropertyKeyConst.ESB_SDK_SERVER_IP,loginInfo.ESB_SDK_SERVER_IP);
		properties.setProperty(EsbPropertyKeyConst.ESB_SDK_SERVER_PORT,loginInfo.ESB_SDK_SERVER_PORT);
		properties.setProperty(EsbPropertyKeyConst.ESB_SDK_CLIENT_VERSION,loginInfo.ESB_SDK_CLIENT_VERSION);
		// new 出来的对象不是由spring管理, Autowired 注入无效。 这里采用反射直接修改 listener父类的属性值
		Field field = listener.getClass().getSuperclass().getDeclaredField("serviceType");
		field.setAccessible(true);
		field.set(listener,loginInfo.SERVICE_TYPE);
		ConsumerBootResult consumer = EsbClient.getInstance.consumer(listener,properties);
		if (consumer.isBootSuccess()){
			log.info("消费者启动成功");
		}else {
			log.info("消费者启动失败"+consumer.getBootState()+"-"+consumer.getBootStateDesc());
		}
	}
}

