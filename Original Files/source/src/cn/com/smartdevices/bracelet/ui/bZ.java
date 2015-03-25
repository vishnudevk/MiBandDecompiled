// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.graphics.RectF;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            StatisticFragment, cf

class bZ
    implements cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
{

    final StatisticFragment a;

    bZ(StatisticFragment statisticfragment)
    {
        a = statisticfragment;
        super();
    }

    public boolean hasData(int i)
    {
        return StatisticFragment.a(a).b(i);
    }

    public cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData loadData(int i)
    {
        return StatisticFragment.a(a).a(i);
    }

    public void onDataLoaded(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata)
    {
        if (StatisticFragment.b(a) == null || !StatisticFragment.b(a).isAttached())
        {
            Debug.w("Statistic.Main", (new StringBuilder()).append("Chart Already Detached From UI : onDataLoaded , ").append(StatisticFragment.b(a)).toString());
        } else
        {
            if (StatisticFragment.c(a))
            {
                AnimUtil.infoSwitch((ViewGroup)StatisticFragment.d(a), (ViewGroup)StatisticFragment.e(a));
                if (StatisticFragment.f(a))
                {
                    StatisticFragment.a(a, StatisticFragment.a(a, StatisticFragment.b(a), StatisticFragment.g(a), (int)StatisticFragment.g(a).getBarItemWidth(), StatisticFragment.g(a).getWidth(), StatisticFragment.h(a), StatisticFragment.i(a), 450));
                } else
                {
                    StatisticFragment.a(a, StatisticFragment.b(a).getBarItem(StatisticFragment.j(a), StatisticFragment.k(a)));
                    if (StatisticFragment.l(a) != null)
                    {
                        StatisticFragment.a(a, (int)StatisticFragment.l(a).getRect().height());
                        int i = StatisticFragment.l(a).value;
                        int j = ((cn.com.smartdevices.bracelet.chart.StatisticChart.StatisticBarItem)StatisticFragment.l(a)).value1;
                        StatisticFragment.b(a, (int)((float)StatisticFragment.h(a) * ((float)j / (float)i)));
                    } else
                    {
                        StatisticFragment.a(a, 0);
                        StatisticFragment.b(a, 0);
                    }
                    Debug.i("Statistic.Main", (new StringBuilder()).append("BarItem Height : ").append(StatisticFragment.h(a)).toString());
                    StatisticFragment.a(a, StatisticFragment.b(a, StatisticFragment.b(a), StatisticFragment.g(a), StatisticFragment.b(a).getWidth(), (int)StatisticFragment.b(a).getBarItemWidth(), StatisticFragment.h(a), StatisticFragment.i(a), 450));
                }
                StatisticFragment.m(a).start();
                return;
            }
            if (StatisticFragment.n(a))
            {
                StatisticFragment.a(a, false);
                AnimUtil.infoSwitch((ViewGroup)StatisticFragment.d(a), (ViewGroup)StatisticFragment.e(a));
                Animator animator = StatisticFragment.b(a).animRefresh();
                if (!animator.isStarted())
                {
                    animator.setDuration(500L);
                    animator.start();
                    return;
                }
            }
        }
    }

    public void onToItem(int i)
    {
        if (StatisticFragment.b(a) == null || !StatisticFragment.b(a).isAttached())
        {
            Debug.w("Statistic.Main", (new StringBuilder()).append("Chart Already Detached From UI : onToItem , ").append(StatisticFragment.b(a)).toString());
            return;
        } else
        {
            StatisticFragment.a(a).c(i);
            return;
        }
    }
}
