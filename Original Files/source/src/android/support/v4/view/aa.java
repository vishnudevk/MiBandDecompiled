// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            ah, AccessibilityDelegateCompat

class aa
    implements ah
{

    aa()
    {
    }

    public int a(View view)
    {
        return 2;
    }

    long a()
    {
        return 10L;
    }

    public void a(View view, int l, int i1, int j1, int k1)
    {
        view.postInvalidateDelayed(a(), l, i1, j1, k1);
    }

    public void a(View view, int l, Paint paint)
    {
    }

    public void a(View view, Paint paint)
    {
    }

    public void a(View view, AccessibilityDelegateCompat accessibilitydelegatecompat)
    {
    }

    public void a(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
    }

    public void a(View view, AccessibilityEvent accessibilityevent)
    {
    }

    public void a(View view, Runnable runnable)
    {
        view.postDelayed(runnable, a());
    }

    public void a(View view, Runnable runnable, long l)
    {
        view.postDelayed(runnable, l + a());
    }

    public void a(View view, boolean flag)
    {
    }

    public boolean a(View view, int l)
    {
        return false;
    }

    public boolean a(View view, int l, Bundle bundle)
    {
        return false;
    }

    public void b(View view, AccessibilityEvent accessibilityevent)
    {
    }

    public boolean b(View view)
    {
        return false;
    }

    public boolean b(View view, int l)
    {
        return false;
    }

    public void c(View view)
    {
        view.postInvalidateDelayed(a());
    }

    public void c(View view, int l)
    {
    }

    public int d(View view)
    {
        return 0;
    }

    public void d(View view, int l)
    {
    }

    public AccessibilityNodeProviderCompat e(View view)
    {
        return null;
    }

    public void e(View view, int l)
    {
    }

    public float f(View view)
    {
        return 1.0F;
    }

    public void f(View view, int l)
    {
    }

    public int g(View view)
    {
        return 0;
    }

    public int h(View view)
    {
        return 0;
    }

    public int i(View view)
    {
        return 0;
    }

    public ViewParent j(View view)
    {
        return view.getParent();
    }

    public boolean k(View view)
    {
        Drawable drawable = view.getBackground();
        boolean flag = false;
        if (drawable != null)
        {
            int l = drawable.getOpacity();
            flag = false;
            if (l == -1)
            {
                flag = true;
            }
        }
        return flag;
    }
}
