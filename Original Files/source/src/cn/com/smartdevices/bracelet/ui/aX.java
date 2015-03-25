// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.view.View;
import android.widget.ProgressBar;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainUIActivity

class aX
    implements android.animation.Animator.AnimatorListener
{

    final MainUIActivity a;

    aX(MainUIActivity mainuiactivity)
    {
        a = mainuiactivity;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        MainUIActivity.f(a).smoothSlideTo(1.0F, 0);
        MainUIActivity.g(a).setVisibility(8);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        MainUIActivity.e(a).setScaleX(1.0F);
        MainUIActivity.e(a).setScaleY(1.0F);
        MainUIActivity.e(a).setAlpha(1.0F);
        MainUIActivity.e(a).setVisibility(0);
    }
}
