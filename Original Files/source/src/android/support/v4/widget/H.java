// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.widget:
//            SlidingPaneLayout

class H extends AccessibilityDelegateCompat
{

    final SlidingPaneLayout b;
    private final Rect c = new Rect();

    H(SlidingPaneLayout slidingpanelayout)
    {
        b = slidingpanelayout;
        super();
    }

    private void a(AccessibilityNodeInfoCompat accessibilitynodeinfocompat, AccessibilityNodeInfoCompat accessibilitynodeinfocompat1)
    {
        Rect rect = c;
        accessibilitynodeinfocompat1.getBoundsInParent(rect);
        accessibilitynodeinfocompat.setBoundsInParent(rect);
        accessibilitynodeinfocompat1.getBoundsInScreen(rect);
        accessibilitynodeinfocompat.setBoundsInScreen(rect);
        accessibilitynodeinfocompat.setVisibleToUser(accessibilitynodeinfocompat1.isVisibleToUser());
        accessibilitynodeinfocompat.setPackageName(accessibilitynodeinfocompat1.getPackageName());
        accessibilitynodeinfocompat.setClassName(accessibilitynodeinfocompat1.getClassName());
        accessibilitynodeinfocompat.setContentDescription(accessibilitynodeinfocompat1.getContentDescription());
        accessibilitynodeinfocompat.setEnabled(accessibilitynodeinfocompat1.isEnabled());
        accessibilitynodeinfocompat.setClickable(accessibilitynodeinfocompat1.isClickable());
        accessibilitynodeinfocompat.setFocusable(accessibilitynodeinfocompat1.isFocusable());
        accessibilitynodeinfocompat.setFocused(accessibilitynodeinfocompat1.isFocused());
        accessibilitynodeinfocompat.setAccessibilityFocused(accessibilitynodeinfocompat1.isAccessibilityFocused());
        accessibilitynodeinfocompat.setSelected(accessibilitynodeinfocompat1.isSelected());
        accessibilitynodeinfocompat.setLongClickable(accessibilitynodeinfocompat1.isLongClickable());
        accessibilitynodeinfocompat.addAction(accessibilitynodeinfocompat1.getActions());
        accessibilitynodeinfocompat.setMovementGranularities(accessibilitynodeinfocompat1.getMovementGranularities());
    }

    public boolean a(View view)
    {
        return b.e(view);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v4/widget/SlidingPaneLayout.getName());
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
        AccessibilityNodeInfoCompat accessibilitynodeinfocompat1 = AccessibilityNodeInfoCompat.obtain(accessibilitynodeinfocompat);
        super.onInitializeAccessibilityNodeInfo(view, accessibilitynodeinfocompat1);
        a(accessibilitynodeinfocompat, accessibilitynodeinfocompat1);
        accessibilitynodeinfocompat1.recycle();
        accessibilitynodeinfocompat.setClassName(android/support/v4/widget/SlidingPaneLayout.getName());
        accessibilitynodeinfocompat.setSource(view);
        android.view.ViewParent viewparent = ViewCompat.getParentForAccessibility(view);
        if (viewparent instanceof View)
        {
            accessibilitynodeinfocompat.setParent((View)viewparent);
        }
        int i = b.getChildCount();
        for (int j = 0; j < i; j++)
        {
            View view1 = b.getChildAt(j);
            if (!a(view1) && view1.getVisibility() == 0)
            {
                ViewCompat.setImportantForAccessibility(view1, 1);
                accessibilitynodeinfocompat.addChild(view1);
            }
        }

    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewgroup, View view, AccessibilityEvent accessibilityevent)
    {
        if (!a(view))
        {
            return super.onRequestSendAccessibilityEvent(viewgroup, view, accessibilityevent);
        } else
        {
            return false;
        }
    }
}
