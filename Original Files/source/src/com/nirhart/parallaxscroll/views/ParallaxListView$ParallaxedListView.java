// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nirhart.parallaxscroll.views;

import android.view.View;
import android.view.animation.TranslateAnimation;

// Referenced classes of package com.nirhart.parallaxscroll.views:
//            ParallaxedView, ParallaxListView

public class a extends ParallaxedView
{

    final ParallaxListView a;

    protected void translatePreICS(View view, float f)
    {
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, f, f);
        translateanimation.setDuration(0L);
        translateanimation.setFillAfter(true);
        view.setAnimation(translateanimation);
        translateanimation.start();
    }

    public (ParallaxListView parallaxlistview, View view)
    {
        a = parallaxlistview;
        super(view);
    }
}
