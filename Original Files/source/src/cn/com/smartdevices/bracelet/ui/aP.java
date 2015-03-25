// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.view.View;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.lua.LuaListAdapter;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainUIActivity, DynamicFragment

class aP
    implements android.animation.Animator.AnimatorListener
{

    final MainUIActivity a;

    aP(MainUIActivity mainuiactivity)
    {
        a = mainuiactivity;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        MainUIActivity.E(a).setBackgroundColor(-1);
        MainUIActivity.e(a).setX(MainUIActivity.F(a));
        MainUIActivity.e(a).setY(MainUIActivity.G(a));
        MainUIActivity.e(a).setVisibility(0);
        MainUIActivity.H(a);
        if (a.a != null)
        {
            a.a.setVPHight();
        }
        Keeper.keepIsPlayEnterAnimation(Boolean.valueOf(false));
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        MainUIActivity.D(a).setTranslationY(800F);
        MainUIActivity.E(a).setBackgroundColor(0xff1898c4);
        MainUIActivity.e(a).setVisibility(8);
        MainUIActivity.l(a).notifyDataSetChanged();
    }
}
