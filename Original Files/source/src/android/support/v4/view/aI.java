// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            aK, ViewParentCompatICS

class aI extends aK
{

    aI()
    {
    }

    public boolean a(ViewParent viewparent, View view, AccessibilityEvent accessibilityevent)
    {
        return ViewParentCompatICS.requestSendAccessibilityEvent(viewparent, view, accessibilityevent);
    }
}
