// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;


// Referenced classes of package com.google.zxing.qrcode.decoder:
//            c, d

class l extends c
{

    private l()
    {
        super(null);
    }

    l(d d)
    {
        this();
    }

    boolean a(int i, int j)
    {
        return (1 & (1 & i + j) + (i * j) % 3) == 0;
    }
}
