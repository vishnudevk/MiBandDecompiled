// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.View;

// Referenced classes of package android.support.v4.widget:
//            SlidingPaneLayout, ViewDragHelper, G

class J extends ViewDragHelper.Callback
{

    final SlidingPaneLayout a;

    private J(SlidingPaneLayout slidingpanelayout)
    {
        a = slidingpanelayout;
        super();
    }

    J(SlidingPaneLayout slidingpanelayout, G g)
    {
        this(slidingpanelayout);
    }

    public int clampViewPositionHorizontal(View view, int i, int j)
    {
        SlidingPaneLayout.LayoutParams layoutparams = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.d(a).getLayoutParams();
        int k = a.getPaddingLeft() + layoutparams.leftMargin;
        int l = k + SlidingPaneLayout.e(a);
        return Math.min(Math.max(i, k), l);
    }

    public int getViewHorizontalDragRange(View view)
    {
        return SlidingPaneLayout.e(a);
    }

    public void onEdgeDragStarted(int i, int j)
    {
        SlidingPaneLayout.b(a).captureChildView(SlidingPaneLayout.d(a), j);
    }

    public void onViewCaptured(View view, int i)
    {
        a.a();
    }

    public void onViewDragStateChanged(int i)
    {
label0:
        {
            if (SlidingPaneLayout.b(a).getViewDragState() == 0)
            {
                if (SlidingPaneLayout.c(a) != 0.0F)
                {
                    break label0;
                }
                a.d(SlidingPaneLayout.d(a));
                a.c(SlidingPaneLayout.d(a));
                SlidingPaneLayout.a(a, false);
            }
            return;
        }
        a.b(SlidingPaneLayout.d(a));
        SlidingPaneLayout.a(a, true);
    }

    public void onViewPositionChanged(View view, int i, int j, int k, int l)
    {
        SlidingPaneLayout.a(a, i);
        a.invalidate();
    }

    public void onViewReleased(View view, float f, float f1)
    {
        SlidingPaneLayout.LayoutParams layoutparams = (SlidingPaneLayout.LayoutParams)view.getLayoutParams();
        int i = a.getPaddingLeft() + layoutparams.leftMargin;
        if (f > 0.0F || f == 0.0F && SlidingPaneLayout.c(a) > 0.5F)
        {
            i += SlidingPaneLayout.e(a);
        }
        SlidingPaneLayout.b(a).settleCapturedViewAt(i, view.getTop());
        a.invalidate();
    }

    public boolean tryCaptureView(View view, int i)
    {
        if (SlidingPaneLayout.a(a))
        {
            return false;
        } else
        {
            return ((SlidingPaneLayout.LayoutParams)view.getLayoutParams()).a;
        }
    }
}
