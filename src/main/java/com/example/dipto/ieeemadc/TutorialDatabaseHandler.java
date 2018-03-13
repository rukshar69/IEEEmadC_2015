package com.example.dipto.ieeemadc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Dipto on 19/05/2016.
 */
public class TutorialDatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NAME = "Tutorial.db";
    private static final String TABLE_NAME = "Tutorial";
    private final static String COLUMN_TUTORIAL_NAME="Tutorial_Name";
    private final static String COLUMN_TUTORIAL_LINK="Tutorial_Link";
    SQLiteDatabase database;

    private static final String TABLE_CREATE = "create table if not exists Tutorial(Tutorial_Name text not null,Tutorial_Link not null)";

    public TutorialDatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public ArrayList<String> getList(){
        database=this.getReadableDatabase();
        String query = "select Tutorial_Name from "+TABLE_NAME;
        Cursor cursor = database.rawQuery(query,null);
        ArrayList<String> list = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                String a = cursor.getString(0);
                list.add(a);

            }while(cursor.moveToNext());
        }
        database.close();
        return list;
    }

    public Hashtable<String,String> getHashTable(){
        database=this.getReadableDatabase();
        String query = "select Tutorial_Name, Tutorial_Link from "+TABLE_NAME;
        Cursor cursor = database.rawQuery(query,null);
        Hashtable<String,String> hashtable = new Hashtable<>();
        if(cursor.moveToFirst()){
            do{
                String a = cursor.getString(0);
                String b = cursor.getString(1);
                hashtable.put(a,b);
            }while(cursor.moveToNext());
        }
        database.close();
        return hashtable;
    }

    public void insert(String name,String url){
        database=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TUTORIAL_NAME, name);
        values.put(COLUMN_TUTORIAL_LINK,url);
        database.insert(TABLE_NAME,null,values);
        database.close();
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
