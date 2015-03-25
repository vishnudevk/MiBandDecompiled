// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.a;

import android.content.SharedPreferences;
import android.os.Environment;
import com.tencent.a.b.a;
import com.tencent.a.b.c;
import java.io.File;

// Referenced classes of package com.tencent.a.a:
//            h, a, f

public class d
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener
{

    protected static final h b;
    protected static final h c;
    private volatile boolean a;
    protected com.tencent.a.a.a d;
    private volatile boolean e;
    private volatile boolean f;

    public d()
    {
        a = false;
        e = true;
        f = true;
    }

    public static File c()
    {
        String s = (new StringBuilder()).append(com.tencent.a.b.b.a.a).append(File.separator).append(com.tencent.a.b.a.b()).toString();
        com.tencent.a.b.d d1 = com.tencent.a.b.c.b();
        boolean flag = false;
        if (d1 != null)
        {
            int i = d1.c() != 0x800000L;
            flag = false;
            if (i > 0)
            {
                flag = true;
            }
        }
        if (flag)
        {
            return new File(Environment.getExternalStorageDirectory(), s);
        } else
        {
            return new File(com.tencent.a.b.a.c(), s);
        }
    }

    public void a(int i, String s, String s1, Throwable throwable)
    {
        if (!d()) goto _L2; else goto _L1
_L1:
        if (!e()) goto _L4; else goto _L3
_L3:
        if (d != null) goto _L5; else goto _L2
_L2:
        return;
_L5:
        d.b(i, Thread.currentThread(), System.currentTimeMillis(), s, s1, throwable);
_L4:
        if (f())
        {
            com.tencent.a.a.f.a.b(i, Thread.currentThread(), System.currentTimeMillis(), s, s1, throwable);
            return;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void b()
    {
        if (d != null)
        {
            d.a();
            d.b();
        }
    }

    public final boolean d()
    {
        return a;
    }

    public final boolean e()
    {
        return e;
    }

    public final boolean f()
    {
        return f;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if ("debug.file.tracelevel".equals(s))
        {
            int i = sharedpreferences.getInt("debug.file.tracelevel", 63);
            a(8, "WnsTracer", (new StringBuilder()).append("File Trace Level Changed = ").append(i).toString(), null);
            d.a(i);
        }
    }

    static 
    {
        File file = c();
        b = new h(file, 24, 0x40000, 8192, "OpenSDK.Client.File.Tracer", 10000L, 10, ".app.log", 0x240c8400L);
        c = new h(file, 24, 0x40000, 8192, "OpenSDK.File.Tracer", 10000L, 10, ".OpenSDK.log", 0x240c8400L);
    }
}
