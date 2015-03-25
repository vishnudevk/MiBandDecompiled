// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;


// Referenced classes of package com.google.zxing:
//            ReaderException

public final class FormatException extends ReaderException
{

    private static final FormatException a = new FormatException();

    private FormatException()
    {
    }

    public static FormatException getFormatInstance()
    {
        return a;
    }

}
