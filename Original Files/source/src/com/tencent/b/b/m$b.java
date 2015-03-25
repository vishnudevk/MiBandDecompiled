// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;


// Referenced classes of package com.tencent.b.b:
//            m

public final class h
    implements Cloneable
{

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public final Object clone()
    {
        h h1;
        try
        {
            h1 = (h)super.clone();
        }
        catch (Exception exception)
        {
            return null;
        }
        return h1;
    }

    public (m m, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 0x7fffffff;
        h = 0x7fffffff;
        a = i;
        b = j;
        c = k;
        d = l;
        e = i1;
        f = j1;
        g = k1;
        h = l1;
    }
}
