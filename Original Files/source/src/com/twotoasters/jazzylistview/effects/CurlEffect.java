// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class CurlEffect
    implements JazzyEffect
{

    private static final int a = 90;

    public CurlEffect()
    {
    }

    public void initView(View view, int i, int j)
    {
        ViewHelper.setPivotX(view, 0.0F);
        ViewHelper.setPivotY(view, view.getHeight() / 2);
        ViewHelper.setRotationY(view, 90F);
    }

    public void setupAnimation(View view, int i, int j, ViewPropertyAnimator viewpropertyanimator)
    {
        viewpropertyanimator.rotationYBy(-90F);
    }
}
