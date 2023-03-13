package dev.waiyanhtet.rabbitmq.demo.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
	
	//@Value("${rabbitmq.queue.name}")
	public static final String QUEUE_NAME = "rabbit_queue";
	
	//@Value("${rabbitmq.exchange.name}")
	public static final String EXCHANGE_NAME = "rabbit_exchange";
	
	//@Value("${rabbitmq.routing.key}")
	public static final String ROUTING_KEY = "rabbit_routing_key";
	
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
}
