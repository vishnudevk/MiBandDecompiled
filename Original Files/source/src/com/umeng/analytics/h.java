// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import java.util.Locale;

// Referenced classes of package com.umeng.analytics:
//            Gender

class h extends Gender
{

    h(String s, int i, int j)
    {
        super(s, i, j, null);
    }

    public String toString()
    {
        Locale locale = Locale.US;
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(value);
        return String.format(locale, "Male:%d", aobj);
    }
}
