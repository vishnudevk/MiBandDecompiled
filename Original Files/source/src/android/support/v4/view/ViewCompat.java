// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            ag, af, ae, ad, 
//            ac, aa, ah, AccessibilityDelegateCompat

public class ViewCompat
{

    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    static final ah a;
    private static final long b = 10L;

    public ViewCompat()
    {
    }

    public static boolean canScrollHorizontally(View view, int i)
    {
        return a.a(view, i);
    }

    public static boolean canScrollVertically(View view, int i)
    {
        return a.b(view, i);
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view)
    {
        return a.e(view);
    }

    public static float getAlpha(View view)
    {
        return a.f(view);
    }

    public static int getImportantForAccessibility(View view)
    {
        return a.d(view);
    }

    public static int getLabelFor(View view)
    {
        return a.h(view);
    }

    public static int getLayerType(View view)
    {
        return a.g(view);
    }

    public static int getLayoutDirection(View view)
    {
        return a.i(view);
    }

    public static int getOverScrollMode(View view)
    {
        return a.a(view);
    }

    public static ViewParent getParentForAccessibility(View view)
    {
        return a.j(view);
    }

    public static boolean hasTransientState(View view)
    {
        return a.b(view);
    }

    public static boolean isOpaque(View view)
    {
        return a.k(view);
    }

    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        a.b(view, accessibilityevent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
        a.a(view, accessibilitynodeinfocompat);
    }

    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        a.a(view, accessibilityevent);
    }

    public static boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        return a.a(view, i, bundle);
    }

    public static void postInvalidateOnAnimation(View view)
    {
        a.c(view);
    }

    public static void postInvalidateOnAnimation(View view, int i, int j, int k, int l)
    {
        a.a(view, i, j, k, l);
    }

    public static void postOnAnimation(View view, Runnable runnable)
    {
        a.a(view, runnable);
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long l)
    {
        a.a(view, runnable, l);
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat)
    {
        a.a(view, accessibilitydelegatecompat);
    }

    public static void setHasTransientState(View view, boolean flag)
    {
        a.a(view, flag);
    }

    public static void setImportantForAccessibility(View view, int i)
    {
        a.d(view, i);
    }

    public static void setLabelFor(View view, int i)
    {
        a.e(view, i);
    }

    public static void setLayerPaint(View view, Paint paint)
    {
        a.a(view, paint);
    }

    public static void setLayerType(View view, int i, Paint paint)
    {
        a.a(view, i, paint);
    }

    public static void setLayoutDirection(View view, int i)
    {
        a.f(view, i);
    }

    public static void setOverScrollMode(View view, int i)
    {
        a.c(view, i);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 17)
        {
            a = new ag();
        } else
        if (i >= 16)
        {
            a = new af();
        } else
        if (i >= 14)
        {
            a = new ae();
        } else
        if (i >= 11)
        {
            a = new ad();
        } else
        if (i >= 9)
        {
            a = new ac();
        } else
        {
            a = new aa();
        }
    }
}
