// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import java.util.List;

// Referenced classes of package android.support.v4.view.accessibility:
//            j, k

class i
{

    i()
    {
    }

    public static Object a(k k)
    {
        return new j(k);
    }

    public static List a(AccessibilityManager accessibilitymanager)
    {
        return accessibilitymanager.getInstalledAccessibilityServiceList();
    }

    public static List a(AccessibilityManager accessibilitymanager, int k)
    {
        return accessibilitymanager.getEnabledAccessibilityServiceList(k);
    }

    public static boolean a(AccessibilityManager accessibilitymanager, Object obj)
    {
        return accessibilitymanager.addAccessibilityStateChangeListener((android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener)obj);
    }

    public static boolean b(AccessibilityManager accessibilitymanager)
    {
        return accessibilitymanager.isTouchExplorationEnabled();
    }

    public static boolean b(AccessibilityManager accessibilitymanager, Object obj)
    {
        return accessibilitymanager.removeAccessibilityStateChangeListener((android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener)obj);
    }
}
