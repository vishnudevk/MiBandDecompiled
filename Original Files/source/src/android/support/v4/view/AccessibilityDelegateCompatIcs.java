// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.support.v4.view:
//            g

class AccessibilityDelegateCompatIcs
{

    AccessibilityDelegateCompatIcs()
    {
    }

    public static Object a()
    {
        return new android.view.View.AccessibilityDelegate();
    }

    public static Object a(AccessibilityDelegateBridge accessibilitydelegatebridge)
    {
        return new g(accessibilitydelegatebridge);
    }

    public static void a(Object obj, View view, int i)
    {
        ((android.view.View.AccessibilityDelegate)obj).sendAccessibilityEvent(view, i);
    }

    public static void a(Object obj, View view, Object obj1)
    {
        ((android.view.View.AccessibilityDelegate)obj).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo)obj1);
    }

    public static boolean a(Object obj, View view, AccessibilityEvent accessibilityevent)
    {
        return ((android.view.View.AccessibilityDelegate)obj).dispatchPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public static boolean a(Object obj, ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return ((android.view.View.AccessibilityDelegate)obj).onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
    }

    public static void b(Object obj, View view, AccessibilityEvent accessibilityevent)
    {
        ((android.view.View.AccessibilityDelegate)obj).onInitializeAccessibilityEvent(view, accessibilityevent);
    }

    public static void c(Object obj, View view, AccessibilityEvent accessibilityevent)
    {
        ((android.view.View.AccessibilityDelegate)obj).onPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public static void d(Object obj, View view, AccessibilityEvent accessibilityevent)
    {
        ((android.view.View.AccessibilityDelegate)obj).sendAccessibilityEventUnchecked(view, accessibilityevent);
    }
}
