package ua.com.kistudio.database.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Вiталя on 16.02.2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME= "mytable";

    public DBHelper(Context context, int version) {
        super(context, "MyDB", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (id integer primary key autoincrement, name text, price integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
