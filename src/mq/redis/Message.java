package mq.redis;

import java.io.Serializable;

/**
 * Message 实体类
 * @author FrankJiang
 */
public class Message implements Serializable {
	
	private String title;
	private String info;
	
	public Message(String title, String info) {
		this.title = title;
		this.info = info;
	}

	public String getTitle() {
		return title;
	}

	public String getInfo() {
		return info;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
