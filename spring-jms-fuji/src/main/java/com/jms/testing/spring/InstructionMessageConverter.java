package com.jms.testing.spring;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class InstructionMessageConverter implements MessageConverter {
	
	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		InstructionMessage instructionMessage = (InstructionMessage) object;
		MapMessage message = session.createMapMessage();
		message.setString("instructionType", String.valueOf(instructionMessage.getInstructionType()));
		message.setString("productCode", String.valueOf(instructionMessage.getProductCode()));
		message.setString("quantity", String.valueOf(instructionMessage.getQuantity()));
		message.setString("timeStamp", String.valueOf(instructionMessage.getTimeStamp()));
		message.setString("uOM", String.valueOf(instructionMessage.getuOM()));
		
		return message;
	}

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		MapMessage mapMessage = (MapMessage) message;
		
		int instructionType = Integer.parseInt(mapMessage.getString("instructionType"));
		int productCode = Integer.parseInt(mapMessage.getString("productCode"));
		int quantity = Integer.parseInt(mapMessage.getString("quantity"));
		int timeStamp = Integer.parseInt(mapMessage.getString("timeStamp"));
		int uOM = Integer.parseInt(mapMessage.getString("uOM"));
		
		InstructionMessage instructionMessage = new InstructionMessage(instructionType, productCode, quantity, uOM, timeStamp);
		
		return instructionMessage;
	}

}
