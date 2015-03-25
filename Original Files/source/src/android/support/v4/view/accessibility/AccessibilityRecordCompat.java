// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import java.util.List;

// Referenced classes of package android.support.v4.view.accessibility:
//            D, B, A, E, 
//            C, AccessibilityNodeInfoCompat

public class AccessibilityRecordCompat
{

    private static final C a;
    private final Object b;

    public AccessibilityRecordCompat(Object obj)
    {
        b = obj;
    }

    public static AccessibilityRecordCompat obtain()
    {
        return new AccessibilityRecordCompat(a.a());
    }

    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat accessibilityrecordcompat)
    {
        return new AccessibilityRecordCompat(a.a(accessibilityrecordcompat.b));
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        AccessibilityRecordCompat accessibilityrecordcompat;
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        accessibilityrecordcompat = (AccessibilityRecordCompat)obj;
        if (b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (accessibilityrecordcompat.b == null) goto _L1; else goto _L3
_L3:
        return false;
        if (b.equals(accessibilityrecordcompat.b)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int getAddedCount()
    {
        return a.b(b);
    }

    public CharSequence getBeforeText()
    {
        return a.c(b);
    }

    public CharSequence getClassName()
    {
        return a.d(b);
    }

    public CharSequence getContentDescription()
    {
        return a.e(b);
    }

    public int getCurrentItemIndex()
    {
        return a.f(b);
    }

    public int getFromIndex()
    {
        return a.g(b);
    }

    public Object getImpl()
    {
        return b;
    }

    public int getItemCount()
    {
        return a.h(b);
    }

    public int getMaxScrollX()
    {
        return a.w(b);
    }

    public int getMaxScrollY()
    {
        return a.x(b);
    }

    public Parcelable getParcelableData()
    {
        return a.i(b);
    }

    public int getRemovedCount()
    {
        return a.j(b);
    }

    public int getScrollX()
    {
        return a.k(b);
    }

    public int getScrollY()
    {
        return a.l(b);
    }

    public AccessibilityNodeInfoCompat getSource()
    {
        return a.m(b);
    }

    public List getText()
    {
        return a.n(b);
    }

    public int getToIndex()
    {
        return a.o(b);
    }

    public int getWindowId()
    {
        return a.p(b);
    }

    public int hashCode()
    {
        if (b == null)
        {
            return 0;
        } else
        {
            return b.hashCode();
        }
    }

    public boolean isChecked()
    {
        return a.q(b);
    }

    public boolean isEnabled()
    {
        return a.r(b);
    }

    public boolean isFullScreen()
    {
        return a.s(b);
    }

    public boolean isPassword()
    {
        return a.t(b);
    }

    public boolean isScrollable()
    {
        return a.u(b);
    }

    public void recycle()
    {
        a.v(b);
    }

    public void setAddedCount(int i)
    {
        a.a(b, i);
    }

    public void setBeforeText(CharSequence charsequence)
    {
        a.a(b, charsequence);
    }

    public void setChecked(boolean flag)
    {
        a.a(b, flag);
    }

    public void setClassName(CharSequence charsequence)
    {
        a.b(b, charsequence);
    }

    public void setContentDescription(CharSequence charsequence)
    {
        a.c(b, charsequence);
    }

    public void setCurrentItemIndex(int i)
    {
        a.b(b, i);
    }

    public void setEnabled(boolean flag)
    {
        a.b(b, flag);
    }

    public void setFromIndex(int i)
    {
        a.c(b, i);
    }

    public void setFullScreen(boolean flag)
    {
        a.c(b, flag);
    }

    public void setItemCount(int i)
    {
        a.d(b, i);
    }

    public void setMaxScrollX(int i)
    {
        a.i(b, i);
    }

    public void setMaxScrollY(int i)
    {
        a.j(b, i);
    }

    public void setParcelableData(Parcelable parcelable)
    {
        a.a(b, parcelable);
    }

    public void setPassword(boolean flag)
    {
        a.d(b, flag);
    }

    public void setRemovedCount(int i)
    {
        a.e(b, i);
    }

    public void setScrollX(int i)
    {
        a.f(b, i);
    }

    public void setScrollY(int i)
    {
        a.g(b, i);
    }

    public void setScrollable(boolean flag)
    {
        a.e(b, flag);
    }

    public void setSource(View view)
    {
        a.a(b, view);
    }

    public void setSource(View view, int i)
    {
        a.a(b, view, i);
    }

    public void setToIndex(int i)
    {
        a.h(b, i);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new D();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            a = new B();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new A();
        } else
        {
            a = new E();
        }
    }
}
