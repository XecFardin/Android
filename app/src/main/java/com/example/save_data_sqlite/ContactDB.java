package com.example.save_data_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactDB
{
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "person_name";
    public static final String KEY_PHONE = "_cell";

    private final String DATABASE_NAME="ContactDB";
    private final String DATABASE_TABLE="Sheet1";
    private final int DATABASE_VERSION=1;

    private DBHelper ourhelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    public ContactDB(Context ourContext) {
        this.ourContext = ourContext;
    }
    private class DBHelper extends SQLiteOpenHelper
    {
        public DBHelper(Context context)
        {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE);
            onCreate(sqLiteDatabase);

        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            /*
            CREATE TABLE  Contactstable (_id INTEGER PRIMARY KEY AUTOINCREMENT,
            person_name TEXT NOT NULL, _cell TEXT NOT NULL);
             */
            String sqlCode = "CREATE TABLE " + DATABASE_TABLE + "("
            + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    KEY_NAME +" TEXT NOT NULL, "+
                    KEY_PHONE +" TEXT NOT NULL);";
            sqLiteDatabase.execSQL(sqlCode);



        }
    }
    public  ContactDB open() throws SQLException
    {
        ourhelper = new DBHelper(ourContext);
        ourDatabase=ourhelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        ourhelper.close();
    }
    public long createentry(String name,String cell)
    {
        ContentValues cv =new ContentValues();
        cv.put(KEY_NAME,name);
        cv.put(KEY_PHONE,cell);
        return ourDatabase.insert(DATABASE_TABLE,null,cv);
    }
    public String getData()
    {
        String [] colums = new String[] {KEY_ROWID,KEY_NAME,KEY_PHONE};
        Cursor cursor=ourDatabase.query(DATABASE_TABLE,colums,null,null,null,null,null);

        String result = "";
        int iRowID=cursor.getColumnIndex(KEY_ROWID);
        int iName=cursor.getColumnIndex(KEY_NAME);
        int iCell=cursor.getColumnIndex(KEY_PHONE);
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext())
        {
            result=result+cursor.getString(iRowID)+": "+cursor.getString(iName)+": "+cursor.getString(iCell)+"\n";
        }
        cursor.close();

        return result;
    }
    public long deleteentry(String rowId)
    {
        return ourDatabase.delete(DATABASE_TABLE,KEY_ROWID+"=?",new String[]{rowId});
    }
    public long updateentry(String rowId,String name,String cell)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_PHONE,cell);

        return  ourDatabase.update(DATABASE_TABLE,contentValues,KEY_ROWID+"=?",new String[]{rowId});
    }
}
