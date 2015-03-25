// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, GeoParsedResult, ParsedResult

public final class GeoResultParser extends ResultParser
{

    private static final Pattern a = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    public GeoResultParser()
    {
    }

    public GeoParsedResult parse(Result result)
    {
        double d;
        String s;
        d = 0.0D;
        s = result.getText();
        if (s != null) goto _L2; else goto _L1
_L1:
        Matcher matcher;
        return null;
_L2:
        if (!(matcher = a.matcher(s)).matches())
        {
            continue; /* Loop/switch isn't completed */
        }
        String s1 = matcher.group(4);
        double d1;
        double d2;
        String s2;
        double d3;
        try
        {
            d1 = Double.parseDouble(matcher.group(1));
        }
        catch (NumberFormatException numberformatexception)
        {
            return null;
        }
        if (d1 > 90D || d1 < -90D)
        {
            continue; /* Loop/switch isn't completed */
        }
        d2 = Double.parseDouble(matcher.group(2));
        if (d2 > 180D || d2 < -180D)
        {
            continue; /* Loop/switch isn't completed */
        }
        s2 = matcher.group(3);
        if (s2 != null) goto _L4; else goto _L3
_L3:
        return new GeoParsedResult(d1, d2, d, s1);
_L4:
        d3 = Double.parseDouble(matcher.group(3));
        if (d3 < d)
        {
            continue; /* Loop/switch isn't completed */
        }
        d = d3;
        if (true) goto _L3; else goto _L5
_L5:
        if (true) goto _L1; else goto _L6
_L6:
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }

}
