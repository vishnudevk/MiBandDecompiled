// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

// Referenced classes of package android.support.v4.app:
//            i, h

public class ActivityCompat extends ContextCompat
{

    public ActivityCompat()
    {
    }

    public static void finishAffinity(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            i.a(activity);
            return;
        } else
        {
            activity.finish();
            return;
        }
    }

    public static boolean invalidateOptionsMenu(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            h.a(activity);
            return true;
        } else
        {
            return false;
        }
    }

    public static void startActivity(Activity activity, Intent intent, Bundle bundle)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            i.a(activity, intent, bundle);
            return;
        } else
        {
            activity.startActivity(intent);
            return;
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int j, Bundle bundle)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            i.a(activity, intent, j, bundle);
            return;
        } else
        {
            activity.startActivityForResult(intent, j);
            return;
        }
    }
}
