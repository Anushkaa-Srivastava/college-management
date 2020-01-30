package com.example.signup;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainPage extends Activity {
Button btnaddstu,btndeletestu,btnupdatestu,btnaddfac,btngallery,btncont;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		btnaddstu=(Button) findViewById(R.id.btnaddstu);
		btndeletestu=(Button) findViewById(R.id.btndeletestu);
		btnupdatestu=(Button) findViewById(R.id.btnupdatestu);
		btnaddfac=(Button) findViewById(R.id.btnaddfac);
		btngallery=(Button) findViewById(R.id.btngallery);
		btncont=(Button) findViewById(R.id.btncont);
		btnaddstu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainPage.this,Registration.class);
				startActivity(i);
				
			}
		});
		btnaddfac.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent i=new Intent(MainPage.this,Mainpgregisteration.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

}
