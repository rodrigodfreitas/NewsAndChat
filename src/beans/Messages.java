package beans;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Messages implements Serializable {
	
	private List<Message> messages;
	
	 public Messages() {
		// TODO Auto-generated constructor stub
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	 

}
