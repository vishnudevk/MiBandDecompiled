// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class URIParsedResult extends ParsedResult
{

    private static final Pattern a = Pattern.compile(":/*([^/@]+)@[^/]+");
    private final String b;
    private final String c;

    public URIParsedResult(String s, String s1)
    {
        super(ParsedResultType.URI);
        b = a(s);
        c = s1;
    }

    private static String a(String s)
    {
        String s1 = s.trim();
        int i = s1.indexOf(':');
        if (i < 0)
        {
            return (new StringBuilder()).append("http://").append(s1).toString();
        }
        if (a(s1, i))
        {
            return (new StringBuilder()).append("http://").append(s1).toString();
        } else
        {
            return (new StringBuilder()).append(s1.substring(0, i).toLowerCase(Locale.ENGLISH)).append(s1.substring(i)).toString();
        }
    }

    private static boolean a(String s, int i)
    {
        int j = s.indexOf('/', i + 1);
        int k;
        int l;
        if (j < 0)
        {
            k = s.length();
        } else
        {
            k = j;
        }
        if (k > i + 1) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        l = i + 1;
label0:
        do
        {
label1:
            {
                if (l >= k)
                {
                    break label1;
                }
                if (s.charAt(l) < '0' || s.charAt(l) > '9')
                {
                    break label0;
                }
                l++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public String getDisplayResult()
    {
        StringBuilder stringbuilder = new StringBuilder(30);
        maybeAppend(c, stringbuilder);
        maybeAppend(b, stringbuilder);
        return stringbuilder.toString();
    }

    public String getTitle()
    {
        return c;
    }

    public String getURI()
    {
        return b;
    }

    public boolean isPossiblyMaliciousURI()
    {
        return a.matcher(b).find();
    }

}
