package dev.waiyanhtet.app1.conf;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

	@Bean
	public NewTopic sampleTopic() {
		return TopicBuilder.name("sample").build();
	}
}
