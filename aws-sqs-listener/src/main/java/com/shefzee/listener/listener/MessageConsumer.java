package com.shefzee.listener.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer {

    @Value("${cloud.aws.end-point.uri}")
    private String queueUrl;

    @SqsListener(value ="${cloud.aws.end-point.uri}" , deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void getMessage(String message){
        log.info("Message from SQS Queue - "+message);
    }
}
