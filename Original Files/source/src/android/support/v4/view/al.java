// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class al
{

    al()
    {
    }

    public static void a(View view, AccessibilityEvent accessibilityevent)
    {
        view.onPopulateAccessibilityEvent(accessibilityevent);
    }

    public static void a(View view, Object obj)
    {
        view.setAccessibilityDelegate((android.view.View.AccessibilityDelegate)obj);
    }

    public static boolean a(View view, int i)
    {
        return view.canScrollHorizontally(i);
    }

    public static void b(View view, AccessibilityEvent accessibilityevent)
    {
        view.onInitializeAccessibilityEvent(accessibilityevent);
    }

    public static void b(View view, Object obj)
    {
        view.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)obj);
    }

    public static boolean b(View view, int i)
    {
        return view.canScrollVertically(i);
    }
}
