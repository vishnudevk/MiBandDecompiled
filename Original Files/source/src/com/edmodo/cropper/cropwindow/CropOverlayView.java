// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import cn.com.smartdevices.bracelet.Debug;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.handle.Handle;
import com.edmodo.cropper.util.AspectRatioUtil;
import com.edmodo.cropper.util.HandleUtil;
import com.edmodo.cropper.util.PaintUtil;

public class CropOverlayView extends View
{

    public static final float DEFAULT_SHOW_GUIDELINES_LIMIT = 100F;
    private static final int a = 6;
    private static final float b = 0F;
    private static final float c = 0F;
    private static final float d = 0F;
    private static final float e = 0F;
    private static final float f = 20F;
    private static final int g = 0;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 0xb0000000;
    private static final int k = 1;
    private static final int l = 2;
    private static final String m = "CropOverlayView";
    private int A;
    private boolean B;
    private float C;
    private float D;
    private float E;
    private int F;
    private Paint n;
    private Paint o;
    private Paint p;
    private Paint q;
    private Rect r;
    private float s;
    private float t;
    private Pair u;
    private Handle v;
    private boolean w;
    private int x;
    private int y;
    private float z;

    public CropOverlayView(Context context)
    {
        super(context);
        w = false;
        x = 1;
        y = 1;
        z = (float)x / (float)y;
        B = false;
        a(context);
    }

    public CropOverlayView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        w = false;
        x = 1;
        y = 1;
        z = (float)x / (float)y;
        B = false;
        a(context);
    }

    private void a()
    {
        if (v == null)
        {
            return;
        } else
        {
            v = null;
            invalidate();
            return;
        }
    }

    private void a(float f1, float f2)
    {
        float f3 = Edge.LEFT.getCoordinate();
        float f4 = Edge.TOP.getCoordinate();
        float f5 = Edge.RIGHT.getCoordinate();
        float f6 = Edge.BOTTOM.getCoordinate();
        v = HandleUtil.getPressedHandle(f1, f2, f3, f4, f5, f6, s);
        if (v == null)
        {
            return;
        } else
        {
            u = HandleUtil.getOffset(v, f1, f2, f3, f4, f5, f6);
            invalidate();
            return;
        }
    }

    private void a(Context context)
    {
        F = 1;
        android.util.DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        s = HandleUtil.getTargetRadius(context);
        t = TypedValue.applyDimension(1, 6F, displaymetrics);
        n = PaintUtil.newBorderPaint(context);
        o = PaintUtil.newGuidelinePaint();
        q = PaintUtil.newBackgroundPaint(context);
        p = PaintUtil.newCornerPaint(context);
        D = -TypedValue.applyDimension(1, d, displaymetrics);
        C = -D;
        E = TypedValue.applyDimension(1, 20F, displaymetrics);
        A = 1;
    }

    private void a(Canvas canvas)
    {
        float f1 = Edge.LEFT.getCoordinate();
        float f2 = Edge.TOP.getCoordinate();
        float f3 = Edge.RIGHT.getCoordinate();
        float f4 = Edge.BOTTOM.getCoordinate();
        float f5 = Edge.getWidth() / 3F;
        float f6 = f1 + f5;
        canvas.drawLine(f6, f2, f6, f4, o);
        float f7 = f3 - f5;
        canvas.drawLine(f7, f2, f7, f4, o);
        float f8 = Edge.getHeight() / 3F;
        float f9 = f2 + f8;
        canvas.drawLine(f1, f9, f3, f9, o);
        float f10 = f4 - f8;
        canvas.drawLine(f1, f10, f3, f10, o);
    }

    private void a(Canvas canvas, Rect rect)
    {
        float f1;
        float f2;
        float f3;
        float f4;
        f1 = Edge.LEFT.getCoordinate();
        f2 = Edge.TOP.getCoordinate();
        f3 = Edge.RIGHT.getCoordinate();
        f4 = Edge.BOTTOM.getCoordinate();
        canvas.save();
        setLayerType(1, null);
        canvas.clipRect(new RectF(rect.left, rect.top, rect.right, rect.bottom));
        if (F != 1) goto _L2; else goto _L1
_L1:
        Path path = new Path();
        path.addCircle(f1 + (f3 - f1) / 2.0F, f2 + (f4 - f2) / 2.0F, (f4 - f2) / 2.0F - n.getStrokeWidth(), android.graphics.Path.Direction.CW);
        canvas.clipPath(path, android.graphics.Region.Op.DIFFERENCE);
_L4:
        canvas.drawColor(0xb0000000);
        canvas.restore();
        return;
_L2:
        if (F == 2)
        {
            canvas.clipRect(f1, f2, f3, f4, android.graphics.Region.Op.DIFFERENCE);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Rect rect)
    {
        if ((rect.right - rect.left) * (rect.bottom - rect.top) <= 0)
        {
            Debug.i("CropOverlayView", "initCropWindow skipped 'cause bitmapRect is empty");
            return;
        }
        if (!B)
        {
            B = true;
        }
        if (w)
        {
            if (AspectRatioUtil.calculateAspectRatio(rect) > z)
            {
                Edge.TOP.setCoordinate(rect.top);
                Edge.BOTTOM.setCoordinate(rect.bottom);
                float f6 = (float)getWidth() / 2.0F;
                float f7 = Math.max(60F, AspectRatioUtil.calculateWidth(Edge.TOP.getCoordinate(), Edge.BOTTOM.getCoordinate(), z));
                if (f7 == 60F)
                {
                    z = 60F / (Edge.BOTTOM.getCoordinate() - Edge.TOP.getCoordinate());
                }
                float f8 = f7 / 2.0F;
                Edge.LEFT.setCoordinate(f6 - f8);
                Edge.RIGHT.setCoordinate(f6 + f8);
                return;
            }
            Edge.LEFT.setCoordinate(rect.left);
            Edge.RIGHT.setCoordinate(rect.right);
            float f3 = (float)getHeight() / 2.0F;
            float f4 = Math.max(60F, AspectRatioUtil.calculateHeight(Edge.LEFT.getCoordinate(), Edge.RIGHT.getCoordinate(), z));
            if (f4 == 60F)
            {
                z = (Edge.RIGHT.getCoordinate() - Edge.LEFT.getCoordinate()) / 60F;
            }
            float f5 = f4 / 2.0F;
            Edge.TOP.setCoordinate(f3 - f5);
            Edge.BOTTOM.setCoordinate(f3 + f5);
            return;
        } else
        {
            float f1 = 0.1F * (float)rect.width();
            float f2 = 0.1F * (float)rect.height();
            Edge.LEFT.setCoordinate(f1 + (float)rect.left);
            Edge.TOP.setCoordinate(f2 + (float)rect.top);
            Edge.RIGHT.setCoordinate((float)rect.right - f1);
            Edge.BOTTOM.setCoordinate((float)rect.bottom - f2);
            return;
        }
    }

    private void b(float f1, float f2)
    {
        if (v == null)
        {
            return;
        }
        float f3 = f1 + ((Float)u.first).floatValue();
        float f4 = f2 + ((Float)u.second).floatValue();
        if (w)
        {
            v.updateCropWindow(f3, f4, z, r, t);
        } else
        {
            v.updateCropWindow(f3, f4, r, t);
        }
        invalidate();
    }

    private void b(Canvas canvas)
    {
        float f1 = Edge.LEFT.getCoordinate();
        float f2 = Edge.TOP.getCoordinate();
        float f3 = Edge.RIGHT.getCoordinate();
        float f4 = Edge.BOTTOM.getCoordinate();
        canvas.drawLine(f1 - D, f2 - C, f1 - D, f2 + E, p);
        canvas.drawLine(f1, f2 - D, f1 + E, f2 - D, p);
        canvas.drawLine(f3 + D, f2 - C, f3 + D, f2 + E, p);
        canvas.drawLine(f3, f2 - D, f3 - E, f2 - D, p);
        canvas.drawLine(f1 - D, f4 + C, f1 - D, f4 - E, p);
        canvas.drawLine(f1, f4 + D, f1 + E, f4 + D, p);
        canvas.drawLine(f3 + D, f4 + C, f3 + D, f4 - E, p);
        canvas.drawLine(f3, f4 + D, f3 - E, f4 + D, p);
    }

    public static boolean showGuidelines()
    {
        return Math.abs(Edge.LEFT.getCoordinate() - Edge.RIGHT.getCoordinate()) >= 100F && Math.abs(Edge.TOP.getCoordinate() - Edge.BOTTOM.getCoordinate()) >= 100F;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        float f1 = Edge.LEFT.getCoordinate();
        float f2 = Edge.TOP.getCoordinate();
        float f3 = Edge.RIGHT.getCoordinate();
        float f4 = Edge.BOTTOM.getCoordinate();
        a(canvas, r);
        if (showGuidelines())
        {
            if (A == 2)
            {
                a(canvas);
            } else
            if (A == 1)
            {
                if (v != null)
                {
                    a(canvas);
                }
            } else
            if (A != 0);
        }
        if (F == 2)
        {
            canvas.drawRect(f1, f2, f3, f4, n);
        } else
        {
            canvas.drawCircle(f1 + (f3 - f1) / 2.0F, f2 + (f4 - f2) / 2.0F, (f4 - f2) / 2.0F - n.getStrokeWidth(), n);
        }
        b(canvas);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        a(r);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!isEnabled())
        {
            return false;
        }
        switch (motionevent.getAction())
        {
        default:
            return false;

        case 0: // '\0'
            a(motionevent.getX(), motionevent.getY());
            return true;

        case 1: // '\001'
        case 3: // '\003'
            getParent().requestDisallowInterceptTouchEvent(false);
            a();
            return true;

        case 2: // '\002'
            b(motionevent.getX(), motionevent.getY());
            break;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public void resetCropOverlayView()
    {
        if (B)
        {
            a(r);
            invalidate();
        }
    }

    public void setAspectRatioX(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        x = i1;
        z = (float)x / (float)y;
        if (B)
        {
            a(r);
            invalidate();
        }
    }

    public void setAspectRatioY(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        y = i1;
        z = (float)x / (float)y;
        if (B)
        {
            a(r);
            invalidate();
        }
    }

    public void setBitmapRect(Rect rect)
    {
        r = rect;
        a(r);
    }

    public void setFixedAspectRatio(boolean flag)
    {
        w = flag;
        if (B)
        {
            a(r);
            invalidate();
        }
    }

    public void setGuidelines(int i1)
    {
        if (i1 < 0 || i1 > 2)
        {
            throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation.");
        }
        A = i1;
        if (B)
        {
            a(r);
            invalidate();
        }
    }

    public void setInitialAttributeValues(int i1, boolean flag, int j1, int k1)
    {
        if (i1 < 0 || i1 > 2)
        {
            throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation.");
        }
        A = i1;
        w = flag;
        if (j1 <= 0)
        {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        x = j1;
        z = (float)x / (float)y;
        if (k1 <= 0)
        {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else
        {
            y = k1;
            z = (float)x / (float)y;
            return;
        }
    }

    static 
    {
        b = PaintUtil.getCornerThickness();
        c = PaintUtil.getLineThickness();
        d = b / 2.0F - c / 2.0F;
        e = b / 2.0F + d;
    }
}
