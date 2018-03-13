package com.example.dipto.ieeemadc;

import
        android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dipto on 10/05/2016.
 */
public class ContactDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Contacts.db";
    private static final String TABLE_NAME = "Contacts";
    private final static String COLUMN_NAME = "Name";
    private final static String COLUMN_EMAIL = "Email";
    private final static String COLUMN_PASSWORD = "Password";
    private final static String COLUMN_NO = "contactNo";
    private final static String COLUMN_JOB = "job";
    private final static String COLUMN_EDUCATION = "education";
    private final static String COLUMN_INTEREST = "interest";
    private final static String COLUMN_BIRTHDAY = "birthday";
    private final static String COLUMN_SEX = "sex";
    SQLiteDatabase database;

    private static final String TABLE_CREATE = "create table if not exists Contacts(Name text not null,Email text not null,Password text not null" +
            ",contactNo text not null,job text not null,education text not null,interest text not null,birthday text not null,sex text not null)";

    public ContactDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertContact(Contact contact) {
        database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, contact.getName());
        values.put(COLUMN_EMAIL, contact.getEmail());
        values.put(COLUMN_PASSWORD, contact.getPassword());
        values.put(COLUMN_NO,contact.getContactNo());
        values.put(COLUMN_JOB, contact.getJob());
        values.put(COLUMN_EDUCATION,contact.getEducation());
        values.put(COLUMN_INTEREST, contact.getInterest());
        values.put(COLUMN_BIRTHDAY, contact.getBirthday());
        values.put(COLUMN_SEX,contact.getSex());


        database.insert(TABLE_NAME, null, values);
        database.close();
    }



    public String makeQuery(String name)
    {
        String dbString = "";

        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("Name")).equals(name)) {
                dbString += "Email Address:" + c.getString(c.getColumnIndex("Email"));
                dbString += "\n";
                dbString += "Contact Number:" + c.getString(c.getColumnIndex("contactNo"));
                dbString += "\n";
                dbString += "Occupation:" + c.getString(c.getColumnIndex("job"));
                dbString += "\n";
                dbString += "Highest Education:" + c.getString(c.getColumnIndex("education"));
                dbString += "\n";
                dbString += "Date of Birth:" + c.getString(c.getColumnIndex("birthday"));
                dbString += "\n";
                dbString += "Sex:" + c.getString(c.getColumnIndex("sex"));
                break;
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    public String searchContact(String name){
        database=this.getReadableDatabase();
        String query = "select Name, Password from "+TABLE_NAME;
        Cursor cursor = database.rawQuery(query,null);
        String a,b;
        b="Not Found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                if(a.equals(name)){
                    b=cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        database.close();
        return b;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        database=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
