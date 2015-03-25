// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Rect;

// Referenced classes of package android.support.v4.view:
//            o, n, m

public class GravityCompat
{

    public static final int END = 0x800005;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 0x800007;
    public static final int RELATIVE_LAYOUT_DIRECTION = 0x800000;
    public static final int START = 0x800003;
    static final m a;

    public GravityCompat()
    {
    }

    public static void apply(int i, int j, int k, Rect rect, int l, int i1, Rect rect1, int j1)
    {
        a.a(i, j, k, rect, l, i1, rect1, j1);
    }

    public static void apply(int i, int j, int k, Rect rect, Rect rect1, int l)
    {
        a.a(i, j, k, rect, rect1, l);
    }

    public static void applyDisplay(int i, Rect rect, Rect rect1, int j)
    {
        a.a(i, rect, rect1, j);
    }

    public static int getAbsoluteGravity(int i, int j)
    {
        return a.a(i, j);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            a = new o();
        } else
        {
            a = new n();
        }
    }
}
