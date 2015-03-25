// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;

// Referenced classes of package android.support.v4.widget:
//            ExploreByTouchHelper, n

class o extends AccessibilityNodeProviderCompat
{

    final ExploreByTouchHelper a;

    private o(ExploreByTouchHelper explorebytouchhelper)
    {
        a = explorebytouchhelper;
        super();
    }

    o(ExploreByTouchHelper explorebytouchhelper, n n)
    {
        this(explorebytouchhelper);
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i)
    {
        return ExploreByTouchHelper.a(a, i);
    }

    public boolean performAction(int i, int j, Bundle bundle)
    {
        return ExploreByTouchHelper.a(a, i, j, bundle);
    }
}
