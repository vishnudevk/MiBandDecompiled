// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;

// Referenced classes of package com.edmodo.cropper.cropwindow.handle:
//            b, e, d, a, 
//            c

public final class Handle extends Enum
{

    public static final Handle BOTTOM;
    public static final Handle BOTTOM_LEFT;
    public static final Handle BOTTOM_RIGHT;
    public static final Handle CENTER;
    public static final Handle LEFT;
    public static final Handle RIGHT;
    public static final Handle TOP;
    public static final Handle TOP_LEFT;
    public static final Handle TOP_RIGHT;
    private static final Handle b[];
    private c a;

    private Handle(String s, int i, c c1)
    {
        super(s, i);
        a = c1;
    }

    public static Handle valueOf(String s)
    {
        return (Handle)Enum.valueOf(com/edmodo/cropper/cropwindow/handle/Handle, s);
    }

    public static Handle[] values()
    {
        return (Handle[])b.clone();
    }

    public void updateCropWindow(float f, float f1, float f2, Rect rect, float f3)
    {
        a.a(f, f1, f2, rect, f3);
    }

    public void updateCropWindow(float f, float f1, Rect rect, float f2)
    {
        a.a(f, f1, rect, f2);
    }

    static 
    {
        TOP_LEFT = new Handle("TOP_LEFT", 0, new b(Edge.TOP, Edge.LEFT));
        TOP_RIGHT = new Handle("TOP_RIGHT", 1, new b(Edge.TOP, Edge.RIGHT));
        BOTTOM_LEFT = new Handle("BOTTOM_LEFT", 2, new b(Edge.BOTTOM, Edge.LEFT));
        BOTTOM_RIGHT = new Handle("BOTTOM_RIGHT", 3, new b(Edge.BOTTOM, Edge.RIGHT));
        LEFT = new Handle("LEFT", 4, new e(Edge.LEFT));
        TOP = new Handle("TOP", 5, new d(Edge.TOP));
        RIGHT = new Handle("RIGHT", 6, new e(Edge.RIGHT));
        BOTTOM = new Handle("BOTTOM", 7, new d(Edge.BOTTOM));
        CENTER = new Handle("CENTER", 8, new a());
        Handle ahandle[] = new Handle[9];
        ahandle[0] = TOP_LEFT;
        ahandle[1] = TOP_RIGHT;
        ahandle[2] = BOTTOM_LEFT;
        ahandle[3] = BOTTOM_RIGHT;
        ahandle[4] = LEFT;
        ahandle[5] = TOP;
        ahandle[6] = RIGHT;
        ahandle[7] = BOTTOM;
        ahandle[8] = CENTER;
        b = ahandle;
    }
}
