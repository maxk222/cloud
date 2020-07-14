package com.maxkkk.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

@RefreshScope
@RestController
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${service-url.nacos-user-service}")
	private String serverURL;
	
	@GetMapping("/testHotKey")
	@SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
	public String get(@RequestParam(value = "p1",required = false)String p1, @RequestParam(value = "p2",required = false)String p2) {
		return restTemplate.getForObject(serverURL + "/payment/" + p1,String.class);
	}
	
	public String deal_testHotKey(String p1, String p2, BlockException exception) {
		return p1 + "";
	}
}
