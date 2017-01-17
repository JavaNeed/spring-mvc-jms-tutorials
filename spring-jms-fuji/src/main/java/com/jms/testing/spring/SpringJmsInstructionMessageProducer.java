package com.jms.testing.spring;

import org.springframework.jms.core.JmsTemplate;

public class SpringJmsInstructionMessageProducer {

	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage(final InstructionMessage instructionMessage) {
		System.out.println("~~~~~~~~~~~~~ Producing The Message ~~~~~~~~~~~~~");
		getJmsTemplate().convertAndSend(instructionMessage);
	}
}
