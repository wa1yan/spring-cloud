package dev.waiyanhtet.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App1Application {

	public static void main(String[] args) {
		SpringApplication.run(App1Application.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
//		return args -> {
//			for(int i=0; i <= 20; i++) {
//				kafkaTemplate.send("sample",i + " : hello kafka from app1");
//			}
//	
//		};
//	}
}
