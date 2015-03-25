// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

class aj
{

    aj()
    {
    }

    public static PendingIntent a(Context context, int i, Intent aintent[], int j)
    {
        return PendingIntent.getActivities(context, i, aintent, j);
    }
}
