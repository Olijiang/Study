package eva.kafka.Controller;

import org.springframework.stereotype.Component;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/2 14:08
 */
@Component
public class MyConsumer {
//	@KafkaListener(topics = "TRANSPORT_FLOW", groupId = "myGroup")
//	public void listenWebGroup(ConsumerRecord<String, String> record, Acknowledgment ack) {
//		String value = record.value();
//		System.out.println("myGroup message: " + value);
//		System.out.println("myGroup record: " + record);
//		//手动提交offset，一般是提交一个banch，幂等性防止重复消息
//		// === 每条消费完确认性能不好！
//		ack.acknowledge();
//	}

	//配置多个消费组
//	@KafkaListener(topics = "my-replicated-topic", groupId = "jihuGroup2")
//	public void listenJihuGroup2(ConsumerRecord<String, String> record, Acknowledgment ack) {
//		String value = record.value();
//		System.out.println("jihuGroup2 message: " + value);
//		System.out.println("jihuGroup2 record: " + record);
//		//手动提交offset
//		ack.acknowledge();
//	}
}
