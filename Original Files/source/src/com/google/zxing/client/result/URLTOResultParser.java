// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, URIParsedResult, ParsedResult

public final class URLTOResultParser extends ResultParser
{

    public URLTOResultParser()
    {
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }

    public URIParsedResult parse(Result result)
    {
        String s = result.getText();
        int i;
        if (s.startsWith("urlto:") || s.startsWith("URLTO:"))
        {
            if ((i = s.indexOf(':', 6)) >= 0)
            {
                String s1 = null;
                if (i > 6)
                {
                    s1 = s.substring(6, i);
                }
                return new URIParsedResult(s.substring(i + 1), s1);
            }
        }
        return null;
    }
}
