// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;


// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class SMSParsedResult extends ParsedResult
{

    private final String a[];
    private final String b[];
    private final String c;
    private final String d;

    public SMSParsedResult(String s, String s1, String s2, String s3)
    {
        super(ParsedResultType.SMS);
        a = (new String[] {
            s
        });
        b = (new String[] {
            s1
        });
        c = s2;
        d = s3;
    }

    public SMSParsedResult(String as[], String as1[], String s, String s1)
    {
        super(ParsedResultType.SMS);
        a = as;
        b = as1;
        c = s;
        d = s1;
    }

    public String getBody()
    {
        return d;
    }

    public String getDisplayResult()
    {
        StringBuilder stringbuilder = new StringBuilder(100);
        maybeAppend(a, stringbuilder);
        maybeAppend(c, stringbuilder);
        maybeAppend(d, stringbuilder);
        return stringbuilder.toString();
    }

    public String[] getNumbers()
    {
        return a;
    }

    public String getSMSURI()
    {
        boolean flag = true;
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("sms:");
        int i = 0;
        boolean flag1 = flag;
        while (i < a.length) 
        {
            if (flag1)
            {
                flag1 = false;
            } else
            {
                stringbuilder.append(',');
            }
            stringbuilder.append(a[i]);
            if (b != null && b[i] != null)
            {
                stringbuilder.append(";via=");
                stringbuilder.append(b[i]);
            }
            i++;
        }
        boolean flag2;
        if (d != null)
        {
            flag2 = flag;
        } else
        {
            flag2 = false;
        }
        if (c == null)
        {
            flag = false;
        }
        if (flag2 || flag)
        {
            stringbuilder.append('?');
            if (flag2)
            {
                stringbuilder.append("body=");
                stringbuilder.append(d);
            }
            if (flag)
            {
                if (flag2)
                {
                    stringbuilder.append('&');
                }
                stringbuilder.append("subject=");
                stringbuilder.append(c);
            }
        }
        return stringbuilder.toString();
    }

    public String getSubject()
    {
        return c;
    }

    public String[] getVias()
    {
        return b;
    }
}
