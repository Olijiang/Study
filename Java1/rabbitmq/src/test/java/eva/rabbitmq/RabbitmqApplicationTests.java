package eva.rabbitmq;

import eva.rabbitmq.mapper.DaxingTrafficMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqApplicationTests {
	@Autowired
	private DaxingTrafficMapper daxingTrafficMapper;
}
