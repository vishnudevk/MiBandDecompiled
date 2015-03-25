// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.view;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.xiaomi.hm.view:
//            GifView

class b extends Handler
{

    final GifView a;

    b(GifView gifview)
    {
        a = gifview;
        super();
    }

    public void handleMessage(Message message)
    {
        try
        {
            GifView.a(a);
            return;
        }
        catch (Exception exception)
        {
            Log.e("GifView", exception.toString());
        }
    }
}
