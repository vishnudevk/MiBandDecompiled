// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SettingFragment

class bR
    implements android.view.animation.Animation.AnimationListener
{

    final SettingFragment a;

    bR(SettingFragment settingfragment)
    {
        a = settingfragment;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        SettingFragment.b(a, false);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        SettingFragment.d(a).setVisibility(0);
        SettingFragment.e(a).setVisibility(8);
        SettingFragment.f(a).setVisibility(8);
        SettingFragment.d(a).setImageResource(0x7f020092);
        SettingFragment.g(a).setMode(0);
        SettingFragment.h(a).setText(0x7f0d009d);
    }
}
