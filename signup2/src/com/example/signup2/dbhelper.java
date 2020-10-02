package com.example.signup2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhelper extends SQLiteOpenHelper{
public static final String dbname="name.db";
public static final String tbname="regstudent";
public static final String col01="ID";
public static final String col11="name";
public static final String col21="age";
public static final String col31="degree";
public static final String tbreg="regfaculty";
public static final String col02="ID";
public static final String col12="name";
public static final String col22="age";
public static final String col32="experience";
public static final String col42="gender";
	public dbhelper(Context context) {
		super(context, dbname, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table "+tbname+"(ID integer primary key,name text,age text,degree text)");
		db.execSQL("create table "+tbreg+"(ID integer,name text,age text,experience text,gender text)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("drop if table exists "+tbname);
		db.execSQL("drop if table exists "+tbreg);
		onCreate(db);
		
	}
	public boolean insertdata(int i,String n,String a,String d)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues v=new ContentValues();
		v.put(col01, i);
		v.put(col11, n);
		v.put(col21, a);
		v.put(col31, d);
		
		Long dd=db.insert(tbname, null, v);
		if(dd==-1)
		{
			return false;
			
		}
		else
		{
			return true;
		}
	}
	
	public boolean detail(String n,String a,String e,String g)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues v=new ContentValues();
		v.put(col12, n);
		v.put(col22, a);
		v.put(col32, e);
		v.put(col42, g);
		Long d=db.insert(tbreg, null, v);
		if(d==-1)
		{
			return false;
			
		}
		else
		{
			return true;
		}
	}
	public int deletedata(String n)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		int a=db.delete(tbname, "name=?",new String[]{n});
		return a;
	}
	public int updatadata(String n,String a,String d)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues v=new ContentValues();
		v.put(col21, a);
		v.put(col31, d);
		int dd=db.update(tbname, v, "name=?", new String[]{n});
		return dd;
		
	}
	public Cursor getdata(String n)
	{
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor res=db.rawQuery("select * from "+tbname+" where name=?",new String[]{n});
		return res;
	}

}
