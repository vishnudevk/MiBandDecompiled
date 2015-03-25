// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            a, AddressBookParsedResult, ParsedResult

public final class AddressBookDoCoMoResultParser extends a
{

    public AddressBookDoCoMoResultParser()
    {
    }

    private static String a(String s)
    {
        int i = s.indexOf(',');
        if (i >= 0)
        {
            s = (new StringBuilder()).append(s.substring(i + 1)).append(' ').append(s.substring(0, i)).toString();
        }
        return s;
    }

    public AddressBookParsedResult parse(Result result)
    {
        String s = result.getText();
        if (!s.startsWith("MECARD:"))
        {
            return null;
        }
        String as[] = a("N:", s, true);
        if (as == null)
        {
            return null;
        }
        String s1 = a(as[0]);
        String s2 = b("SOUND:", s, true);
        String as1[] = a("TEL:", s, true);
        String as2[] = a("EMAIL:", s, true);
        String s3 = b("NOTE:", s, false);
        String as3[] = a("ADR:", s, true);
        String s4 = b("BDAY:", s, true);
        if (s4 != null && !isStringOfDigits(s4, 8))
        {
            s4 = null;
        }
        String s5 = b("URL:", s, true);
        String s6 = b("ORG:", s, true);
        return new AddressBookParsedResult(maybeWrap(s1), s2, as1, null, as2, null, null, s3, as3, null, s6, s4, null, s5);
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }
}
