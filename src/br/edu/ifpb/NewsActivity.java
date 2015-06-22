package br.edu.ifpb;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsActivity extends Activity {
	
	private TextView TitleView, ConteudoView, AutorView;
	private ImageView PhotoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_layout);
		
		TitleView = (TextView)findViewById(R.id.txtTitle);
		ConteudoView = (TextView)findViewById(R.id.txtContent);
		AutorView = (TextView)findViewById(R.id.txtAuthor);
		PhotoView = (ImageView)findViewById(R.id.txtImage);
		
		Intent i= getIntent();
        Bundle bund = i.getExtras();

        if(bund!=null)
        {
            String j =(String) bund.get("titulo");
            TitleView.setText(j);
        
            String k =(String) bund.get("conteudo");
            ConteudoView.setText(k);

            String l =(String) bund.get("autor");
            AutorView.setText(l);
            
            Bitmap m =(Bitmap) bund.get("imagem");
            PhotoView.setImageBitmap(m);
        }
	}
}

		//
		// Log.i("Msg", "iniciando o service");
		// Intent intent = new Intent(this, ServiceNotification.class);
		// startService(intent);
		//
		// for(int i = 0; i < 100; i++){
		// Log.i("Msg", "Exibindo lista");
		// Log.i("Msg", Controller.getInstance().getSession());
		// Log.i("Msg", String.valueOf(Controller.getInstance().getSize()));
		// }
		// // Thread thread = new Thread() {
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

	//}

	// private void setListAdapter(NewsActivity newsActivity, List<Message>
	// list2) {
	// // TODO Auto-generated method stub
	//
	// }

//}
