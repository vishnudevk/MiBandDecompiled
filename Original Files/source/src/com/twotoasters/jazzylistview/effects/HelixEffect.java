// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class HelixEffect
    implements JazzyEffect
{

    private static final int a = 180;

    public HelixEffect()
    {
    }

    public void initView(View view, int i, int j)
    {
        ViewHelper.setRotationY(view, 180F);
    }

    public void setupAnimation(View view, int i, int j, ViewPropertyAnimator viewpropertyanimator)
    {
        viewpropertyanimator.rotationYBy(j * 180);
    }
}
