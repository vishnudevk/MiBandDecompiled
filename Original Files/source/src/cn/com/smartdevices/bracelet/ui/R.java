// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.DynamicDetailChartView;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DynamicDetailFragment

class R extends Handler
{

    final DynamicDetailFragment a;

    R(DynamicDetailFragment dynamicdetailfragment)
    {
        a = dynamicdetailfragment;
        super();
    }

    public void handleMessage(Message message)
    {
        DynamicDetailFragment.a(a, DynamicDetailFragment.a(a).getToday());
        DynamicDetailFragment.b(a, DynamicDetailFragment.a(a).getCurDay());
        DynamicDetailFragment.c(a, DynamicDetailFragment.b(a));
        DynamicDetailFragment.d(a, DynamicDetailFragment.a(a).getStartDay());
        DynamicDetailFragment.e(a, DynamicDetailFragment.a(a).getStopDay());
        Debug.i("Dynamic.Detail", (new StringBuilder()).append("Today : ").append(DynamicDetailFragment.c(a)).append(" , StartDay : ").append(DynamicDetailFragment.d(a)).append(" , StopDay : ").append(DynamicDetailFragment.e(a)).append(" , CurrentDay : ").append(DynamicDetailFragment.f(a)).toString());
        DynamicDetailFragment.g(a).getDataLoader().cancel();
        DynamicDetailFragment.g(a).clearData();
        if (DynamicDetailFragment.h(a) == 16)
        {
            DynamicDetailFragment.g(a).loadDynamicData(0, new int[] {
                -1
            });
        } else
        if (DynamicDetailFragment.h(a) == 1)
        {
            DynamicDetailFragment.g(a).loadDynamicData(0);
            return;
        }
    }
}
