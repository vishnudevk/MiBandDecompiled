// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

// Referenced classes of package android.support.v4.app:
//            M, O

class N extends M
{

    N()
    {
    }

    public Intent a(Activity activity)
    {
        Intent intent = O.a(activity);
        if (intent == null)
        {
            intent = b(activity);
        }
        return intent;
    }

    public String a(Context context, ActivityInfo activityinfo)
    {
        String s = O.a(activityinfo);
        if (s == null)
        {
            s = super.a(context, activityinfo);
        }
        return s;
    }

    public boolean a(Activity activity, Intent intent)
    {
        return O.a(activity, intent);
    }

    Intent b(Activity activity)
    {
        return super.a(activity);
    }

    public void b(Activity activity, Intent intent)
    {
        O.b(activity, intent);
    }
}
