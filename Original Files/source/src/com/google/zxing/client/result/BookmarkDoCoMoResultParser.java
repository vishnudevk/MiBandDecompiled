// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            a, URIResultParser, URIParsedResult, ParsedResult

public final class BookmarkDoCoMoResultParser extends a
{

    public BookmarkDoCoMoResultParser()
    {
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }

    public URIParsedResult parse(Result result)
    {
        String s = result.getText();
        if (s.startsWith("MEBKM:"))
        {
            String s1 = b("TITLE:", s, true);
            String as[] = a("URL:", s, true);
            if (as != null)
            {
                String s2 = as[0];
                if (URIResultParser.a(s2))
                {
                    return new URIParsedResult(s2, s1);
                }
            }
        }
        return null;
    }
}
