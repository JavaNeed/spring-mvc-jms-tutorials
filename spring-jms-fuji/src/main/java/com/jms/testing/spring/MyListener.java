package com.jms.testing.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class MyListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println("ON MESSAGE");
		try {
			ObjectMessage mapMessage = (ObjectMessage) message;

			InstructionMessage instructionMessage = (InstructionMessage) mapMessage.getObject();
			System.out.println(instructionMessage.toString());
			
			String priority = checkPriority(instructionMessage);
			switch (priority) {
			case "High":
				System.out.println("Sending the message for HIGH Priority");
				break;
			case "Medium":
				System.out.println("Sending the message for MEDIUM Priority");
				break;
			case "Low":
				System.out.println("Sending the message for LOW Priority");
				break;
			default:
				System.out.println("This time no HIGH priority message");
				throw new IllegalArgumentException("message");
			}

		} catch (IllegalArgumentException | JMSException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	private String checkPriority(InstructionMessage instructionMessage) {
		String priority = null;

		int instructionType = instructionMessage.getInstructionType();
		if(!(instructionType > 0 && instructionType <100))
			throw new IllegalArgumentException("instructionType validation fails !!!");

		if(instructionType > 0 && instructionType < 11){
			priority = "High";
		}else if(instructionType > 10 && instructionType < 91){
			priority = "Medium";
		}else if(instructionType > 90 && instructionType < 100){
			priority = "Low";
		}
		return priority;
	}
}