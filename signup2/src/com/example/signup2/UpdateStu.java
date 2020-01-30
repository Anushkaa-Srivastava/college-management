package com.example.signup2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateStu extends Activity {
	EditText etname,etage;
	CheckBox chkbtech,chkbca;
	Button btnsave;
	String s1="";
	dbhelper db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_stu);
		db=new dbhelper(this);
		 etname=(EditText) findViewById(R.id.etname);
	        etage=(EditText) findViewById(R.id.etage);
	        chkbtech=(CheckBox) findViewById(R.id.chkbtech);
	        chkbca=(CheckBox) findViewById(R.id.chkbca);
	        btnsave=(Button) findViewById(R.id.btnedit);
	        
	        btnsave.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					s1="";
					if(chkbtech.isChecked())
					{
						s1+=chkbtech.getText()+",";
					}
					if(chkbca.isChecked())
					{
						s1+=chkbca.getText()+",";
						
					}
					
					String a=etname.getText().toString();
					String b=etage.getText().toString();
					
					int g=db.updatadata(a, b, s1);
					
						Toast.makeText(getApplicationContext(), g+" row updated", Toast.LENGTH_LONG).show();
					
					
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update_stu, menu);
		return true;
	}

}
