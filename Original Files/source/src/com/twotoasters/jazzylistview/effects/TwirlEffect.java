// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class TwirlEffect
    implements JazzyEffect
{

    private static final int a = 80;
    private static final int b = 70;
    private static final int c = 10;

    public TwirlEffect()
    {
    }

    public void initView(View view, int i, int j)
    {
        ViewHelper.setPivotX(view, view.getWidth() / 2);
        ViewHelper.setPivotY(view, view.getWidth() / 2);
        ViewHelper.setRotationX(view, 80F);
        ViewHelper.setRotationY(view, j * 70);
        ViewHelper.setRotation(view, 10F);
    }

    public void setupAnimation(View view, int i, int j, ViewPropertyAnimator viewpropertyanimator)
    {
        viewpropertyanimator.rotationXBy(-80F).rotationYBy(j * -70).rotationBy(-10F);
    }
}
