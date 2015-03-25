// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.a.a;

import com.tencent.b.b.q;

// Referenced classes of package com.tencent.b.a.a:
//            d

public class b
{

    private int a;
    private int b;
    private int c;
    private int d;

    public b(int i, int j, int k, int l)
    {
        a = 1;
        b = 0;
        c = 12;
        d = 1;
        q.a((new StringBuilder("argument: ")).append(a).append(" ").append(d).append(" ").append(b).toString());
        if (i >= 0 && i <= 1)
        {
            a = i;
        }
        if (j >= 0 && j <= 1)
        {
            d = j;
        }
        if (k == 0 || k == 3 || k == 4 || k == 7)
        {
            b = k;
        }
        if (d == 0)
        {
            b = 0;
        }
        c = l;
    }

    public int getReqDelay()
    {
        return c;
    }

    public int getReqGeoType()
    {
        return d;
    }

    public int getReqLevel()
    {
        return b;
    }

    public int getReqType()
    {
        return a;
    }

    public void onLocationDataUpdate(byte abyte0[], int i)
    {
    }

    public void onLocationUpdate(d d1)
    {
    }

    public void onStatusUpdate(int i)
    {
    }
}
