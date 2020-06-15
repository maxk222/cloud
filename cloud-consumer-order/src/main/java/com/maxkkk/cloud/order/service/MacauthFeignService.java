package com.maxkkk.cloud.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "macauth", url = "${macauth.remote.url}")
public interface MacauthFeignService {

	@GetMapping("/customize/getLoginList")
	Object getLoginList(@RequestParam("username") String username);
	
	@PostMapping("/customize/macBlack")
	Object addMacBlack(@RequestParam("mac") String mac, @RequestParam("invalidString") String invalidString, @RequestParam("memo") String memo);
}
