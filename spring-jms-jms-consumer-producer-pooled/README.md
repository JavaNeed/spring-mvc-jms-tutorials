spring-jms-jms-consumer-producer
----------------------------
JmsTemplate takes care of creating a connection, obtaining a session, and the actual sending and receiving of messages. Let’s configure JmsTemplate.
To use JmsTemplate, we’ll need to declare it as a bean in the Spring configuration XML.

<bean id="jmsTemplate" class="org.springframework.jms.core.JmsTemplate">
		<property name="connectionFactory" ref="connectionFactory" />
		<property name="receiveTimeout" value="10000" />
</bean>

JmsTemplate is only a helper class so it still needs to know how to get connections to the message broker.
ConnectionFactory bean is configured and JmsTemplate refers to the configured connection factory bean.

<bean id="connectionFactory" class="org.apache.activemq.ActiveMQConnectionFactory">
		<property name="brokerURL" value="tcp://localhost:61616" />
</bean>


applicationContext.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

	<context:property-placeholder location="jms.properties" />

	<!-- Message Destination -->
	<bean id="messageDestination" class="org.apache.activemq.command.ActiveMQQueue">
		<constructor-arg value="messageQueue1" />
	</bean>

	<!-- Connection Factory --> 
	<bean id="connectionFactory" class="org.apache.activemq.ActiveMQConnectionFactory">
		<property name="brokerURL" value="${jms.brokerURL}" />
	</bean>


	<bean id="jmsTemplate" class="org.springframework.jms.core.JmsTemplate">
		<property name="connectionFactory" value="connectionFactory" />
		<property name="receiveTimeout" value="${jms.receiveTimeout}" />
	</bean>

	<!-- JMS Producer and Consumer -->
	<bean id="springJmsProducer" class="com.jms.testing.spring.SpringJmsProducer">
		<property name="destination" ref="messageDestination" />
		<property name="jmsTemplate" ref="jmsTemplate" />
	</bean>
	<bean id="springJmsProducer" class="com.jms.testing.spring.SpringJmsConsumer">
		<property name="destination" ref="messageDestination" />
		<property name="jmsTemplate" ref="jmsTemplate" />
	</bean>
</beans>



Reference url : https://examples.javacodegeeks.com/enterprise-java/jms/jms-messagelistener-example/