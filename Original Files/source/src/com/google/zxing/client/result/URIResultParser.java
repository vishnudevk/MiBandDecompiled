// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, URIParsedResult, ParsedResult

public final class URIResultParser extends ResultParser
{

    private static final String a = "(:\\d{1,5})?(/|\\?|$)";
    private static final Pattern b = Pattern.compile("[a-zA-Z0-9]{2,}://[a-zA-Z0-9\\-]+(\\.[a-zA-Z0-9\\-]+)*(:\\d{1,5})?(/|\\?|$)");
    private static final Pattern c = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z0-9\\-]{2,}(:\\d{1,5})?(/|\\?|$)");

    public URIResultParser()
    {
    }

    static boolean a(CharSequence charsequence)
    {
        Matcher matcher = b.matcher(charsequence);
        Matcher matcher1;
        if (!matcher.find() || matcher.start() != 0)
        {
            if (!(matcher1 = c.matcher(charsequence)).find() || matcher1.start() != 0)
            {
                return false;
            }
        }
        return true;
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }

    public URIParsedResult parse(Result result)
    {
        String s = result.getText();
        if (s.startsWith("URL:"))
        {
            s = s.substring(4);
        }
        String s1 = s.trim();
        if (a(s1))
        {
            return new URIParsedResult(s1, null);
        } else
        {
            return null;
        }
    }

}
