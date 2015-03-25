// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import u.aly.s;
import u.aly.u;

// Referenced classes of package com.umeng.analytics.game:
//            c

public class b
{

    public String a;
    public String b;
    private Context c;
    private final String d = "um_g_cache";
    private final String e = "single_level";
    private final String f = "stat_player_level";
    private final String g = "stat_game_level";
    private c h;

    public b(Context context)
    {
        h = null;
        c = context;
    }

    public c a(String s1)
    {
        h = new c(s1);
        h.a();
        return h;
    }

    public void a()
    {
        if (h != null)
        {
            h.b();
            android.content.SharedPreferences.Editor editor = c.getSharedPreferences("um_g_cache", 0).edit();
            editor.putString("single_level", s.a(h));
            editor.putString("stat_player_level", b);
            editor.putString("stat_game_level", a);
            editor.commit();
        }
    }

    public c b(String s1)
    {
        if (h != null)
        {
            h.d();
            if (h.a(s1))
            {
                c c1 = h;
                h = null;
                return c1;
            }
        }
        return null;
    }

    public void b()
    {
        SharedPreferences sharedpreferences = u.a(c, "um_g_cache");
        String s1 = sharedpreferences.getString("single_level", null);
        if (s1 != null)
        {
            h = (c)s.a(s1);
            if (h != null)
            {
                h.c();
            }
        }
        if (b == null)
        {
            b = sharedpreferences.getString("stat_player_level", null);
        }
        if (a == null)
        {
            a = sharedpreferences.getString("stat_game_level", null);
        }
    }
}
