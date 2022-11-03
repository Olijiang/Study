package eva.kafka.controller;

import com.alibaba.fastjson.JSONObject;
import eva.kafka.entity.ParkingTraffic;
import eva.kafka.entity.TaxiTrans;
import eva.kafka.mapper.ParkingTrafficMapper;
import eva.kafka.mapper.TaxiTransMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/2 14:08
 */
@Component
@Slf4j
public class MyConsumer {

	@Autowired(required = false)
	private TaxiTransMapper taxiTransMapper;
	@Autowired(required = false)
	private ParkingTrafficMapper parkingTrafficMapper;


	@KafkaListener(topics = "TRANSPORT_FLOW", groupId = "testGroup")
	public void listenWebGroup(ConsumerRecord<String, String> record, Acknowledgment ack) {
		String value = record.value();
		log.info(value);
		JSONObject jsonObject = JSONObject.parseObject(value);
		Object parking_traffic = jsonObject.getJSONArray("parking_traffic").get(0);
		Object taxi_trans = jsonObject.getJSONArray("taxi_trans").get(0);
		ParkingTraffic parkingTraffic = JSONObject.parseObject(parking_traffic.toString(),ParkingTraffic.class);
		TaxiTrans taxiTrans = JSONObject.parseObject(taxi_trans.toString(),TaxiTrans.class);
		taxiTransMapper.insert(taxiTrans);
		parkingTrafficMapper.insert(parkingTraffic);
		//手动提交offset，一般是提交一个banch，幂等性防止重复消息
		// === 每条消费完确认性能不好！
		ack.acknowledge();
	}

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
