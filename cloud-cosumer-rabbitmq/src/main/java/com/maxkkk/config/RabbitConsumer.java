package com.maxkkk.config;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.maxkkk.commons.entity.CommonResult;
import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitConsumer {
	
	public void onMessage(@Payload String message, Channel channel) throws Exception {
		log.info("Message content : " + message);
		log.info("消息已确认");
	}
	
	@RabbitListener(queues = "directQueue1")
	public <T> void onMessage(@Payload CommonResult<T> result, @Headers Map<String, Object> headers, Channel channel) throws Exception {
		log.info(LocalDateTime.now().toString());
		log.info("Message content : " + result.toString());
		log.info("Message headers : " + headers);
		channel.basicAck((long) headers.get(AmqpHeaders.DELIVERY_TAG), false);
		log.info("消息已确认");
	}
	
	@RabbitListener(queues = "directQueue2")
	public <T> void onMessage2(@Payload CommonResult<T> result, @Headers Map<String, Object> headers, Channel channel) throws Exception {
		log.info(LocalDateTime.now().toString());
		log.info("Message2 content : " + result.toString());
		log.info("Message2 headers : " + headers);
		channel.basicAck((long) headers.get(AmqpHeaders.DELIVERY_TAG), false);
		log.info("消息已确认");
	}
	
}
