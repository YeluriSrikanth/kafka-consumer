package com.consumer.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConsumerController {

//	@KafkaListener(topics = "producer_bucket")
//	public void consumeMessages(String topic, String message) {
//		System.out.println("Consumer ............." + message);
//
//	}


    @KafkaListener(topics = "upi-topic", groupId = "upi-group")
    public void consumeMessages(String topic, String jsonString) {
        User user = null;
        try {
            user = new ObjectMapper().readValue(jsonString, User.class);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Consumer ............." + jsonString);

    }


//	@KafkaListener(topics = "producer_bucket", groupId = "consumer-group")
//	@SendTo("response-topic")
//	public String consumeMessage(String message) {
//		System.out.println("Received message: " + message);
//		return "Consumed: " + message;
//	}

    @KafkaListener(topics = "upi-topic", groupId = "upi-group")
    @SendTo("transaction-topic")
    public String doTransation(String msg) {

        System.out.println("consumer consume the user Object and do transaction and return Ackn ");

        return msg;

    }

    @KafkaListener(topics = "name-topic", groupId = "name-group")
    @SendTo("name-response")
    public String registerUser(String msg) {

        System.out.println("consumer consume the String Object " + msg);

        return "Successful Registered User " + msg;

    }


}
