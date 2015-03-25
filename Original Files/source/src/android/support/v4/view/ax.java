// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class ax
{

    ax()
    {
    }

    public static boolean a(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        return viewgroup.onRequestSendAccessibilityEvent(view, accessibilityevent);
    }
}
