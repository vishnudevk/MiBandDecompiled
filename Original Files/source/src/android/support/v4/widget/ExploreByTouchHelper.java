// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package android.support.v4.widget:
//            o

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat
{

    public static final int INVALID_ID = 0x80000000;
    private static final String b = android/view/View.getName();
    private final Rect c = new Rect();
    private final Rect d = new Rect();
    private final Rect e = new Rect();
    private final int f[] = new int[2];
    private final AccessibilityManager g;
    private final View h;
    private o i;
    private int j;
    private int k;

    public ExploreByTouchHelper(View view)
    {
        j = 0x80000000;
        k = 0x80000000;
        if (view == null)
        {
            throw new IllegalArgumentException("View may not be null");
        } else
        {
            h = view;
            g = (AccessibilityManager)view.getContext().getSystemService("accessibility");
            return;
        }
    }

    static AccessibilityNodeInfoCompat a(ExploreByTouchHelper explorebytouchhelper, int l)
    {
        return explorebytouchhelper.c(l);
    }

    private AccessibilityEvent a(int l, int i1)
    {
        switch (l)
        {
        default:
            return b(l, i1);

        case -1: 
            return b(i1);
        }
    }

    private void a(int l)
    {
        if (k == l)
        {
            return;
        } else
        {
            int i1 = k;
            k = l;
            sendEventForVirtualView(l, 128);
            sendEventForVirtualView(i1, 256);
            return;
        }
    }

    private boolean a(int l, int i1, Bundle bundle)
    {
        switch (l)
        {
        default:
            return b(l, i1, bundle);

        case -1: 
            return a(i1, bundle);
        }
    }

    private boolean a(int l, Bundle bundle)
    {
        return ViewCompat.performAccessibilityAction(h, l, bundle);
    }

    private boolean a(Rect rect)
    {
        if (rect == null || rect.isEmpty())
        {
            return false;
        }
        if (h.getWindowVisibility() != 0)
        {
            return false;
        }
        android.view.ViewParent viewparent;
        View view;
        for (viewparent = h.getParent(); viewparent instanceof View; viewparent = view.getParent())
        {
            view = (View)viewparent;
            if (ViewCompat.getAlpha(view) <= 0.0F || view.getVisibility() != 0)
            {
                return false;
            }
        }

        if (viewparent == null)
        {
            return false;
        }
        if (!h.getLocalVisibleRect(e))
        {
            return false;
        } else
        {
            return rect.intersect(e);
        }
    }

    static boolean a(ExploreByTouchHelper explorebytouchhelper, int l, int i1, Bundle bundle)
    {
        return explorebytouchhelper.a(l, i1, bundle);
    }

    private AccessibilityNodeInfoCompat b()
    {
        AccessibilityNodeInfoCompat accessibilitynodeinfocompat = AccessibilityNodeInfoCompat.obtain(h);
        ViewCompat.onInitializeAccessibilityNodeInfo(h, accessibilitynodeinfocompat);
        LinkedList linkedlist = new LinkedList();
        getVisibleVirtualViews(linkedlist);
        Integer integer;
        for (Iterator iterator = linkedlist.iterator(); iterator.hasNext(); accessibilitynodeinfocompat.addChild(h, integer.intValue()))
        {
            integer = (Integer)iterator.next();
        }

        return accessibilitynodeinfocompat;
    }

    private AccessibilityEvent b(int l)
    {
        AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain(l);
        ViewCompat.onInitializeAccessibilityEvent(h, accessibilityevent);
        return accessibilityevent;
    }

    private AccessibilityEvent b(int l, int i1)
    {
        AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain(i1);
        accessibilityevent.setEnabled(true);
        accessibilityevent.setClassName(b);
        onPopulateEventForVirtualView(l, accessibilityevent);
        if (accessibilityevent.getText().isEmpty() && accessibilityevent.getContentDescription() == null)
        {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        } else
        {
            accessibilityevent.setPackageName(h.getContext().getPackageName());
            AccessibilityEventCompat.asRecord(accessibilityevent).setSource(h, l);
            return accessibilityevent;
        }
    }

    private boolean b(int l, int i1, Bundle bundle)
    {
        switch (i1)
        {
        default:
            return onPerformActionForVirtualView(l, i1, bundle);

        case 64: // '@'
        case 128: 
            return c(l, i1, bundle);
        }
    }

    private AccessibilityNodeInfoCompat c(int l)
    {
        switch (l)
        {
        default:
            return d(l);

        case -1: 
            return b();
        }
    }

    private boolean c(int l, int i1, Bundle bundle)
    {
        switch (i1)
        {
        default:
            return false;

        case 64: // '@'
            return f(l);

        case 128: 
            return g(l);
        }
    }

    private AccessibilityNodeInfoCompat d(int l)
    {
        AccessibilityNodeInfoCompat accessibilitynodeinfocompat = AccessibilityNodeInfoCompat.obtain();
        accessibilitynodeinfocompat.setEnabled(true);
        accessibilitynodeinfocompat.setClassName(b);
        onPopulateNodeForVirtualView(l, accessibilitynodeinfocompat);
        if (accessibilitynodeinfocompat.getText() == null && accessibilitynodeinfocompat.getContentDescription() == null)
        {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        accessibilitynodeinfocompat.getBoundsInParent(d);
        if (d.isEmpty())
        {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int i1 = accessibilitynodeinfocompat.getActions();
        if ((i1 & 0x40) != 0)
        {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((i1 & 0x80) != 0)
        {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilitynodeinfocompat.setPackageName(h.getContext().getPackageName());
        accessibilitynodeinfocompat.setSource(h, l);
        accessibilitynodeinfocompat.setParent(h);
        int j1;
        int k1;
        if (j == l)
        {
            accessibilitynodeinfocompat.setAccessibilityFocused(true);
            accessibilitynodeinfocompat.addAction(128);
        } else
        {
            accessibilitynodeinfocompat.setAccessibilityFocused(false);
            accessibilitynodeinfocompat.addAction(64);
        }
        if (a(d))
        {
            accessibilitynodeinfocompat.setVisibleToUser(true);
            accessibilitynodeinfocompat.setBoundsInParent(d);
        }
        h.getLocationOnScreen(f);
        j1 = f[0];
        k1 = f[1];
        c.set(d);
        c.offset(j1, k1);
        accessibilitynodeinfocompat.setBoundsInScreen(c);
        return accessibilitynodeinfocompat;
    }

    private boolean e(int l)
    {
        return j == l;
    }

    private boolean f(int l)
    {
        while (!g.isEnabled() || !AccessibilityManagerCompat.isTouchExplorationEnabled(g) || e(l)) 
        {
            return false;
        }
        j = l;
        h.invalidate();
        sendEventForVirtualView(l, 32768);
        return true;
    }

    private boolean g(int l)
    {
        if (e(l))
        {
            j = 0x80000000;
            h.invalidate();
            sendEventForVirtualView(l, 0x10000);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean dispatchHoverEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        if (g.isEnabled() && AccessibilityManagerCompat.isTouchExplorationEnabled(g))
        {
            switch (motionevent.getAction())
            {
            case 8: // '\b'
            default:
                return false;

            case 7: // '\007'
            case 9: // '\t'
                int l = getVirtualViewAt(motionevent.getX(), motionevent.getY());
                a(l);
                if (l == 0x80000000)
                {
                    flag = false;
                }
                return flag;

            case 10: // '\n'
                break;
            }
            if (j != 0x80000000)
            {
                a(0x80000000);
                return flag;
            }
        }
        return false;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view)
    {
        if (i == null)
        {
            i = new o(this, null);
        }
        return i;
    }

    public int getFocusedVirtualView()
    {
        return j;
    }

    protected abstract int getVirtualViewAt(float f1, float f2);

    protected abstract void getVisibleVirtualViews(List list);

    public void invalidateRoot()
    {
        invalidateVirtualView(-1);
    }

    public void invalidateVirtualView(int l)
    {
        sendEventForVirtualView(l, 2048);
    }

    protected abstract boolean onPerformActionForVirtualView(int l, int i1, Bundle bundle);

    protected abstract void onPopulateEventForVirtualView(int l, AccessibilityEvent accessibilityevent);

    protected abstract void onPopulateNodeForVirtualView(int l, AccessibilityNodeInfoCompat accessibilitynodeinfocompat);

    public boolean sendEventForVirtualView(int l, int i1)
    {
        android.view.ViewParent viewparent;
        if (l != 0x80000000 && g.isEnabled())
        {
            if ((viewparent = h.getParent()) != null)
            {
                AccessibilityEvent accessibilityevent = a(l, i1);
                return ViewParentCompat.requestSendAccessibilityEvent(viewparent, h, accessibilityevent);
            }
        }
        return false;
    }

}
