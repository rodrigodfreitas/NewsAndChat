package servicos;

import interfaces.LoginServiceInterface;

import java.io.IOException;
import java.net.UnknownHostException;

import socket.SocketAppPDM;
import xmlparse.XmlParse;

public class LoginServiceImp implements LoginServiceInterface{

	private SocketAppPDM socketAppPDM;

	@Override
	public String logar(String acessCode) throws UnknownHostException, IOException {
		
		socketAppPDM = new SocketAppPDM();
		
		String response = socketAppPDM.logar(acessCode);
		
		return XmlParse.xmlSessioResponse(response);
		
	}
	
}
