// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package u.aly:
//            k, bj, u, af, 
//            aw, y, z, bi, 
//            bv

public class v
{

    private static final String a = "session_start_time";
    private static final String b = "session_end_time";
    private static final String c = "session_id";
    private static final String f = "activities";
    private final String d = "a_start_time";
    private final String e = "a_end_time";

    public v()
    {
    }

    private String a(Context context, SharedPreferences sharedpreferences)
    {
        k k1 = k.a(context);
        String s = b(context);
        af af1 = a(context);
        android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("session_id", s);
        editor.putLong("session_start_time", System.currentTimeMillis());
        editor.putLong("session_end_time", 0L);
        editor.commit();
        if (af1 != null)
        {
            k1.a(af1);
            return s;
        } else
        {
            k1.a(null);
            return s;
        }
    }

    private void a(SharedPreferences sharedpreferences)
    {
        android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.remove("session_start_time");
        editor.remove("session_end_time");
        editor.remove("session_id");
        editor.remove("a_start_time");
        editor.remove("a_end_time");
        editor.putString("activities", "");
        editor.commit();
    }

    private boolean b(SharedPreferences sharedpreferences)
    {
        long l = sharedpreferences.getLong("a_start_time", 0L);
        long l1 = sharedpreferences.getLong("a_end_time", 0L);
        long l2 = System.currentTimeMillis();
        if (l != 0L && l2 - l < AnalyticsConfig.kContinueSessionMillis)
        {
            bj.b("MobclickAgent", "onResume called before onPause");
        } else
        if (l2 - l1 > AnalyticsConfig.kContinueSessionMillis)
        {
            return true;
        }
        return false;
    }

    public af a(Context context)
    {
        SharedPreferences sharedpreferences = u.a(context);
        String s = sharedpreferences.getString("session_id", null);
        if (s == null)
        {
            return null;
        }
        long l = sharedpreferences.getLong("session_start_time", 0L);
        long l1 = sharedpreferences.getLong("session_end_time", 0L);
        long l2 = 0L;
        if (l1 != 0L)
        {
            l2 = l1 - l;
            if (Math.abs(l2) > 0x5265c00L)
            {
                l2 = 0L;
            }
        }
        af af1 = new af();
        af1.a(s);
        af1.a(l);
        af1.b(l1);
        af1.c(l2);
        double ad[] = AnalyticsConfig.getLocation();
        if (ad != null)
        {
            aw aw1 = new aw(ad[0], ad[1], System.currentTimeMillis());
            be be;
            List list;
            if (af1.y())
            {
                af1.a(aw1);
            } else
            {
                af1.b(Arrays.asList(new aw[] {
                    aw1
                }));
            }
        }
        be = y.a(context);
        if (be != null)
        {
            af1.a(be);
        }
        list = z.a(sharedpreferences);
        if (list != null && list.size() > 0)
        {
            af1.a(list);
        }
        a(sharedpreferences);
        return af1;
    }

    public String b(Context context)
    {
        String s = bi.f(context);
        String s1 = AnalyticsConfig.getAppkey(context);
        long l = System.currentTimeMillis();
        if (s1 == null)
        {
            throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(l).append(s1).append(s);
            return bv.a(stringbuilder.toString());
        }
    }

    public void c(Context context)
    {
        SharedPreferences sharedpreferences = u.a(context);
        if (sharedpreferences == null)
        {
            return;
        }
        android.content.SharedPreferences.Editor editor;
        if (b(sharedpreferences))
        {
            String s1 = a(context, sharedpreferences);
            bj.a("MobclickAgent", (new StringBuilder("Start new session: ")).append(s1).toString());
        } else
        {
            String s = sharedpreferences.getString("session_id", null);
            bj.a("MobclickAgent", (new StringBuilder("Extend current session: ")).append(s).toString());
        }
        editor = sharedpreferences.edit();
        editor.putLong("a_start_time", System.currentTimeMillis());
        editor.putLong("a_end_time", 0L);
        editor.commit();
    }

    public void d(Context context)
    {
        SharedPreferences sharedpreferences = u.a(context);
        if (sharedpreferences == null)
        {
            return;
        }
        if (sharedpreferences.getLong("a_start_time", 0L) == 0L && AnalyticsConfig.ACTIVITY_DURATION_OPEN)
        {
            bj.b("MobclickAgent", "onPause called before onResume");
            return;
        } else
        {
            long l = System.currentTimeMillis();
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putLong("a_start_time", 0L);
            editor.putLong("a_end_time", l);
            editor.putLong("session_end_time", l);
            editor.commit();
            return;
        }
    }
}
