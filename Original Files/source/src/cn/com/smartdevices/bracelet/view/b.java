// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            DynamicView

class b
    implements android.animation.Animator.AnimatorListener
{

    final DynamicView a;

    b(DynamicView dynamicview)
    {
        a = dynamicview;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        DynamicView.h(a).setAlpha(0.0F);
        DynamicView.i(a).setAlpha(0.0F);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        DynamicView.h(a).setVisibility(0);
        DynamicView.i(a).setVisibility(0);
        DynamicView.e(a).setRotationY(-90F);
        DynamicView.e(a).setTranslationY(300F);
        DynamicView.e(a).setAlpha(0.0F);
        DynamicView.b(a).setAlpha(0.0F);
        DynamicView.h(a).setAlpha(1.0F);
        DynamicView.h(a).setTranslationX(0.0F);
        DynamicView.h(a).setTranslationY(0.0F);
        DynamicView.h(a).setScaleX(1.0F);
        DynamicView.h(a).setScaleY(1.0F);
        DynamicView.i(a).setAlpha(1.0F);
        DynamicView.i(a).setTranslationX(0.0F);
        DynamicView.i(a).setTranslationY(0.0F);
        DynamicView.i(a).setScaleX(1.0F);
        DynamicView.i(a).setScaleY(1.0F);
        ((View)DynamicView.c(a)).setAlpha(0.0F);
        DynamicView.j(a);
    }
}
