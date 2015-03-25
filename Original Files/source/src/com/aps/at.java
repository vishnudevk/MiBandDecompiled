// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;


// Referenced classes of package com.aps:
//            y

public final class at extends Thread
{

    private y a;

    public final void run()
    {
        do
        {
            try
            {
                if (!y.c(a))
                {
                    break;
                }
                y.a(a, y.g(a), 1, System.currentTimeMillis());
            }
            catch (Exception exception)
            {
                break;
            }
            try
            {
                Thread.sleep(y.h(a));
            }
            catch (Exception exception1) { }
        } while (true);
    }
}
