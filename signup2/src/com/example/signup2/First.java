package com.example.signup2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class First extends Activity {
Button btnaddstu,btnaddfac,btnhome,btngallery,btnconfirst;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		btnaddstu=(Button) findViewById(R.id.btnaddstu);
		btnaddfac=(Button) findViewById(R.id.btnaddfac);
		btnhome=(Button) findViewById(R.id.btnhome);
		btngallery=(Button) findViewById(R.id.btngallery);
		btnconfirst=(Button) findViewById(R.id.btncontactfirst);
		btnaddstu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(First.this,Studentdetails.class);
				startActivity(i);
				
			}
		});
		btnaddfac.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(First.this,Facultydetails.class);
				startActivity(i);
				
			}
		});
		btnhome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				Intent i=new Intent(First.this,Home.class);
				startActivity(i);
			}
		});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}

}
