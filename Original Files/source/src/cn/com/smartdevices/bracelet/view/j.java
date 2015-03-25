// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import cn.com.smartdevices.bracelet.chart.DynamicPieChartView;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            DynamicView

class j
    implements android.animation.Animator.AnimatorListener
{

    final DynamicView a;

    j(DynamicView dynamicview)
    {
        a = dynamicview;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        DynamicView.d(a).setRotationY(0.0F);
    }
}
