package servicos;

import interfaces.NotificationServiceInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Scanner;

import controle.Controller;
import android.annotation.SuppressLint;
import android.util.Log;
import beans.Message;
import br.edu.ifpb.SocketImplements;
import xmlparse.XmlParse;

public class NotificationServiceImp implements NotificationServiceInterface {

	private SocketImplements socketAppPDM;
	private SocketChannel channel;
	private Socket socket;

	public NotificationServiceImp() {
		this.socketAppPDM = new SocketImplements();
	}

	@Override
	public void hasNotification(String session) {
		Scanner in = null;
		while (true) {
			try {
				// connected
				channel = socketAppPDM.getConnectionServerSocket();
				socket = channel.socket();
				if (socket.isConnected()) {
					socket.getOutputStream().write(XmlParse.xmlSessionNoticias(session).getBytes());
					in = new Scanner(socket.getInputStream());
					while (channel.finishConnect()) {
						String txt = convertInputForString(socket.getInputStream());
						txt = txt.trim();
						if (txt != null && !txt.equals("")&& txt.trim().length() > 0) {
							List<Message> lista = XmlParse.parseXmlToObjectNews(txt);
							Controller.getInstance().addNotificationAll(lista);
						}
						Log.i("Msg","Total de msg:"+ String.valueOf(Controller.getInstance().getSize()));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				in.close();
			}
		}
	}

	@SuppressLint("UseValueOf")
	private String convertInputForString(InputStream input) throws IOException {
		String txt = "";
			String str = "";
			String padrao = "<?xml";
			boolean stop = false;
			String tag = "";
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input) );
			
			while( !stop ){
				
				str = bufferedReader.readLine();
				
				if( str.contains(padrao) ){
					
					String[] end_tag = str.split("<");
					
					tag = "/" + end_tag[2].replace(">","");
					Log.i("Msg", tag);
					
				}
				
				txt += str;
				
				if(str.contains(tag) ){
					stop = true;
				}
				
			}
			
			return txt;
			
	}

}
