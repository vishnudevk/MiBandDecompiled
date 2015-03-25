// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;

// Referenced classes of package android.support.v4.widget:
//            k, j, l

public class EdgeEffectCompat
{

    private static final l b;
    private Object a;

    public EdgeEffectCompat(Context context)
    {
        a = b.a(context);
    }

    public boolean draw(Canvas canvas)
    {
        return b.a(a, canvas);
    }

    public void finish()
    {
        b.b(a);
    }

    public boolean isFinished()
    {
        return b.a(a);
    }

    public boolean onAbsorb(int i)
    {
        return b.a(a, i);
    }

    public boolean onPull(float f)
    {
        return b.a(a, f);
    }

    public boolean onRelease()
    {
        return b.c(a);
    }

    public void setSize(int i, int i1)
    {
        b.a(a, i, i1);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            b = new k();
        } else
        {
            b = new j();
        }
    }
}
