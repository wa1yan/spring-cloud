package dev.waiyanhtet.rabbitmq.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import dev.waiyanhtet.rabbitmq.demo.config.RabbitMQConfig;
import dev.waiyanhtet.rabbitmq.demo.dto.OrderStatus;

//@Component
//public class User {
//	
//	@RabbitListener(queues = {RabbitMQConfig.QUEUE_NAME})
//	public void consumeMessageFromQueue(OrderStatus orderStatus) {
//		System.out.println("Message received from quue : " + orderStatus);
//	}
//
//}
