// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat:
//            a, StatStore, s

class o
    implements Runnable
{

    final a a;
    final StatStore b;

    o(StatStore statstore, a a1)
    {
        b = statstore;
        a = a1;
        super();
    }

    public void run()
    {
        String s1;
        String s2;
        s1 = a.a();
        s2 = StatCommonHelper.md5sum(s1);
        if (s2.equals(a.c)) goto _L2; else goto _L1
_L1:
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        contentvalues.put("content", a.b.toString());
        contentvalues.put("md5sum", s2);
        a.c = s2;
        contentvalues.put("version", Integer.valueOf(a.d));
        Cursor cursor1 = StatStore.b(b).getReadableDatabase().query("config", null, null, null, null, null, null);
        Cursor cursor = cursor1;
_L6:
        if (!cursor.moveToNext()) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        i = cursor.getInt(0);
        j = a.a;
        if (i != j) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L14:
        if (cursor != null)
        {
            cursor.close();
        }
_L9:
        Exception exception;
        Exception exception1;
        long l;
        if (flag)
        {
            SQLiteDatabase sqlitedatabase = StatStore.b(b).getWritableDatabase();
            String as[] = new String[1];
            as[0] = Integer.toString(a.a);
            l = sqlitedatabase.update("config", contentvalues, "type=?", as);
        } else
        {
            contentvalues.put("type", Integer.valueOf(a.a));
            l = StatStore.b(b).getWritableDatabase().insert("config", null, contentvalues);
        }
        if (l != -1L) goto _L8; else goto _L7
_L7:
        StatStore.b().error((new StringBuilder()).append("Failed to store cfg:").append(s1).toString());
_L2:
        return;
        exception1;
        cursor = null;
_L12:
        StatStore.b().e(exception1);
        if (cursor != null)
        {
            cursor.close();
            flag = false;
        } else
        {
            flag = false;
        }
          goto _L9
        exception;
        cursor = null;
_L11:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
_L8:
        StatStore.b().i((new StringBuilder()).append("Sucessed to store cfg:").append(s1).toString());
        return;
        exception;
        if (true) goto _L11; else goto _L10
_L10:
        exception1;
          goto _L12
_L4:
        flag = false;
        if (true) goto _L14; else goto _L13
_L13:
    }
}
