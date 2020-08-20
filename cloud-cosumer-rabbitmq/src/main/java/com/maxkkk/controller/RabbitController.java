package com.maxkkk.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {

	public static final String QUEUE_NAME = "erduo";

	@GetMapping("put")
	public void put() {
		try {
			// 创建连接工厂
			ConnectionFactory connectionFactory = new ConnectionFactory();
			// 连接到本地server
			connectionFactory.setHost("120.79.128.143");
			connectionFactory.setUsername("admin");
			connectionFactory.setPassword("admin");
			// 通过连接工厂创建连接
			Connection connection = connectionFactory.newConnection();
			// 通过连接创建通道
			Channel channel = connection.createChannel();
			// 创建一个名为耳朵的队列，该队列非持久(RabbitMQ重启后会消失)、非独占(非仅用于此链接)、非自动删除(服务器将不再使用的队列删除)
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String msg = "hello, 我是耳朵。" + LocalDateTime.now().toString();
			// 发布消息
			// 四个参数为：指定路由器，指定key，指定参数，和二进制数据内容
			channel.basicPublish("", QUEUE_NAME, null, msg.getBytes(StandardCharsets.UTF_8));
			System.out.println("生产者发送消息结束，发送内容为：" + msg);
			channel.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("catch")
	public void catchInfo() {
		try {
			// 创建连接工厂
			ConnectionFactory connectionFactory = new ConnectionFactory();
			// 连接到本地server
			connectionFactory.setHost("120.79.128.143");
			connectionFactory.setUsername("admin");
			connectionFactory.setPassword("admin");
			// 通过连接工厂创建连接
			Connection connection = connectionFactory.newConnection();
			// 通过连接创建通道
			Channel channel = connection.createChannel();
			// 创建消费者，阻塞接收消息
			com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
						byte[] body) throws IOException {
					System.out.println("-------------------------------------------");
					System.out.println("consumerTag : " + consumerTag);
					System.out.println("exchangeName : " + envelope.getExchange());
					System.out.println("routingKey : " + envelope.getRoutingKey());
					String msg = new String(body, StandardCharsets.UTF_8);
					System.out.println("消息内容 : " + msg);
					
					// 消息确认
		            channel.basicAck(envelope.getDeliveryTag(), false);
		            System.out.println("消息已确认");
				}
			};

			// 启动消费者消费指定队列
			channel.basicConsume(QUEUE_NAME, consumer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
