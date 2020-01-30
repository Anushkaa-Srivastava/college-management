package com.example.signup;

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
import android.widget.Spinner;
import android.widget.Toast;

public class Mainpgregisteration extends Activity {
	EditText etnamereg,etemailreg,etcontactreg;
	Button btnsavereg,btnresetreg;
	
	RadioGroup rbg;
	RadioButton rbtn;
	String ss="",ss1="";
	DBHandler db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainpgregisteration);
		db=new DBHandler(this);
		etnamereg=(EditText) findViewById(R.id.etnamereg);
        etemailreg=(EditText) findViewById(R.id.etemailreg);
        etcontactreg=(EditText) findViewById(R.id.etcontactreg);
        btnsavereg=(Button) findViewById(R.id.btnsavereg);
        btnresetreg=(Button) findViewById(R.id.btnresetreg);
        rbg=(RadioGroup) findViewById(R.id.radioGroup1);
        
        
        btnsavereg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int op=rbg.getCheckedRadioButtonId();
				rbtn=(RadioButton) findViewById(op);
				ss=rbtn.getText().toString();
				ss1="anu";
		        String aa=etnamereg.getText().toString();
				String bb=etemailreg.getText().toString();
				String cc=etcontactreg.getText().toString();
				boolean k=db.detail(aa, ss, ss1, bb, cc);
				if(k==false)
				{
					Toast.makeText(getApplicationContext(), "registered successfully...", Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "error occured", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mainpgregisteration, menu);
		return true;
	}

}
