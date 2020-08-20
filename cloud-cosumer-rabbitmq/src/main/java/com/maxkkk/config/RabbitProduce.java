package com.maxkkk.config;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Component;

import com.maxkkk.commons.entity.CommonResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("rabbitProduce")
public class RabbitProduce {

	public static final String QUEUE_NAME = "erduo";

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send() {
		String message = "Hello 我是作者和耳朵，欢迎关注我。" + LocalDateTime.now().toString();
		System.out.println("Message content : " + message);

		// 指定消息类型
		MessageProperties props = MessagePropertiesBuilder.newInstance()
				.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN).build();

		rabbitTemplate.send(QUEUE_NAME, new Message(message.getBytes(StandardCharsets.UTF_8), props));
		System.out.println("消息发送完毕。");
	}

	public void convertAndSend() {
		CommonResult<String> text = new CommonResult<String>("");
		System.out.println("Message content : " + text);

		rabbitTemplate.convertAndSend(QUEUE_NAME, text);
		System.out.println("消息发送完毕。");
	}

}