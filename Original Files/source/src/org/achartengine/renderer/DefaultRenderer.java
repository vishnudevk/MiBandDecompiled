// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.renderer;

import android.graphics.Typeface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package org.achartengine.renderer:
//            SimpleSeriesRenderer

public class DefaultRenderer
    implements Serializable
{

    public static final int BACKGROUND_COLOR = 0xff000000;
    public static final int NO_COLOR = 0;
    public static final int TEXT_COLOR = 0xffcccccc;
    private static final Typeface c;
    private boolean A;
    private float B;
    private boolean C;
    private float D;
    private boolean E;
    private int F;
    private boolean G;
    private boolean H;
    private float I;
    private String a;
    private float b;
    private String d;
    private int e;
    private Typeface f;
    private int g;
    private boolean h;
    private boolean i;
    private int j;
    private boolean k;
    private int l;
    private float m;
    private boolean n;
    private float o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private List t;
    private boolean u;
    private int v;
    private int w[] = {
        20, 30, 10, 20
    };
    private float x;
    private boolean y;
    private boolean z;

    public DefaultRenderer()
    {
        a = "";
        b = 15F;
        d = c.toString();
        e = 0;
        i = true;
        j = 0xffcccccc;
        k = true;
        l = 0xffcccccc;
        m = 10F;
        n = true;
        o = 12F;
        p = false;
        q = false;
        r = false;
        s = false;
        t = new ArrayList();
        u = true;
        v = 0;
        x = 1.0F;
        y = true;
        z = true;
        A = false;
        B = 1.5F;
        C = false;
        D = x;
        E = false;
        F = 15;
        I = 0.0F;
    }

    public void addSeriesRenderer(int i1, SimpleSeriesRenderer simpleseriesrenderer)
    {
        t.add(i1, simpleseriesrenderer);
    }

    public void addSeriesRenderer(SimpleSeriesRenderer simpleseriesrenderer)
    {
        t.add(simpleseriesrenderer);
    }

    public int getAxesColor()
    {
        return j;
    }

    public int getBackgroundColor()
    {
        return g;
    }

    public String getChartTitle()
    {
        return a;
    }

    public float getChartTitleTextSize()
    {
        return b;
    }

    public int getLabelsColor()
    {
        return l;
    }

    public float getLabelsTextSize()
    {
        return m;
    }

    public int getLegendHeight()
    {
        return v;
    }

    public float getLegendTextSize()
    {
        return o;
    }

    public int[] getMargins()
    {
        return w;
    }

    public float getOriginalScale()
    {
        return D;
    }

    public float getScale()
    {
        return x;
    }

    public int getSelectableBuffer()
    {
        return F;
    }

    public SimpleSeriesRenderer getSeriesRendererAt(int i1)
    {
        return (SimpleSeriesRenderer)t.get(i1);
    }

    public int getSeriesRendererCount()
    {
        return t.size();
    }

    public SimpleSeriesRenderer[] getSeriesRenderers()
    {
        return (SimpleSeriesRenderer[])t.toArray(new SimpleSeriesRenderer[0]);
    }

    public float getStartAngle()
    {
        return I;
    }

    public Typeface getTextTypeface()
    {
        return f;
    }

    public String getTextTypefaceName()
    {
        return d;
    }

    public int getTextTypefaceStyle()
    {
        return e;
    }

    public float getZoomRate()
    {
        return B;
    }

    public boolean isAntialiasing()
    {
        return u;
    }

    public boolean isApplyBackgroundColor()
    {
        return h;
    }

    public boolean isClickEnabled()
    {
        return E;
    }

    public boolean isDisplayValues()
    {
        return G;
    }

    public boolean isExternalZoomEnabled()
    {
        return C;
    }

    public boolean isFitLegend()
    {
        return p;
    }

    public boolean isInScroll()
    {
        return H;
    }

    public boolean isPanEnabled()
    {
        return y;
    }

    public boolean isShowAxes()
    {
        return i;
    }

    public boolean isShowCustomTextGrid()
    {
        return s;
    }

    public boolean isShowGridX()
    {
        return q;
    }

    public boolean isShowGridY()
    {
        return r;
    }

    public boolean isShowLabels()
    {
        return k;
    }

    public boolean isShowLegend()
    {
        return n;
    }

    public boolean isZoomButtonsVisible()
    {
        return A;
    }

    public boolean isZoomEnabled()
    {
        return z;
    }

    public void removeAllRenderers()
    {
        t.clear();
    }

    public void removeSeriesRenderer(SimpleSeriesRenderer simpleseriesrenderer)
    {
        t.remove(simpleseriesrenderer);
    }

    public void setAntialiasing(boolean flag)
    {
        u = flag;
    }

    public void setApplyBackgroundColor(boolean flag)
    {
        h = flag;
    }

    public void setAxesColor(int i1)
    {
        j = i1;
    }

    public void setBackgroundColor(int i1)
    {
        g = i1;
    }

    public void setChartTitle(String s1)
    {
        a = s1;
    }

    public void setChartTitleTextSize(float f1)
    {
        b = f1;
    }

    public void setClickEnabled(boolean flag)
    {
        E = flag;
    }

    public void setDisplayValues(boolean flag)
    {
        G = flag;
    }

    public void setExternalZoomEnabled(boolean flag)
    {
        C = flag;
    }

    public void setFitLegend(boolean flag)
    {
        p = flag;
    }

    public void setInScroll(boolean flag)
    {
        H = flag;
    }

    public void setLabelsColor(int i1)
    {
        l = i1;
    }

    public void setLabelsTextSize(float f1)
    {
        m = f1;
    }

    public void setLegendHeight(int i1)
    {
        v = i1;
    }

    public void setLegendTextSize(float f1)
    {
        o = f1;
    }

    public void setMargins(int ai[])
    {
        w = ai;
    }

    public void setPanEnabled(boolean flag)
    {
        y = flag;
    }

    public void setScale(float f1)
    {
        x = f1;
    }

    public void setSelectableBuffer(int i1)
    {
        F = i1;
    }

    public void setShowAxes(boolean flag)
    {
        i = flag;
    }

    public void setShowCustomTextGrid(boolean flag)
    {
        s = flag;
    }

    public void setShowGrid(boolean flag)
    {
        setShowGridX(flag);
        setShowGridY(flag);
    }

    public void setShowGridX(boolean flag)
    {
        q = flag;
    }

    public void setShowGridY(boolean flag)
    {
        r = flag;
    }

    public void setShowLabels(boolean flag)
    {
        k = flag;
    }

    public void setShowLegend(boolean flag)
    {
        n = flag;
    }

    public void setStartAngle(float f1)
    {
        I = f1;
    }

    public void setTextTypeface(Typeface typeface)
    {
        f = typeface;
    }

    public void setTextTypeface(String s1, int i1)
    {
        d = s1;
        e = i1;
    }

    public void setZoomButtonsVisible(boolean flag)
    {
        A = flag;
    }

    public void setZoomEnabled(boolean flag)
    {
        z = flag;
    }

    public void setZoomRate(float f1)
    {
        B = f1;
    }

    static 
    {
        c = Typeface.create(Typeface.SERIF, 0);
    }
}
