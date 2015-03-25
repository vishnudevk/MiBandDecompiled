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
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

// Referenced classes of package org.achartengine.tools:
//            AbstractTool, ZoomListener, ZoomEvent

public class Zoom extends AbstractTool
{

    public static final int ZOOM_AXIS_X = 1;
    public static final int ZOOM_AXIS_XY = 0;
    public static final int ZOOM_AXIS_Y = 2;
    private boolean a;
    private float b;
    private List c;
    private boolean d;
    private boolean e;

    public Zoom(AbstractChart abstractchart, boolean flag, float f)
    {
        super(abstractchart);
        c = new ArrayList();
        d = false;
        e = false;
        a = flag;
        setZoomRate(f);
    }

    private void a(ZoomEvent zoomevent)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((ZoomListener)iterator.next()).zoomApplied(zoomevent)) { }
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void addZoomListener(ZoomListener zoomlistener)
    {
        this;
        JVM INSTR monitorenter ;
        c.add(zoomlistener);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void apply(int i)
    {
        if (mChart instanceof XYChart)
        {
            int j = mRenderer.getScalesCount();
            int k = 0;
            while (k < j) 
            {
                double ad[] = getRange(k);
                checkRange(ad, k);
                double ad1[] = mRenderer.getZoomLimits();
                double d1 = (ad[0] + ad[1]) / 2D;
                double d2 = (ad[2] + ad[3]) / 2D;
                double d3 = ad[1] - ad[0];
                double d4 = ad[3] - ad[2];
                double d5 = d1 - d3 / 2D;
                double d6 = d1 + d3 / 2D;
                double d7 = d2 - d4 / 2D;
                double d8 = d2 + d4 / 2D;
                if (k == 0)
                {
                    double d13;
                    double d14;
                    boolean flag;
                    boolean flag1;
                    if (ad1 != null && (d5 <= ad1[0] || d6 >= ad1[1]))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    d = flag;
                    if (ad1 != null && (d7 <= ad1[2] || d8 >= ad1[3]))
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    e = flag1;
                }
                if (a)
                {
                    DefaultRenderer defaultrenderer;
                    double d9;
                    double d10;
                    double d11;
                    double d12;
                    double d15;
                    if (mRenderer.isZoomXEnabled() && (i == 1 || i == 0))
                    {
                        if (d && b < 1.0F)
                        {
                            d15 = d3;
                        } else
                        {
                            d15 = d3 / (double)b;
                        }
                    } else
                    {
                        d15 = d3;
                    }
                    if (mRenderer.isZoomYEnabled() && (i == 2 || i == 0))
                    {
                        if (e && b < 1.0F)
                        {
                            d9 = d4;
                            d10 = d15;
                        } else
                        {
                            d9 = d4 / (double)b;
                            d10 = d15;
                        }
                    } else
                    {
                        d9 = d4;
                        d10 = d15;
                    }
                } else
                {
                    if (mRenderer.isZoomXEnabled() && !d && (i == 1 || i == 0))
                    {
                        d3 *= b;
                    }
                    if (mRenderer.isZoomYEnabled() && !e && (i == 2 || i == 0))
                    {
                        d9 = d4 * (double)b;
                        d10 = d3;
                    } else
                    {
                        d9 = d4;
                        d10 = d3;
                    }
                }
                if (ad1 != null)
                {
                    d11 = Math.min(mRenderer.getZoomInLimitX(), ad1[1] - ad1[0]);
                    d12 = Math.min(mRenderer.getZoomInLimitY(), ad1[3] - ad1[2]);
                } else
                {
                    d11 = mRenderer.getZoomInLimitX();
                    d12 = mRenderer.getZoomInLimitY();
                }
                d13 = Math.max(d10, d11);
                d14 = Math.max(d9, d12);
                if (mRenderer.isZoomXEnabled() && (i == 1 || i == 0))
                {
                    setXRange(d1 - d13 / 2D, d1 + d13 / 2D, k);
                }
                if (mRenderer.isZoomYEnabled() && (i == 2 || i == 0))
                {
                    setYRange(d2 - d14 / 2D, d2 + d14 / 2D, k);
                }
                k++;
            }
        } else
        {
            defaultrenderer = ((RoundChart)mChart).getRenderer();
            if (a)
            {
                defaultrenderer.setScale(defaultrenderer.getScale() * b);
            } else
            {
                defaultrenderer.setScale(defaultrenderer.getScale() / b);
            }
        }
        a(new ZoomEvent(a, b));
    }

    public void notifyZoomResetListeners()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((ZoomListener)iterator.next()).zoomReset()) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void removeZoomListener(ZoomListener zoomlistener)
    {
        this;
        JVM INSTR monitorenter ;
        c.remove(zoomlistener);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setZoomRate(float f)
    {
        b = f;
    }
}
