package com.example.signup2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteStudent extends Activity {
EditText etname;
Button btndelete;
dbhelper db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		db=new dbhelper(this);
		setContentView(R.layout.activity_delete_student);
		etname=(EditText) findViewById(R.id.etnamestudelete);
		btndelete=(Button) findViewById(R.id.btndeletest);
		btndelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int s=db.deletedata(etname.getText().toString());
				Toast.makeText(getApplicationContext(), s+" row affected", Toast.LENGTH_LONG).show();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delete_student, menu);
		return true;
	}

}
