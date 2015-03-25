// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.os.Message;

// Referenced classes of package com.tencent.b.b:
//            n, r, b, u, 
//            y

final class z extends Thread
{

    private String a;
    private String b;
    private String c;
    private n d;

    public z(n n1, String s)
    {
        d = n1;
        super();
        a = null;
        b = null;
        c = null;
        a = s;
        StringBuilder stringbuilder = new StringBuilder();
        String s1;
        if (n.h(n1) == 0)
        {
            s1 = "http://lstest.map.soso.com/loc?c=1";
        } else
        {
            s1 = "http://lbs.map.qq.com/loc?c=1";
        }
        b = stringbuilder.append(s1).append("&mars=").append(n.i(n1)).toString();
    }

    private String a(byte abyte0[], String s)
    {
        n.a(d, System.currentTimeMillis());
        StringBuffer stringbuffer = new StringBuffer();
        try
        {
            stringbuffer.append(new String(abyte0, s));
        }
        catch (Exception exception)
        {
            return null;
        }
        return stringbuffer.toString();
    }

    public final void run()
    {
        Message message;
        message = new Message();
        message.what = 8;
        byte abyte1[] = r.a(a.getBytes());
        n.a(d, true);
        u u2 = com.tencent.b.b.b.a(b, "SOSO MAP LBS SDK", abyte1);
        n.a(d, false);
        c = a(r.b(u2.a), u2.b);
        if (c == null) goto _L2; else goto _L1
_L1:
        message.arg1 = 0;
        message.obj = c;
_L10:
        n.j(d);
        n.d(d).sendMessage(message);
        return;
_L2:
        int i;
        try
        {
            message.arg1 = 1;
            continue; /* Loop/switch isn't completed */
        }
        catch (Exception exception)
        {
            i = 0;
        }
_L8:
        if (++i > 3) goto _L4; else goto _L3
_L3:
        sleep(1000L);
        byte abyte0[] = r.a(a.getBytes());
        n.a(d, true);
        u u1 = com.tencent.b.b.b.a(b, "SOSO MAP LBS SDK", abyte0);
        n.a(d, false);
        c = a(r.b(u1.a), u1.b);
        if (c == null) goto _L6; else goto _L5
_L5:
        message.arg1 = 0;
        message.obj = c;
          goto _L7
_L6:
        try
        {
            message.arg1 = 1;
        }
        catch (Exception exception1) { }
_L7:
        if (true) goto _L8; else goto _L4
_L4:
        n.a(d, false);
        message.arg1 = 1;
        if (true) goto _L10; else goto _L9
_L9:
    }
}
