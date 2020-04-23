package com.shefzee.listener;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AwsSqsListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSqsListenerApplication.class, args);
	}

	@Bean
	public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory(AmazonSQSAsync amazonSQS){
		SimpleMessageListenerContainerFactory factory = new SimpleMessageListenerContainerFactory();
		factory.setAmazonSqs(amazonSQS);
		factory.setMaxNumberOfMessages(10);
		return factory;
	}

}
