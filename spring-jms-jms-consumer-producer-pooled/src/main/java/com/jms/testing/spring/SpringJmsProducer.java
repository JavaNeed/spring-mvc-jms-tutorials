package com.jms.testing.spring;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SpringJmsProducer {
	private JmsTemplate jmsTemplate;
	private Destination destination;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	public void sendMessage(final String message){
		System.out.println("Producer Sends :: "+message);
		
		if(destination == null){
			jmsTemplate.send(new MessageCreator() {
				
				@Override
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(message);
				}
			});
		}
		else{
			jmsTemplate.send(destination,new MessageCreator() {
				
				@Override
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(message);
				}
			});
		}
	}
}
