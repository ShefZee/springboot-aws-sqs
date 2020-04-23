package com.shefzee.publisher.publisher;

import com.amazonaws.services.sqs.model.SendMessageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessagePublisher {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String awsSqsUrl;

    private Integer i = 0;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){

        i++;
        String msg = "Message - " + i;
        queueMessagingTemplate.send(awsSqsUrl, MessageBuilder.withPayload(msg).build());
        log.info(msg);
    }

}
