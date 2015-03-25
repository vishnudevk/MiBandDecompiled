// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

class H
{

    H()
    {
    }

    public static void a(Object obj, View view, int i)
    {
        ((AccessibilityRecord)obj).setSource(view, i);
    }
}
