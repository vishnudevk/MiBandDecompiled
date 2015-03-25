// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package android.support.v4.app:
//            af, ak

class ai
    implements af
{

    ai()
    {
    }

    public PendingIntent a(Context context, Intent aintent[], int i, int j, Bundle bundle)
    {
        aintent[0] = (new Intent(aintent[0])).addFlags(0x1000c000);
        return ak.a(context, i, aintent, j, bundle);
    }
}
