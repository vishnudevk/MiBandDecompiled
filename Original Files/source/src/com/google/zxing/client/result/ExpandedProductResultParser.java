// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, ExpandedProductParsedResult, ParsedResult

public final class ExpandedProductResultParser extends ResultParser
{

    public ExpandedProductResultParser()
    {
    }

    private static String a(int i, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (s.charAt(i) != '(')
        {
            return null;
        }
        String s1 = s.substring(i + 1);
        for (int j = 0; j < s1.length();)
        {
            char c = s1.charAt(j);
            if (c == ')')
            {
                return stringbuilder.toString();
            }
            if (c >= '0' && c <= '9')
            {
                stringbuilder.append(c);
                j++;
            } else
            {
                return null;
            }
        }

        return stringbuilder.toString();
    }

    private static String b(int i, String s)
    {
        StringBuilder stringbuilder;
        String s1;
        int j;
        stringbuilder = new StringBuilder();
        s1 = s.substring(i);
        j = 0;
_L8:
        if (j >= s1.length()) goto _L2; else goto _L1
_L1:
        char c = s1.charAt(j);
        if (c != '(') goto _L4; else goto _L3
_L3:
        if (a(j, s1) != null) goto _L2; else goto _L5
_L5:
        stringbuilder.append('(');
_L6:
        j++;
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuilder.append(c);
        if (true) goto _L6; else goto _L2
_L2:
        return stringbuilder.toString();
        if (true) goto _L8; else goto _L7
_L7:
    }

    public ExpandedProductParsedResult parse(Result result)
    {
        if (result.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED)
        {
            return null;
        }
        String s = result.getText();
        if (s == null)
        {
            return null;
        }
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        String s6 = null;
        String s7 = null;
        String s8 = null;
        String s9 = null;
        String s10 = null;
        String s11 = null;
        String s12 = null;
        String s13 = null;
        HashMap hashmap = new HashMap();
        int i = 0;
        while (i < s.length()) 
        {
            String s14 = a(i, s);
            if (s14 == null)
            {
                return null;
            }
            int j = i + (2 + s14.length());
            String s15 = b(j, s);
            int k = j + s15.length();
            if ("00".equals(s14))
            {
                s2 = s15;
            } else
            if ("01".equals(s14))
            {
                s1 = s15;
            } else
            if ("10".equals(s14))
            {
                s3 = s15;
            } else
            if ("11".equals(s14))
            {
                s4 = s15;
            } else
            if ("13".equals(s14))
            {
                s5 = s15;
            } else
            if ("15".equals(s14))
            {
                s6 = s15;
            } else
            if ("17".equals(s14))
            {
                s7 = s15;
            } else
            if ("3100".equals(s14) || "3101".equals(s14) || "3102".equals(s14) || "3103".equals(s14) || "3104".equals(s14) || "3105".equals(s14) || "3106".equals(s14) || "3107".equals(s14) || "3108".equals(s14) || "3109".equals(s14))
            {
                s9 = "KG";
                s10 = s14.substring(3);
                s8 = s15;
            } else
            if ("3200".equals(s14) || "3201".equals(s14) || "3202".equals(s14) || "3203".equals(s14) || "3204".equals(s14) || "3205".equals(s14) || "3206".equals(s14) || "3207".equals(s14) || "3208".equals(s14) || "3209".equals(s14))
            {
                s9 = "LB";
                s10 = s14.substring(3);
                s8 = s15;
            } else
            if ("3920".equals(s14) || "3921".equals(s14) || "3922".equals(s14) || "3923".equals(s14))
            {
                s12 = s14.substring(3);
                s11 = s15;
            } else
            if ("3930".equals(s14) || "3931".equals(s14) || "3932".equals(s14) || "3933".equals(s14))
            {
                if (s15.length() < 4)
                {
                    return null;
                }
                s11 = s15.substring(3);
                s13 = s15.substring(0, 3);
                s12 = s14.substring(3);
            } else
            {
                hashmap.put(s14, s15);
            }
            i = k;
        }
        return new ExpandedProductParsedResult(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, hashmap);
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }
}
