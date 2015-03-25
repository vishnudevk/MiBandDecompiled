// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.text.TextUtils;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.weather.WeatherInfo;
import cn.com.smartdevices.bracelet.weather.WeatherListener;
import cn.com.smartdevices.bracelet.weather.WeatherManager;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainUIActivity

class aF
    implements WeatherListener
{

    final MainUIActivity a;

    aF(MainUIActivity mainuiactivity)
    {
        a = mainuiactivity;
        super();
    }

    public void onReceiveWeather(WeatherInfo weatherinfo)
    {
        String s = "";
        if (!TextUtils.isEmpty(weatherinfo.getWeatherDescription()))
        {
            s = (new StringBuilder()).append(s).append(weatherinfo.getWeatherDescription()).toString();
        }
        if (!TextUtils.isEmpty(weatherinfo.getAqiDescription()))
        {
            StringBuilder stringbuilder = (new StringBuilder()).append(s).append(" ");
            MainUIActivity mainuiactivity = a;
            Object aobj[] = new Object[1];
            aobj[0] = weatherinfo.getAqiDescription();
            s = stringbuilder.append(mainuiactivity.getString(0x7f0d01e3, aobj)).toString();
        }
        if (!TextUtils.isEmpty(s))
        {
            UmengAnalytics.event(MainUIActivity.a(a).getContext(), "WeatherOK");
        }
        MainUIActivity.b(a).setText(s);
    }
}
