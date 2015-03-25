// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.IntentCompat;

// Referenced classes of package android.support.v4.app:
//            N, M, L

public class NavUtils
{

    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String a = "NavUtils";
    private static final L b;

    private NavUtils()
    {
    }

    public static Intent getParentActivityIntent(Activity activity)
    {
        return b.a(activity);
    }

    public static Intent getParentActivityIntent(Context context, ComponentName componentname)
    {
        String s = getParentActivityName(context, componentname);
        if (s == null)
        {
            return null;
        }
        ComponentName componentname1 = new ComponentName(componentname.getPackageName(), s);
        if (getParentActivityName(context, componentname1) == null)
        {
            return IntentCompat.makeMainActivity(componentname1);
        } else
        {
            return (new Intent()).setComponent(componentname1);
        }
    }

    public static Intent getParentActivityIntent(Context context, Class class1)
    {
        String s = getParentActivityName(context, new ComponentName(context, class1));
        if (s == null)
        {
            return null;
        }
        ComponentName componentname = new ComponentName(context, s);
        if (getParentActivityName(context, componentname) == null)
        {
            return IntentCompat.makeMainActivity(componentname);
        } else
        {
            return (new Intent()).setComponent(componentname);
        }
    }

    public static String getParentActivityName(Activity activity)
    {
        String s;
        try
        {
            s = getParentActivityName(((Context) (activity)), activity.getComponentName());
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            throw new IllegalArgumentException(namenotfoundexception);
        }
        return s;
    }

    public static String getParentActivityName(Context context, ComponentName componentname)
    {
        android.content.pm.ActivityInfo activityinfo = context.getPackageManager().getActivityInfo(componentname, 128);
        return b.a(context, activityinfo);
    }

    public static void navigateUpFromSameTask(Activity activity)
    {
        Intent intent = getParentActivityIntent(activity);
        if (intent == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Activity ").append(activity.getClass().getSimpleName()).append(" does not have a parent activity name specified.").append(" (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> ").append(" element in your manifest?)").toString());
        } else
        {
            navigateUpTo(activity, intent);
            return;
        }
    }

    public static void navigateUpTo(Activity activity, Intent intent)
    {
        b.b(activity, intent);
    }

    public static boolean shouldUpRecreateTask(Activity activity, Intent intent)
    {
        return b.a(activity, intent);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            b = new N();
        } else
        {
            b = new M();
        }
    }
}
