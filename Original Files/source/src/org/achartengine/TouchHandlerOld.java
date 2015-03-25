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
import org.achartengine.tools.ZoomListener;

// Referenced classes of package org.achartengine:
//            ITouchHandler, GraphicalView

public class TouchHandlerOld
    implements ITouchHandler
{

    private DefaultRenderer a;
    private float b;
    private float c;
    private RectF d;
    private Pan e;
    private GraphicalView f;

    public TouchHandlerOld(GraphicalView graphicalview, AbstractChart abstractchart)
    {
        d = new RectF();
        f = graphicalview;
        d = f.getZoomRectangle();
        if (abstractchart instanceof XYChart)
        {
            a = ((XYChart)abstractchart).getRenderer();
        } else
        {
            a = ((RoundChart)abstractchart).getRenderer();
        }
        if (a.isPanEnabled())
        {
            e = new Pan(abstractchart);
        }
    }

    public void addPanListener(PanListener panlistener)
    {
        if (e != null)
        {
            e.addPanListener(panlistener);
        }
    }

    public void addZoomListener(ZoomListener zoomlistener)
    {
    }

    public boolean handleTouch(MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (a == null || i != 2) goto _L2; else goto _L1
_L1:
        if (b < 0.0F && c < 0.0F) goto _L4; else goto _L3
_L3:
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        if (a.isPanEnabled())
        {
            e.apply(b, c, f1, f2);
        }
        b = f1;
        c = f2;
        f.repaint();
_L6:
        return true;
_L2:
        if (i == 0)
        {
            b = motionevent.getX();
            c = motionevent.getY();
            if (a != null && a.isZoomEnabled() && d.contains(b, c))
            {
                if (b < d.left + d.width() / 3F)
                {
                    f.zoomIn();
                    return true;
                }
                if (b < d.left + (2.0F * d.width()) / 3F)
                {
                    f.zoomOut();
                    return true;
                } else
                {
                    f.zoomReset();
                    return true;
                }
            }
        } else
        if (i == 1)
        {
            b = 0.0F;
            c = 0.0F;
        }
_L4:
        if (a.isClickEnabled())
        {
            return false;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void removePanListener(PanListener panlistener)
    {
        if (e != null)
        {
            e.removePanListener(panlistener);
        }
    }

    public void removeZoomListener(ZoomListener zoomlistener)
    {
    }
}
