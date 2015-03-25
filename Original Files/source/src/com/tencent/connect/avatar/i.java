// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;


// Referenced classes of package com.tencent.connect.avatar:
//            h, ImageActivity

class i
    implements Runnable
{

    final String a;
    final h b;

    i(h h1, String s)
    {
        b = h1;
        a = s;
        super();
    }

    public void run()
    {
        ImageActivity.b(b.a, a);
    }
}
