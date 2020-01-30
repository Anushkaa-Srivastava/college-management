package com.example.signup2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Studentdetails extends Activity {
Button btnaddstud,btndltstud,btnupdatestud,btnsearchstud,btnstudfeedback;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_studentdetails);
		btnaddstud=(Button) findViewById(R.id.btnaddstud);
		btndltstud=(Button) findViewById(R.id.btndltstud);
		btnupdatestud=(Button) findViewById(R.id.btnupdatestud);
		btnsearchstud=(Button) findViewById(R.id.btnsearchstud);
		btnstudfeedback=(Button) findViewById(R.id.btnstudfeedback);
		btnaddstud.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Studentdetails.this,Register.class);
				startActivity(i);
			}
		});
		btndltstud.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Studentdetails.this,DeleteStudent.class);
				startActivity(i);
			}
		});
         btnupdatestud.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Studentdetails.this,UpdateStu.class);
				startActivity(i);
			}
		});
         btnsearchstud.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
 				Intent i=new Intent(Studentdetails.this,ShowStudentDetails.class);
 				startActivity(i);
 			}
 		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.studentdetails, menu);
		return true;
	}

}
