// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;


// Referenced classes of package android.support.v4.view.accessibility:
//            k

final class j
    implements android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
{

    final k a;

    j(k k1)
    {
        a = k1;
        super();
    }

    public void onAccessibilityStateChanged(boolean flag)
    {
        a.a(flag);
    }
}
