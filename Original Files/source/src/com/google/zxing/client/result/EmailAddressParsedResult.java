// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;


// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class EmailAddressParsedResult extends ParsedResult
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;

    EmailAddressParsedResult(String s, String s1, String s2, String s3)
    {
        super(ParsedResultType.EMAIL_ADDRESS);
        a = s;
        b = s1;
        c = s2;
        d = s3;
    }

    public String getBody()
    {
        return c;
    }

    public String getDisplayResult()
    {
        StringBuilder stringbuilder = new StringBuilder(30);
        maybeAppend(a, stringbuilder);
        maybeAppend(b, stringbuilder);
        maybeAppend(c, stringbuilder);
        return stringbuilder.toString();
    }

    public String getEmailAddress()
    {
        return a;
    }

    public String getMailtoURI()
    {
        return d;
    }

    public String getSubject()
    {
        return b;
    }
}
