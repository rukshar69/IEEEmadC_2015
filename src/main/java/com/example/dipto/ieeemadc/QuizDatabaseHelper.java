package com.example.dipto.ieeemadc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Dipto on 11/05/2016.
 */
public class QuizDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "QuizMain.db";
    private static final String TABLE_NAME = "Quiz";
    private final static String COLUMN_ID="QuizId";
    private final static String COLUMN_NAME="Name";
    private final static String COLUMN_SUBJECT="Subject";
    SQLiteDatabase database;

    private static final String TABLE_CREATE = "create table if not exists Quiz(QuizId integer not null,Name text not null,Subject text not null)";

    public QuizDatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public ArrayList<String> getList(){
        database=this.getReadableDatabase();
        String query = "select Name, Subject from "+TABLE_NAME;
        Cursor cursor = database.rawQuery(query,null);
        ArrayList<String> list = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                String a = cursor.getString(0);
                String b = cursor.getString(1);
                b+="_"+a;
                list.add(b);

            }while(cursor.moveToNext());
        }
        database.close();
        return list;
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
