package servicos;

import controle.Controller;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class ServiceNotification extends IntentService {

	private NotificationServiceImp imp;
	
	public ServiceNotification() {
		super("ServiceNotification");
		imp = new NotificationServiceImp();
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		
		Log.i("Msg", "Executando o IntenteService");
		String session = Controller.getInstance().getSession();
		imp.hasNotification(session);
		
	}

}
