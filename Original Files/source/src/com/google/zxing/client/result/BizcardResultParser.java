// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.zxing.client.result:
//            a, AddressBookParsedResult, ParsedResult

public final class BizcardResultParser extends a
{

    public BizcardResultParser()
    {
    }

    private static String a(String s, String s1)
    {
        if (s == null)
        {
            return s1;
        }
        if (s1 != null)
        {
            s = (new StringBuilder()).append(s).append(' ').append(s1).toString();
        }
        return s;
    }

    private static String[] a(String s, String s1, String s2)
    {
        ArrayList arraylist = new ArrayList(3);
        if (s != null)
        {
            arraylist.add(s);
        }
        if (s1 != null)
        {
            arraylist.add(s1);
        }
        if (s2 != null)
        {
            arraylist.add(s2);
        }
        int i = arraylist.size();
        if (i == 0)
        {
            return null;
        } else
        {
            return (String[])arraylist.toArray(new String[i]);
        }
    }

    public AddressBookParsedResult parse(Result result)
    {
        String s = result.getText();
        if (!s.startsWith("BIZCARD:"))
        {
            return null;
        } else
        {
            String s1 = a(b("N:", s, true), b("X:", s, true));
            String s2 = b("T:", s, true);
            String s3 = b("C:", s, true);
            String as[] = a("A:", s, true);
            String s4 = b("B:", s, true);
            String s5 = b("M:", s, true);
            String s6 = b("F:", s, true);
            String s7 = b("E:", s, true);
            return new AddressBookParsedResult(maybeWrap(s1), null, a(s4, s5, s6), null, maybeWrap(s7), null, null, null, as, null, s3, null, s2, null);
        }
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }
}
