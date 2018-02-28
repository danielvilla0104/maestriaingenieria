package co.activemq.pojo;

import java.util.Date;

public class Pong_Message {
	private String body;
	private Date message_date;
	
	
	public Pong_Message(String body, Date message_date) {
		this.body = body;
		this.message_date = message_date;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getMessage_date() {
		return message_date;
	}
	public void setMessage_date(Date message_date) {
		this.message_date = message_date;
	}
	@Override
	public String toString() {
		return "Pong_Message [body=" + body + ", message_date=" + message_date + "]";
	}
	
	
	

}
