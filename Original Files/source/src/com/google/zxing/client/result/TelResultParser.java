// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, TelParsedResult, ParsedResult

public final class TelResultParser extends ResultParser
{

    public TelResultParser()
    {
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }

    public TelParsedResult parse(Result result)
    {
        String s = result.getText();
        if (!s.startsWith("tel:") && !s.startsWith("TEL:"))
        {
            return null;
        }
        String s1;
        int i;
        String s2;
        if (s.startsWith("TEL:"))
        {
            s1 = (new StringBuilder()).append("tel:").append(s.substring(4)).toString();
        } else
        {
            s1 = s;
        }
        i = s.indexOf('?', 4);
        if (i < 0)
        {
            s2 = s.substring(4);
        } else
        {
            s2 = s.substring(4, i);
        }
        return new TelParsedResult(s2, s1, null);
    }
}
