// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            at, as, av, au

public class ViewGroupCompat
{

    static final au a;

    private ViewGroupCompat()
    {
    }

    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return a.a(viewgroup, view, accessibilityevent);
    }

    public static void setMotionEventSplittingEnabled(ViewGroup viewgroup, boolean flag)
    {
        a.a(viewgroup, flag);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 14)
        {
            a = new at();
        } else
        if (i >= 11)
        {
            a = new as();
        } else
        {
            a = new av();
        }
    }
}
