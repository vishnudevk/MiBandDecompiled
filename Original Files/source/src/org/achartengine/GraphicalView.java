// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.tools.FitZoom;
import org.achartengine.tools.PanListener;
import org.achartengine.tools.Zoom;
import org.achartengine.tools.ZoomListener;

// Referenced classes of package org.achartengine:
//            TouchHandlerOld, TouchHandler, ITouchHandler, a, 
//            b

public class GraphicalView extends View
{

    private static final int j = Color.argb(175, 150, 150, 150);
    private AbstractChart a;
    private DefaultRenderer b;
    private Rect c;
    private Handler d;
    private RectF e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private int i;
    private Zoom k;
    private Zoom l;
    private FitZoom m;
    private Paint n;
    private ITouchHandler o;
    private float p;
    private float q;
    private boolean r;

    public GraphicalView(Context context, AbstractChart abstractchart)
    {
        int i1;
        super(context);
        c = new Rect();
        e = new RectF();
        i = 50;
        n = new Paint();
        a = abstractchart;
        d = new Handler();
        int j1;
        if (a instanceof XYChart)
        {
            b = ((XYChart)a).getRenderer();
        } else
        {
            b = ((RoundChart)a).getRenderer();
        }
        if (b.isZoomButtonsVisible())
        {
            f = BitmapFactory.decodeStream(org/achartengine/GraphicalView.getResourceAsStream("image/zoom_in.png"));
            g = BitmapFactory.decodeStream(org/achartengine/GraphicalView.getResourceAsStream("image/zoom_out.png"));
            h = BitmapFactory.decodeStream(org/achartengine/GraphicalView.getResourceAsStream("image/zoom-1.png"));
        }
        if ((b instanceof XYMultipleSeriesRenderer) && ((XYMultipleSeriesRenderer)b).getMarginsColor() == 0)
        {
            ((XYMultipleSeriesRenderer)b).setMarginsColor(n.getColor());
        }
        if (b.isZoomEnabled() && b.isZoomButtonsVisible() || b.isExternalZoomEnabled())
        {
            k = new Zoom(a, true, b.getZoomRate());
            l = new Zoom(a, false, b.getZoomRate());
            m = new FitZoom(a);
        }
        j1 = Integer.valueOf(android.os.Build.VERSION.SDK).intValue();
        i1 = j1;
_L1:
        Exception exception;
        if (i1 < 7)
        {
            o = new TouchHandlerOld(this, a);
            return;
        } else
        {
            o = new TouchHandler(this, a);
            return;
        }
        exception;
        i1 = 7;
          goto _L1
    }

    public void addPanListener(PanListener panlistener)
    {
        o.addPanListener(panlistener);
    }

    public void addZoomListener(ZoomListener zoomlistener, boolean flag, boolean flag1)
    {
        if (flag)
        {
            if (k != null)
            {
                k.addZoomListener(zoomlistener);
                l.addZoomListener(zoomlistener);
            }
            if (flag1)
            {
                o.addZoomListener(zoomlistener);
            }
        }
    }

    public SeriesSelection getCurrentSeriesAndPoint()
    {
        return a.getSeriesAndPointForScreenCoordinate(new Point(p, q));
    }

    protected RectF getZoomRectangle()
    {
        return e;
    }

    protected void onDraw(Canvas canvas)
    {
        int i1 = 0;
        super.onDraw(canvas);
        canvas.getClipBounds(c);
        int j1 = c.top;
        int k1 = c.left;
        int l1 = c.width();
        int i2 = c.height();
        if (b.isInScroll())
        {
            l1 = getMeasuredWidth();
            i2 = getMeasuredHeight();
            j1 = 0;
        } else
        {
            i1 = k1;
        }
        a.draw(canvas, i1, j1, l1, i2, n);
        if (b != null && b.isZoomEnabled() && b.isZoomButtonsVisible())
        {
            n.setColor(j);
            i = Math.max(i, Math.min(l1, i2) / 7);
            e.set((i1 + l1) - 3 * i, (float)(j1 + i2) - 0.775F * (float)i, i1 + l1, j1 + i2);
            canvas.drawRoundRect(e, i / 3, i / 3, n);
            float f1 = (float)(j1 + i2) - 0.625F * (float)i;
            canvas.drawBitmap(f, (float)(i1 + l1) - 2.75F * (float)i, f1, null);
            canvas.drawBitmap(g, (float)(i1 + l1) - 1.75F * (float)i, f1, null);
            canvas.drawBitmap(h, (float)(i1 + l1) - 0.75F * (float)i, f1, null);
        }
        r = true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            p = motionevent.getX();
            q = motionevent.getY();
        }
        if (b != null && r && (b.isPanEnabled() || b.isZoomEnabled()) && o.handleTouch(motionevent))
        {
            return true;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void removePanListener(PanListener panlistener)
    {
        o.removePanListener(panlistener);
    }

    public void removeZoomListener(ZoomListener zoomlistener)
    {
        this;
        JVM INSTR monitorenter ;
        if (k != null)
        {
            k.removeZoomListener(zoomlistener);
            l.removeZoomListener(zoomlistener);
        }
        o.removeZoomListener(zoomlistener);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void repaint()
    {
        d.post(new a(this));
    }

    public void repaint(int i1, int j1, int k1, int l1)
    {
        d.post(new b(this, i1, j1, k1, l1));
    }

    public void setZoomRate(float f1)
    {
        if (k != null && l != null)
        {
            k.setZoomRate(f1);
            l.setZoomRate(f1);
        }
    }

    public Bitmap toBitmap()
    {
        setDrawingCacheEnabled(false);
        if (!isDrawingCacheEnabled())
        {
            setDrawingCacheEnabled(true);
        }
        if (b.isApplyBackgroundColor())
        {
            setDrawingCacheBackgroundColor(b.getBackgroundColor());
        }
        setDrawingCacheQuality(0x100000);
        return getDrawingCache(true);
    }

    public double[] toRealPoint(int i1)
    {
        if (a instanceof XYChart)
        {
            return ((XYChart)a).toRealPoint(p, q, i1);
        } else
        {
            return null;
        }
    }

    public void zoomIn()
    {
        if (k != null)
        {
            k.apply(0);
            repaint();
        }
    }

    public void zoomOut()
    {
        if (l != null)
        {
            l.apply(0);
            repaint();
        }
    }

    public void zoomReset()
    {
        if (m != null)
        {
            m.apply();
            k.notifyZoomResetListeners();
            repaint();
        }
    }

}
