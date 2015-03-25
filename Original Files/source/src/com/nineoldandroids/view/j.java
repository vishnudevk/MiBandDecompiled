// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;


// Referenced classes of package com.nineoldandroids.view:
//            i

class j
    implements Runnable
{

    final i a;

    j(i k)
    {
        a = k;
        super();
    }

    public void run()
    {
        i.a(a);
    }
}
