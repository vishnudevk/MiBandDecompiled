// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.List;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, VCardResultParser, CalendarParsedResult, ParsedResult

public final class VEventResultParser extends ResultParser
{

    public VEventResultParser()
    {
    }

    private static String a(CharSequence charsequence, String s, boolean flag)
    {
        List list = VCardResultParser.a(charsequence, s, flag);
        if (list == null || list.isEmpty())
        {
            return null;
        } else
        {
            return (String)list.get(0);
        }
    }

    public CalendarParsedResult parse(Result result)
    {
        double d = (0.0D / 0.0D);
        String s = result.getText();
        if (s == null)
        {
            return null;
        }
        if (s.indexOf("BEGIN:VEVENT") < 0)
        {
            return null;
        }
        String s1 = a("SUMMARY", s, true);
        String s2 = a("DTSTART", s, true);
        if (s2 == null)
        {
            return null;
        }
        String s3 = a("DTEND", s, true);
        String s4 = a("LOCATION", s, true);
        String s5 = a("DESCRIPTION", s, true);
        String s6 = a("GEO", s, true);
        double d1;
        CalendarParsedResult calendarparsedresult;
        if (s6 == null)
        {
            d1 = d;
        } else
        {
            int i = s6.indexOf(';');
            double d2;
            try
            {
                d1 = Double.parseDouble(s6.substring(0, i));
                d2 = Double.parseDouble(s6.substring(i + 1));
            }
            catch (NumberFormatException numberformatexception)
            {
                return null;
            }
            d = d2;
        }
        try
        {
            calendarparsedresult = new CalendarParsedResult(s1, s2, s3, s4, null, s5, d1, d);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return null;
        }
        return calendarparsedresult;
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }
}
