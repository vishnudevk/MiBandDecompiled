// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.User;
import com.tencent.stat.event.Event;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.tencent.stat:
//            s, k, t, StatConfig, 
//            p, q, o, b, 
//            m, l, n, a

public class StatStore
{

    private static StatLogger e = StatCommonHelper.getLogger();
    private static StatStore f = null;
    Handler a;
    volatile int b;
    User c;
    private s d;
    private HashMap g;

    private StatStore(Context context)
    {
        a = null;
        b = 0;
        c = null;
        g = new HashMap();
        try
        {
            HandlerThread handlerthread = new HandlerThread("StatStore");
            handlerthread.start();
            e.w((new StringBuilder()).append("Launch store thread:").append(handlerthread).toString());
            a = new Handler(handlerthread.getLooper());
            Context context1 = context.getApplicationContext();
            d = new s(context1);
            d.getWritableDatabase();
            d.getReadableDatabase();
            getUser(context1);
            a();
            d();
            a.post(new k(this));
            return;
        }
        catch (Throwable throwable)
        {
            e.e(throwable);
        }
    }

    static void a(StatStore statstore)
    {
        statstore.c();
    }

    static void a(StatStore statstore, List list)
    {
        statstore.b(list);
    }

    static void a(StatStore statstore, List list, int i)
    {
        statstore.b(list, i);
    }

    static StatLogger b()
    {
        return e;
    }

    static s b(StatStore statstore)
    {
        return statstore.d;
    }

    static void b(StatStore statstore, List list, int i)
    {
        statstore.c(list, i);
    }

    private void b(List list)
    {
        e.i((new StringBuilder()).append("Delete ").append(list.size()).append(" sent events in thread:").append(Thread.currentThread()).toString());
        d.getWritableDatabase().beginTransaction();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            t t1 = (t)iterator.next();
            int i = b;
            SQLiteDatabase sqlitedatabase = d.getWritableDatabase();
            String as[] = new String[1];
            as[0] = Long.toString(t1.a);
            b = i - sqlitedatabase.delete("events", "event_id = ?", as);
        }

        break MISSING_BLOCK_LABEL_156;
        SQLiteException sqliteexception1;
        sqliteexception1;
        e.e(sqliteexception1);
        SQLiteException sqliteexception3;
        try
        {
            d.getWritableDatabase().endTransaction();
            return;
        }
        catch (SQLiteException sqliteexception2)
        {
            e.e(sqliteexception2);
        }
        break MISSING_BLOCK_LABEL_215;
        d.getWritableDatabase().setTransactionSuccessful();
        b = (int)DatabaseUtils.queryNumEntries(d.getReadableDatabase(), "events");
        try
        {
            d.getWritableDatabase().endTransaction();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteException sqliteexception3)
        {
            e.e(sqliteexception3);
        }
        return;
        return;
        Exception exception;
        exception;
        try
        {
            d.getWritableDatabase().endTransaction();
        }
        catch (SQLiteException sqliteexception)
        {
            e.e(sqliteexception);
        }
        throw exception;
    }

    private void b(List list, int i)
    {
        e.i((new StringBuilder()).append("Update ").append(list.size()).append(" sending events to status:").append(i).append(" in thread:").append(Thread.currentThread()).toString());
        ContentValues contentvalues;
        Iterator iterator;
        contentvalues = new ContentValues();
        contentvalues.put("status", Integer.toString(i));
        d.getWritableDatabase().beginTransaction();
        iterator = list.iterator();
_L3:
        t t1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_346;
        }
        t1 = (t)iterator.next();
        if (1 + t1.d <= StatConfig.getMaxSendRetryCount()) goto _L2; else goto _L1
_L1:
        int i1 = b;
        SQLiteDatabase sqlitedatabase1 = d.getWritableDatabase();
        String as1[] = new String[1];
        as1[0] = Long.toString(t1.a);
        b = i1 - sqlitedatabase1.delete("events", "event_id=?", as1);
          goto _L3
        SQLiteException sqliteexception1;
        sqliteexception1;
        e.e(sqliteexception1);
        Exception exception;
        SQLiteException sqliteexception3;
        SQLiteDatabase sqlitedatabase;
        String as[];
        int j;
        try
        {
            d.getWritableDatabase().endTransaction();
            return;
        }
        catch (SQLiteException sqliteexception2)
        {
            e.e(sqliteexception2);
        }
        break MISSING_BLOCK_LABEL_405;
_L2:
        contentvalues.put("send_count", Integer.valueOf(1 + t1.d));
        e.i((new StringBuilder()).append("Update event:").append(t1.a).append(" for content:").append(contentvalues).toString());
        sqlitedatabase = d.getWritableDatabase();
        as = new String[1];
        as[0] = Long.toString(t1.a);
        j = sqlitedatabase.update("events", contentvalues, "event_id=?", as);
        if (j > 0) goto _L3; else goto _L4
_L4:
        e.e((new StringBuilder()).append("Failed to update db, error code:").append(Integer.toString(j)).toString());
          goto _L3
        exception;
        try
        {
            d.getWritableDatabase().endTransaction();
        }
        catch (SQLiteException sqliteexception)
        {
            e.e(sqliteexception);
        }
        throw exception;
        d.getWritableDatabase().setTransactionSuccessful();
        b = (int)DatabaseUtils.queryNumEntries(d.getReadableDatabase(), "events");
        try
        {
            d.getWritableDatabase().endTransaction();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteException sqliteexception3)
        {
            e.e(sqliteexception3);
        }
        return;
    }

    private void c()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("status", Integer.valueOf(1));
        SQLiteDatabase sqlitedatabase = d.getWritableDatabase();
        String as[] = new String[1];
        as[0] = Long.toString(2L);
        sqlitedatabase.update("events", contentvalues, "status=?", as);
        b = (int)DatabaseUtils.queryNumEntries(d.getReadableDatabase(), "events");
        e.i((new StringBuilder()).append("Total ").append(b).append(" unsent events.").toString());
    }

    private void c(List list, int i)
    {
        Cursor cursor = null;
        Cursor cursor2;
        SQLiteDatabase sqlitedatabase = d.getReadableDatabase();
        String as[] = new String[1];
        as[0] = Integer.toString(1);
        cursor2 = sqlitedatabase.query("events", null, "status=?", as, null, null, "event_id", Integer.toString(i));
        while (cursor2.moveToNext()) 
        {
            list.add(new t(cursor2.getLong(0), StatCommonHelper.decode(cursor2.getString(1)), cursor2.getInt(2), cursor2.getInt(3)));
        }
          goto _L1
        SQLiteException sqliteexception;
        sqliteexception;
        Cursor cursor1 = cursor2;
_L7:
        e.e(sqliteexception);
        if (cursor1 != null)
        {
            cursor1.close();
        }
_L3:
        return;
_L1:
        if (cursor2 == null) goto _L3; else goto _L2
_L2:
        cursor2.close();
        return;
        Exception exception;
        exception;
_L5:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        exception;
        cursor = cursor2;
        continue; /* Loop/switch isn't completed */
        exception;
        cursor = cursor1;
        if (true) goto _L5; else goto _L4
_L4:
        sqliteexception;
        cursor1 = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void d()
    {
        Cursor cursor1 = d.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
        Cursor cursor = cursor1;
        while (cursor.moveToNext()) 
        {
            g.put(cursor.getString(0), cursor.getString(1));
        }
          goto _L1
        SQLiteException sqliteexception;
        sqliteexception;
_L7:
        e.e(sqliteexception);
        if (cursor != null)
        {
            cursor.close();
        }
_L3:
        return;
_L1:
        if (cursor == null) goto _L3; else goto _L2
_L2:
        cursor.close();
        return;
        Exception exception;
        exception;
        cursor = null;
_L5:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        exception;
        if (true) goto _L5; else goto _L4
_L4:
        sqliteexception;
        cursor = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static StatStore getInstance()
    {
        return f;
    }

    public static StatStore getInstance(Context context)
    {
        if (f == null)
        {
            f = new StatStore(context);
        }
        return f;
    }

    void a()
    {
        a.post(new p(this));
    }

    void a(int i)
    {
        a.post(new q(this, i));
    }

    void a(a a1)
    {
        if (a1 == null)
        {
            return;
        }
        try
        {
            a.post(new o(this, a1));
            return;
        }
        catch (Exception exception)
        {
            e.e(exception);
        }
    }

    void a(Event event, b b1)
    {
        if (StatConfig.getMaxStoreEventCount() > 0)
        {
            if (b > StatConfig.getMaxStoreEventCount())
            {
                e.warn("Too many events stored in db.");
                b = b - d.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
            }
            ContentValues contentvalues = new ContentValues();
            String s1 = StatCommonHelper.encode(event.toJsonString());
            contentvalues.put("content", s1);
            contentvalues.put("send_count", "0");
            contentvalues.put("status", Integer.toString(1));
            contentvalues.put("timestamp", Long.valueOf(event.getTimestamp()));
            if (d.getWritableDatabase().insert("events", null, contentvalues) == -1L)
            {
                e.error((new StringBuilder()).append("Failed to store event:").append(s1).toString());
                return;
            }
            b = 1 + b;
            if (b1 != null)
            {
                b1.a();
                return;
            }
        }
    }

    void a(List list)
    {
        if (Thread.currentThread().getId() == a.getLooper().getThread().getId())
        {
            b(list);
            return;
        }
        try
        {
            a.post(new m(this, list));
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            e.e(sqliteexception);
        }
        return;
    }

    void a(List list, int i)
    {
        if (Thread.currentThread().getId() == a.getLooper().getThread().getId())
        {
            b(list, i);
            return;
        }
        try
        {
            a.post(new l(this, list, i));
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            e.e(sqliteexception);
        }
        return;
    }

    void b(Event event, b b1)
    {
        if (!StatConfig.isEnableStatService())
        {
            return;
        }
        try
        {
            if (Thread.currentThread().getId() == a.getLooper().getThread().getId())
            {
                a(event, b1);
                return;
            }
        }
        catch (SQLiteException sqliteexception)
        {
            e.e(sqliteexception);
            return;
        }
        a.post(new n(this, event, b1));
        return;
    }

    public int getNumStoredEvents()
    {
        return b;
    }

    public User getUser(Context context)
    {
        if (c != null)
        {
            return c;
        }
        Cursor cursor2 = d.getReadableDatabase().query("user", null, null, null, null, null, null, null);
        Cursor cursor = cursor2;
        boolean flag = cursor.moveToNext();
        boolean flag1 = false;
        if (!flag) goto _L2; else goto _L1
_L1:
        String s1;
        String s2;
        int i;
        String s3;
        long l1;
        long l2;
        s1 = cursor.getString(0);
        s2 = StatCommonHelper.decode(s1);
        i = cursor.getInt(1);
        s3 = cursor.getString(2);
        l1 = cursor.getLong(3);
        l2 = System.currentTimeMillis() / 1000L;
        if (i == 1) goto _L4; else goto _L3
_L3:
        if (StatCommonHelper.getDateFormat(l1 * 1000L).equals(StatCommonHelper.getDateFormat(1000L * l2))) goto _L4; else goto _L5
_L5:
        int j = 1;
_L33:
        Exception exception;
        Throwable throwable;
        Cursor cursor1;
        int i1;
        String as[];
        String s4;
        String s5;
        String s6;
        boolean flag2;
        String s7;
        String s8;
        ContentValues contentvalues;
        String s9;
        String s10;
        String s11;
        String s13;
        String s14;
        if (!s3.equals(StatCommonHelper.getAppVersion(context)))
        {
            i1 = j | 2;
        } else
        {
            i1 = j;
        }
        as = s2.split(",");
        if (as == null) goto _L7; else goto _L6
_L6:
        if (as.length <= 0) goto _L7; else goto _L8
_L8:
        s13 = as[0];
        if (s13 == null) goto _L10; else goto _L9
_L9:
        if (s13.length() >= 11) goto _L11; else goto _L10
_L10:
        s14 = StatCommonHelper.getDeviceID(context);
        if (s14 == null) goto _L13; else goto _L12
_L12:
        if (s14.length() > 10)
        {
            flag2 = true;
            break MISSING_BLOCK_LABEL_776;
        }
          goto _L13
_L24:
        if (as == null) goto _L15; else goto _L14
_L14:
        if (as.length < 2) goto _L15; else goto _L16
_L16:
        s7 = as[1];
        s6 = (new StringBuilder()).append(s5).append(",").append(s7).toString();
_L26:
        c = new User(s5, s7, i1);
        contentvalues = new ContentValues();
        contentvalues.put("uid", StatCommonHelper.encode(s6));
        contentvalues.put("user_type", Integer.valueOf(i1));
        contentvalues.put("app_ver", StatCommonHelper.getAppVersion(context));
        contentvalues.put("ts", Long.valueOf(l2));
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        d.getWritableDatabase().update("user", contentvalues, "uid=?", new String[] {
            s1
        });
        if (i1 == i) goto _L18; else goto _L17
_L17:
        d.getWritableDatabase().replace("user", null, contentvalues);
        flag1 = true;
_L2:
        if (flag1) goto _L20; else goto _L19
_L19:
        s9 = StatCommonHelper.getUserID(context);
        s10 = StatCommonHelper.getMacId(context);
        if (s10 == null) goto _L22; else goto _L21
_L21:
        if (s10.length() <= 0) goto _L22; else goto _L23
_L23:
        s11 = (new StringBuilder()).append(s9).append(",").append(s10).toString();
_L32:
        long l3 = System.currentTimeMillis() / 1000L;
        String s12 = StatCommonHelper.getAppVersion(context);
        ContentValues contentvalues1 = new ContentValues();
        contentvalues1.put("uid", StatCommonHelper.encode(s11));
        contentvalues1.put("user_type", Integer.valueOf(0));
        contentvalues1.put("app_ver", s12);
        contentvalues1.put("ts", Long.valueOf(l3));
        d.getWritableDatabase().insert("user", null, contentvalues1);
        c = new User(s9, s10, 0);
_L20:
        if (cursor != null)
        {
            cursor.close();
        }
_L28:
        return c;
_L7:
        s4 = StatCommonHelper.getUserID(context);
        s5 = s4;
        s6 = s4;
        flag2 = true;
          goto _L24
_L15:
        s7 = StatCommonHelper.getMacId(context);
        if (s7 == null) goto _L26; else goto _L25
_L25:
        if (s7.length() <= 0) goto _L26; else goto _L27
_L27:
        s8 = (new StringBuilder()).append(s5).append(",").append(s7).toString();
        s6 = s8;
        flag2 = true;
          goto _L26
        throwable;
        cursor1 = null;
_L31:
        e.e(throwable);
        if (cursor1 != null)
        {
            cursor1.close();
        }
          goto _L28
        exception;
        cursor = null;
_L30:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        exception;
        continue; /* Loop/switch isn't completed */
        exception;
        cursor = cursor1;
        if (true) goto _L30; else goto _L29
_L29:
        throwable;
        cursor1 = cursor;
          goto _L31
_L22:
        s11 = s9;
          goto _L32
_L18:
        flag1 = true;
          goto _L2
_L13:
        s14 = s13;
        flag2 = false;
        break MISSING_BLOCK_LABEL_776;
_L11:
        s6 = s2;
        s5 = s13;
        flag2 = false;
          goto _L24
_L4:
        j = i;
          goto _L33
        s6 = s2;
        s5 = s14;
          goto _L24
    }

}
