// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;


// Referenced classes of package com.tencent.b.b:
//            b, r, u

public final class it> extends Thread
{

    private b a;

    public final void run()
    {
        byte abyte1[] = r.a(a.a.getBytes());
        b.a(a, true);
        u u2 = b.a("http://ls.map.soso.com/deflect?c=1", "SOSO MAP LBS SDK", abyte1);
        b.a(a, false);
        byte abyte2[] = r.b(u2.a);
        b.a(a, abyte2, u2.b);
_L1:
        return;
        Exception exception;
        exception;
        for (int i = 0; ++i <= 3;)
        {
            try
            {
                sleep(2000L);
                u u1 = b.a("http://ls.map.soso.com/deflect?c=1", "SOSO MAP LBS SDK", r.a(a.a.getBytes()));
                b.a(a, false);
                byte abyte0[] = r.b(u1.a);
                b.a(a, abyte0, u1.b);
                return;
            }
            catch (Exception exception1) { }
        }

        b.a(a, false);
        if (b.a(a) != null)
        {
            b.a(a).a(360D, 360D);
            return;
        }
          goto _L1
    }

    public (b b1)
    {
        a = b1;
        super();
    }
}
