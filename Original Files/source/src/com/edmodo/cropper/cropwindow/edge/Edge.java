// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.edge;

import android.graphics.Rect;
import android.view.View;
import com.edmodo.cropper.util.AspectRatioUtil;

// Referenced classes of package com.edmodo.cropper.cropwindow.edge:
//            a

public final class Edge extends Enum
{

    public static final Edge BOTTOM;
    public static final Edge LEFT;
    public static final int MIN_CROP_LENGTH_PX = 60;
    public static final Edge RIGHT;
    public static final Edge TOP;
    private static final Edge b[];
    private float a;

    private Edge(String s, int i)
    {
        super(s, i);
    }

    private static float a(float f, Rect rect, float f1, float f2)
    {
        float f3 = (1.0F / 0.0F);
        if (f - (float)rect.left < f1)
        {
            return (float)rect.left;
        }
        float f4;
        if (f >= RIGHT.getCoordinate() - 60F)
        {
            f4 = RIGHT.getCoordinate() - 60F;
        } else
        {
            f4 = f3;
        }
        if ((RIGHT.getCoordinate() - f) / f2 <= 60F)
        {
            f3 = RIGHT.getCoordinate() - 60F * f2;
        }
        return Math.min(f, Math.min(f4, f3));
    }

    private boolean a(float f, float f1, float f2, float f3, Rect rect)
    {
        return f < (float)rect.top || f1 < (float)rect.left || f2 > (float)rect.bottom || f3 > (float)rect.right;
    }

    private static float b(float f, Rect rect, float f1, float f2)
    {
        float f3 = (-1.0F / 0.0F);
        if ((float)rect.right - f < f1)
        {
            return (float)rect.right;
        }
        float f4;
        if (f <= 60F + LEFT.getCoordinate())
        {
            f4 = 60F + LEFT.getCoordinate();
        } else
        {
            f4 = f3;
        }
        if ((f - LEFT.getCoordinate()) / f2 <= 60F)
        {
            f3 = LEFT.getCoordinate() + 60F * f2;
        }
        return Math.max(f, Math.max(f4, f3));
    }

    private static float c(float f, Rect rect, float f1, float f2)
    {
        float f3 = (1.0F / 0.0F);
        if (f - (float)rect.top < f1)
        {
            return (float)rect.top;
        }
        float f4;
        if (f >= BOTTOM.getCoordinate() - 60F)
        {
            f4 = BOTTOM.getCoordinate() - 60F;
        } else
        {
            f4 = f3;
        }
        if (f2 * (BOTTOM.getCoordinate() - f) <= 60F)
        {
            f3 = BOTTOM.getCoordinate() - 60F / f2;
        }
        return Math.min(f, Math.min(f4, f3));
    }

    private static float d(float f, Rect rect, float f1, float f2)
    {
        float f3 = (-1.0F / 0.0F);
        if ((float)rect.bottom - f < f1)
        {
            return (float)rect.bottom;
        }
        float f4;
        if (f <= 60F + TOP.getCoordinate())
        {
            f4 = 60F + TOP.getCoordinate();
        } else
        {
            f4 = f3;
        }
        if (f2 * (f - TOP.getCoordinate()) <= 60F)
        {
            f3 = TOP.getCoordinate() + 60F / f2;
        }
        return Math.max(f, Math.max(f3, f4));
    }

    public static float getHeight()
    {
        return BOTTOM.getCoordinate() - TOP.getCoordinate();
    }

    public static float getWidth()
    {
        return RIGHT.getCoordinate() - LEFT.getCoordinate();
    }

    public static Edge valueOf(String s)
    {
        return (Edge)Enum.valueOf(com/edmodo/cropper/cropwindow/edge/Edge, s);
    }

    public static Edge[] values()
    {
        return (Edge[])b.clone();
    }

    public void adjustCoordinate(float f)
    {
        float f1 = LEFT.getCoordinate();
        float f2 = TOP.getCoordinate();
        float f3 = RIGHT.getCoordinate();
        float f4 = BOTTOM.getCoordinate();
        switch (a.a[ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a = AspectRatioUtil.calculateLeft(f2, f3, f4, f);
            return;

        case 2: // '\002'
            a = AspectRatioUtil.calculateTop(f1, f3, f4, f);
            return;

        case 3: // '\003'
            a = AspectRatioUtil.calculateRight(f1, f2, f4, f);
            return;

        case 4: // '\004'
            a = AspectRatioUtil.calculateBottom(f1, f2, f3, f);
            break;
        }
    }

    public void adjustCoordinate(float f, float f1, Rect rect, float f2, float f3)
    {
        switch (a.a[ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a = a(f, rect, f2, f3);
            return;

        case 2: // '\002'
            a = c(f1, rect, f2, f3);
            return;

        case 3: // '\003'
            a = b(f, rect, f2, f3);
            return;

        case 4: // '\004'
            a = d(f1, rect, f2, f3);
            break;
        }
    }

    public float getCoordinate()
    {
        return a;
    }

    public boolean isNewRectangleOutOfBounds(Edge edge, Rect rect, float f)
    {
        float f1 = edge.snapOffset(rect);
        a.a[ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 46
    //                   2 162
    //                   3 278
    //                   4 394;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L2:
        if (edge.equals(TOP))
        {
            float f23 = rect.top;
            float f24 = BOTTOM.getCoordinate() - f1;
            float f25 = RIGHT.getCoordinate();
            return a(f23, AspectRatioUtil.calculateLeft(f23, f25, f24, f), f24, f25, rect);
        }
        if (edge.equals(BOTTOM))
        {
            float f20 = rect.bottom;
            float f21 = TOP.getCoordinate() - f1;
            float f22 = RIGHT.getCoordinate();
            return a(f21, AspectRatioUtil.calculateLeft(f21, f22, f20, f), f20, f22, rect);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (edge.equals(LEFT))
        {
            float f17 = rect.left;
            float f18 = RIGHT.getCoordinate() - f1;
            float f19 = BOTTOM.getCoordinate();
            return a(AspectRatioUtil.calculateTop(f17, f18, f19, f), f17, f19, f18, rect);
        }
        if (edge.equals(RIGHT))
        {
            float f14 = rect.right;
            float f15 = LEFT.getCoordinate() - f1;
            float f16 = BOTTOM.getCoordinate();
            return a(AspectRatioUtil.calculateTop(f15, f14, f16, f), f15, f16, f14, rect);
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (edge.equals(TOP))
        {
            float f11 = rect.top;
            float f12 = BOTTOM.getCoordinate() - f1;
            float f13 = LEFT.getCoordinate();
            return a(f11, f13, f12, AspectRatioUtil.calculateRight(f13, f11, f12, f), rect);
        }
        if (edge.equals(BOTTOM))
        {
            float f8 = rect.bottom;
            float f9 = TOP.getCoordinate() - f1;
            float f10 = LEFT.getCoordinate();
            return a(f9, f10, f8, AspectRatioUtil.calculateRight(f10, f9, f8, f), rect);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        if (edge.equals(LEFT))
        {
            float f5 = rect.left;
            float f6 = RIGHT.getCoordinate() - f1;
            float f7 = TOP.getCoordinate();
            return a(f7, f5, AspectRatioUtil.calculateBottom(f5, f7, f6, f), f6, rect);
        }
        if (edge.equals(RIGHT))
        {
            float f2 = rect.right;
            float f3 = LEFT.getCoordinate() - f1;
            float f4 = TOP.getCoordinate();
            return a(f4, f3, AspectRatioUtil.calculateBottom(f3, f4, f2, f), f2, rect);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public boolean isOutsideFrame(Rect rect)
    {
        boolean flag = true;
        a.a[ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 44
    //                   2 62
    //                   3 80
    //                   4 98;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        flag = false;
_L7:
        return flag;
_L2:
        if ((double)(a - (float)rect.left) >= 0.0D)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if ((double)(a - (float)rect.top) >= 0.0D)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if ((double)((float)rect.right - a) >= 0.0D)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if ((double)((float)rect.bottom - a) >= 0.0D)
        {
            return false;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean isOutsideMargin(Rect rect, float f)
    {
        boolean flag = true;
        a.a[ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 44
    //                   2 61
    //                   3 78
    //                   4 95;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        flag = false;
_L7:
        return flag;
_L2:
        if (a - (float)rect.left >= f)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (a - (float)rect.top >= f)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if ((float)rect.right - a >= f)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if ((float)rect.bottom - a >= f)
        {
            return false;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void offset(float f)
    {
        a = f + a;
    }

    public void setCoordinate(float f)
    {
        a = f;
    }

    public float snapOffset(Rect rect)
    {
        float f = a;
        a.a[ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 50
    //                   2 59
    //                   3 68
    //                   4 77;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        float f1 = f;
_L7:
        return f1 - f;
_L2:
        f1 = rect.left;
        continue; /* Loop/switch isn't completed */
_L3:
        f1 = rect.top;
        continue; /* Loop/switch isn't completed */
_L4:
        f1 = rect.right;
        continue; /* Loop/switch isn't completed */
_L5:
        f1 = rect.bottom;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public float snapToRect(Rect rect)
    {
        float f = a;
        a.a[ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 51
    //                   2 63
    //                   3 75
    //                   4 87;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return a - f;
_L2:
        a = rect.left;
        continue; /* Loop/switch isn't completed */
_L3:
        a = rect.top;
        continue; /* Loop/switch isn't completed */
_L4:
        a = rect.right;
        continue; /* Loop/switch isn't completed */
_L5:
        a = rect.bottom;
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void snapToView(View view)
    {
        switch (a.a[ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a = 0.0F;
            return;

        case 2: // '\002'
            a = 0.0F;
            return;

        case 3: // '\003'
            a = view.getWidth();
            return;

        case 4: // '\004'
            a = view.getHeight();
            break;
        }
    }

    static 
    {
        LEFT = new Edge("LEFT", 0);
        TOP = new Edge("TOP", 1);
        RIGHT = new Edge("RIGHT", 2);
        BOTTOM = new Edge("BOTTOM", 3);
        Edge aedge[] = new Edge[4];
        aedge[0] = LEFT;
        aedge[1] = TOP;
        aedge[2] = RIGHT;
        aedge[3] = BOTTOM;
        b = aedge;
    }
}
