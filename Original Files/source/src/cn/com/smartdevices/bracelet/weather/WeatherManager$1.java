// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.location.Location;

// Referenced classes of package cn.com.smartdevices.bracelet.weather:
//            WeatherManager

class this._cls0 extends BroadcastReceiver
{

    final WeatherManager this$0;

    public void onReceive(Context context, Intent intent)
    {
        Location location = (Location)intent.getParcelableExtra("Location");
        Debug.i("WeatherManager", (new StringBuilder()).append("Broadcast Receive Location : ").append(location).toString());
        if (location == null)
        {
            return;
        } else
        {
            UmengAnalytics.event(WeatherManager.access$000(WeatherManager.this), "WeatherStart");
            WeatherManager.access$100(WeatherManager.this, location);
            return;
        }
    }

    ()
    {
        this$0 = WeatherManager.this;
        super();
    }
}
