// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.renderer;

import java.util.ArrayList;
import java.util.List;
import org.achartengine.chart.PointStyle;

// Referenced classes of package org.achartengine.renderer:
//            SimpleSeriesRenderer

public class XYSeriesRenderer extends SimpleSeriesRenderer
{

    private boolean a;
    private List b;
    private PointStyle c;
    private float d;
    private float e;

    public XYSeriesRenderer()
    {
        a = false;
        b = new ArrayList();
        c = PointStyle.POINT;
        d = 1.0F;
        e = 1.0F;
    }

    public void addFillOutsideLine(FillOutsideLine filloutsideline)
    {
        b.add(filloutsideline);
    }

    public FillOutsideLine[] getFillOutsideLine()
    {
        return (FillOutsideLine[])b.toArray(new FillOutsideLine[0]);
    }

    public float getLineWidth()
    {
        return e;
    }

    public float getPointStrokeWidth()
    {
        return d;
    }

    public PointStyle getPointStyle()
    {
        return c;
    }

    public boolean isFillBelowLine()
    {
        return b.size() > 0;
    }

    public boolean isFillPoints()
    {
        return a;
    }

    public void setFillBelowLine(boolean flag)
    {
        b.clear();
        class FillOutsideLine.Type extends Enum
        {

            public static final FillOutsideLine.Type ABOVE;
            public static final FillOutsideLine.Type BELOW;
            public static final FillOutsideLine.Type BOUNDS_ABOVE;
            public static final FillOutsideLine.Type BOUNDS_ALL;
            public static final FillOutsideLine.Type BOUNDS_BELOW;
            public static final FillOutsideLine.Type NONE;
            private static final FillOutsideLine.Type a[];

            public static FillOutsideLine.Type valueOf(String s)
            {
                return (FillOutsideLine.Type)Enum.valueOf(org/achartengine/renderer/XYSeriesRenderer$FillOutsideLine$Type, s);
            }

            public static FillOutsideLine.Type[] values()
            {
                return (FillOutsideLine.Type[])a.clone();
            }

            static 
            {
                NONE = new FillOutsideLine.Type("NONE", 0);
                BOUNDS_ALL = new FillOutsideLine.Type("BOUNDS_ALL", 1);
                BOUNDS_BELOW = new FillOutsideLine.Type("BOUNDS_BELOW", 2);
                BOUNDS_ABOVE = new FillOutsideLine.Type("BOUNDS_ABOVE", 3);
                BELOW = new FillOutsideLine.Type("BELOW", 4);
                ABOVE = new FillOutsideLine.Type("ABOVE", 5);
                FillOutsideLine.Type atype[] = new FillOutsideLine.Type[6];
                atype[0] = NONE;
                atype[1] = BOUNDS_ALL;
                atype[2] = BOUNDS_BELOW;
                atype[3] = BOUNDS_ABOVE;
                atype[4] = BELOW;
                atype[5] = ABOVE;
                a = atype;
            }

            private FillOutsideLine.Type(String s, int i)
            {
                super(s, i);
            }
        }

        if (flag)
        {
            b.add(new FillOutsideLine(FillOutsideLine.Type.BOUNDS_ALL));
            return;
        } else
        {
            b.add(new FillOutsideLine(FillOutsideLine.Type.NONE));
            return;
        }
    }

    public void setFillBelowLineColor(int i)
    {
        if (b.size() > 0)
        {
            ((FillOutsideLine)b.get(0)).setColor(i);
        }
    }

    public void setFillPoints(boolean flag)
    {
        a = flag;
    }

    public void setLineWidth(float f)
    {
        e = f;
    }

    public void setPointStrokeWidth(float f)
    {
        d = f;
    }

    public void setPointStyle(PointStyle pointstyle)
    {
        c = pointstyle;
    }

    private class FillOutsideLine
        implements Serializable
    {

        private final Type a;
        private int b;
        private int c[];

        public int getColor()
        {
            return b;
        }

        public int[] getFillRange()
        {
            return c;
        }

        public Type getType()
        {
            return a;
        }

        public void setColor(int i)
        {
            b = i;
        }

        public void setFillRange(int ai[])
        {
            c = ai;
        }

        public FillOutsideLine(Type type)
        {
            b = Color.argb(125, 0, 0, 200);
            a = type;
        }
    }

}
