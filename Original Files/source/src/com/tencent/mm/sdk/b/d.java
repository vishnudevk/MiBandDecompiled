// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.b;

import com.tencent.mm.a.a;

// Referenced classes of package com.tencent.mm.sdk.b:
//            c

public final class d
{

    private final a a;
    private c b;

    public final String b(String s)
    {
        if (!s.startsWith("!")) goto _L2; else goto _L1
_L1:
        String s1;
        if (b.a(s))
        {
            return (String)b.get(s);
        }
        s1 = s.substring(1);
        String s5;
        String as[] = s1.split("@");
        if (as.length <= 1)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        String s2 = as[0];
        int i = Integer.valueOf(as[0]).intValue();
        String s3 = s1.substring(1 + s2.length(), i + (1 + s2.length()));
        String s4 = s1.substring(i + (1 + s2.length()));
        s5 = (new StringBuilder()).append(a.a(s3)).append(s4).toString();
        b.put(s, s5);
        return s5;
        Exception exception;
        exception;
_L3:
        exception.printStackTrace();
        s = (new StringBuilder("[td]")).append(s).toString();
_L2:
        return s;
        Exception exception1;
        exception1;
        s = s1;
        exception = exception1;
          goto _L3
        s = s1;
          goto _L2
    }
}
