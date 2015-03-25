// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            DynamicDetailFragmentOld, DynamicDetailChartViewOld

class l extends Handler
{

    final DynamicDetailFragmentOld a;

    l(DynamicDetailFragmentOld dynamicdetailfragmentold)
    {
        a = dynamicdetailfragmentold;
        super();
    }

    public void handleMessage(Message message)
    {
        if (DynamicDetailFragmentOld.f(a) == null)
        {
            DynamicDetailFragmentOld.c(a, DynamicDetailFragmentOld.e(a).getToday());
        }
        if (DynamicDetailFragmentOld.b(a) == null)
        {
            DynamicDetailFragmentOld.a(a, DynamicDetailFragmentOld.e(a).getCurDay());
        }
        DynamicDetailFragmentOld.d(a, DynamicDetailFragmentOld.b(a));
        DynamicDetailFragmentOld.e(a, DynamicDetailFragmentOld.e(a).getStartDay());
        DynamicDetailFragmentOld.f(a, DynamicDetailFragmentOld.e(a).getStopDay());
        Debug.i("DDDD", (new StringBuilder()).append("Today : ").append(DynamicDetailFragmentOld.f(a)).append(" , StartDay : ").append(DynamicDetailFragmentOld.a(a)).append(" , StopDay : ").append(DynamicDetailFragmentOld.c(a)).append(" , CurrentDay : ").append(DynamicDetailFragmentOld.h(a)).toString());
        DynamicDetailFragmentOld.g(a).clearData();
        DynamicDetailFragmentOld.g(a).loadDayActiveData(0);
    }
}
