package com.zx.activemq.config;


import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 配置activemq通知
 */
@Component
public class ActivemqConfig {

    @Value("${my_topic}")
    private String myTopic;

    /**
     * 将队列注入到bean中
     * @return
     */
    @Bean
    public Topic queue(){
        return new ActiveMQTopic(myTopic);
    }

}
