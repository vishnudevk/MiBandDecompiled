// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import java.util.List;

// Referenced classes of package android.support.v4.view.accessibility:
//            g, f, i

class e extends g
{

    e()
    {
    }

    public Object a(AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat accessibilitystatechangelistenercompat)
    {
        return i.a(new f(this, accessibilitystatechangelistenercompat));
    }

    public List a(AccessibilityManager accessibilitymanager)
    {
        return i.a(accessibilitymanager);
    }

    public List a(AccessibilityManager accessibilitymanager, int j)
    {
        return i.a(accessibilitymanager, j);
    }

    public boolean a(AccessibilityManager accessibilitymanager, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat accessibilitystatechangelistenercompat)
    {
        return i.a(accessibilitymanager, accessibilitystatechangelistenercompat.a);
    }

    public boolean b(AccessibilityManager accessibilitymanager)
    {
        return i.b(accessibilitymanager);
    }

    public boolean b(AccessibilityManager accessibilitymanager, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat accessibilitystatechangelistenercompat)
    {
        return i.b(accessibilitymanager, accessibilitystatechangelistenercompat.a);
    }
}
