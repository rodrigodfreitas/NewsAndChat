package br.edu.ifpb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ErroAcessoActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.error_login);
		
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent);
		
		Toast.makeText(getApplicationContext(), "Você não tem acesso", Toast.LENGTH_LONG).show();

	}

}
