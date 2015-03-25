// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

class am
{

    am()
    {
    }

    public static void a(View view, int i)
    {
        view.setImportantForAccessibility(i);
    }

    public static void a(View view, int i, int j, int k, int l)
    {
        view.postInvalidate(i, j, k, l);
    }

    public static void a(View view, Runnable runnable)
    {
        view.postOnAnimation(runnable);
    }

    public static void a(View view, Runnable runnable, long l)
    {
        view.postOnAnimationDelayed(runnable, l);
    }

    public static void a(View view, boolean flag)
    {
        view.setHasTransientState(flag);
    }

    public static boolean a(View view)
    {
        return view.hasTransientState();
    }

    public static boolean a(View view, int i, Bundle bundle)
    {
        return view.performAccessibilityAction(i, bundle);
    }

    public static void b(View view)
    {
        view.postInvalidateOnAnimation();
    }

    public static int c(View view)
    {
        return view.getImportantForAccessibility();
    }

    public static Object d(View view)
    {
        return view.getAccessibilityNodeProvider();
    }

    public static ViewParent e(View view)
    {
        return view.getParentForAccessibility();
    }
}
