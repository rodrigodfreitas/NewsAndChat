package br.edu.ifpb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button) findViewById(R.id.btLogin);
		button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			
			Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
			MainActivity.this.startActivity(intent);
			MainActivity.this.finish();				
			}
		});
	}
//	
//	@Override
//	protected void onDestroy(){
//		super.onDestroy();
//		Controller.getInstance().clear();
//	}
}
