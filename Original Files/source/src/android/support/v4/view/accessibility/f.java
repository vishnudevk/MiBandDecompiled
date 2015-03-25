// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;


// Referenced classes of package android.support.v4.view.accessibility:
//            k, e

class f
    implements k
{

    final AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat a;
    final e b;

    f(e e, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat accessibilitystatechangelistenercompat)
    {
        b = e;
        a = accessibilitystatechangelistenercompat;
        super();
    }

    public void a(boolean flag)
    {
        a.onAccessibilityStateChanged(flag);
    }
}
