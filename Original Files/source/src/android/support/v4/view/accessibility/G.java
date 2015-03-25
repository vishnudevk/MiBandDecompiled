// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityRecord;

class G
{

    G()
    {
    }

    public static int a(Object obj)
    {
        return ((AccessibilityRecord)obj).getMaxScrollX();
    }

    public static void a(Object obj, int i)
    {
        ((AccessibilityRecord)obj).setMaxScrollX(i);
    }

    public static int b(Object obj)
    {
        return ((AccessibilityRecord)obj).getMaxScrollY();
    }

    public static void b(Object obj, int i)
    {
        ((AccessibilityRecord)obj).setMaxScrollY(i);
    }
}
