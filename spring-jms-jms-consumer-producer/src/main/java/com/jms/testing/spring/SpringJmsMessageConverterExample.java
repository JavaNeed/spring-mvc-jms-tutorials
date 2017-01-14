package com.jms.testing.spring;

import java.net.URISyntaxException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJmsMessageConverterExample {
	public static void main(String[] args) throws URISyntaxException, Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"appContextWithMessageConverter.xml");

		try {
			SpringJmsPersonProducer springJmsProducer = (SpringJmsPersonProducer) context
					.getBean("springJmsPersonProducer");
			Person joe = new Person("Joe", 32);
			System.out.println("Sending person " + joe);
			springJmsProducer.sendMessage(joe);

			SpringJmsPersonConsumer springJmsConsumer = (SpringJmsPersonConsumer) context
					.getBean("springJmsPersonConsumer");
			System.out.println("Consumer receives " + springJmsConsumer.receiveMessage());
		} finally {
			context.close();
		}
	}
}
