package com.example.signup2;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShowStudentDetails extends Activity {
Button btnrefresh;
TextView snm,sag,sdeg;
dbhelper db;
EditText entry;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_student_details);
		db=new dbhelper(this);
		snm=(TextView) findViewById(R.id.snm);
		sag=(TextView) findViewById(R.id.sag);
		sdeg=(TextView) findViewById(R.id.sdeg);
		btnrefresh=(Button) findViewById(R.id.btnrefresh);
		entry=(EditText) findViewById(R.id.entry);
		btnrefresh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Cursor res=db.getdata(entry.getText().toString());
				while(res.moveToNext())
				{
					snm.setText(res.getString(0));
					sag.setText(res.getString(1));
					sdeg.setText(res.getString(2));
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_student_details, menu);
		return true;
	}

}
