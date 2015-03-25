// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v4.view.accessibility:
//            o, n, l, p, 
//            m

public class AccessibilityNodeInfoCompat
{

    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 0x10000;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 0x20000;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final m a;
    private final Object b;

    public AccessibilityNodeInfoCompat(Object obj)
    {
        b = obj;
    }

    static AccessibilityNodeInfoCompat a(Object obj)
    {
        if (obj != null)
        {
            return new AccessibilityNodeInfoCompat(obj);
        } else
        {
            return null;
        }
    }

    private static String a(int i)
    {
        switch (i)
        {
        default:
            return "ACTION_UNKNOWN";

        case 1: // '\001'
            return "ACTION_FOCUS";

        case 2: // '\002'
            return "ACTION_CLEAR_FOCUS";

        case 4: // '\004'
            return "ACTION_SELECT";

        case 8: // '\b'
            return "ACTION_CLEAR_SELECTION";

        case 16: // '\020'
            return "ACTION_CLICK";

        case 32: // ' '
            return "ACTION_LONG_CLICK";

        case 64: // '@'
            return "ACTION_ACCESSIBILITY_FOCUS";

        case 128: 
            return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";

        case 256: 
            return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";

        case 512: 
            return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";

        case 1024: 
            return "ACTION_NEXT_HTML_ELEMENT";

        case 2048: 
            return "ACTION_PREVIOUS_HTML_ELEMENT";

        case 4096: 
            return "ACTION_SCROLL_FORWARD";

        case 8192: 
            return "ACTION_SCROLL_BACKWARD";

        case 65536: 
            return "ACTION_CUT";

        case 16384: 
            return "ACTION_COPY";

        case 32768: 
            return "ACTION_PASTE";

        case 131072: 
            return "ACTION_SET_SELECTION";
        }
    }

    public static AccessibilityNodeInfoCompat obtain()
    {
        return a(a.a());
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
        return a(a.a(accessibilitynodeinfocompat.b));
    }

    public static AccessibilityNodeInfoCompat obtain(View view)
    {
        return a(a.a(view));
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int i)
    {
        return a(a.a(view, i));
    }

    public void addAction(int i)
    {
        a.a(b, i);
    }

    public void addChild(View view)
    {
        a.a(b, view);
    }

    public void addChild(View view, int i)
    {
        a.b(b, view, i);
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        AccessibilityNodeInfoCompat accessibilitynodeinfocompat;
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        accessibilitynodeinfocompat = (AccessibilityNodeInfoCompat)obj;
        if (b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (accessibilitynodeinfocompat.b == null) goto _L1; else goto _L3
_L3:
        return false;
        if (b.equals(accessibilitynodeinfocompat.b)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public List findAccessibilityNodeInfosByText(String s)
    {
        ArrayList arraylist = new ArrayList();
        List list = a.a(b, s);
        int i = list.size();
        for (int j = 0; j < i; j++)
        {
            arraylist.add(new AccessibilityNodeInfoCompat(list.get(j)));
        }

        return arraylist;
    }

    public AccessibilityNodeInfoCompat findFocus(int i)
    {
        return a(a.d(b, i));
    }

    public AccessibilityNodeInfoCompat focusSearch(int i)
    {
        return a(a.e(b, i));
    }

    public int getActions()
    {
        return a.b(b);
    }

    public void getBoundsInParent(Rect rect)
    {
        a.a(b, rect);
    }

    public void getBoundsInScreen(Rect rect)
    {
        a.b(b, rect);
    }

    public AccessibilityNodeInfoCompat getChild(int i)
    {
        return a(a.b(b, i));
    }

    public int getChildCount()
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

    public Object getInfo()
    {
        return b;
    }

    public int getMovementGranularities()
    {
        return a.u(b);
    }

    public CharSequence getPackageName()
    {
        return a.f(b);
    }

    public AccessibilityNodeInfoCompat getParent()
    {
        return a(a.g(b));
    }

    public CharSequence getText()
    {
        return a.h(b);
    }

    public String getViewIdResourceName()
    {
        return a.x(b);
    }

    public int getWindowId()
    {
        return a.i(b);
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

    public boolean isAccessibilityFocused()
    {
        return a.w(b);
    }

    public boolean isCheckable()
    {
        return a.j(b);
    }

    public boolean isChecked()
    {
        return a.k(b);
    }

    public boolean isClickable()
    {
        return a.l(b);
    }

    public boolean isEnabled()
    {
        return a.m(b);
    }

    public boolean isFocusable()
    {
        return a.n(b);
    }

    public boolean isFocused()
    {
        return a.o(b);
    }

    public boolean isLongClickable()
    {
        return a.p(b);
    }

    public boolean isPassword()
    {
        return a.q(b);
    }

    public boolean isScrollable()
    {
        return a.r(b);
    }

    public boolean isSelected()
    {
        return a.s(b);
    }

    public boolean isVisibleToUser()
    {
        return a.v(b);
    }

    public boolean performAction(int i)
    {
        return a.c(b, i);
    }

    public boolean performAction(int i, Bundle bundle)
    {
        return a.a(b, i, bundle);
    }

    public void recycle()
    {
        a.t(b);
    }

    public void setAccessibilityFocused(boolean flag)
    {
        a.l(b, flag);
    }

    public void setBoundsInParent(Rect rect)
    {
        a.c(b, rect);
    }

    public void setBoundsInScreen(Rect rect)
    {
        a.d(b, rect);
    }

    public void setCheckable(boolean flag)
    {
        a.a(b, flag);
    }

    public void setChecked(boolean flag)
    {
        a.b(b, flag);
    }

    public void setClassName(CharSequence charsequence)
    {
        a.a(b, charsequence);
    }

    public void setClickable(boolean flag)
    {
        a.c(b, flag);
    }

    public void setContentDescription(CharSequence charsequence)
    {
        a.b(b, charsequence);
    }

    public void setEnabled(boolean flag)
    {
        a.d(b, flag);
    }

    public void setFocusable(boolean flag)
    {
        a.e(b, flag);
    }

    public void setFocused(boolean flag)
    {
        a.f(b, flag);
    }

    public void setLongClickable(boolean flag)
    {
        a.g(b, flag);
    }

    public void setMovementGranularities(int i)
    {
        a.f(b, i);
    }

    public void setPackageName(CharSequence charsequence)
    {
        a.c(b, charsequence);
    }

    public void setParent(View view)
    {
        a.b(b, view);
    }

    public void setParent(View view, int i)
    {
        a.c(b, view, i);
    }

    public void setPassword(boolean flag)
    {
        a.h(b, flag);
    }

    public void setScrollable(boolean flag)
    {
        a.i(b, flag);
    }

    public void setSelected(boolean flag)
    {
        a.j(b, flag);
    }

    public void setSource(View view)
    {
        a.c(b, view);
    }

    public void setSource(View view, int i)
    {
        a.a(b, view, i);
    }

    public void setText(CharSequence charsequence)
    {
        a.d(b, charsequence);
    }

    public void setViewIdResourceName(String s)
    {
        a.b(b, s);
    }

    public void setVisibleToUser(boolean flag)
    {
        a.k(b, flag);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        stringbuilder.append((new StringBuilder()).append("; boundsInParent: ").append(rect).toString());
        getBoundsInScreen(rect);
        stringbuilder.append((new StringBuilder()).append("; boundsInScreen: ").append(rect).toString());
        stringbuilder.append("; packageName: ").append(getPackageName());
        stringbuilder.append("; className: ").append(getClassName());
        stringbuilder.append("; text: ").append(getText());
        stringbuilder.append("; contentDescription: ").append(getContentDescription());
        stringbuilder.append("; viewId: ").append(getViewIdResourceName());
        stringbuilder.append("; checkable: ").append(isCheckable());
        stringbuilder.append("; checked: ").append(isChecked());
        stringbuilder.append("; focusable: ").append(isFocusable());
        stringbuilder.append("; focused: ").append(isFocused());
        stringbuilder.append("; selected: ").append(isSelected());
        stringbuilder.append("; clickable: ").append(isClickable());
        stringbuilder.append("; longClickable: ").append(isLongClickable());
        stringbuilder.append("; enabled: ").append(isEnabled());
        stringbuilder.append("; password: ").append(isPassword());
        stringbuilder.append((new StringBuilder()).append("; scrollable: ").append(isScrollable()).toString());
        stringbuilder.append("; [");
        int i = getActions();
        do
        {
            if (i == 0)
            {
                break;
            }
            int j = 1 << Integer.numberOfTrailingZeros(i);
            i &= ~j;
            stringbuilder.append(a(j));
            if (i != 0)
            {
                stringbuilder.append(", ");
            }
        } while (true);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    static 
    {
        if ("JellyBeanMR2".equals(android.os.Build.VERSION.CODENAME))
        {
            a = new o();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new n();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new l();
        } else
        {
            a = new p();
        }
    }
}
