// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;

// Referenced classes of package android.support.v4.media:
//            d, c

class g extends BroadcastReceiver
{

    final d a;

    g(d d1)
    {
        a = d1;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            KeyEvent keyevent = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            a.d.a(keyevent);
            return;
        }
        catch (ClassCastException classcastexception)
        {
            Log.w("TransportController", classcastexception);
        }
    }
}
