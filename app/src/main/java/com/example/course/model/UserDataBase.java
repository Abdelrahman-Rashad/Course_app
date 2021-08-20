package com.example.course.model;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

import java.util.ArrayList;
public class UserDataBase extends SQLiteOpenHelper {

    public static final String DatabaseName="app.db1";
    public UserDataBase(Context con)
    {
        super(con,DatabaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user (id INTEGER primary key AUTOINCREMENT, username TEXT , fullname TEXT , email TEXT , password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user ");
        onCreate(db);
    }

    public String Insert_Data(String n1,String n2,String n3,String n4)
    {
        SQLiteDatabase s = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("fullname",n1);
        values.put("username" ,n2);
        values.put("email",n3);
        values.put("password",n4);
        long re=s.insert("user",null,values);
        if(re==-1)
            return "Error";
        else
            return "Inserted Row";
    }

    public ArrayList<User> Get_Data_User()
    {
        ArrayList<User> arrayList=new ArrayList<User>();
        SQLiteDatabase s=this.getReadableDatabase();
        Cursor c=s.rawQuery("select * from user",null);
        c.moveToFirst();
        while (c.isAfterLast()==false)
        {
            arrayList.add(new User(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4)));
            c.moveToNext();
        }
        return arrayList;
    }

    public void up(String id , String fullname , String username , String E_mail , String password)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("fullname",fullname);
        values.put("username",username);
        values.put("email",E_mail);
        values.put("password",password);
        sq.update("user",values,"id=?",new String[]{id});
    }

    public void deletedata(String id)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        sq.delete("user","id=?",new String[]{id});
    }
    public Boolean checkusername(String name)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        Cursor cursor = sq.rawQuery("select * from user where username = ?",new String []{name} );
        if (cursor.getCount()>0) {
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean checkusername_pass(String name,String pass)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        Cursor cursor = sq.rawQuery("select * from user where username = ? and password = ?",new String []{name,pass} );
        if (cursor.getCount()>0) {
            return true;
        }
        else{
            return false;
        }
    }


}

