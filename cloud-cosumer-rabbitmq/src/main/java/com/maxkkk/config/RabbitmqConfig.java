package com.maxkkk.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxkkk.common.Constont;

@Configuration
public class RabbitmqConfig {

	@Bean
	public MessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter(new ObjectMapper());
	}

	/*
	 * @Bean public Queue erduo() { // 其三个参数：durable exclusive autoDelete //
	 * 一般只设置一下持久化即可 return new Queue(Constont.RABBIT_QUEUE_NAME, false); }
	 */

	@Bean
	public Queue directQueue1() {
		return new Queue("directQueue1");
	}

	@Bean
	public Queue directQueue2() {
		return new Queue("directQueue2");
	}

	@Bean
	public DirectExchange directExchange() {
		// 三个构造参数：name durable autoDelete
		return new DirectExchange("directExchange", false, false);
	}

	@Bean
	public Binding directBinding1() {
		return BindingBuilder.bind(directQueue1()).to(directExchange()).with("sms");
	}

	@Bean
	public Binding directBinding2() {
		return BindingBuilder.bind(directQueue2()).to(directExchange()).with("mail");
	}
}
