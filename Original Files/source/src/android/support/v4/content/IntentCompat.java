// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

// Referenced classes of package android.support.v4.content:
//            i, h, g, f

public class IntentCompat
{

    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
    public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;
    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;
    private static final f a;

    private IntentCompat()
    {
    }

    public static Intent makeMainActivity(ComponentName componentname)
    {
        return a.a(componentname);
    }

    public static Intent makeMainSelectorActivity(String s, String s1)
    {
        return a.a(s, s1);
    }

    public static Intent makeRestartActivityTask(ComponentName componentname)
    {
        return a.b(componentname);
    }

    static 
    {
        int j = android.os.Build.VERSION.SDK_INT;
        if (j >= 15)
        {
            a = new i();
        } else
        if (j >= 11)
        {
            a = new h();
        } else
        {
            a = new g();
        }
    }
}
