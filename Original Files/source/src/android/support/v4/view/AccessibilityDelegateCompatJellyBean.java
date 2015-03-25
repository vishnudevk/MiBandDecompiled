// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            h

class AccessibilityDelegateCompatJellyBean
{

    AccessibilityDelegateCompatJellyBean()
    {
    }

    public static Object a(AccessibilityDelegateBridgeJellyBean accessibilitydelegatebridgejellybean)
    {
        return new h(accessibilitydelegatebridgejellybean);
    }

    public static Object a(Object obj, View view)
    {
        return ((android.view.View.AccessibilityDelegate)obj).getAccessibilityNodeProvider(view);
    }

    public static boolean a(Object obj, View view, int i, Bundle bundle)
    {
        return ((android.view.View.AccessibilityDelegate)obj).performAccessibilityAction(view, i, bundle);
    }
}
