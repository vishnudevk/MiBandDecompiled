// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            AccessibilityDelegateCompat, a

class b
    implements AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
{

    final AccessibilityDelegateCompat a;
    final a b;

    b(a a1, AccessibilityDelegateCompat accessibilitydelegatecompat)
    {
        b = a1;
        a = accessibilitydelegatecompat;
        super();
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        return a.dispatchPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        a.onInitializeAccessibilityEvent(view, accessibilityevent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, Object obj)
    {
        a.onInitializeAccessibilityNodeInfo(view, new AccessibilityNodeInfoCompat(obj));
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        a.onPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return a.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
    }

    public void sendAccessibilityEvent(View view, int i)
    {
        a.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityevent)
    {
        a.sendAccessibilityEventUnchecked(view, accessibilityevent);
    }
}
