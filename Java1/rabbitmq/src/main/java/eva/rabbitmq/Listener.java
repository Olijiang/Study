package eva.rabbitmq;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/7 14:50
 */

import com.caacitc.rabbitmq.listener.AbstractMessageListener;
import eva.rabbitmq.entity.DaxingTraffic;
import eva.rabbitmq.mapper.DaxingTrafficMapper;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;


@Component
@Slf4j
public class Listener extends AbstractMessageListener {

	@Autowired
	DaxingTrafficMapper daxingTrafficMapper;

	public Listener(){
		super();
	}

	public Listener(String serviceType) {
		super(serviceType);
	}

	@Override
	public Boolean handleMessage(String message) {
		try {
			log.info("从总线获取到" +message);
			try {
				;
//				save(message);
			}catch (Exception e){
				e.printStackTrace();
				log.warn("保存到数据库失败");
			}
			return true;
		} catch (Exception var3) {
			log.info(var3.getMessage());
			return false;
		}
	}

	public void save(String message) throws DocumentException {
		//将给定的String文本解析为XML文档并返回新创建的document
		Document document = DocumentHelper.parseText(message);
		//获取根节点
		Element rootElement = document.getRootElement();
		//获取根节点下的某个元素
		Element DATAS = rootElement.element("DATAS");
		//遍历所有子节点
		DaxingTraffic daxingTraffic = new DaxingTraffic();
		for (Iterator i = DATAS.elementIterator(); i.hasNext(); ) {
			Element next = (Element) i.next();
			if ("start".equalsIgnoreCase(next.getName())) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
				LocalDateTime Date = LocalDateTime.parse((String) next.getData(), formatter);
				String start = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(Date);
				daxingTraffic.setStart(start);
			}
			else if ("end".equalsIgnoreCase(next.getName())) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
				LocalDateTime Date = LocalDateTime.parse((String) next.getData(), formatter);
				String start = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(Date);
				daxingTraffic.setEnd(start);
			}

			else if ("PROVINCIAL_BUS".equalsIgnoreCase(next.getName())) daxingTraffic.setProvincialBus(new Integer(next.getData().toString()));
			else if ("CITY_BUS".equalsIgnoreCase(next.getName())) daxingTraffic.setCityBus(new Integer(next.getData().toString()));
			else if ("RAILWAY".equalsIgnoreCase(next.getName())) daxingTraffic.setRailway(new Integer(next.getData().toString()));
			else if ("PARKING_BUILDING_PASSENGER".equalsIgnoreCase(next.getName())) daxingTraffic.setParkingBuildingPassenger(new Integer(next.getData().toString()));
			else if ("METRO".equalsIgnoreCase(next.getName())) daxingTraffic.setMetro(new Integer(next.getData().toString()));
			else if ("TAXI_QUEUE_1".equalsIgnoreCase(next.getName())) daxingTraffic.setTaxiQueue1(new Integer(next.getData().toString()));
			else if ("TAXI_QUEUE_2".equalsIgnoreCase(next.getName())) daxingTraffic.setTaxiQueue2(new Integer(next.getData().toString()));
			else if ("TAXI_QUEUE_3".equalsIgnoreCase(next.getName())) daxingTraffic.setTaxiQueue3(new Integer(next.getData().toString()));
		}
		System.out.println(daxingTrafficMapper);
		System.out.println(daxingTraffic);
		daxingTrafficMapper.insert(daxingTraffic);
		log.info("保存到数据库成功");
	}


}