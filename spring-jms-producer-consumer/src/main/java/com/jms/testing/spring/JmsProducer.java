package com.jms.testing.spring;

import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsProducer {
	public static void main(String[] args) throws URISyntaxException, Exception {
		Connection connection = null;
		try {
			// Producer
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Queue queue = session.createQueue("customerQueue");
			
			MessageProducer producer = session.createProducer(queue);
			
			String payload = "Testing Message from the Spring Developer :)";
			Message msg = session.createTextMessage(payload);
			System.out.println("Sending text '" + payload + "'");
			producer.send(msg);
			session.close();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
}
