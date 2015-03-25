// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            d, c, a, f

public class AccessibilityDelegateCompat
{

    private static final c b;
    private static final Object c;
    final Object a;

    public AccessibilityDelegateCompat()
    {
        a = b.a(this);
    }

    Object a()
    {
        return a;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        return b.a(c, view, accessibilityevent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view)
    {
        return b.a(c, view);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        b.b(c, view, accessibilityevent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
        b.a(c, view, accessibilitynodeinfocompat);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        b.c(c, view, accessibilityevent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return b.a(c, viewgroup, view, accessibilityevent);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        return b.a(c, view, i, bundle);
    }

    public void sendAccessibilityEvent(View view, int i)
    {
        b.a(c, view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityevent)
    {
        b.d(c, view, accessibilityevent);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            b = new d();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            b = new a();
        } else
        {
            b = new f();
        }
        c = b.a();
    }
}
