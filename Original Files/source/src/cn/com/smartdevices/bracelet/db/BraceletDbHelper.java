// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.UploadData;
import java.util.ArrayList;
import java.util.Iterator;

public class BraceletDbHelper extends SQLiteOpenHelper
{

    private static BraceletDbHelper a = null;
    private static final String b = "origin_db";
    private static final int c = 1;
    private static final String d = "date_data";
    private static final String e = "id";
    private static final String f = "date";
    private static final String g = "type";
    private static final String h = "source";
    private static final String i = "data";
    private static final String j = "summary";
    private static final String k = "sync";
    private static final String l = "indexs";

    public BraceletDbHelper(Context context)
    {
        super(context, "origin_db", null, 1);
    }

    public static void create(Context context)
    {
        if (a == null)
        {
            a = new BraceletDbHelper(context);
        }
    }

    public static BraceletDbHelper getInstance()
    {
        return a;
    }

    public String[] dateOfStartAndStop()
    {
        Cursor cursor = getReadableDatabase().query("date_data", null, null, null, null, null, "date ASC");
        String as[] = null;
        if (cursor != null)
        {
            int i1 = cursor.getCount();
            as = null;
            if (i1 > 0)
            {
                as = new String[2];
                cursor.moveToFirst();
                as[0] = cursor.getString(cursor.getColumnIndex("date"));
                cursor.moveToLast();
                as[1] = cursor.getString(cursor.getColumnIndex("date"));
            }
        }
        if (cursor != null)
        {
            cursor.close();
        }
        return as;
    }

    public void dropAllDatas()
    {
        getWritableDatabase().execSQL("DELETE FROM date_data");
    }

    public int getCount()
    {
        Cursor cursor = getReadableDatabase().query("date_data", null, null, null, null, null, null);
        if (cursor != null)
        {
            int i1 = cursor.getCount();
            cursor.close();
            return i1;
        } else
        {
            return 0;
        }
    }

    public void insertDatas(ArrayList arraylist, int i1)
    {
        insertDatas(arraylist, i1, 0, 0);
    }

    public void insertDatas(ArrayList arraylist, int i1, int j1, int k1)
    {
        if (arraylist == null || arraylist.size() < 1)
        {
            return;
        }
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.beginTransaction();
        UploadData uploaddata;
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); write(sqlitedatabase, uploaddata.date, uploaddata.data, j1, k1, i1, uploaddata.summary, uploaddata.indexs))
        {
            uploaddata = (UploadData)iterator.next();
        }

        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE date_data(id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,source INTEGER,date TEXT,summary TEXT,indexs TEXT,data BLOB,sync INTEGER);");
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i1, int j1)
    {
        sqlitedatabase.execSQL(" DROP TABLE IF EXISTS date_data");
        onCreate(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i1, int j1)
    {
        sqlitedatabase.execSQL(" DROP TABLE IF EXISTS date_data");
        onCreate(sqlitedatabase);
    }

    public ArrayList readNotSyncDatas()
    {
        return readNotSyncDatas(0, 0);
    }

    public ArrayList readNotSyncDatas(int i1, int j1)
    {
        String as[] = {
            "date", "data", "summary", "indexs"
        };
        String as1[] = new String[3];
        as1[0] = (new StringBuilder()).append("").append(i1).toString();
        as1[1] = (new StringBuilder()).append("").append(j1).toString();
        as1[2] = "0";
        Cursor cursor = getReadableDatabase().query("date_data", as, "type=? AND source=? AND sync=?", as1, null, null, "date ASC");
        if (cursor == null || cursor.getCount() == 0)
        {
            if (cursor != null)
            {
                cursor.close();
            }
            return null;
        }
        ArrayList arraylist = new ArrayList();
        arraylist.ensureCapacity(cursor.getCount());
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            UploadData uploaddata = new UploadData();
            uploaddata.date = cursor.getString(cursor.getColumnIndex("date"));
            uploaddata.data = cursor.getBlob(cursor.getColumnIndex("data"));
            uploaddata.summary = cursor.getString(cursor.getColumnIndex("summary"));
            uploaddata.indexs = cursor.getString(cursor.getColumnIndex("indexs"));
            Debug.i("WPJ", (new StringBuilder()).append("not sync data:").append(uploaddata.date).append(",size:").append(uploaddata.data.length).toString());
            arraylist.add(uploaddata);
        }

        cursor.close();
        return arraylist;
    }

    public byte[] readOriginData(String s)
    {
        return readOriginData(s, 0, 0);
    }

    public byte[] readOriginData(String s, int i1, int j1)
    {
        String as[] = {
            "data"
        };
        String as1[] = new String[3];
        as1[0] = s;
        as1[1] = (new StringBuilder()).append("").append(i1).toString();
        as1[2] = (new StringBuilder()).append("").append(j1).toString();
        Cursor cursor = getReadableDatabase().query("date_data", as, "date=? AND type=? AND source=?", as1, null, null, null);
        byte abyte0[] = null;
        if (cursor != null)
        {
            int k1 = cursor.getCount();
            abyte0 = null;
            if (k1 != 0)
            {
                cursor.moveToFirst();
                abyte0 = cursor.getBlob(cursor.getColumnIndex("data"));
            }
        }
        if (cursor != null)
        {
            cursor.close();
        }
        return abyte0;
    }

    public String readSummary(String s)
    {
        String as[] = {
            "summary"
        };
        String as1[] = {
            s
        };
        Cursor cursor = getReadableDatabase().query("date_data", as, "date=?", as1, null, null, null);
        String s1 = null;
        if (cursor != null)
        {
            int i1 = cursor.getCount();
            s1 = null;
            if (i1 > 0)
            {
                cursor.moveToFirst();
                s1 = cursor.getString(0);
            }
            cursor.close();
        }
        return s1;
    }

    public void updateSyncState(ArrayList arraylist, int i1)
    {
        updateSyncState(arraylist, i1, 0, 0);
    }

    public void updateSyncState(ArrayList arraylist, int i1, int j1, int k1)
    {
        if (arraylist == null || arraylist.size() < 1)
        {
            return;
        }
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.beginTransaction();
        String s;
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); sqlitedatabase.execSQL(s))
        {
            UploadData uploaddata = (UploadData)iterator.next();
            s = (new StringBuilder()).append("update date_data set sync = ").append(i1).append(" where ").append("date").append(" = ").append("'").append(uploaddata.date).append("'").append(" and ").append("type").append(" = ").append(j1).append(" and ").append("source").append(" = ").append(k1).append(";").toString();
            Debug.i("WPJ", (new StringBuilder()).append("update sync state:").append(s).toString());
        }

        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
    }

    public void write(SQLiteDatabase sqlitedatabase, String s, byte abyte0[], int i1, int j1, int k1, String s1, 
            String s2)
    {
        Debug.i("BraceletDbHelper", (new StringBuilder()).append("1======write......").append(s).toString());
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("type", Integer.valueOf(i1));
        contentvalues.put("source", Integer.valueOf(j1));
        contentvalues.put("date", s);
        contentvalues.put("summary", s1);
        contentvalues.put("indexs", s2);
        contentvalues.put("data", abyte0);
        contentvalues.put("sync", Integer.valueOf(k1));
        String as[] = new String[3];
        as[0] = s;
        as[1] = (new StringBuilder()).append("").append(i1).toString();
        as[2] = (new StringBuilder()).append("").append(j1).toString();
        Cursor cursor = sqlitedatabase.query("date_data", null, "date=? AND type=? AND source=?", as, null, null, null);
        if (cursor != null && cursor.getCount() > 0)
        {
            sqlitedatabase.update("date_data", contentvalues, "date=? AND type=? AND source=?", as);
        } else
        {
            sqlitedatabase.insert("date_data", null, contentvalues);
        }
        if (cursor != null)
        {
            cursor.close();
        }
    }

    public void write(String s, byte abyte0[], int i1, int j1, String s1, String s2)
    {
        Debug.i("BraceletDbHelper", (new StringBuilder()).append("0======write......").append(s).toString());
        Debug.f("BraceletDbHelper", (new StringBuilder()).append("date:").append(s).append(",data len:").append(abyte0.length).append(",summary:").append(s1).append(",indexs:").append(s2).toString());
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("type", Integer.valueOf(i1));
        contentvalues.put("source", Integer.valueOf(j1));
        contentvalues.put("date", s);
        contentvalues.put("summary", s1);
        contentvalues.put("indexs", s2);
        contentvalues.put("data", abyte0);
        contentvalues.put("sync", Integer.valueOf(0));
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        String as[] = new String[3];
        as[0] = s;
        as[1] = (new StringBuilder()).append("").append(i1).toString();
        as[2] = (new StringBuilder()).append("").append(j1).toString();
        Cursor cursor = sqlitedatabase.query("date_data", null, "date=? AND type=? AND source=?", as, null, null, null);
        if (cursor != null && cursor.getCount() > 0)
        {
            sqlitedatabase.update("date_data", contentvalues, "date=? AND type=? AND source=?", as);
        } else
        {
            sqlitedatabase.insert("date_data", null, contentvalues);
        }
        if (cursor != null)
        {
            cursor.close();
        }
    }

    public void write(String s, byte abyte0[], String s1, String s2)
    {
        write(s, abyte0, 0, 0, s1, s2);
    }

}
