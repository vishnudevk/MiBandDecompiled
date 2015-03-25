// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.tencent.b.b:
//            n, r, s, m, 
//            y

final class A extends Thread
{

    private e.a a;
    private m.b b;
    private f.b c;
    private n d;

    A(n n1, e.a a1, m.b b1, f.b b2)
    {
        d = n1;
        super();
        a = null;
        b = null;
        c = null;
        if (a1 != null)
        {
            a = (e.a)a1.clone();
        }
        if (b1 != null)
        {
            b = (m.b)b1.clone();
        }
        if (b2 != null)
        {
            c = (f.b)b2.clone();
        }
    }

    public final void run()
    {
        if (n.c()) goto _L2; else goto _L1
_L1:
        Pattern pattern;
        n n5;
        TelephonyManager telephonymanager = (TelephonyManager)n.k(d).getSystemService("phone");
        n.c(d, telephonymanager.getDeviceId());
        n.d(d, telephonymanager.getSubscriberId());
        n.e(d, telephonymanager.getLine1Number());
        pattern = Pattern.compile("[0-9a-zA-Z+-]*");
        n5 = d;
        if (n.l(d) != null) goto _L4; else goto _L3
_L3:
        String s12 = "";
_L19:
        n.c(n5, s12);
        if (!pattern.matcher(n.l(d)).matches()) goto _L6; else goto _L5
_L5:
        n n10 = d;
        if (n.l(d) != null) goto _L8; else goto _L7
_L7:
        String s17 = "";
_L20:
        n.c(n10, s17);
_L21:
        n n6 = d;
        if (n.m(d) != null) goto _L10; else goto _L9
_L9:
        String s13 = "";
_L22:
        n.d(n6, s13);
        if (!pattern.matcher(n.m(d)).matches()) goto _L12; else goto _L11
_L11:
        n n9 = d;
        if (n.m(d) != null) goto _L14; else goto _L13
_L13:
        String s16 = "";
_L23:
        n.d(n9, s16);
_L24:
        n n7 = d;
        if (n.n(d) != null) goto _L16; else goto _L15
_L15:
        String s14 = "";
_L25:
        n n8;
        n.e(n7, s14);
        if (!pattern.matcher(n.n(d)).matches())
        {
            break MISSING_BLOCK_LABEL_781;
        }
        n8 = d;
        if (n.n(d) != null) goto _L18; else goto _L17
_L17:
        String s15 = "";
_L26:
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        android.os.Message message;
        n n1;
        String s8;
        n n2;
        String s9;
        n n3;
        String s10;
        n n4;
        String s11;
        try
        {
            n.e(n8, s15);
        }
        catch (Exception exception) { }
_L27:
        n.a(true);
        n1 = d;
        if (n.l(d) == null)
        {
            s8 = "";
        } else
        {
            s8 = n.l(d);
        }
        n.c(n1, s8);
        n2 = d;
        if (n.m(d) == null)
        {
            s9 = "";
        } else
        {
            s9 = n.m(d);
        }
        n.d(n2, s9);
        n3 = d;
        if (n.n(d) == null)
        {
            s10 = "";
        } else
        {
            s10 = n.n(d);
        }
        n.e(n3, s10);
        n4 = d;
        if (n.l(d) == null)
        {
            s11 = "0123456789ABCDEF";
        } else
        {
            s11 = n.l(d);
        }
        n.f(n4, r.a(s11));
_L2:
        if (n.o(d) == 4)
        {
            s1 = s.a(c);
        } else
        {
            s1 = "[]";
        }
        s2 = s.a(b, n.p(d).b());
        s3 = s.a(n.l(d), n.m(d), n.n(d), n.q(d), n.r(d));
        if (a != null && a.a())
        {
            s4 = s.a(a);
        } else
        {
            s4 = "{}";
        }
        s5 = (new StringBuilder("{\"version\":\"1.1.8\",\"address\":")).append(n.s(d)).toString();
        s6 = (new StringBuilder()).append(s5).append(",\"source\":203,\"access_token\":\"").append(n.t(d)).append("\",\"app_name\":").append("\"").append(n.u(d)).append("\",\"bearing\":1").toString();
        s7 = (new StringBuilder()).append(s6).append(",\"attribute\":").append(s3).append(",\"location\":").append(s4).append(",\"cells\":").append(s2).append(",\"wifis\":").append(s1).append("}").toString();
        message = n.d(d).obtainMessage(16, s7);
        n.d(d).sendMessage(message);
        return;
_L4:
        s12 = n.l(d);
          goto _L19
_L8:
        s17 = n.l(d);
          goto _L20
_L6:
        n.c(d, "");
          goto _L21
_L10:
        s13 = n.m(d);
          goto _L22
_L14:
        s16 = n.m(d);
          goto _L23
_L12:
        n.d(d, "");
          goto _L24
_L16:
        s14 = n.n(d);
          goto _L25
_L18:
        s15 = n.n(d);
          goto _L26
        n.e(d, "");
          goto _L27
    }
}
