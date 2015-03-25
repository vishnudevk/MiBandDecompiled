// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.support.v4.widget.ViewDragHelper;
import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            SlidingUpPanelLayout, o, l

class m extends android.support.v4.widget.ViewDragHelper.Callback
{

    final SlidingUpPanelLayout a;

    private m(SlidingUpPanelLayout slidinguppanellayout)
    {
        a = slidinguppanellayout;
        super();
    }

    m(SlidingUpPanelLayout slidinguppanellayout, l l)
    {
        this(slidinguppanellayout);
    }

    public int clampViewPositionVertical(View view, int i, int j)
    {
        int k;
        int l;
        if (SlidingUpPanelLayout.access$1000(a))
        {
            l = SlidingUpPanelLayout.access$1100(a);
            k = l + SlidingUpPanelLayout.access$300(a);
        } else
        {
            k = a.getPaddingTop();
            l = k - SlidingUpPanelLayout.access$300(a);
        }
        return Math.min(Math.max(i, l), k + a.getPullDownDistance());
    }

    public int getViewVerticalDragRange(View view)
    {
        return SlidingUpPanelLayout.access$300(a);
    }

    public void onViewCaptured(View view, int i)
    {
        a.setAllChildrenVisible();
        SlidingUpPanelLayout.access$802(a, Boolean.valueOf(true));
    }

    public void onViewDragStateChanged(int i)
    {
        int j = (int)(SlidingUpPanelLayout.access$200(a) * (float)SlidingUpPanelLayout.access$300(a));
        if (SlidingUpPanelLayout.access$400(a).getViewDragState() != 0) goto _L2; else goto _L1
_L1:
        if (SlidingUpPanelLayout.access$500(a) != 0.0F) goto _L4; else goto _L3
_L3:
        if (SlidingUpPanelLayout.access$600(a) != o.a)
        {
            a.updateObscuredViewVisibility();
            a.dispatchOnPanelExpanded(SlidingUpPanelLayout.access$700(a));
            SlidingUpPanelLayout.access$602(a, o.a);
        }
_L2:
        return;
_L4:
        if (SlidingUpPanelLayout.access$500(a) != (float)j / (float)SlidingUpPanelLayout.access$300(a))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (SlidingUpPanelLayout.access$600(a) == o.c) goto _L2; else goto _L5
_L5:
        a.updateObscuredViewVisibility();
        a.dispatchOnPanelAnchored(SlidingUpPanelLayout.access$700(a));
        SlidingUpPanelLayout.access$602(a, o.c);
        return;
        if (SlidingUpPanelLayout.access$600(a) == o.b) goto _L2; else goto _L6
_L6:
        a.dispatchOnPanelCollapsed(SlidingUpPanelLayout.access$700(a));
        SlidingUpPanelLayout.access$602(a, o.b);
        return;
    }

    public void onViewPositionChanged(View view, int i, int j, int k, int l)
    {
        SlidingUpPanelLayout.access$900(a, j);
        a.invalidate();
    }

    public void onViewReleased(View view, float f, float f1)
    {
        int i;
        float f4;
        SlidingUpPanelLayout.access$802(a, Boolean.valueOf(false));
        if (SlidingUpPanelLayout.access$1000(a))
        {
            i = SlidingUpPanelLayout.access$1100(a);
        } else
        {
            i = SlidingUpPanelLayout.access$1100(a) - SlidingUpPanelLayout.access$300(a);
        }
        if (SlidingUpPanelLayout.access$200(a) == 0.0F) goto _L2; else goto _L1
_L1:
        if (SlidingUpPanelLayout.access$1000(a))
        {
            f4 = (float)(int)(SlidingUpPanelLayout.access$200(a) * (float)SlidingUpPanelLayout.access$300(a)) / (float)SlidingUpPanelLayout.access$300(a);
        } else
        {
            int j = SlidingUpPanelLayout.access$1200(a) - (int)(SlidingUpPanelLayout.access$200(a) * (float)SlidingUpPanelLayout.access$300(a));
            f4 = (float)(SlidingUpPanelLayout.access$1200(a) - j) / (float)SlidingUpPanelLayout.access$300(a);
        }
        if (f1 <= 0.0F && (f1 != 0.0F || SlidingUpPanelLayout.access$500(a) < (1.0F + f4) / 2.0F)) goto _L4; else goto _L3
_L3:
        i += SlidingUpPanelLayout.access$300(a);
_L6:
        if (!a.getPullDownDockEnable().booleanValue())
        {
            SlidingUpPanelLayout.access$400(a).settleCapturedViewAt(view.getLeft(), i);
            a.invalidate();
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (f1 == 0.0F && SlidingUpPanelLayout.access$500(a) < (1.0F + f4) / 2.0F && SlidingUpPanelLayout.access$500(a) >= f4 / 2.0F)
        {
            i = (int)((float)i + (float)SlidingUpPanelLayout.access$300(a) * SlidingUpPanelLayout.access$200(a));
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (f1 > 0.0F || f1 == 0.0F && SlidingUpPanelLayout.access$500(a) > 0.5F)
        {
            i += SlidingUpPanelLayout.access$300(a);
        }
        if (true) goto _L6; else goto _L5
_L5:
        float f2 = a.getSlideThreshhold();
        float f3 = a.getSlideThreshhold2();
        if (0.0F != f2 && SlidingUpPanelLayout.access$500(a) > f2)
        {
            SlidingUpPanelLayout.access$400(a).settleCapturedViewAt(view.getLeft(), (int)((float)(i - SlidingUpPanelLayout.access$300(a)) + f3 * (float)SlidingUpPanelLayout.access$300(a)));
        } else
        {
            SlidingUpPanelLayout.access$400(a).settleCapturedViewAt(view.getLeft(), i);
        }
        a.invalidate();
        return;
    }

    public boolean tryCaptureView(View view, int i)
    {
        if (SlidingUpPanelLayout.access$100(a))
        {
            return false;
        } else
        {
            return ((SlidingUpPanelLayout.LayoutParams)view.getLayoutParams()).slideable;
        }
    }
}
