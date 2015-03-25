// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;


// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class TextParsedResult extends ParsedResult
{

    private final String a;
    private final String b;

    public TextParsedResult(String s, String s1)
    {
        super(ParsedResultType.TEXT);
        a = s;
        b = s1;
    }

    public String getDisplayResult()
    {
        return a;
    }

    public String getLanguage()
    {
        return b;
    }

    public String getText()
    {
        return a;
    }
}
