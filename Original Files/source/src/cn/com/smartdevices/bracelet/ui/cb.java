// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;


// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            StatisticFragment, SystemBarTintActivity

class cb
    implements cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimColorListener
{

    final StatisticFragment a;

    cb(StatisticFragment statisticfragment)
    {
        a = statisticfragment;
        super();
    }

    public void onColorChanged(int i)
    {
        android.app.Activity activity = a.getActivity();
        if (activity != null)
        {
            ((SystemBarTintActivity)activity).applyStatusBarTint(i);
        }
    }
}
