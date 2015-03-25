// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.view.View;
import android.widget.HorizontalScrollView;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            w

class x
    implements ScrollDetectors.ScrollDetector
{

    private x()
    {
    }

    x(w w)
    {
        this();
    }

    public boolean canScrollHorizontal(View view, int i)
    {
        HorizontalScrollView horizontalscrollview = (HorizontalScrollView)view;
        for (int j = horizontalscrollview.getScrollX(); horizontalscrollview.getChildCount() == 0 || (i >= 0 || j >= horizontalscrollview.getChildAt(0).getWidth() - horizontalscrollview.getWidth()) && (i <= 0 || j <= 0);)
        {
            return false;
        }

        return true;
    }

    public boolean canScrollVertical(View view, int i)
    {
        return false;
    }
}
