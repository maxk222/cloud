package com.maxkkk.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
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

/*	@Bean
	public Queue erduo() {
		// 其三个参数：durable exclusive autoDelete
		// 一般只设置一下持久化即可
		return new Queue(Constont.RABBIT_QUEUE_NAME, false);
	}*/

	@Bean
    public Queue fanout1() {
        return new Queue("fanout1");
    }

    @Bean
    public Queue fanout2() {
        return new Queue("fanout2");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        // 三个构造参数：name durable autoDelete
        return new FanoutExchange("fanoutExchange", false, false);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(fanout1()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(fanout2()).to(fanoutExchange());
    }
}
