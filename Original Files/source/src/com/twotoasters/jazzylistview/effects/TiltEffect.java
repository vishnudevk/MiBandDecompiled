// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class TiltEffect
    implements JazzyEffect
{

    private static final float a = 0.7F;

    public TiltEffect()
    {
    }

    public void initView(View view, int i, int j)
    {
        ViewHelper.setPivotX(view, view.getWidth() / 2);
        ViewHelper.setPivotY(view, view.getHeight() / 2);
        ViewHelper.setScaleX(view, 0.7F);
        ViewHelper.setScaleY(view, 0.7F);
        ViewHelper.setTranslationY(view, j * (view.getHeight() / 2));
        ViewHelper.setAlpha(view, 127F);
    }

    public void setupAnimation(View view, int i, int j, ViewPropertyAnimator viewpropertyanimator)
    {
        viewpropertyanimator.translationYBy(j * (-view.getHeight() / 2)).scaleX(1.0F).scaleY(1.0F).alpha(255F);
    }
}
