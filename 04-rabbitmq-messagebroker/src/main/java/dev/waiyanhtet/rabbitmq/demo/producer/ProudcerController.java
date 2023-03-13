package dev.waiyanhtet.rabbitmq.demo.producer;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.waiyanhtet.rabbitmq.demo.config.RabbitMQConfig;
import dev.waiyanhtet.rabbitmq.demo.dto.Order;
import dev.waiyanhtet.rabbitmq.demo.dto.OrderStatus;

@RestController
@RequestMapping("/order")
public class ProudcerController {
	
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/{restraunt_name}")
	public String order(@RequestBody Order order, @PathVariable String restraunt_name) {
		order.setOrderId(UUID.randomUUID().toString());
		OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed successfully in " + restraunt_name);
		template.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, orderStatus);
		return "success";
	}

}
