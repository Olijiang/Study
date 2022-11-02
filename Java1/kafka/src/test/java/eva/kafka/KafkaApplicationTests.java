package eva.kafka;

import com.alibaba.fastjson.JSONObject;
import eva.kafka.entity.ParkingTraffic;
import eva.kafka.entity.TaxiTrans;
import eva.kafka.mapper.ParkingTrafficMapper;
import eva.kafka.mapper.TaxiTransMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaApplicationTests {

	@Autowired(required = false)
	private TaxiTransMapper taxiTransMapper;
	@Autowired(required = false)
	private ParkingTrafficMapper parkingTrafficMapper;


	@Test
	void contextLoads() {
		String jsonData = "{\"parking_traffic\":[{\"in_parking_num\":29,\"update_time\":\"2022-10-30 05:00:00\",\"busi_type\":\"gtc\",\"area_id\":\"T3-GTC\",\"out_parking_num\":34}],\"taxi_trans\":[{\"update_time\":\"2022-10-30 05:00:00\",\"perhalf_num\":23,\"area_id\":\"T3-TAXI\"}]}";

		JSONObject jsonObject = JSONObject.parseObject(jsonData);
		Object parking_traffic = jsonObject.getJSONArray("parking_traffic").get(0);
		Object taxi_trans = jsonObject.getJSONArray("taxi_trans").get(0);
		ParkingTraffic parkingTraffic = JSONObject.parseObject(parking_traffic.toString(),ParkingTraffic.class);
		TaxiTrans taxiTrans = JSONObject.parseObject(taxi_trans.toString(),TaxiTrans.class);
		System.out.println(parkingTraffic);
		System.out.println(taxiTrans);
		taxiTransMapper.insert(taxiTrans);
		parkingTrafficMapper.insert(parkingTraffic);

	}



}
