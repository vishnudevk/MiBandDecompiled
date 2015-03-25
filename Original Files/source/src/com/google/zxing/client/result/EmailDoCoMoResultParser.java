// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.zxing.client.result:
//            a, EmailAddressParsedResult, ParsedResult

public final class EmailDoCoMoResultParser extends a
{

    private static final Pattern a = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    public EmailDoCoMoResultParser()
    {
    }

    static boolean a(String s)
    {
        return s != null && a.matcher(s).matches() && s.indexOf('@') >= 0;
    }

    public EmailAddressParsedResult parse(Result result)
    {
        String s = result.getText();
        String as[];
        String s1;
        if (s.startsWith("MATMSG:"))
        {
            if ((as = a("TO:", s, true)) != null && a(s1 = as[0]))
            {
                return new EmailAddressParsedResult(s1, b("SUB:", s, false), b("BODY:", s, false), (new StringBuilder()).append("mailto:").append(s1).toString());
            }
        }
        return null;
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }

}
