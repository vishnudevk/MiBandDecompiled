// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;


// Referenced classes of package com.tencent.connect.avatar:
//            k, b

class j
    implements Runnable
{

    final b a;

    j(b b1)
    {
        a = b1;
        super();
    }

    public void run()
    {
        try
        {
            Thread.sleep(300L);
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        a.post(new k(this));
        b.a(a, false);
    }
}
