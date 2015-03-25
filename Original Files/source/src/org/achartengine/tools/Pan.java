// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

// Referenced classes of package org.achartengine.tools:
//            AbstractTool, PanListener

public class Pan extends AbstractTool
{

    private List a;
    private boolean b;
    private boolean c;

    public Pan(AbstractChart abstractchart)
    {
        super(abstractchart);
        a = new ArrayList();
        b = false;
        c = false;
    }

    private double a(double ad[])
    {
        return Math.abs(ad[1] - ad[0]) / Math.abs(ad[3] - ad[2]);
    }

    private void a()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((PanListener)iterator.next()).panApplied()) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void addPanListener(PanListener panlistener)
    {
        this;
        JVM INSTR monitorenter ;
        a.add(panlistener);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void apply(float f, float f1, float f2, float f3)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        double ad[];
        boolean flag4;
        XYChart xychart;
        int j;
        double ad1[];
        flag = true;
        flag1 = true;
        flag2 = true;
        flag3 = true;
        if (!(mChart instanceof XYChart))
        {
            break MISSING_BLOCK_LABEL_540;
        }
        int i = mRenderer.getScalesCount();
        ad = mRenderer.getPanLimits();
        double ad2[];
        if (ad != null && ad.length == 4)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        xychart = (XYChart)mChart;
        j = 0;
_L3:
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_580;
        }
        ad1 = getRange(j);
        ad2 = xychart.getCalcRange(j);
        if (b && c && (ad1[0] == ad1[1] && ad2[0] == ad2[1] || ad1[2] == ad1[3] && ad2[2] == ad2[3]))
        {
            return;
        }
        checkRange(ad1, j);
        double ad3[] = xychart.toRealPoint(f, f1, j);
        double ad4[] = xychart.toRealPoint(f2, f3, j);
        double d = ad3[0] - ad4[0];
        double d1 = ad3[1] - ad4[1];
        double d2 = a(ad1);
        RoundChart roundchart;
        double d3;
        double d4;
        boolean flag5;
        boolean flag6;
        if (xychart.isVertical(mRenderer))
        {
            double d5 = d2 * -d1;
            d4 = d / d2;
            d3 = d5;
        } else
        {
            d3 = d;
            d4 = d1;
        }
        if (mRenderer.isPanXEnabled())
        {
            if (ad != null)
            {
                if (flag2)
                {
                    boolean flag10;
                    if (ad[0] <= d3 + ad1[0])
                    {
                        flag10 = true;
                    } else
                    {
                        flag10 = false;
                    }
                    flag2 = flag10;
                }
                if (flag3)
                {
                    boolean flag9;
                    if (ad[1] >= d3 + ad1[1])
                    {
                        flag9 = true;
                    } else
                    {
                        flag9 = false;
                    }
                    flag3 = flag9;
                }
            }
            if (!flag4 || flag2 && flag3)
            {
                setXRange(d3 + ad1[0], d3 + ad1[1], j);
                b = false;
            } else
            {
                b = true;
            }
        }
        if (!mRenderer.isPanYEnabled())
        {
            break MISSING_BLOCK_LABEL_529;
        }
        if (ad != null)
        {
            if (flag1)
            {
                boolean flag8;
                if (ad[2] <= d4 + ad1[2])
                {
                    flag8 = true;
                } else
                {
                    flag8 = false;
                }
                flag1 = flag8;
            }
            if (flag)
            {
                boolean flag7;
                if (ad[3] >= d4 + ad1[3])
                {
                    flag7 = true;
                } else
                {
                    flag7 = false;
                }
                flag = flag7;
            }
        }
        if (flag4 && (!flag1 || !flag)) goto _L2; else goto _L1
_L1:
        setYRange(d4 + ad1[2], d4 + ad1[3], j);
        c = false;
        flag5 = flag1;
        flag6 = flag;
_L4:
        j++;
        flag1 = flag5;
        flag = flag6;
          goto _L3
_L2:
        c = true;
        flag5 = flag1;
        flag6 = flag;
          goto _L4
        roundchart = (RoundChart)mChart;
        roundchart.setCenterX(roundchart.getCenterX() + (int)(f2 - f));
        roundchart.setCenterY(roundchart.getCenterY() + (int)(f3 - f1));
        a();
        return;
    }

    public void removePanListener(PanListener panlistener)
    {
        this;
        JVM INSTR monitorenter ;
        a.remove(panlistener);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
