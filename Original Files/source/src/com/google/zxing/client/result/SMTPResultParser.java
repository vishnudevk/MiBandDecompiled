// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, EmailAddressParsedResult, ParsedResult

public final class SMTPResultParser extends ResultParser
{

    public SMTPResultParser()
    {
    }

    public EmailAddressParsedResult parse(Result result)
    {
        String s = result.getText();
        if (!s.startsWith("smtp:") && !s.startsWith("SMTP:"))
        {
            return null;
        }
        String s1 = s.substring(5);
        int i = s1.indexOf(':');
        String s2;
        String s3;
        if (i >= 0)
        {
            s3 = s1.substring(i + 1);
            s1 = s1.substring(0, i);
            int j = s3.indexOf(':');
            s2 = null;
            if (j >= 0)
            {
                s2 = s3.substring(j + 1);
                s3 = s3.substring(0, j);
            }
        } else
        {
            s2 = null;
            s3 = null;
        }
        return new EmailAddressParsedResult(s1, s3, s2, (new StringBuilder()).append("mailto:").append(s1).toString());
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }
}
