// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public interface 
{

    public abstract boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent);

    public abstract Object getAccessibilityNodeProvider(View view);

    public abstract void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent);

    public abstract void onInitializeAccessibilityNodeInfo(View view, Object obj);

    public abstract void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent);

    public abstract boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent);

    public abstract boolean performAccessibilityAction(View view, int i, Bundle bundle);

    public abstract void sendAccessibilityEvent(View view, int i);

    public abstract void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityevent);
}
