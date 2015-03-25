// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, SMSParsedResult, ParsedResult

public final class SMSTOMMSTOResultParser extends ResultParser
{

    public SMSTOMMSTOResultParser()
    {
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }

    public SMSParsedResult parse(Result result)
    {
        String s = result.getText();
        if (!s.startsWith("smsto:") && !s.startsWith("SMSTO:") && !s.startsWith("mmsto:") && !s.startsWith("MMSTO:"))
        {
            return null;
        }
        String s1 = s.substring(6);
        int i = s1.indexOf(':');
        String s2;
        if (i >= 0)
        {
            s2 = s1.substring(i + 1);
            s1 = s1.substring(0, i);
        } else
        {
            s2 = null;
        }
        return new SMSParsedResult(s1, null, null, s2);
    }
}
