// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;

// Referenced classes of package org.achartengine.chart:
//            PieSegment

public class PieMapper
    implements Serializable
{

    private List a;
    private int b;
    private int c;
    private int d;

    public PieMapper()
    {
        a = new ArrayList();
    }

    public void addPieSegment(int i, float f, float f1, float f2)
    {
        a.add(new PieSegment(i, f, f1, f2));
    }

    public boolean areAllSegmentPresent(int i)
    {
        return a.size() == i;
    }

    public void clearPieSegments()
    {
        a.clear();
    }

    public double getAngle(Point point)
    {
        double d1 = point.getX() - (float)c;
        double d2 = Math.atan2(-(point.getY() - (float)d), d1);
        double d3;
        if (d2 < 0.0D)
        {
            d3 = Math.abs(d2);
        } else
        {
            d3 = 6.2831853071795862D - d2;
        }
        return Math.toDegrees(d3);
    }

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point point)
    {
label0:
        {
            if (!isOnPieChart(point))
            {
                break label0;
            }
            double d1 = getAngle(point);
            Iterator iterator = a.iterator();
            PieSegment piesegment;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                piesegment = (PieSegment)iterator.next();
            } while (!piesegment.isInSegment(d1));
            return new SeriesSelection(0, piesegment.getDataIndex(), piesegment.getValue(), piesegment.getValue());
        }
        return null;
    }

    public boolean isOnPieChart(Point point)
    {
        return Math.pow((float)c - point.getX(), 2D) + Math.pow((float)d - point.getY(), 2D) <= (double)(b * b);
    }

    public void setDimensions(int i, int j, int k)
    {
        b = i;
        c = j;
        d = k;
    }
}
