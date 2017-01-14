package com.jms.testing.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJmsTemplateExample {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		try {
			SpringJmsProducer producer = (SpringJmsProducer) context.getBean("springJmsProducer");
			producer.sendMessage("Hello, How're you doing? How is your Spring Development going on ??");
			
			SpringJmsConsumer consumer = (SpringJmsConsumer) context.getBean("springJmsConsumer");
			System.out.println("Consumer receives "+consumer.receiveMessage());  
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			context.close();
		}
	}
}
