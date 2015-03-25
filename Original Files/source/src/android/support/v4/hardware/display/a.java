// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;

// Referenced classes of package android.support.v4.hardware.display:
//            DisplayManagerCompat, c

class a extends DisplayManagerCompat
{

    private final Object a;

    public a(Context context)
    {
        a = c.a(context);
    }

    public Display getDisplay(int i)
    {
        return c.a(a, i);
    }

    public Display[] getDisplays()
    {
        return c.a(a);
    }

    public Display[] getDisplays(String s)
    {
        return c.a(a, s);
    }
}
