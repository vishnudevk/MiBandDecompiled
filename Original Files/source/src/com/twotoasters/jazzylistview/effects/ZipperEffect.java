// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class ZipperEffect
    implements JazzyEffect
{

    public ZipperEffect()
    {
    }

    public void initView(View view, int i, int j)
    {
        byte byte0 = 1;
        byte byte1;
        if (i % 2 == 0)
        {
            byte1 = byte0;
        } else
        {
            byte1 = 0;
        }
        if (byte1 != 0)
        {
            byte0 = -1;
        }
        ViewHelper.setTranslationX(view, byte0 * view.getWidth());
    }

    public void setupAnimation(View view, int i, int j, ViewPropertyAnimator viewpropertyanimator)
    {
        viewpropertyanimator.translationX(0.0F);
    }
}
