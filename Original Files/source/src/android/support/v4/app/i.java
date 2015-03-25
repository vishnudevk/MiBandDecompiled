// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class i
{

    i()
    {
    }

    public static void a(Activity activity)
    {
        activity.finishAffinity();
    }

    public static void a(Activity activity, Intent intent, int j, Bundle bundle)
    {
        activity.startActivityForResult(intent, j, bundle);
    }

    public static void a(Context context, Intent intent, Bundle bundle)
    {
        context.startActivity(intent, bundle);
    }
}
