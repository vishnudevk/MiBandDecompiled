// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.lua.LuaListAdapter;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainUIActivity

class aI
    implements android.animation.Animator.AnimatorListener
{

    final float a;
    final MainUIActivity b;

    aI(MainUIActivity mainuiactivity, float f)
    {
        b = mainuiactivity;
        a = f;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        MainUIActivity.k(b).setVisibility(8);
        MainUIActivity.b(b, Boolean.valueOf(false));
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        MainUIActivity.k(b).setVisibility(0);
        MainUIActivity.k(b).setTranslationY(-a);
        MainUIActivity.b(b, Boolean.valueOf(true));
        MainUIActivity.l(b).setFlagsToFalse();
    }
}
