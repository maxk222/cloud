package com.maxkkk.cloud.rules;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.netflix.loadbalancer.IRule;

@Component
public class RandomRule {

	@Bean
	public IRule random() {
		return new com.netflix.loadbalancer.RandomRule();
	}
}
