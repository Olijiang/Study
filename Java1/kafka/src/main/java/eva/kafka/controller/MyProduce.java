package eva.kafka.controller;

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
public class KafkaController {
	private final static String TOPIC_NAME = "myTopic";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping("/send/{msg}")
	public String send(@PathVariable("msg") String msg) {
		kafkaTemplate.send(TOPIC_NAME, "key", msg);
		return String.format("消息 %s 发送成功！", msg);
	}
}
