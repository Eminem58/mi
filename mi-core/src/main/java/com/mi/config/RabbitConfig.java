package com.mi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 金彪
 * @date 2021.01.28
 */
@Slf4j
@Configuration
public class RabbitConfig {

    public final static String EXCHANGE_KILL = "kill.exchange";
    public final static String ROUTINGKEY_KILL = "kill.key";
    public final static String QUEUE_KILL = "kill.queue";
    public final static String EXCHANGE_KILL_DELAY = "kill.delay.exchange";
    public final static String ROUTINGKEY_KILL_DELAY = "kill.delay.key";
    public final static String QUEUE_KILL_DELAY = "kill.delay.queue";
    public final static String EXCHANGE_KILL_DEAD = "kill.dead.exchange";
    public final static String ROUTINGKEY_KILL_DEAD = "kill.dead.key";
    public final static String QUEUE_KILL_DEAD = "kill.dead.queue";

    @Bean
    public Queue killQueue() {
        return new Queue(QUEUE_KILL, true, false, false);
    }

    @Bean
    public DirectExchange killExchange() {
        return new DirectExchange(EXCHANGE_KILL, false, false);
    }

    @Bean
    public Binding killBinding() {
        return BindingBuilder
                .bind(killQueue())
                .to(killExchange())
                .with(ROUTINGKEY_KILL);
    }

    @Bean
    public Queue killDelayQueue() {
        Map<String, Object> arguments = new HashMap<>(4);
        arguments.put("x-message-ttl", 1000 * 60);
//        arguments.put("x-expires",1000 * 60);
//        arguments.put("x-max-length",10000);
//        arguments.put("x-max-length-bytes",50*1024);
        arguments.put("x-dead-letter-exchange", EXCHANGE_KILL_DEAD);
        arguments.put("x-dead-letter-routing-key", ROUTINGKEY_KILL_DEAD);
        return new Queue(QUEUE_KILL_DELAY, true, false, false, arguments);
    }

    @Bean
    public DirectExchange killDelayExchange() {
        return new DirectExchange(EXCHANGE_KILL_DELAY, false, false);
    }

    @Bean
    public Binding killDelayBinding() {
        return BindingBuilder
                .bind(killDelayQueue())
                .to(killDelayExchange())
                .with(ROUTINGKEY_KILL_DELAY);
    }

    @Bean
    public Queue killDeadQueue() {
        return new Queue(QUEUE_KILL_DEAD, true, false, false);
    }

    @Bean
    public DirectExchange killDeadExchange() {
        return new DirectExchange(EXCHANGE_KILL_DEAD, false, false);
    }

    @Bean
    public Binding killDeadBinding() {
        return BindingBuilder
                .bind(killDeadQueue())
                .to(killDeadExchange())
                .with(ROUTINGKEY_KILL_DEAD);
    }
}
