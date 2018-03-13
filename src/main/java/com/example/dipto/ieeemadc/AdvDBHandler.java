package com.example.dipto.ieeemadc;

/**
 * Created by rukshar on 5/14/2016.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class AdvDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "advertisement.db";
    public static final String TABLE_PRODUCTS = "advertisements";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TOPIC = "topic";
    public static final String COLUMN_DESCRIPTION = "description";

    //We need to pass database information along to superclass
    public AdvDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TOPIC + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    //Add a new row to the database
    public void addProduct(Advertisement product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TOPIC, product.get_topic());
        values.put(COLUMN_DESCRIPTION, product.get_description());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    //Delete a product from the database
    public void deleteProduct(String productName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_TOPIC + "=\"" + productName + "\";");
    }

    public void deleteAll(String[] productList)
    {
        for (String  s: productList)
        {
            String[] temp = s.split(",");

            deleteProduct(temp[0]); // temp-0 is the topic name
        }
    }

    public String databaseToString(){
        String dbString = "";

        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("topic")) != null) {
                dbString += c.getString(c.getColumnIndex("topic"));
                dbString += ",";
                dbString += c.getString(c.getColumnIndex("description"));
                dbString += "\n";

            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    public String databaseToString2(){
        String dbString ="";

        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("description")) != null) {
                dbString += c.getString(c.getColumnIndex("description"));
                dbString += ",";

            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

}