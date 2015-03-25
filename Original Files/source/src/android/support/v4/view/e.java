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
//            AccessibilityDelegateCompat, d

class e
    implements AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
{

    final AccessibilityDelegateCompat a;
    final d b;

    e(d d, AccessibilityDelegateCompat accessibilitydelegatecompat)
    {
        b = d;
        a = accessibilitydelegatecompat;
        super();
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        return a.dispatchPopulateAccessibilityEvent(view, accessibilityevent);
    }

    public Object getAccessibilityNodeProvider(View view)
    {
        AccessibilityNodeProviderCompat accessibilitynodeprovidercompat = a.getAccessibilityNodeProvider(view);
        if (accessibilitynodeprovidercompat != null)
        {
            return accessibilitynodeprovidercompat.getProvider();
        } else
        {
            return null;
        }
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

    public boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        return a.performAccessibilityAction(view, i, bundle);
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
