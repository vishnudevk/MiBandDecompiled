// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.net;


// Referenced classes of package android.support.v4.net:
//            l, j

class k extends ThreadLocal
{

    final j a;

    k(j j)
    {
        a = j;
        super();
    }

    protected l a()
    {
        return new l(null);
    }

    protected Object initialValue()
    {
        return a();
    }
}
