package com.jms.testing.spring;

import javax.jms.JMSException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:appContextWithMessageConverter.xml")
public class InstructionMessageTest {

	private SpringJmsInstructionMessageProducer springJmsProducer = null;
	private SpringJmsInstructionMessageConsumer springJmsConsumer = null;
	
	@Before
	public void beforeClass(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContextWithMessageConverter.xml");
		springJmsProducer = (SpringJmsInstructionMessageProducer) context.getBean("springJmsInstProducer");
		springJmsConsumer = (SpringJmsInstructionMessageConsumer) context.getBean("springJmsInstConsumer");
	}
	
	@Test
	public void testActriveMQMessages() throws JMSException{
		InstructionMessage m1 = new InstructionMessage(10,10,10,10,10);
		//System.out.println("Sending person " + m1);
		springJmsProducer.sendMessage(m1);
		
		InstructionMessage m2 = new InstructionMessage(5,5,5,5,5);
		//System.out.println("Sending person " + m2);
		springJmsProducer.sendMessage(m2);
		
		InstructionMessage m3 = new InstructionMessage(1,1,1,1,1);
		//System.out.println("Sending person " + m3);
		springJmsProducer.sendMessage(m3);

		System.out.println("Message Listen Successfully");
	}
	
	@Test
	public void testWrongvalidation(){
		try {
			InstructionMessage m1 = new InstructionMessage(0,0,0,0,0);
			springJmsProducer.sendMessage(m1);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
