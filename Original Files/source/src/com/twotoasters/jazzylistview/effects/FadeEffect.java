// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class FadeEffect
    implements JazzyEffect
{

    private static final int a = 5;

    public FadeEffect()
    {
    }

    public void initView(View view, int i, int j)
    {
        ViewHelper.setAlpha(view, 0.0F);
    }

    public void setupAnimation(View view, int i, int j, ViewPropertyAnimator viewpropertyanimator)
    {
        viewpropertyanimator.setDuration(3000L);
        viewpropertyanimator.alpha(255F);
    }
}
