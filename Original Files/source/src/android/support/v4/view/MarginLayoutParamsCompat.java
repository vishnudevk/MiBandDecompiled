// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;


// Referenced classes of package android.support.v4.view:
//            y, x, w

public class MarginLayoutParamsCompat
{

    static final w a;

    public MarginLayoutParamsCompat()
    {
    }

    public static int getLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return a.d(marginlayoutparams);
    }

    public static int getMarginEnd(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return a.b(marginlayoutparams);
    }

    public static int getMarginStart(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return a.a(marginlayoutparams);
    }

    public static boolean isMarginRelative(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return a.c(marginlayoutparams);
    }

    public static void resolveLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
    {
        a.d(marginlayoutparams, i);
    }

    public static void setLayoutDirection(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
    {
        a.c(marginlayoutparams, i);
    }

    public static void setMarginEnd(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
    {
        a.b(marginlayoutparams, i);
    }

    public static void setMarginStart(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
    {
        a.a(marginlayoutparams, i);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            a = new y();
        } else
        {
            a = new x();
        }
    }
}
