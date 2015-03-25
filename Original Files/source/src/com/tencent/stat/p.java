// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.stat.common.StatLogger;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat:
//            StatStore, s, a, StatConfig

class p
    implements Runnable
{

    final StatStore a;

    p(StatStore statstore)
    {
        a = statstore;
        super();
    }

    public void run()
    {
        Cursor cursor1 = StatStore.b(a).getReadableDatabase().query("config", null, null, null, null, null, null);
        Cursor cursor = cursor1;
        while (cursor.moveToNext()) 
        {
            int i = cursor.getInt(0);
            String s1 = cursor.getString(1);
            String s2 = cursor.getString(2);
            int j = cursor.getInt(3);
            a a1 = new a(i);
            a1.a = i;
            a1.b = new JSONObject(s1);
            a1.c = s2;
            a1.d = j;
            StatConfig.a(a1);
        }
          goto _L1
        Exception exception;
        exception;
_L7:
        StatStore.b().e(exception);
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
        Exception exception1;
        exception1;
        cursor = null;
_L5:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception1;
        exception1;
        if (true) goto _L5; else goto _L4
_L4:
        exception;
        cursor = null;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
