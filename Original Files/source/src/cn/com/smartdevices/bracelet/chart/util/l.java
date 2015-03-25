// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;

final class l
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final int a;
    final int b;
    final int c;
    final int d;
    final int e;
    final int f;
    final View g[];
    final AnimUtil.AnimColorListener h;

    l(int i, int j, int k, int i1, int j1, int k1, View aview[], 
            AnimUtil.AnimColorListener animcolorlistener)
    {
        a = i;
        b = j;
        c = k;
        d = i1;
        e = j1;
        f = k1;
        g = aview;
        h = animcolorlistener;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f1 = ((Float)valueanimator.getAnimatedValue()).floatValue();
        int i = Color.rgb((int)(f1 * (float)a + (float)b * (1.0F - f1)), (int)(f1 * (float)c + (float)d * (1.0F - f1)), (int)(f1 * (float)e + (float)f * (1.0F - f1)));
        View aview[] = g;
        int j = aview.length;
        for (int k = 0; k < j; k++)
        {
            aview[k].setBackgroundColor(i);
        }

        if (h != null)
        {
            h.onColorChanged(i);
        }
    }
}
