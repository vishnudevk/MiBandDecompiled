// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.amap.api.location:
//            b, AMapLocalWeatherLive, AMapLocalWeatherListener, AMapLocalWeatherForecast, 
//            l, AMapLocation

class k extends Handler
{

    private WeakReference a;

    k(b b1)
    {
        try
        {
            a = new WeakReference(b1);
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void handleMessage(Message message)
    {
        b b1;
        super.handleMessage(message);
        b1 = (b)a.get();
        message.what;
        JVM INSTR tableswitch 1 3: default 129
    //                   1 48
    //                   2 78
    //                   3 102;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        Throwable throwable;
        if (b1.b != null)
        {
            b1.b.onWeatherLiveSearched((AMapLocalWeatherLive)message.obj);
            return;
        }
        break; /* Loop/switch isn't completed */
_L3:
        try
        {
            if (b1.b != null)
            {
                b1.b.onWeatherForecaseSearched((AMapLocalWeatherForecast)message.obj);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        (new l(this, b1, (AMapLocation)message.obj)).start();
        return;
        Throwable throwable1;
        throwable1;
        throwable1.printStackTrace();
    }
}
