package com.example.dipto.ieeemadc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Dipto on 13/05/2016.
 */
public class QuestionDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    private static String DATABASE_NAME="EEE_Electrical_Circuits";
    private static final String TABLE_NAME = "Question";
    private final static String COLUMN_ID="QNo";
    private final static String COLUMN_QUESTION="Question";
    private final static String COLUMN_ANSWER="Answer";
    SQLiteDatabase database;

    private static final String TABLE_CREATE = "create table if not exists Question(QNo integer not null,Question text not null,Answer text not null)";

    public QuestionDatabaseHelper(Context context,String string){
        super(context,string,null,DATABASE_VERSION);
    }

    public Hashtable<String,String> getList(){
        database=this.getReadableDatabase();
        String query = "select Question, Answer from "+TABLE_NAME;
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
