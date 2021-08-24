package com.example.course.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Course_Database extends SQLiteOpenHelper {
    public static  final String DatabaseName="Course.db";

    public Course_Database(Context context){
        super(context,DatabaseName,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table course (id integer primary key autoincrement,name text,description text,teachername text,check1 integer default 1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists course");
    }

    public String insert(String name,String description,String teachername){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("description",description);
        values.put("teachername",teachername);
        long result=db.insert("course",null,values);
        if(result== -1)
            return "error";
        else
            return "Insert Succeeded";
    }

    public ArrayList<Course> getdata(){
        ArrayList<Course> arr=new ArrayList<Course>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c= db.rawQuery("select * from course",null);
        c.moveToFirst();
        while (c.isAfterLast()==false)
        {
            arr.add(new Course(c.getInt(0),c.getString(1),c.getString(2),c.getString(3)));
            c.moveToNext();
        }
        return  arr;
    }

    public boolean update(String id,String name,String description,String teachername){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("teachername",teachername);
        values.put("description",description);

        Cursor cursor = db.rawQuery("select * from course where id = ?",new String []{id} );
        if (cursor.getCount()>0) {

            long result =  db.update("course", values, "id=?", new String[]{id});
            if (result == -1){
                return false;
            }
            else{
                return true;
            }
        }
        else {
            return false;
        }

    }

    public void delete(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("course","id=?",new String[]{id});
    }

}
