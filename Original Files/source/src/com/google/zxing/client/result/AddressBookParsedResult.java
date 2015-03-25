// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;


// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class AddressBookParsedResult extends ParsedResult
{

    private final String a[];
    private final String b;
    private final String c[];
    private final String d[];
    private final String e[];
    private final String f[];
    private final String g;
    private final String h;
    private final String i[];
    private final String j[];
    private final String k;
    private final String l;
    private final String m;
    private final String n;

    public AddressBookParsedResult(String as[], String s, String as1[], String as2[], String as3[], String as4[], String s1, 
            String s2, String as5[], String as6[], String s3, String s4, String s5, String s6)
    {
        super(ParsedResultType.ADDRESSBOOK);
        a = as;
        b = s;
        c = as1;
        d = as2;
        e = as3;
        f = as4;
        g = s1;
        h = s2;
        i = as5;
        j = as6;
        k = s3;
        l = s4;
        m = s5;
        n = s6;
    }

    public String[] getAddressTypes()
    {
        return j;
    }

    public String[] getAddresses()
    {
        return i;
    }

    public String getBirthday()
    {
        return l;
    }

    public String getDisplayResult()
    {
        StringBuilder stringbuilder = new StringBuilder(100);
        maybeAppend(a, stringbuilder);
        maybeAppend(b, stringbuilder);
        maybeAppend(m, stringbuilder);
        maybeAppend(k, stringbuilder);
        maybeAppend(i, stringbuilder);
        maybeAppend(c, stringbuilder);
        maybeAppend(e, stringbuilder);
        maybeAppend(g, stringbuilder);
        maybeAppend(n, stringbuilder);
        maybeAppend(l, stringbuilder);
        maybeAppend(h, stringbuilder);
        return stringbuilder.toString();
    }

    public String[] getEmailTypes()
    {
        return f;
    }

    public String[] getEmails()
    {
        return e;
    }

    public String getInstantMessenger()
    {
        return g;
    }

    public String[] getNames()
    {
        return a;
    }

    public String getNote()
    {
        return h;
    }

    public String getOrg()
    {
        return k;
    }

    public String[] getPhoneNumbers()
    {
        return c;
    }

    public String[] getPhoneTypes()
    {
        return d;
    }

    public String getPronunciation()
    {
        return b;
    }

    public String getTitle()
    {
        return m;
    }

    public String getURL()
    {
        return n;
    }
}
