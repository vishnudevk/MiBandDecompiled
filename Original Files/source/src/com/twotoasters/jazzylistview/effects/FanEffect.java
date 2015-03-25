// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class FanEffect
    implements JazzyEffect
{

    private static final int a = 70;

    public FanEffect()
    {
    }

    public void initView(View view, int i, int j)
    {
        ViewHelper.setPivotX(view, 0.0F);
        ViewHelper.setPivotY(view, 0.0F);
        ViewHelper.setRotation(view, j * 70);
    }

    public void setupAnimation(View view, int i, int j, ViewPropertyAnimator viewpropertyanimator)
    {
        viewpropertyanimator.rotationBy(j * -70);
    }
}
