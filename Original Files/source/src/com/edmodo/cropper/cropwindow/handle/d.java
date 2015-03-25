// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.util.AspectRatioUtil;

// Referenced classes of package com.edmodo.cropper.cropwindow.handle:
//            c

class d extends c
{

    private Edge a;

    d(Edge edge)
    {
        super(edge, null);
        a = edge;
    }

    void a(float f, float f1, float f2, Rect rect, float f3)
    {
        a.adjustCoordinate(f, f1, rect, f3, f2);
        float f4 = Edge.LEFT.getCoordinate();
        float f5 = Edge.TOP.getCoordinate();
        float f6 = Edge.RIGHT.getCoordinate();
        float f7 = (AspectRatioUtil.calculateWidth(f5, Edge.BOTTOM.getCoordinate(), f2) - (f6 - f4)) / 2.0F;
        float f8 = f4 - f7;
        float f9 = f7 + f6;
        Edge.LEFT.setCoordinate(f8);
        Edge.RIGHT.setCoordinate(f9);
        if (Edge.LEFT.isOutsideMargin(rect, f3) && !a.isNewRectangleOutOfBounds(Edge.LEFT, rect, f2))
        {
            float f11 = Edge.LEFT.snapToRect(rect);
            Edge.RIGHT.offset(-f11);
            a.adjustCoordinate(f2);
        }
        if (Edge.RIGHT.isOutsideMargin(rect, f3) && !a.isNewRectangleOutOfBounds(Edge.RIGHT, rect, f2))
        {
            float f10 = Edge.RIGHT.snapToRect(rect);
            Edge.LEFT.offset(-f10);
            a.adjustCoordinate(f2);
        }
    }
}
