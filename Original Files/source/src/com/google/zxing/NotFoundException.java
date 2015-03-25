// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;


// Referenced classes of package com.google.zxing:
//            ReaderException

public final class NotFoundException extends ReaderException
{

    private static final NotFoundException a = new NotFoundException();

    private NotFoundException()
    {
    }

    public static NotFoundException getNotFoundInstance()
    {
        return a;
    }

}
