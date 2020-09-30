package com.maxkkk.config;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maxkkk.commons.entity.CommonResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitProduce {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void convertAndSend() {
		CommonResult<String> text = new CommonResult<String>(LocalDateTime.now().toString());
		log.info("Message content : " + text.toString());
		rabbitTemplate.convertAndSend("topicQueue1", text);
		rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
			log.info("CorrelationData content : " + correlationData);
            log.info("Ack status : " + ack);
            log.info("Cause content : " + cause);
            if(ack){
                log.info("消息成功发送，订单入库，更改订单状态");
            }else{
                log.info("消息发送失败："+correlationData+", 出现异常："+cause);
            }
		});
		log.info("消息发送完毕。");
	}

}