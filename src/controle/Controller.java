package controle;

import java.util.LinkedList;
import java.util.List;

import beans.Message;

public class Controller {

	private static Controller instance = null;
	private LinkedList<Message> generalList;
	private String session;

	private Controller() {
		this.generalList = new LinkedList<Message>();
	}

	public static Controller getInstance() {
		if (instance == null) {
			return instance = new Controller();
		}
		return instance;
	}

	public boolean addNotificationFirst(Message news) {
		generalList.addFirst(news);
		return true;
	}

	public boolean addNotificationAll(List<Message> list) {
		return generalList.addAll(list);
	}
	
	public int getSize() {
		return this.generalList.size();
	}

	public void setGeneralList(LinkedList<Message> list) {
		this.generalList = list;
	}

	public LinkedList<Message> getGeneralList() {
		return this.generalList;
	}

	public int countNotificationNotRead() {
		int count = 0;
		for(Message news : generalList){
			if(news.getLida()){
				count++;
			}
		}
		return count;
	}
		
	public void read(Long id){
		for(Message news : generalList){
			if( news.getId() == id ){
				news.setLida(true);
				break;
			}
		}
	}
	
	public Message getFirstNotRead(){
		return generalList.getFirst();
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public static void setInstance(Controller instance) {
		Controller.instance = instance;
	}
	
	public void clear(){
		generalList.clear();
	}
	
}
