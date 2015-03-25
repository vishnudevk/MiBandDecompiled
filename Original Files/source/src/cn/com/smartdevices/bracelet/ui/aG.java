// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Utils;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainUIActivity

class aG
    implements android.animation.Animator.AnimatorListener
{

    final MainUIActivity a;

    aG(MainUIActivity mainuiactivity)
    {
        a = mainuiactivity;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
        MainUIActivity.a(a, Boolean.valueOf(false));
    }

    public void onAnimationEnd(Animator animator)
    {
        MainUIActivity.h(a).setScaleX(1.0F);
        MainUIActivity.h(a).setScaleY(1.0F);
        MainUIActivity.i(a).setScaleX(1.0F);
        MainUIActivity.i(a).setScaleY(1.0F);
        MainUIActivity.h(a).setAlpha(1.0F);
        MainUIActivity.i(a).setAlpha(1.0F);
        MainUIActivity.j(a).setRotation(180F);
        MainUIActivity.a(a, Boolean.valueOf(false));
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        MainUIActivity.e(a).setScaleX(1.0F);
        MainUIActivity.e(a).setScaleY(1.0F);
        MainUIActivity.e(a).setAlpha(1.0F);
        MainUIActivity.h(a).setScaleX(0.5F);
        MainUIActivity.h(a).setScaleY(0.5F);
        MainUIActivity.i(a).setScaleX(0.5F);
        MainUIActivity.i(a).setScaleY(0.5F);
        MainUIActivity.h(a).setAlpha(0.5F);
        MainUIActivity.i(a).setAlpha(0.5F);
        MainUIActivity.j(a).setRotation(0.0F);
        MainUIActivity.h(a).setText(0x7f0d0079);
        MainUIActivity.i(a).setText(Utils.getSyncTime(a, 0x7f0d0076));
        MainUIActivity.a(a, Boolean.valueOf(true));
    }
}
