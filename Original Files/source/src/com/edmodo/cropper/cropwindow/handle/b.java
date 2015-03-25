// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.edge.EdgePair;

// Referenced classes of package com.edmodo.cropper.cropwindow.handle:
//            c

class b extends c
{

    b(Edge edge, Edge edge1)
    {
        super(edge, edge1);
    }

    void a(float f, float f1, float f2, Rect rect, float f3)
    {
        EdgePair edgepair = a(f, f1, f2);
        Edge edge = edgepair.primary;
        Edge edge1 = edgepair.secondary;
        edge.adjustCoordinate(f, f1, rect, f3, f2);
        edge1.adjustCoordinate(f2);
        if (edge1.isOutsideMargin(rect, f3))
        {
            edge1.snapToRect(rect);
            edge.adjustCoordinate(f2);
        }
    }
}
