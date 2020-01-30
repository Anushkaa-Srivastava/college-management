package com.example.signup2;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText etuser,etpass;
Button btnlogin,btnsignup;
Spinner spin;
SQLiteDatabase db;
String con[]={"Student","Admin","Faculty"};
String s="";
dbhelper dbb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbb=new dbhelper(this);
        etuser=(EditText) findViewById(R.id.etuser);
        etpass=(EditText) findViewById(R.id.etpass);
        spin=(Spinner) findViewById(R.id.spinner1);
        btnlogin=(Button) findViewById(R.id.btnlogin);
        btnsignup=(Button) findViewById(R.id.btnsignup);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,con);
        aa.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				s=con[arg2];
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        btnlogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				db=dbb.getReadableDatabase();
				String a=etuser.getText().toString();
				String b=etpass.getText().toString();
				if(a.compareTo("anu")==0 && b.compareTo("123")==0)
				{
					if(s.compareTo("Admin")==0)
					{
					Intent i=new Intent(MainActivity.this,First.class);
					startActivity(i);
					
					}
					}
				else if(s=="Student")
				{
					Cursor c=db.rawQuery("select * from "+dbb.tbname+" where "+dbb.col11+"=? and "+dbb.col21+"=?"	,new String[]{a,b});
					if(c.getCount()>0)
					{
						Intent i=new Intent(MainActivity.this,StudentActivity.class);
						startActivity(i);
					}
					
				}
				else if(s=="Faculty")
				{
				Cursor c=db.rawQuery("select * from "+dbb.tbreg+" where "+dbb.col12+"=? and "+dbb.col22+"=?"	,new String[]{a,b});
				if(c.getCount()>0)
				{
					Intent i=new Intent(MainActivity.this,FacultyActivity.class);
					startActivity(i);
				}}
				
			}
		});
        btnsignup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity.this,Register.class);
				startActivity(i);
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
