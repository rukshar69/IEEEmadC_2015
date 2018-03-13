package com.example.dipto.ieeemadc;

/**
 * Created by rukshar on 5/22/2016.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChatDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "chat.db";
    public static final String TABLE_PRODUCTS = "history";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USER = "user";
    public static final String COLUMN_MESSAGE = "message";
    private Context mycontext;
    private String DB_PATH = "/data/data/com.example.dipto.ieeemadc/databases/";

    //We need to pass database information along to superclass
    public ChatDB(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        mycontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        boolean dbExist = checkDataBase();
        if(dbExist==false) {
            /*String query = "CREATE TABLE IF NOT EXISTS " + TABLE_PRODUCTS + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USER + " TEXT, " +
                    COLUMN_MESSAGE + " TEXT " +
                    ");";
            db.execSQL(query);*/
            this.getReadableDatabase();

            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){
            //database does't exist yet.
        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException, IOException {

        //Open your local db as the input stream
        InputStream myInput = mycontext.getAssets().open(DATABASE_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DATABASE_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    //Add a new row to the database
    public void addProduct(Chat product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER, product.get_user());
        values.put(COLUMN_MESSAGE, product.get_message());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    //Delete a product from the database


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
            if (c.getString(c.getColumnIndex("user")) != null) {
                dbString += c.getString(c.getColumnIndex("user"));
                dbString += "$";
                dbString += c.getString(c.getColumnIndex("message"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
