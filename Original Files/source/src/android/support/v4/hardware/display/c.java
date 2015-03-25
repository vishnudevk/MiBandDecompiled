// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;

final class c
{

    c()
    {
    }

    public static Display a(Object obj, int i)
    {
        return ((DisplayManager)obj).getDisplay(i);
    }

    public static Object a(Context context)
    {
        return context.getSystemService("display");
    }

    public static Display[] a(Object obj)
    {
        return ((DisplayManager)obj).getDisplays();
    }

    public static Display[] a(Object obj, String s)
    {
        return ((DisplayManager)obj).getDisplays(s);
    }
}
