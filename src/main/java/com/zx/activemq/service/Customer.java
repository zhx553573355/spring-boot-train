package com.zx.activemq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSDestinationDefinition;

/**
 * 客户端
 */
@Component
public class Customer {
    @JmsListener(destination = "${my_topic}")
    public void receiveQue(String text){
        System.out.println(text);
    }
}
