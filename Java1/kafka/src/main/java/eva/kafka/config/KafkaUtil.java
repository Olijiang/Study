package eva.kafka.config;

import org.apache.kafka.clients.admin.*;

import java.util.Collections;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/7 10:47
 */
public class KafkaUtil {


	private final AdminClient adminClient;

	public KafkaUtil(String serverIp){
		Properties properties = new Properties();
		properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,serverIp);
		adminClient = AdminClient.create(properties);
	}

	/**
	 * 创建topic
	 *  @param topicName        topic的名称
	 * @param partitions       分区数
	 * @param replication      副本数
	 */
	public void createTopic(String topicName, int partitions, int replication) {
		// topic
		NewTopic newTopic = new NewTopic(topicName,partitions,(short) replication);
		// 创建
		CreateTopicsResult createTopicsResult = adminClient.createTopics(Collections.singletonList(newTopic));
		try{
			createTopicsResult.all().get();
			System.out.println("topic:"+topicName+"创建成功");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	public void deleteTopic(String topicName){
		//删除topic
		DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(Collections.singletonList(topicName));
		try{
			deleteTopicsResult.all().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("删除的topic:"+topicName);
	}

	public boolean hadTopic(String topicName) throws ExecutionException, InterruptedException {
		//topic
		ListTopicsResult listTopicsResult = adminClient.listTopics();
		// 遍历放入集合
		Set<String> topics = listTopicsResult.names().get();
		return topics.contains(topicName);
	}
}
