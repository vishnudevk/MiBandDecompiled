// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package android.support.v4.app:
//            af

class ag
    implements af
{

    ag()
    {
    }

    public PendingIntent a(Context context, Intent aintent[], int i, int j, Bundle bundle)
    {
        Intent intent = new Intent(aintent[-1 + aintent.length]);
        intent.addFlags(0x10000000);
        return PendingIntent.getActivity(context, i, intent, j);
    }
}
