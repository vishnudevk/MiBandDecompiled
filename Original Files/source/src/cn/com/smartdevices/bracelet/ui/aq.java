// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.view.animation.Animation;
import android.widget.TextView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            FwUpgradeActivity

class aq
    implements android.view.animation.Animation.AnimationListener
{

    final FwUpgradeActivity a;

    aq(FwUpgradeActivity fwupgradeactivity)
    {
        a = fwupgradeactivity;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        FwUpgradeActivity.h(a).setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
