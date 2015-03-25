// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            DynamicView

class l
    implements android.animation.Animator.AnimatorListener
{

    final DynamicView a;

    l(DynamicView dynamicview)
    {
        a = dynamicview;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        DynamicView.f(a);
        DynamicView.g(a);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        DynamicView.e(a).setRotationY(-90F);
        DynamicView.e(a).setTranslationY(300F);
        DynamicView.e(a).setAlpha(0.0F);
        DynamicView.b(a).setAlpha(0.0F);
    }
}
