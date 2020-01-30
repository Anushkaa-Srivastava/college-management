package com.example.signup;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper{
	public static final String dbname="college.db";
	public static final String tbname="clg";
	  public static final String col1="name";
	  public static final String col2="age";
	  public static final String col3="quali";
	  public static final String col4="contact";
	  public static final String col5="country";
	  public static final String tbnamefac="faculty";
	  public static final String c1="name";
	  public static final String c2="gender";
	  public static final String c3="experience";
	  public static final String c4="email";
	  public static final String c5="contact";
	public DBHandler(Context context) {
		super(context, dbname, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table "+tbname+"(name text,age text,quali text,contact text,country text)");
		db.execSQL("create table "+tbnamefac+"(name text,gender text,experience text,email text,contact text)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("drop if table exist "+tbname);
		db.execSQL("drop if table exist "+tbnamefac);
		onCreate(db);
		
	}
	
	
	
	public boolean insertdata(String n,String a,String q,String c,String con)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues v=new ContentValues();
		v.put(col1, n);
		v.put(col2, a);
		v.put(col3, q);
		v.put(col4, c);
		v.put(col5, con);
		Long d=db.insert(tbname, null, v);
		if(d==-1)
		{
			return false;
			
		}
		else
		{
			return true;
		}
	}
	
	public boolean detail(String n,String g,String e,String em,String con)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues v=new ContentValues();
		v.put(c1, n);
		v.put(c2, g);
		v.put(c3, e);
		v.put(c4, em);
		v.put(c5, con);
		Long d=db.insert(tbnamefac, null, v);
		if(d==-1)
		{
			return false;
			
		}
		else
		{
			return true;
		}
	}
	

}
