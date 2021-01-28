package com.mi.mq;

import com.alibaba.fastjson.JSON;
import com.mi.config.RabbitConfig;
import com.mi.sys.vo.OrderKillVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 金彪
 * @date 2021-01-28
 */
@Component
@Slf4j
public class KillSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(OrderKillVO orderKillVO) {
        String string = JSON.toJSONString(orderKillVO);
        log.info("=======sendMsg=======:" + string);
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_KILL, RabbitConfig.ROUTINGKEY_KILL, string);
    }

    public void send(OrderKillVO orderKillVO, CorrelationData correlationData) {
        String string = JSON.toJSONString(orderKillVO);
        log.info("=======sendMsg=======:" + string);
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_KILL, RabbitConfig.ROUTINGKEY_KILL, string, correlationData);
    }

    public void sendToDelayQueue(OrderKillVO orderKillVO) {
        String string = JSON.toJSONString(orderKillVO);
        log.info("=======sendMsg=======:" + string);
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_KILL_DELAY, RabbitConfig.ROUTINGKEY_KILL_DELAY, string);
    }
}
