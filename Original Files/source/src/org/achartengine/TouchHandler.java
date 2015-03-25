// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine;

import android.graphics.RectF;
import android.view.MotionEvent;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.tools.Pan;
import org.achartengine.tools.PanListener;
import org.achartengine.tools.Zoom;
import org.achartengine.tools.ZoomListener;

// Referenced classes of package org.achartengine:
//            ITouchHandler, GraphicalView

public class TouchHandler
    implements ITouchHandler
{

    private DefaultRenderer a;
    private float b;
    private float c;
    private float d;
    private float e;
    private RectF f;
    private Pan g;
    private Zoom h;
    private GraphicalView i;

    public TouchHandler(GraphicalView graphicalview, AbstractChart abstractchart)
    {
        f = new RectF();
        i = graphicalview;
        f = i.getZoomRectangle();
        if (abstractchart instanceof XYChart)
        {
            a = ((XYChart)abstractchart).getRenderer();
        } else
        {
            a = ((RoundChart)abstractchart).getRenderer();
        }
        if (a.isPanEnabled())
        {
            g = new Pan(abstractchart);
        }
        if (a.isZoomEnabled())
        {
            h = new Zoom(abstractchart, true, 1.0F);
        }
    }

    private void a(float f1, int j)
    {
        float f2 = Math.min(Math.max(f1, 0.9F), 1.1F);
        if ((double)f2 > 0.90000000000000002D && (double)f2 < 1.1000000000000001D)
        {
            h.setZoomRate(f2);
            h.apply(j);
        }
    }

    public void addPanListener(PanListener panlistener)
    {
        if (g != null)
        {
            g.addPanListener(panlistener);
        }
    }

    public void addZoomListener(ZoomListener zoomlistener)
    {
        if (h != null)
        {
            h.addZoomListener(zoomlistener);
        }
    }

    public boolean handleTouch(MotionEvent motionevent)
    {
        int j = motionevent.getAction();
        if (a == null || j != 2) goto _L2; else goto _L1
_L1:
        if (b < 0.0F && c < 0.0F) goto _L4; else goto _L3
_L3:
        float f1;
        float f2;
        f1 = motionevent.getX(0);
        f2 = motionevent.getY(0);
        if (motionevent.getPointerCount() <= 1 || d < 0.0F && e < 0.0F || !a.isZoomEnabled()) goto _L6; else goto _L5
_L5:
        float f3 = motionevent.getX(1);
        float f4 = motionevent.getY(1);
        float f5 = Math.abs(f1 - f3);
        float f6 = Math.abs(f2 - f4);
        float f7 = Math.abs(b - d);
        float f8 = Math.abs(c - e);
        float f9 = Math.abs(f2 - c) / Math.abs(f1 - b);
        float f10 = Math.abs(f4 - e) / Math.abs(f3 - d);
        if ((double)f9 <= 0.25D && (double)f10 <= 0.25D)
        {
            a(f5 / f7, 1);
        } else
        if ((double)f9 >= 3.73D && (double)f10 >= 3.73D)
        {
            a(f6 / f8, 2);
        } else
        {
            float f11;
            if (Math.abs(f1 - b) >= Math.abs(f2 - c))
            {
                f11 = f5 / f7;
            } else
            {
                f11 = f6 / f8;
            }
            a(f11, 0);
        }
_L9:
        d = f3;
        e = f4;
_L7:
        b = f1;
        c = f2;
        i.repaint();
        return true;
_L6:
        if (a.isPanEnabled())
        {
            g.apply(b, c, f1, f2);
            d = 0.0F;
            e = 0.0F;
        }
        if (true) goto _L7; else goto _L2
_L2:
        if (j == 0)
        {
            b = motionevent.getX(0);
            c = motionevent.getY(0);
            if (a != null && a.isZoomEnabled() && f.contains(b, c))
            {
                if (b < f.left + f.width() / 3F)
                {
                    i.zoomIn();
                } else
                if (b < f.left + (2.0F * f.width()) / 3F)
                {
                    i.zoomOut();
                } else
                {
                    i.zoomReset();
                }
                return true;
            }
        } else
        if (j == 1 || j == 6)
        {
            b = 0.0F;
            c = 0.0F;
            d = 0.0F;
            e = 0.0F;
            if (j == 6)
            {
                b = -1F;
                c = -1F;
            }
        }
_L4:
        if (!a.isClickEnabled())
        {
            return true;
        }
        return false;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void removePanListener(PanListener panlistener)
    {
        if (g != null)
        {
            g.removePanListener(panlistener);
        }
    }

    public void removeZoomListener(ZoomListener zoomlistener)
    {
        if (h != null)
        {
            h.removeZoomListener(zoomlistener);
        }
    }
}
