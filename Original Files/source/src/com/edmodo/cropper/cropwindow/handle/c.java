// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.edge.EdgePair;
import com.edmodo.cropper.util.AspectRatioUtil;

abstract class c
{

    private static final float a = 1F;
    private Edge b;
    private Edge c;
    private EdgePair d;

    c(Edge edge, Edge edge1)
    {
        b = edge;
        c = edge1;
        d = new EdgePair(b, c);
    }

    private float a(float f, float f1)
    {
        float f2;
        float f3;
        if (c == Edge.LEFT)
        {
            f2 = f;
        } else
        {
            f2 = Edge.LEFT.getCoordinate();
        }
        if (b == Edge.TOP)
        {
            f3 = f1;
        } else
        {
            f3 = Edge.TOP.getCoordinate();
        }
        if (c != Edge.RIGHT)
        {
            f = Edge.RIGHT.getCoordinate();
        }
        if (b != Edge.BOTTOM)
        {
            f1 = Edge.BOTTOM.getCoordinate();
        }
        return AspectRatioUtil.calculateAspectRatio(f2, f3, f, f1);
    }

    EdgePair a()
    {
        return d;
    }

    EdgePair a(float f, float f1, float f2)
    {
        if (a(f, f1) > f2)
        {
            d.primary = c;
            d.secondary = b;
        } else
        {
            d.primary = b;
            d.secondary = c;
        }
        return d;
    }

    abstract void a(float f, float f1, float f2, Rect rect, float f3);

    void a(float f, float f1, Rect rect, float f2)
    {
        EdgePair edgepair = a();
        Edge edge = edgepair.primary;
        Edge edge1 = edgepair.secondary;
        if (edge != null)
        {
            edge.adjustCoordinate(f, f1, rect, f2, 1.0F);
        }
        if (edge1 != null)
        {
            edge1.adjustCoordinate(f, f1, rect, f2, 1.0F);
        }
    }
}
