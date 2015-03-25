// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.view.View;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DynamicDetailFragment

class Y
    implements android.animation.Animator.AnimatorListener
{

    final View a;
    final DynamicDetailFragment b;
    private boolean c;

    Y(DynamicDetailFragment dynamicdetailfragment, View view)
    {
        b = dynamicdetailfragment;
        a = view;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
        Debug.i("Dynamic.Detail", "Dismiss Anim Canceled!!");
        c = true;
    }

    public void onAnimationEnd(Animator animator)
    {
        if (!c)
        {
            Debug.i("Dynamic.Detail", "Dismiss Anim Ended!!");
            a.setVisibility(4);
            DynamicDetailFragment.a(b, false);
            if (b.getActivity() != null && DynamicDetailFragment.h(b) == 1)
            {
                DynamicDetailFragment.c(b, 0x7f0d0072);
            }
        }
        DynamicDetailFragment.b(b, null);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
