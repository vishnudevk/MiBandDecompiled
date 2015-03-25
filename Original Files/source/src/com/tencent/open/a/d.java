// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.tencent.open.a:
//            f, a, c

public class d
{

    private Context a;
    private SQLiteDatabase b;
    private f c;
    private int d;

    public d(Context context)
    {
        a = context;
        c = new f(this, context, "sdk_cgi_report.db", null, 2);
        d = c().size();
    }

    public int a(ArrayList arraylist)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator;
        Log.i("cgi_report_debug", (new StringBuilder()).append("ReportDataModal backupOldItems count = ").append(arraylist.size()).toString());
        iterator = arraylist.iterator();
        int i = 0;
_L1:
        ContentValues contentvalues;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_230;
        }
        a a1 = (a)iterator.next();
        contentvalues = new ContentValues();
        contentvalues.put("apn", a1.a());
        contentvalues.put("frequency", a1.b());
        contentvalues.put("commandid", a1.c());
        contentvalues.put("resultcode", a1.d());
        contentvalues.put("tmcost", a1.e());
        contentvalues.put("reqsize", a1.f());
        contentvalues.put("rspsize", a1.g());
        contentvalues.put("deviceinfo", a1.i());
        contentvalues.put("detail", a1.h());
        b = c.getWritableDatabase();
        b.insertOrThrow("olddata", null, contentvalues);
        b.close();
_L2:
        i++;
          goto _L1
        Exception exception1;
        exception1;
        exception1.printStackTrace();
          goto _L2
        Exception exception;
        exception;
        throw exception;
        Log.i("cgi_report_debug", (new StringBuilder()).append("ReportDataModal backupOldItems succ_count = ").append(i).toString());
        this;
        JVM INSTR monitorexit ;
        return i;
    }

    public boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        Log.i("cgi_report_debug", "ReportDataModal deleteOldItems start");
        b = c.getWritableDatabase();
        b.execSQL("delete from olddata;");
        b.close();
        Log.i("cgi_report_debug", "ReportDataModal deleteOldItems success");
        boolean flag = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        flag = false;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        Exception exception2;
        exception2;
        exception2.printStackTrace();
        b.close();
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean a(String s, String s1, String s2, int i, long l, long l1, long l2, String s3)
    {
        this;
        JVM INSTR monitorenter ;
        ContentValues contentvalues;
        StringBuilder stringbuilder;
        StringBuilder stringbuilder1;
        if (s2.contains("?"))
        {
            s2 = s2.split("\\?")[0];
        }
        Log.i("cgi_report_debug", (new StringBuilder()).append("ReportDataModal addNewItem apn=").append(s).append(",frequency=").append(s1).append(",commandid=").append(s2).append(",resultCode=").append(i).append(",costTime=").append(l).append(",reqSzie=").append(l1).append(",rspSize=").append(l2).toString());
        contentvalues = new ContentValues();
        contentvalues.put("apn", (new StringBuilder()).append(s).append("").toString());
        contentvalues.put("frequency", (new StringBuilder()).append(s1).append("").toString());
        contentvalues.put("commandid", (new StringBuilder()).append(s2).append("").toString());
        contentvalues.put("resultcode", (new StringBuilder()).append(i).append("").toString());
        contentvalues.put("tmcost", (new StringBuilder()).append(l).append("").toString());
        contentvalues.put("reqsize", (new StringBuilder()).append(l1).append("").toString());
        contentvalues.put("rspsize", (new StringBuilder()).append(l2).append("").toString());
        stringbuilder = new StringBuilder();
        stringbuilder.append("network=").append(s).append('&');
        stringbuilder1 = stringbuilder.append("sdcard=");
        int j;
        boolean flag;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            j = 1;
        } else
        {
            j = 0;
        }
        stringbuilder1.append(j).append('&');
        stringbuilder.append("wifi=").append(com.tencent.open.a.c.c(a));
        contentvalues.put("deviceinfo", stringbuilder.toString());
        contentvalues.put("detail", s3);
        b = c.getWritableDatabase();
        b.insertOrThrow("newdata", null, contentvalues);
        b.close();
        Log.i("cgi_report_debug", "ReportDataModal addNewItem success");
        d = 1 + d;
        flag = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception1;
        exception1;
        Log.e("cgi_report_debug", "ReportDataModal addNewItem failed");
        exception1.printStackTrace();
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean b()
    {
        this;
        JVM INSTR monitorenter ;
        Log.i("cgi_report_debug", "ReportDataModal deleteNewItems start");
        b = c.getWritableDatabase();
        b.execSQL("delete from newdata;");
        d = 0;
        b.close();
        Log.i("cgi_report_debug", "ReportDataModal deleteNewItems start");
        boolean flag = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        flag = false;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        Exception exception2;
        exception2;
        exception2.printStackTrace();
        b.close();
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public ArrayList c()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        Log.i("cgi_report_debug", "ReportDataModal getNewItems start");
        arraylist = new ArrayList();
        b = c.getReadableDatabase();
        Cursor cursor;
        cursor = b.rawQuery("select * from newdata", new String[0]);
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            String s = cursor.getString(cursor.getColumnIndex("apn"));
            String s1 = cursor.getString(cursor.getColumnIndex("frequency"));
            String s2 = cursor.getString(cursor.getColumnIndex("commandid"));
            String s3 = cursor.getString(cursor.getColumnIndex("resultcode"));
            String s4 = cursor.getString(cursor.getColumnIndex("tmcost"));
            String s5 = cursor.getString(cursor.getColumnIndex("reqsize"));
            String s6 = cursor.getString(cursor.getColumnIndex("rspsize"));
            String s7 = cursor.getString(cursor.getColumnIndex("detail"));
            arraylist.add(new a(s, s1, s2, s3, s4, s5, s6, cursor.getString(cursor.getColumnIndex("deviceinfo")), s7));
        }

          goto _L1
        Exception exception;
        exception;
        throw exception;
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        ArrayList arraylist1 = arraylist;
_L3:
        this;
        JVM INSTR monitorexit ;
        return arraylist1;
_L1:
        cursor.close();
        b.close();
        Log.i("cgi_report_debug", (new StringBuilder()).append("ReportDataModal getNewItems success, count = ").append(arraylist.size()).toString());
        arraylist1 = arraylist;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public ArrayList d()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        Log.i("cgi_report_debug", "ReportDataModal getOldItems start");
        arraylist = new ArrayList();
        b = c.getReadableDatabase();
        Cursor cursor;
        cursor = b.rawQuery("select * from olddata", new String[0]);
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            String s = cursor.getString(cursor.getColumnIndex("apn"));
            String s1 = cursor.getString(cursor.getColumnIndex("frequency"));
            String s2 = cursor.getString(cursor.getColumnIndex("commandid"));
            String s3 = cursor.getString(cursor.getColumnIndex("resultcode"));
            String s4 = cursor.getString(cursor.getColumnIndex("tmcost"));
            String s5 = cursor.getString(cursor.getColumnIndex("reqsize"));
            String s6 = cursor.getString(cursor.getColumnIndex("rspsize"));
            String s7 = cursor.getString(cursor.getColumnIndex("detail"));
            arraylist.add(new a(s, s1, s2, s3, s4, s5, s6, cursor.getString(cursor.getColumnIndex("deviceinfo")), s7));
        }

          goto _L1
        Exception exception;
        exception;
        throw exception;
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        ArrayList arraylist1 = arraylist;
_L3:
        this;
        JVM INSTR monitorexit ;
        return arraylist1;
_L1:
        cursor.close();
        b.close();
        Log.i("cgi_report_debug", (new StringBuilder()).append("ReportDataModal getOldItems success, count = ").append(arraylist.size()).toString());
        arraylist1 = arraylist;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public int e()
    {
        Log.i("cgi_report_debug", (new StringBuilder()).append("ReportDataModal getTotalCount count = ").append(d).toString());
        return d;
    }
}
