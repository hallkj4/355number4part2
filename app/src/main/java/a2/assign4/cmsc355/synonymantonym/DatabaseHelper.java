package a2.assign4.cmsc355.synonymantonym;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kevin on 4/2/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "thesaurus.db";
    private static final String TABLE_NAME = "thesaurus";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_SYN = "synonym";
    private static final String COLUMN_ANT = "antonym";

    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table thesaurus(word text primary key not null , synonym text not null , " +
            "antonym text not null);";

    public DatabaseHelper(Context c){
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }
    public void insertThesaurus(Thesaurus t){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        values.put(COLUMN_WORD, t.getWord());
        values.put(COLUMN_SYN, t.getSyn());
        values.put(COLUMN_ANT, t.getAnt());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public String[] searchThesaurus(String word){
        db = this.getReadableDatabase();
        String query = "select word, synonym, antonym from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String temp;
        String[] result = new String[2];
        result[0] = "Not found";
        result[1] = "Not found";
        if(cursor.moveToFirst()){
            do{
                temp = cursor.getString(0);
                if(temp.equals(word)){
                    result[0]= cursor.getString(1);
                    result[1]= cursor.getString(2);
                    break;
                }

            }
            while(cursor.moveToNext());
        }
        db.close();
        return result;
    }
    public String searchWord(String word){
        db = this.getReadableDatabase();
        String query = "select word from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String temp;
        String result = "Not found";
        if(cursor.moveToFirst()){
            do{
                temp = cursor.getString(0);
                if(temp.equals(word)){
                    result = temp;
                    break;
                }

            }
            while(cursor.moveToNext());
        }
        return result;
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}

