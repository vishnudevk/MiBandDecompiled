// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

// Referenced classes of package android.support.v4.app:
//            ab, aa, Z, Y

public class ShareCompat
{

    public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static Y a;

    public ShareCompat()
    {
    }

    static Y a()
    {
        return a;
    }

    public static void configureMenuItem(Menu menu, int i, IntentBuilder intentbuilder)
    {
        MenuItem menuitem = menu.findItem(i);
        if (menuitem == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Could not find menu item with id ").append(i).append(" in the supplied menu").toString());
        } else
        {
            configureMenuItem(menuitem, intentbuilder);
            return;
        }
    }

    public static void configureMenuItem(MenuItem menuitem, IntentBuilder intentbuilder)
    {
        a.a(menuitem, intentbuilder);
    }

    public static ComponentName getCallingActivity(Activity activity)
    {
        ComponentName componentname = activity.getCallingActivity();
        if (componentname == null)
        {
            componentname = (ComponentName)activity.getIntent().getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY");
        }
        return componentname;
    }

    public static String getCallingPackage(Activity activity)
    {
        String s = activity.getCallingPackage();
        if (s == null)
        {
            s = activity.getIntent().getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE");
        }
        return s;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new ab();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new aa();
        } else
        {
            a = new Z();
        }
    }
}
