package com.jms.testing.spring;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class MyListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		MapMessage mapMessage = (MapMessage) message;

		try {
			int instructionType = Integer.parseInt(mapMessage.getString("instructionType"));
			int productCode = Integer.parseInt(mapMessage.getString("productCode"));
			int quantity = Integer.parseInt(mapMessage.getString("quantity"));
			int timeStamp = Integer.parseInt(mapMessage.getString("timeStamp"));
			int uOM = Integer.parseInt(mapMessage.getString("uOM"));
			InstructionMessage instructionMessage = new InstructionMessage(instructionType, productCode, quantity, uOM,
					timeStamp);
			System.out.println(instructionMessage.toString());

		} catch (NumberFormatException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}