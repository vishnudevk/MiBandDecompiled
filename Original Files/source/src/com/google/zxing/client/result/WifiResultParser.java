// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, WifiParsedResult, ParsedResult

public final class WifiResultParser extends ResultParser
{

    public WifiResultParser()
    {
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }

    public WifiParsedResult parse(Result result)
    {
        String s = result.getText();
        String s1;
        if (s.startsWith("WIFI:"))
        {
            if ((s1 = b("S:", s, ';', false)) != null && s1.length() != 0)
            {
                String s2 = b("P:", s, ';', false);
                String s3 = b("T:", s, ';', false);
                if (s3 == null)
                {
                    s3 = "nopass";
                }
                return new WifiParsedResult(s3, s1, s2);
            }
        }
        return null;
    }
}
