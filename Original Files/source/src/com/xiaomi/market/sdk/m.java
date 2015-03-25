// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.os.HandlerThread;
import java.io.File;

// Referenced classes of package com.xiaomi.market.sdk:
//            n, r, l, q, 
//            w

public class m
{

    public static m aK;
    private Context a;
    private w b;
    private q c;
    private long d;
    private File e;
    private DownloadManager f;
    private HandlerThread g;
    private n h;

    private m(Context context)
    {
        d = -1L;
        a = context;
        f = (DownloadManager)a.getSystemService("download");
        g = new HandlerThread("Worker Thread");
        g.start();
        h = new n(this, g.getLooper());
    }

    static Context a(m m1)
    {
        return m1.a;
    }

    static void a(m m1, long l1)
    {
        m1.d = l1;
    }

    static void a(m m1, q q1)
    {
        m1.c = q1;
    }

    static void a(m m1, w w)
    {
        m1.b = w;
    }

    static void a(m m1, File file)
    {
        m1.e = file;
    }

    static DownloadManager b(m m1)
    {
        return m1.f;
    }

    static w c(m m1)
    {
        return m1.b;
    }

    static q d(m m1)
    {
        return m1.c;
    }

    static File e(m m1)
    {
        return m1.e;
    }

    static long f(m m1)
    {
        return m1.d;
    }

    public static m i(Context context)
    {
        if (aK == null)
        {
            aK = new m(context);
        }
        return aK;
    }

    public void a(long l1)
    {
        if (d > 0L && d != l1)
        {
            return;
        } else
        {
            h.m();
            return;
        }
    }

    public void a(q q1, w w)
    {
        if (w == null || q1 == null)
        {
            return;
        } else
        {
            b = w;
            c = q1;
            h.l();
            return;
        }
    }

    public boolean a(q q1)
    {
        Cursor cursor;
        r r1 = r.j(a);
        String as[] = l.aJ;
        String as1[] = new String[1];
        as1[0] = q1.packageName;
        cursor = r1.query("update_download", as, "package_name=?", as1, null, null, null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
        long l2 = cursor.getLong(cursor.getColumnIndex("download_id"));
        long l1 = l2;
_L5:
        if (l1 == -1L)
        {
            if (cursor != null)
            {
                cursor.close();
            }
            return false;
        }
        break MISSING_BLOCK_LABEL_119;
        Exception exception1;
        exception1;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception1;
        Cursor cursor1;
        int j;
        if (cursor != null)
        {
            cursor.close();
        }
        android.app.DownloadManager.Query query = new android.app.DownloadManager.Query();
        query.setFilterById(new long[] {
            l1
        });
        cursor1 = f.query(query);
        j = -1;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        int k;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_205;
        }
        k = cursor1.getInt(cursor1.getColumnIndexOrThrow("status"));
        j = k;
        if (j != 4 && j != 1 && j != 2)
        {
            if (cursor1 != null)
            {
                cursor1.close();
            }
            return false;
        }
        break MISSING_BLOCK_LABEL_254;
        Exception exception;
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return true;
_L2:
        l1 = -1L;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
