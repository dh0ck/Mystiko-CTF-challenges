package com.example.kryptonite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private static SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }
    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

    public static void setSecret(String user, String secret){
        /*c = db.rawQuery("select secret from test where Name = '" + user + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String secret = c.getString(0);
            buffer.append(""+secret);
        }
        return buffer.toString();*/

        final String USER_NAME = "user";
        final String SECRET_NAME = "secret";
        String start = "INSERT INTO test VALUES (";
        String query = "INSERT INTO test VALUES (\'" + user + "\', \'" + secret + "\');";
        Log.e("xxxxxxxxxxxxxx",query);
        //db.rawQuery( query, null);
        db.execSQL(query);
        Log.e("yyyyyyyyyyyyyy",query);
        //StringBuffer buffer = new StringBuffer();

    }
}
