package br.edu.ifpb;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import xmlparse.XmlParse;
import android.util.Log;

public class SocketImplements {

	private int port;
	private String host;
	private Socket socket;
	private Scanner in;

	// 104.154.41.92
	public SocketImplements() {
		this.port = 10005;
		this.host = "192.168.0.14";
	}

	public String request(String conteudo) throws UnknownHostException,	IOException {

		this.socket = new Socket(this.host, this.port);

		// openSocket();
		this.socket.getOutputStream().write(conteudo.getBytes());
		this.socket.getOutputStream().flush();
		this.socket.shutdownOutput();

		Scanner in = new Scanner(this.socket.getInputStream());
		String response = in.nextLine();

		in.close();

		this.socket.close();
		// closedSocket();

		return response;

	}

	// método que loga
	public String logar(String login) throws UnknownHostException, IOException {

		this.socket = new Socket( "192.168.0.14", 10005 );

		this.socket.getOutputStream().write(
				XmlParse.xmlFacebookToken(login).getBytes());
		this.socket.getOutputStream().flush();
		this.socket.shutdownOutput();

		this.in = new Scanner(this.socket.getInputStream());

		String response = in.nextLine();

		in.close();
		this.socket.close();

		return response;

	}

	public String recuperarMsgs(String session) throws UnknownHostException,
			IOException {

		Log.i("Lendo", "recuperando mensagens");
		this.socket = new Socket(this.host, 10006);

		@SuppressWarnings("unused")
		String response = null;

		this.socket.getOutputStream().write(XmlParse.xmlSessionNoticias(session).getBytes());
		this.socket.getOutputStream().flush();
		this.socket.shutdownOutput();

		this.in = new Scanner(this.socket.getInputStream());
		Log.i("Size", in.toString());
		

//		while (true) {
//			
//			String txt = in.nextLine();
//			
//			if (txt != null && !txt.equals("") && txt.trim().length() > 0) {
//				// recupear o xml
//				// fazer o parse
//			}
//		}

		// int aux = 0;
		// response = in.nextLine();

		// DataInputStream inStream = new
		// DataInputStream(socket.getInputStream());
		// ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		// byte[] b = new byte[1024];
		//
		// inStream.read(b);
		//
		// outputStream.write(b);
		//
		// //response = outputStream.toString();
		//
		// for (int i = 0; i < b.length; i++) {
		// if (b[i] != 0) {
		// aux++;
		// }
		// }
		//
		// byte[] dados = new byte[aux];
		//
		// System.arraycopy(b, 0, dados, 0, aux);
		//
		// response = new String(dados);

		in.close();
		this.socket.close();

		return in.toString();
	}

	public SocketChannel getConnectionServerSocket() throws IOException{
		SocketAddress address = new InetSocketAddress("192.168.0.14", 10006);
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(true);
        channel.connect(address);
        return channel;
	}
	
}
