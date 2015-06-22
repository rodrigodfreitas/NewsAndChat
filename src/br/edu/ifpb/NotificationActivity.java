package br.edu.ifpb;

import java.util.ArrayList;

import servicos.ServiceNotification;
import controle.Controller;
import adapter.NotificationAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import beans.Notification;

public class NotificationActivity extends Activity {

	private ListView lista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
		
		

		Log.i("Msg", "iniciando o service");
		Intent intent = new Intent(this, ServiceNotification.class);
		startService(intent);

		for(int i = 0; i < 100; i++){
			Log.i("Msg", "Exibindo lista");
			Log.i("Msg", Controller.getInstance().getSession());
			Log.i("Msg", String.valueOf(Controller.getInstance().getSize()));
		}
		

		ArrayList<Notification> not = new ArrayList<Notification>();

		not.add(new Notification(1, "Rodrigo", "Test1", "conteudo", false));
		not.add(new Notification(1, "Felipe", "Test2", "conteudo", false));
		not.add(new Notification(1, "Jannayna", "Test3", "conteudo", false));
		not.add(new Notification(1, "Laraina", "Test4", "conteudo", false));
		not.add(new Notification(1, "Diego", "Test5", "conteudo", false));
		not.add(new Notification(1, "Fatinha", "Test6", "conteudo", false));

		
		lista = (ListView) findViewById(R.id.ListView_lista);
		lista.setAdapter(new NotificationAdapter(not, R.layout.noticia, this) {

			@Override
			public void onNotificacao(Object nota, View view) {
				if (nota != null) {
					TextView titulo = (TextView) view.findViewById(R.id.titulo);
					if (titulo != null)
						titulo.setText(((Notification) nota).getTitulo());

					TextView autor = (TextView) view.findViewById(R.id.autor);
					if (autor != null)
						autor.setText(((Notification) nota).getAutor());

					ImageView imagens = (ImageView) view
							.findViewById(R.id.imagem);
					if (imagens != null)
						// prestar atenção nisso aqui
						imagens.setImageBitmap(((Notification) nota)
								.getImagem());
				}
			}
		});

		lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parente, View view,
					int posicao, long id) {
				Notification noti = (Notification) parente
						.getItemAtPosition(posicao);

				CharSequence texto = "Notícia: " + noti.getTitulo();
				Toast.makeText(NotificationActivity.this, texto,
						Toast.LENGTH_LONG).show();

				//mudando a situação da notificação para lida
				noti.setLida(true);
				
				if (noti.getLida() == true){
					//mudando a cor da notificação lida para cinza					
					lista.getChildAt(posicao).setBackgroundColor(Color.parseColor("#9D9AA9"));
				}
				Intent intent = new Intent(NotificationActivity.this,
						NewsActivity.class);
				
				//conteúdos para a próxima tela
				intent.putExtra("autor", noti.getAutor());
				intent.putExtra("conteudo", noti.getConteudo());
				intent.putExtra("imagem", noti.getImagem());
				intent.putExtra("id", noti.getId());
				intent.putExtra("titulo", noti.getTitulo());
	
				NotificationActivity.this.startActivity(intent);

			}
		});
	}

}
