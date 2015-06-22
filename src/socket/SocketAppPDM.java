package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Scanner;

import android.content.Context;
import util.GerenciadorArquivo;
import xmlparse.XmlParse;

public class SocketAppPDM {

	private int port;
	private String host;
	private Scanner in;

	public SocketAppPDM() {
	}

	public void updateHostPort(Context context){
		Map<String, String> mapa = GerenciadorArquivo.getFilePropertiesConnection(context);
		this.host = mapa.get("host");
		this.port = Integer.parseInt( mapa.get("port") );
	}
	
	//method connect
	public SocketChannel getConnectionServerSocket() throws IOException{
		SocketAddress address = new InetSocketAddress(this.host, this.port);
        SocketChannel channel = SocketChannel.open();
        channel.connect(address);
        return channel;
	}
	
	//method login
	public String logar(String login)throws UnknownHostException, IOException {
		
		Socket socket = new Socket( "104.154.41.92", 10002 );
		
		socket.getOutputStream().write( XmlParse.xmlFacebookToken(login).getBytes()  );
		socket.getOutputStream().flush();
		socket.shutdownOutput();
		
		this.in = new Scanner( socket.getInputStream() );
		
		String response = in.nextLine();
		
		in.close();
		socket.close();
		
		return response;
		
	}
	
}
