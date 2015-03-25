// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;


// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class CalendarParsedResult extends ParsedResult
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final double g;
    private final double h;

    public CalendarParsedResult(String s, String s1, String s2, String s3, String s4, String s5)
    {
        this(s, s1, s2, s3, s4, s5, (0.0D / 0.0D), (0.0D / 0.0D));
    }

    public CalendarParsedResult(String s, String s1, String s2, String s3, String s4, String s5, double d1, double d2)
    {
        super(ParsedResultType.CALENDAR);
        a(s1);
        a = s;
        b = s1;
        if (s2 != null)
        {
            a(s2);
            c = s2;
        } else
        {
            c = null;
        }
        d = s3;
        e = s4;
        f = s5;
        g = d1;
        h = d2;
    }

    private static void a(CharSequence charsequence)
    {
        if (charsequence != null)
        {
            int i = charsequence.length();
            if (i != 8 && i != 15 && i != 16)
            {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < 8; j++)
            {
                if (!Character.isDigit(charsequence.charAt(j)))
                {
                    throw new IllegalArgumentException();
                }
            }

            if (i > 8)
            {
                if (charsequence.charAt(8) != 'T')
                {
                    throw new IllegalArgumentException();
                }
                for (int k = 9; k < 15; k++)
                {
                    if (!Character.isDigit(charsequence.charAt(k)))
                    {
                        throw new IllegalArgumentException();
                    }
                }

                if (i == 16 && charsequence.charAt(15) != 'Z')
                {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public String getAttendee()
    {
        return e;
    }

    public String getDescription()
    {
        return f;
    }

    public String getDisplayResult()
    {
        StringBuilder stringbuilder = new StringBuilder(100);
        maybeAppend(a, stringbuilder);
        maybeAppend(b, stringbuilder);
        maybeAppend(c, stringbuilder);
        maybeAppend(d, stringbuilder);
        maybeAppend(e, stringbuilder);
        maybeAppend(f, stringbuilder);
        return stringbuilder.toString();
    }

    public String getEnd()
    {
        return c;
    }

    public double getLatitude()
    {
        return g;
    }

    public String getLocation()
    {
        return d;
    }

    public double getLongitude()
    {
        return h;
    }

    public String getStart()
    {
        return b;
    }

    public String getSummary()
    {
        return a;
    }
}
