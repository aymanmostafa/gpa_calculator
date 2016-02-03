package com.ayman.huci;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import javax.security.auth.Subject;

/**
 * Created by Hamy on 15/09/2015.
 */
class SubjectsDB extends SQLiteOpenHelper
{
    public SubjectsDB(Context context)
    {
        super(context, "Subjects", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String SUBJECTS = "CREATE TABLE Subjects ( ID INTEGER PRIMARY KEY autoincrement,Name TEXT not null,Hours Double not null,Grade Text not null)";
        db.execSQL(SUBJECTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS Subjects");
        // Create tables again
        onCreate(db);

    }
    public void addSubject (MySubject mSubject)
    {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("Name", mSubject.getName());
        values.put("Hours", mSubject.getHours());
        values.put("Grade",mSubject.getGrade());

        mydb.insert("Subjects", null, values);
        mydb.close();
    }
    public MySubject getSubjectByName(String name)
    {

        //        String SUBJECTS = "CREATE TABLE Subjects ( ID INTEGER PRIMARY KEY autoincrement,Name TEXT not null,Hours INTEGER not null,Grade Text not null)";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Subjects", new String[]{"ID", "Hours", "Grade"},
                "Name=?", new String[]{String.valueOf(name)}
                , null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        int retID = cursor.getInt(0);
        double retHours = cursor.getDouble(1);
        String retGrade = cursor.getString(2);

        MySubject mSubject = new MySubject(retID,name,retHours,retGrade);
        return mSubject;
    }

    public int updateSubjectByName(String name,String g)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        MySubject s=getSubjectByName(name);

        values.put("Name", s.getName());
        values.put("Hours", s.getHours());
        values.put("Grade",g);

        int updateItems = db.update("Subjects", values,"ID = ?", new String[] {String.valueOf(s.getId())} );
        db.close();
        return updateItems;
    }

    public ArrayList<MySubject> getAllSubjects()
    {
        ArrayList<MySubject> AllSubjects = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM Subjects";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst())
        {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                double hours = cursor.getDouble(2);
                String grade = cursor.getString(3);


                AllSubjects.add(new MySubject(id, name, hours, grade));
            } while (cursor.moveToNext());
        }
        db.close();
        // return contact list
        return AllSubjects;
    }
}