// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

class q
{

    q()
    {
    }

    public static Object a()
    {
        return AccessibilityNodeInfo.obtain();
    }

    public static Object a(View view)
    {
        return AccessibilityNodeInfo.obtain(view);
    }

    public static Object a(Object obj)
    {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)obj);
    }

    public static List a(Object obj, String s1)
    {
        return (List)((AccessibilityNodeInfo)obj).findAccessibilityNodeInfosByText(s1);
    }

    public static void a(Object obj, int i1)
    {
        ((AccessibilityNodeInfo)obj).addAction(i1);
    }

    public static void a(Object obj, Rect rect)
    {
        ((AccessibilityNodeInfo)obj).getBoundsInParent(rect);
    }

    public static void a(Object obj, View view)
    {
        ((AccessibilityNodeInfo)obj).addChild(view);
    }

    public static void a(Object obj, CharSequence charsequence)
    {
        ((AccessibilityNodeInfo)obj).setClassName(charsequence);
    }

    public static void a(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setCheckable(flag);
    }

    public static int b(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getActions();
    }

    public static Object b(Object obj, int i1)
    {
        return ((AccessibilityNodeInfo)obj).getChild(i1);
    }

    public static void b(Object obj, Rect rect)
    {
        ((AccessibilityNodeInfo)obj).getBoundsInScreen(rect);
    }

    public static void b(Object obj, View view)
    {
        ((AccessibilityNodeInfo)obj).setParent(view);
    }

    public static void b(Object obj, CharSequence charsequence)
    {
        ((AccessibilityNodeInfo)obj).setContentDescription(charsequence);
    }

    public static void b(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setChecked(flag);
    }

    public static int c(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getChildCount();
    }

    public static void c(Object obj, Rect rect)
    {
        ((AccessibilityNodeInfo)obj).setBoundsInParent(rect);
    }

    public static void c(Object obj, View view)
    {
        ((AccessibilityNodeInfo)obj).setSource(view);
    }

    public static void c(Object obj, CharSequence charsequence)
    {
        ((AccessibilityNodeInfo)obj).setPackageName(charsequence);
    }

    public static void c(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setClickable(flag);
    }

    public static boolean c(Object obj, int i1)
    {
        return ((AccessibilityNodeInfo)obj).performAction(i1);
    }

    public static CharSequence d(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getClassName();
    }

    public static void d(Object obj, Rect rect)
    {
        ((AccessibilityNodeInfo)obj).setBoundsInScreen(rect);
    }

    public static void d(Object obj, CharSequence charsequence)
    {
        ((AccessibilityNodeInfo)obj).setText(charsequence);
    }

    public static void d(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setEnabled(flag);
    }

    public static CharSequence e(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getContentDescription();
    }

    public static void e(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setFocusable(flag);
    }

    public static CharSequence f(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getPackageName();
    }

    public static void f(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setFocused(flag);
    }

    public static Object g(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getParent();
    }

    public static void g(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setLongClickable(flag);
    }

    public static CharSequence h(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getText();
    }

    public static void h(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setPassword(flag);
    }

    public static int i(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).getWindowId();
    }

    public static void i(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setScrollable(flag);
    }

    public static void j(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setSelected(flag);
    }

    public static boolean j(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isCheckable();
    }

    public static boolean k(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isChecked();
    }

    public static boolean l(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isClickable();
    }

    public static boolean m(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isEnabled();
    }

    public static boolean n(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isFocusable();
    }

    public static boolean o(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isFocused();
    }

    public static boolean p(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isLongClickable();
    }

    public static boolean q(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isPassword();
    }

    public static boolean r(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isScrollable();
    }

    public static boolean s(Object obj)
    {
        return ((AccessibilityNodeInfo)obj).isSelected();
    }

    public static void t(Object obj)
    {
        ((AccessibilityNodeInfo)obj).recycle();
    }
}
