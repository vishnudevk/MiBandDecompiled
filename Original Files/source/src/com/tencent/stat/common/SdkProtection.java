// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.common;

import android.content.Context;

// Referenced classes of package com.tencent.stat.common:
//            StatPreferences

public class SdkProtection
{

    static long a = -1L;

    static long a(Context context, String s)
    {
        return StatPreferences.getLong(context, s, a);
    }

    static void a(Context context, String s, long l)
    {
        StatPreferences.putLong(context, s, l);
    }

    public static boolean beginCheck(Context context)
    {
        long l = a(context, "1.0.0_begin_protection");
        long l1 = a(context, "1.0.0_end__protection");
        if (l > 0L && l1 == a)
        {
            return false;
        }
        if (l == a)
        {
            a(context, "1.0.0_begin_protection", System.currentTimeMillis());
        }
        return true;
    }

    public static void endCheck(Context context)
    {
        if (a(context, "1.0.0_end__protection") == a)
        {
            a(context, "1.0.0_end__protection", System.currentTimeMillis());
        }
    }

}
