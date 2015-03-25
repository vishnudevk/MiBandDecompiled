// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;


// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class WifiParsedResult extends ParsedResult
{

    private final String a;
    private final String b;
    private final String c;

    public WifiParsedResult(String s, String s1, String s2)
    {
        super(ParsedResultType.WIFI);
        a = s1;
        b = s;
        c = s2;
    }

    public String getDisplayResult()
    {
        StringBuilder stringbuilder = new StringBuilder(80);
        maybeAppend(a, stringbuilder);
        maybeAppend(b, stringbuilder);
        maybeAppend(c, stringbuilder);
        return stringbuilder.toString();
    }

    public String getNetworkEncryption()
    {
        return b;
    }

    public String getPassword()
    {
        return c;
    }

    public String getSsid()
    {
        return a;
    }
}
