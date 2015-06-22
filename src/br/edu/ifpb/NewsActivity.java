package br.edu.ifpb;

import java.util.List;

import controle.Controller;
import servicos.ServiceNotification;
import xmlparse.XmlParse;
import beans.Message;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class NewsActivity extends Activity {

	List<Message> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_layout);

		Log.i("Msg", "iniciando o service");
		Intent intent = new Intent(this, ServiceNotification.class);
		startService(intent);

		for(int i = 0; i < 100; i++){
			Log.i("Msg", "Exibindo lista");
			Log.i("Msg", Controller.getInstance().getSession());
			Log.i("Msg", String.valueOf(Controller.getInstance().getSize()));
		}
		// Thread thread = new Thread() {
		// public void run() {
		// try {
		//
		// SocketImplements socketImplements = new SocketImplements();
		//
		// String isSession = socketImplements.recuperarMsgs("5");
		//
		// // list = XmlParse.parseXmlToObjectNews(isSession);
		//
		//
		//
		// } catch (UnknownHostException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// // } catch (ParseException e) {
		// // // TODO Auto-generated catch block
		// // e.printStackTrace();
		// // }
		// }
		//
		// };
		// thread.start();

		// if(list.size() > 0) {
		// setListAdapter(this, list);
		//
		//
		// } else {
		// Intent in = new Intent(this, MainActivity.class);
		// startActivity(in);
		// }
		//
		//

	}

	// private void setListAdapter(NewsActivity newsActivity, List<Message>
	// list2) {
	// // TODO Auto-generated method stub
	//
	// }

}
