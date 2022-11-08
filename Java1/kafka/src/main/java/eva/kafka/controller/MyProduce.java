package eva.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/2 14:04
 */
@RestController
@Slf4j
public class MyProduce {
	private final static String TOPIC_NAME = "putTopic";

	@Autowired(required = false)
	private KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping("/send/{msg}")
	public String send(@PathVariable("msg") String msg) {
		kafkaTemplate.send(TOPIC_NAME, "key", msg);
		log.info(msg+" 发送到 "+TOPIC_NAME+" 成功");
		return String.format("消息 %s 发送成功！", msg);
	}

	@RequestMapping("/send2/{msg}")
	public String send2(@PathVariable("msg") String msg) {
		kafkaTemplate.send("getTopic", "key", msg);
		log.info(msg+" 发送到 getTopic 成功");
		return String.format("消息 %s 发送成功！", msg);
	}
}
