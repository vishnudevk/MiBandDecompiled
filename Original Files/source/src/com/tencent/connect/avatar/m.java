// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;


// Referenced classes of package com.tencent.connect.avatar:
//            l, ImageActivity

class m
    implements Runnable
{

    final l a;

    m(l l1)
    {
        a = l1;
        super();
    }

    public void run()
    {
        ImageActivity.g(a.a);
    }
}
