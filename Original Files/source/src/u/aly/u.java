// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.SharedPreferences;

public class u
{

    private static final String a = "umeng_general_config";

    private u()
    {
    }

    public static SharedPreferences a(Context context)
    {
        return context.getSharedPreferences("umeng_general_config", 0);
    }

    public static SharedPreferences a(Context context, String s)
    {
        return context.getSharedPreferences(s, 0);
    }
}
