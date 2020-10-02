package com.example.signup2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Second extends Activity {
	EditText etnamefac,etagefac;
	CheckBox chk1year,chk2year;
	Button btnsavefac;
	RadioGroup rbg;
	RadioButton rbtn;
	dbhelper db;
	String ss,ss1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		db=new dbhelper(this);
		 etnamefac=(EditText) findViewById(R.id.etnamefac);
	        etagefac=(EditText) findViewById(R.id.etagefac);
	        chk1year=(CheckBox) findViewById(R.id.chk1year);
	        chk2year=(CheckBox) findViewById(R.id.chk2year);
	        btnsavefac=(Button) findViewById(R.id.btnsavefac);
	        rbg=(RadioGroup) findViewById(R.id.radioGroup1);
	        btnsavefac.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					int op=rbg.getCheckedRadioButtonId();
					rbtn=(RadioButton) findViewById(op);
					ss=rbtn.getText().toString();
			        ss1="";
					if(chk1year.isChecked())
					{
						ss1+=chk1year.getText()+",";
					}
					if(chk2year.isChecked())
					{
						ss1+=chk2year.getText()+",";
						
					}
			        String aa=etnamefac.getText().toString();
					String bb=etagefac.getText().toString();
					
					boolean k=db.detail(aa,bb,ss1,ss);
					if(k==true)
					{
						Toast.makeText(getApplicationContext(), "registered successfully...", Toast.LENGTH_SHORT).show();
					}
					else
					{
						Toast.makeText(getApplicationContext(), "error occured", Toast.LENGTH_SHORT).show();
					}
					
					
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
