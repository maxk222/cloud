package com.maxkkk.config;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maxkkk.common.Constont;
import com.maxkkk.commons.entity.CommonResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitProduce {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send() {
		String message = "Hello 我是作者和耳朵，欢迎关注我。" + LocalDateTime.now().toString();
		log.info("Message content : " + message);

		// 指定消息类型
		MessageProperties props = MessagePropertiesBuilder.newInstance()
				.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN).build();

		rabbitTemplate.send(Constont.RABBIT_QUEUE_NAME, new Message(message.getBytes(StandardCharsets.UTF_8), props));
		log.info("消息发送完毕。");
	}

	public void convertAndSend() {
		CommonResult<String> text = new CommonResult<String>(LocalDateTime.now().toString());
		log.info("Message content : " + text.toString());
		rabbitTemplate.convertAndSend("topicExchange", "sms.liantong", text);
		log.info("消息发送完毕。");
	}

}