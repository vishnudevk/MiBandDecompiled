// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.aps:
//            y

final class H extends BroadcastReceiver
{

    H(y y1)
    {
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        if (intent.getAction().equals("android.location.GPS_FIX_CHANGE"))
        {
            y.b = false;
        }
        return;
        Exception exception;
        exception;
    }
}
