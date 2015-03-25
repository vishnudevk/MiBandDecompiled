// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;


// Referenced classes of package com.google.zxing.qrcode.decoder:
//            c, d

class k extends c
{

    private k()
    {
        super(null);
    }

    k(d d)
    {
        this();
    }

    boolean a(int i, int j)
    {
        int l = i * j;
        return (1 & (l & 1) + l % 3) == 0;
    }
}
