package com.example.signup;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends Activity {
	EditText etname,etage,etcontact;
	Button btnsave,btnreset2;
	
	Spinner spin;
	String conn[]={"india","australia","pakistan"};
	String s,s1;
	DBHandler db;
	@Override	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		db=new DBHandler(this);
		etname=(EditText) findViewById(R.id.etname);
        etage=(EditText) findViewById(R.id.etage);
        etcontact=(EditText) findViewById(R.id.etcontact);
        btnsave=(Button) findViewById(R.id.btnsave);
        btnreset2=(Button) findViewById(R.id.btnreset2);
        spin=(Spinner) findViewById(R.id.spincountry);
        
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,conn);
        aa.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
		s=conn[arg2];
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
       
        
        btnsave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 s1="anushka";
				String a=etname.getText().toString();
				String b=etage.getText().toString();
				String c=etcontact.getText().toString();
				boolean bb=db.insertdata(a, b, s1, c, s);
				if(bb==true)
				{
					Toast.makeText(getApplicationContext(), "registered successfully...", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registration, menu);
		return true;
	}

}
