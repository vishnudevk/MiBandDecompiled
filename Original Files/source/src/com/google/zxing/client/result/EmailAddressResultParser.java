// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Map;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, EmailAddressParsedResult, EmailDoCoMoResultParser, ParsedResult

public final class EmailAddressResultParser extends ResultParser
{

    public EmailAddressResultParser()
    {
    }

    public EmailAddressParsedResult parse(Result result)
    {
        String s = result.getText();
        if (s.startsWith("mailto:") || s.startsWith("MAILTO:"))
        {
            String s1 = s.substring(7);
            int i = s1.indexOf('?');
            if (i >= 0)
            {
                s1 = s1.substring(0, i);
            }
            Map map = b(s);
            String s2;
            String s3;
            String s4;
            if (map != null)
            {
                EmailAddressParsedResult emailaddressparsedresult;
                boolean flag;
                if (s1.length() == 0)
                {
                    s2 = (String)map.get("to");
                } else
                {
                    s2 = s1;
                }
                s3 = (String)map.get("subject");
                s4 = (String)map.get("body");
            } else
            {
                s2 = s1;
                s3 = null;
                s4 = null;
            }
            emailaddressparsedresult = new EmailAddressParsedResult(s2, s3, s4, s);
        } else
        {
            flag = EmailDoCoMoResultParser.a(s);
            emailaddressparsedresult = null;
            if (flag)
            {
                return new EmailAddressParsedResult(s, null, null, (new StringBuilder()).append("mailto:").append(s).toString());
            }
        }
        return emailaddressparsedresult;
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }
}
