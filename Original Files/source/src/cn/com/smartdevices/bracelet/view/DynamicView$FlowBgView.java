// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            n

public class a extends View
{

    private Paint a;
    private float b;
    private float c;
    private float d;
    private float e;

    static float a(a a1)
    {
        return a1.b;
    }

    static float a(b b1, float f)
    {
        b1.e = f;
        return f;
    }

    public Animator animFlow()
    {
        return AnimUtil.animFlow(new n(this));
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawCircle(c, d, e, a);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        int i1 = k - i;
        int j1 = l - j;
        b = j1;
        e = b;
        c = (float)i1 / 2.0F;
        d = 0.4203719F * (float)j1;
    }

    public (Context context)
    {
        this(context, null, 0);
    }

    public <init>(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public <init>(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = new Paint();
        a.setColor(0xff2980b9);
    }
}
