package eva.rabbitmq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("eva.rabbitmq.mapper")
public class RabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}

}
