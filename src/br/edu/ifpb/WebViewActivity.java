package br.edu.ifpb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import controle.Controller;

public class WebViewActivity extends Activity {

	private String token[];

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview_layout);

		WebView webView = (WebView) findViewById(R.id.webView);
		webView.clearCache(true);
		webView.loadUrl("https://www.facebook.com/dialog/oauth?client_id=102843940054244&response_type=token&redirect_uri="
				+ "https://www.facebook.com/connect/login_success.html");
		CookieManager cookieManager = CookieManager.getInstance();
		cookieManager.removeAllCookie();

		webView.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				if (url.contains("access_token")) {
					Log.i("Msg", "Aceito");
					String auxToken[] = url.split("access_token=");
					token = auxToken[1].split("&");
					Log.i("Token", token[0]);
					Thread thread = new Thread() {
						@SuppressWarnings("unused")
						public void run() {
//							try {
								
//								SocketImplements socketImplements = new SocketImplements();
//								String resposta = socketImplements.logar(token[0]);
								String resposta = "5";
								if (resposta != null) {
									
//									String session = XmlParse.parseSession(resposta);
									String session = resposta;
									if( !session.equals("") ){
										Controller.getInstance().setSession( session );
										Log.i("Msg", "Abrindo a NewActivity");
										Intent in = new Intent(WebViewActivity.this,NotificationActivity.class);
										startActivity(in);
									} else{
										//uma página de erro
									}
									
								} else {
									
									Intent in2 = new Intent(WebViewActivity.this,ErroAcessoActivity.class);
									startActivity(in2);
									
								}
//							} catch (UnknownHostException e) {
//								e.printStackTrace();
//							} catch (IOException e) {
//								e.printStackTrace();
//							}
						}

					};
					
					thread.start();

				} else {
					Log.i("Msg", "Token invalido");
				}
				return false;
			};
		});

	}
}
