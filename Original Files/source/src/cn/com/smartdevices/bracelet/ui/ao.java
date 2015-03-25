// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.view.animation.Animation;
import cn.com.smartdevices.bracelet.view.RoundProgressBar;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            FwUpgradeActivity

class ao
    implements android.view.animation.Animation.AnimationListener
{

    final FwUpgradeActivity a;

    ao(FwUpgradeActivity fwupgradeactivity)
    {
        a = fwupgradeactivity;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        FwUpgradeActivity.f(a).setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
