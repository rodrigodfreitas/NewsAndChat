package interfaces;

import java.io.IOException;
import java.net.UnknownHostException;

public interface LoginServiceInterface {

	public String logar(String acessCode) throws UnknownHostException, IOException;
	
}
