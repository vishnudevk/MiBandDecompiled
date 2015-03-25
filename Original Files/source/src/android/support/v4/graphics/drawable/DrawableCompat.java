// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v4.graphics.drawable:
//            c, a, b

public class DrawableCompat
{

    static final b a;

    public DrawableCompat()
    {
    }

    public static void jumpToCurrentState(Drawable drawable)
    {
        a.a(drawable);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new c();
        } else
        {
            a = new a();
        }
    }
}
