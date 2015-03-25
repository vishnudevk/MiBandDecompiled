// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;

// Referenced classes of package com.edmodo.cropper.cropwindow.handle:
//            c

class a extends c
{

    a()
    {
        super(null, null);
    }

    void a(float f, float f1, float f2, Rect rect, float f3)
    {
        a(f, f1, rect, f3);
    }

    void a(float f, float f1, Rect rect, float f2)
    {
        float f3 = Edge.LEFT.getCoordinate();
        float f4 = Edge.TOP.getCoordinate();
        float f5 = Edge.RIGHT.getCoordinate();
        float f6 = Edge.BOTTOM.getCoordinate();
        float f7 = (f3 + f5) / 2.0F;
        float f8 = (f4 + f6) / 2.0F;
        float f9 = f - f7;
        float f10 = f1 - f8;
        Edge.LEFT.offset(f9);
        Edge.TOP.offset(f10);
        Edge.RIGHT.offset(f9);
        Edge.BOTTOM.offset(f10);
        if (!Edge.LEFT.isOutsideMargin(rect, f2)) goto _L2; else goto _L1
_L1:
        float f14 = Edge.LEFT.snapToRect(rect);
        Edge.RIGHT.offset(f14);
_L8:
        if (!Edge.TOP.isOutsideMargin(rect, f2)) goto _L4; else goto _L3
_L3:
        float f13 = Edge.TOP.snapToRect(rect);
        Edge.BOTTOM.offset(f13);
_L6:
        return;
_L2:
        if (Edge.RIGHT.isOutsideMargin(rect, f2))
        {
            float f11 = Edge.RIGHT.snapToRect(rect);
            Edge.LEFT.offset(f11);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!Edge.BOTTOM.isOutsideMargin(rect, f2)) goto _L6; else goto _L5
_L5:
        float f12 = Edge.BOTTOM.snapToRect(rect);
        Edge.TOP.offset(f12);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
