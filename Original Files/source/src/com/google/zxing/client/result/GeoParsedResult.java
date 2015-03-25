// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;


// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class GeoParsedResult extends ParsedResult
{

    private final double a;
    private final double b;
    private final double c;
    private final String d;

    GeoParsedResult(double d1, double d2, double d3, String s)
    {
        super(ParsedResultType.GEO);
        a = d1;
        b = d2;
        c = d3;
        d = s;
    }

    public double getAltitude()
    {
        return c;
    }

    public String getDisplayResult()
    {
        StringBuilder stringbuilder = new StringBuilder(20);
        stringbuilder.append(a);
        stringbuilder.append(", ");
        stringbuilder.append(b);
        if (c > 0.0D)
        {
            stringbuilder.append(", ");
            stringbuilder.append(c);
            stringbuilder.append('m');
        }
        if (d != null)
        {
            stringbuilder.append(" (");
            stringbuilder.append(d);
            stringbuilder.append(')');
        }
        return stringbuilder.toString();
    }

    public String getGeoURI()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("geo:");
        stringbuilder.append(a);
        stringbuilder.append(',');
        stringbuilder.append(b);
        if (c > 0.0D)
        {
            stringbuilder.append(',');
            stringbuilder.append(c);
        }
        if (d != null)
        {
            stringbuilder.append('?');
            stringbuilder.append(d);
        }
        return stringbuilder.toString();
    }

    public double getLatitude()
    {
        return a;
    }

    public double getLongitude()
    {
        return b;
    }

    public String getQuery()
    {
        return d;
    }
}
