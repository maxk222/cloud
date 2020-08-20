package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maxkkk.Main;
import com.maxkkk.config.RabbitProduce;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class RabbitProduceTest {
	
	@Autowired
	private RabbitProduce rabbitProduce;

	@Test
	public void sendSimpleMessage() {
		rabbitProduce.send();
		rabbitProduce.convertAndSend();
	}
}
