// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.util.AspectRatioUtil;

// Referenced classes of package com.edmodo.cropper.cropwindow.handle:
//            c

class e extends c
{

    private Edge a;

    e(Edge edge)
    {
        super(null, edge);
        a = edge;
    }

    void a(float f, float f1, float f2, Rect rect, float f3)
    {
        a.adjustCoordinate(f, f1, rect, f3, f2);
        float f4 = Edge.LEFT.getCoordinate();
        float f5 = Edge.TOP.getCoordinate();
        float f6 = Edge.RIGHT.getCoordinate();
        float f7 = Edge.BOTTOM.getCoordinate();
        float f8 = (AspectRatioUtil.calculateHeight(f4, f6, f2) - (f7 - f5)) / 2.0F;
        float f9 = f5 - f8;
        float f10 = f8 + f7;
        Edge.TOP.setCoordinate(f9);
        Edge.BOTTOM.setCoordinate(f10);
        if (Edge.TOP.isOutsideMargin(rect, f3) && !a.isNewRectangleOutOfBounds(Edge.TOP, rect, f2))
        {
            float f12 = Edge.TOP.snapToRect(rect);
            Edge.BOTTOM.offset(-f12);
            a.adjustCoordinate(f2);
        }
        if (Edge.BOTTOM.isOutsideMargin(rect, f3) && !a.isNewRectangleOutOfBounds(Edge.BOTTOM, rect, f2))
        {
            float f11 = Edge.BOTTOM.snapToRect(rect);
            Edge.TOP.offset(-f11);
            a.adjustCoordinate(f2);
        }
    }
}
