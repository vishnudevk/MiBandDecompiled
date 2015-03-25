// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;


// Referenced classes of package com.google.zxing:
//            ReaderException

public final class ChecksumException extends ReaderException
{

    private static final ChecksumException a = new ChecksumException();

    private ChecksumException()
    {
    }

    public static ChecksumException getChecksumInstance()
    {
        return a;
    }

}
