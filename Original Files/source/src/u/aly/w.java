// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package u.aly:
//            u, aj

public class w
{

    private static final String h = "successful_request";
    private static final String i = "failed_requests ";
    private static final String j = "last_request_spent_ms";
    private static final String k = "last_request_time";
    private static final String l = "first_activate_time";
    public int a;
    public int b;
    public long c;
    private final int d = 0x36ee80;
    private int e;
    private long f;
    private long g;
    private Context m;

    public w(Context context)
    {
        f = 0L;
        g = 0L;
        b(context);
    }

    public static aj a(Context context)
    {
        SharedPreferences sharedpreferences = u.a(context);
        aj aj1 = new aj();
        aj1.c(sharedpreferences.getInt("failed_requests ", 0));
        aj1.d(sharedpreferences.getInt("last_request_spent_ms", 0));
        aj1.a(sharedpreferences.getInt("successful_request", 0));
        return aj1;
    }

    private void b(Context context)
    {
        m = context.getApplicationContext();
        SharedPreferences sharedpreferences = u.a(context);
        a = sharedpreferences.getInt("successful_request", 0);
        b = sharedpreferences.getInt("failed_requests ", 0);
        e = sharedpreferences.getInt("last_request_spent_ms", 0);
        c = sharedpreferences.getLong("last_request_time", 0L);
    }

    public int a()
    {
        if (e > 0x36ee80)
        {
            return 0x36ee80;
        } else
        {
            return e;
        }
    }

    public boolean b()
    {
        return c == 0L;
    }

    public void c()
    {
        a = 1 + a;
        c = f;
    }

    public void d()
    {
        b = 1 + b;
    }

    public void e()
    {
        f = System.currentTimeMillis();
    }

    public void f()
    {
        e = (int)(System.currentTimeMillis() - f);
    }

    public void g()
    {
        u.a(m).edit().putInt("successful_request", a).putInt("failed_requests ", b).putInt("last_request_spent_ms", e).putLong("last_request_time", c).commit();
    }

    public void h()
    {
        u.a(m).edit().putLong("first_activate_time", System.currentTimeMillis()).commit();
    }

    public boolean i()
    {
        if (g == 0L)
        {
            g = u.a(m).getLong("first_activate_time", 0L);
        }
        return g == 0L;
    }

    public long j()
    {
        if (i())
        {
            return System.currentTimeMillis();
        } else
        {
            return g;
        }
    }
}
