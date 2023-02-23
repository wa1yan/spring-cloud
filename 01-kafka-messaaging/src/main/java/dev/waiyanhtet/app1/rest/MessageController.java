package dev.waiyanhtet.app1.rest;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {

	private final KafkaTemplate<String, String> kafkaTemplate;
	
	@PostMapping
	public void publish(@RequestBody MessageRequest request) {
		kafkaTemplate.send("sample", request.message());
	}
}
