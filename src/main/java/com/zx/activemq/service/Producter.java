package com.zx.activemq.service;

import io.netty.util.internal.MathUtil;
import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.Random;

/**
 * 生产
 */
public class Producter {
    @Autowired
    private Queue queue;

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    Topic topic;


    /**
     * 每个5秒钟发送一次指令
     */
    public void sendMessage(){
        String currentTime=System.currentTimeMillis()+":"+Math.random();
        this.jmsMessagingTemplate.convertAndSend(topic,currentTime);

    }


}
