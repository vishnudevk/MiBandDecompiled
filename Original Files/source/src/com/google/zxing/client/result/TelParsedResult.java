// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;


// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class TelParsedResult extends ParsedResult
{

    private final String a;
    private final String b;
    private final String c;

    public TelParsedResult(String s, String s1, String s2)
    {
        super(ParsedResultType.TEL);
        a = s;
        b = s1;
        c = s2;
    }

    public String getDisplayResult()
    {
        StringBuilder stringbuilder = new StringBuilder(20);
        maybeAppend(a, stringbuilder);
        maybeAppend(c, stringbuilder);
        return stringbuilder.toString();
    }

    public String getNumber()
    {
        return a;
    }

    public String getTelURI()
    {
        return b;
    }

    public String getTitle()
    {
        return c;
    }
}
