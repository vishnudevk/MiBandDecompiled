// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;


// Referenced classes of package com.google.zxing.client.result:
//            ParsedResultType

public abstract class ParsedResult
{

    private final ParsedResultType a;

    protected ParsedResult(ParsedResultType parsedresulttype)
    {
        a = parsedresulttype;
    }

    public static void maybeAppend(String s, StringBuilder stringbuilder)
    {
        if (s != null && s.length() > 0)
        {
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append('\n');
            }
            stringbuilder.append(s);
        }
    }

    public static void maybeAppend(String as[], StringBuilder stringbuilder)
    {
        if (as != null)
        {
            int i = as.length;
            for (int j = 0; j < i; j++)
            {
                String s = as[j];
                if (s == null || s.length() <= 0)
                {
                    continue;
                }
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append('\n');
                }
                stringbuilder.append(s);
            }

        }
    }

    public abstract String getDisplayResult();

    public ParsedResultType getType()
    {
        return a;
    }

    public String toString()
    {
        return getDisplayResult();
    }
}
