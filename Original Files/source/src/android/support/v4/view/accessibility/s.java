// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

class s
{

    s()
    {
    }

    public static String a(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getViewIdResourceName();
    }

    public static void a(Object obj, String s1)
    {
        ((AccessibilityNodeInfo)obj).setViewIdResourceName(s1);
    }
}
