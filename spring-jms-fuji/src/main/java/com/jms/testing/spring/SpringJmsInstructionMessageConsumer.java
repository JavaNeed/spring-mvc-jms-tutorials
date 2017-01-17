package com.jms.testing.spring;

import javax.jms.JMSException;

import org.springframework.jms.core.JmsTemplate;

public class SpringJmsInstructionMessageConsumer {
	
	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public InstructionMessage receiveMessage() throws JMSException {
		//InstructionMessage instructionMessage = (InstructionMessage) getJmsTemplate().receiveAndConvert();
		Object receiveAndConvert = getJmsTemplate().receiveAndConvert();
		
		
		InstructionMessage instructionMessage=null;
		return instructionMessage;	
	}
}
