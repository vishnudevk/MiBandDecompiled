// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;


class z
{

    z()
    {
    }

    public static int a(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return marginlayoutparams.getMarginStart();
    }

    public static void a(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
    {
        marginlayoutparams.setMarginStart(i);
    }

    public static int b(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return marginlayoutparams.getMarginEnd();
    }

    public static void b(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
    {
        marginlayoutparams.setMarginEnd(i);
    }

    public static void c(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
    {
        marginlayoutparams.setLayoutDirection(i);
    }

    public static boolean c(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return marginlayoutparams.isMarginRelative();
    }

    public static int d(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return marginlayoutparams.getLayoutDirection();
    }

    public static void d(android.view.ViewGroup.MarginLayoutParams marginlayoutparams, int i)
    {
        marginlayoutparams.resolveLayoutDirection(i);
    }
}
