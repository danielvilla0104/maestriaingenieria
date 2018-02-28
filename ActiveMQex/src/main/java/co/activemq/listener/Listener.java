package co.activemq.listener;

import java.util.Date;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import co.activemq.pojo.Pong_Message;

@Component
public class Listener {

	@JmsListener(destination = "inbound.queue")
	@SendTo("outbound.queue")
	public String receiveMessage(final Message jsonMessage) throws JMSException, InterruptedException {
		
		ActiveMQTextMessage msg = (ActiveMQTextMessage) jsonMessage;
		System.out.println(msg.getText());
		Pong_Message pong = new Pong_Message(msg.getText(), new Date());
		System.out.println(pong.toString());
		String messageData = null;
		System.out.println("Received message " + jsonMessage + "received at: " + new Date());
		Thread.sleep(2000L);
		System.out.println("Despertó" + new Date());
		String response = null;
		if(jsonMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage)jsonMessage;
			messageData = textMessage.getText();
			Map map = new Gson().fromJson(messageData, Map.class);
			response  = "Hello " + map.get("name");
		}
		return response;
	}

}
