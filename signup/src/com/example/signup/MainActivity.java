package com.example.signup;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText etusername,etpass;
Button btnlogin,btnreset,btnsignup;
SQLiteDatabase db;
DBHandler dbb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbb=new DBHandler(this);
        etusername=(EditText) findViewById(R.id.etusername);
        etpass=(EditText) findViewById(R.id.etpass);
        btnlogin=(Button) findViewById(R.id.btnlogin);
        btnreset=(Button) findViewById(R.id.btnreset);
        btnsignup=(Button) findViewById(R.id.btnsignup);
        btnsignup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity.this,Registration.class);
				startActivity(i);
				
			}
		});
        btnlogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				db=dbb.getReadableDatabase();
				String a=etusername.getText().toString();
				String b=etpass.getText().toString();
				Cursor c=db.rawQuery("select * from "+dbb.tbname+" where "+dbb.col1+"=? and "+dbb.col2+"=?"	,new String[]{a,b});
				if(c.getCount()>0)
				{
					Intent i=new Intent(MainActivity.this,MainPage.class);
					startActivity(i);
				}
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
