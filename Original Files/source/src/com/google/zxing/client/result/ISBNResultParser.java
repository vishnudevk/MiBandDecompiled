// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, ISBNParsedResult, ParsedResult

public final class ISBNResultParser extends ResultParser
{

    public ISBNResultParser()
    {
    }

    public ISBNParsedResult parse(Result result)
    {
        String s;
        if (result.getBarcodeFormat() == BarcodeFormat.EAN_13)
        {
            if ((s = result.getText()).length() == 13 && (s.startsWith("978") || s.startsWith("979")))
            {
                return new ISBNParsedResult(s);
            }
        }
        return null;
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }
}
