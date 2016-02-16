package ua.com.kistudio.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ua.com.kistudio.database.util.DBHelper;

public class MainActivity extends AppCompatActivity {

    public static final int DB_VERSION = 1;
    DBHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbh = new DBHelper(this,DB_VERSION);
        SQLiteDatabase db = dbh.getWritableDatabase();

        ContentValues cv = new ContentValues();
        for (int i=0;i<3;i++) {
            cv.put("name", "Device "+i);
            cv.put("price", 1000 * i);
            //db.insert(DBHelper.TABLE_NAME, null, cv);
        }
        Cursor c = db.query(DBHelper.TABLE_NAME,null,null,null,null,null,null);

        int idIndex = c.getColumnIndex("id");
        int nameIndex = c.getColumnIndex("name");
        int priceIndex = c.getColumnIndex("price");
        c.moveToFirst();

        Log.d("MyLogs","-------------------------------------");
        do{
            Log.d("MyLogs",String.format("%d - id, %s - text, %d - price ",c.getInt(idIndex),
                    c.getString(nameIndex),c.getInt(priceIndex)));
        }
        while(c.moveToNext());

        db.delete(DBHelper.TABLE_NAME,"id=1",null);

    }
}
