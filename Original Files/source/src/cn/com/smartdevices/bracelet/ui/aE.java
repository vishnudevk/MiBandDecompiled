// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.view.animation.Animation;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainMenuFragment

class aE
    implements android.view.animation.Animation.AnimationListener
{

    final MainMenuFragment a;

    aE(MainMenuFragment mainmenufragment)
    {
        a = mainmenufragment;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        a.dismiss();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
