// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;


// Referenced classes of package com.google.zxing.qrcode.decoder:
//            c, d

class i extends c
{

    private i()
    {
        super(null);
    }

    i(d d)
    {
        this();
    }

    boolean a(int j, int k)
    {
        return (1 & (j >>> 1) + k / 3) == 0;
    }
}
