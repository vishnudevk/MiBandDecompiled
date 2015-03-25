// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.renderer;

import android.graphics.Color;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// Referenced classes of package org.achartengine.renderer:
//            DefaultRenderer, SimpleSeriesRenderer

public class XYMultipleSeriesRenderer extends DefaultRenderer
{

    private android.graphics.Paint.Align A;
    private android.graphics.Paint.Align B[];
    private float C;
    private float D;
    private float E;
    private android.graphics.Paint.Align F[];
    private int G;
    private int H[] = {
        0xffcccccc
    };
    private boolean I;
    private NumberFormat J;
    private float K;
    private double L;
    private double M;
    private String a;
    private String b[];
    private float c;
    private double d[];
    private double e[];
    private double f[];
    private double g[];
    private int h;
    private int i;
    private Orientation j;
    private Map k;
    private Map l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private double q;
    private int r;
    private double s[];
    private double t[];
    private float u;
    private float v;
    private Map w;
    private float x;
    private int y;
    private int z;

    public XYMultipleSeriesRenderer()
    {
        this(1);
    }

    public XYMultipleSeriesRenderer(int i1)
    {
        a = "";
        c = 12F;
        h = 5;
        i = 5;
        j = Orientation.HORIZONTAL;
        k = new HashMap();
        l = new LinkedHashMap();
        m = true;
        n = true;
        o = true;
        p = true;
        q = 0.0D;
        r = 0;
        w = new LinkedHashMap();
        x = 3F;
        y = Color.argb(75, 200, 200, 200);
        A = android.graphics.Paint.Align.CENTER;
        C = 0.0F;
        D = 0.0F;
        E = 2.0F;
        G = 0xffcccccc;
        I = true;
        K = -1F;
        L = 0.0D;
        M = 0.0D;
        z = i1;
        initAxesRange(i1);
    }

    public void addTextLabel(double d1, String s1)
    {
        addXTextLabel(d1, s1);
    }

    public void addXTextLabel(double d1, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        k.put(Double.valueOf(d1), s1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void addYTextLabel(double d1, String s1)
    {
        addYTextLabel(d1, s1, 0);
    }

    public void addYTextLabel(double d1, String s1, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        ((Map)l.get(Integer.valueOf(i1))).put(Double.valueOf(d1), s1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void clearTextLabels()
    {
        clearXTextLabels();
    }

    public void clearXTextLabels()
    {
        this;
        JVM INSTR monitorenter ;
        k.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void clearYTextLabels()
    {
        clearYTextLabels(0);
    }

    public void clearYTextLabels(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        ((Map)l.get(Integer.valueOf(i1))).clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public float getAxisTitleTextSize()
    {
        return c;
    }

    public double getBarSpacing()
    {
        return q;
    }

    public float getBarWidth()
    {
        return K;
    }

    public double getBarsSpacing()
    {
        return getBarSpacing();
    }

    public int getGridColor()
    {
        return y;
    }

    public double[] getInitialRange()
    {
        return getInitialRange(0);
    }

    public double[] getInitialRange(int i1)
    {
        return (double[])w.get(Integer.valueOf(i1));
    }

    public NumberFormat getLabelFormat()
    {
        return J;
    }

    public int getMarginsColor()
    {
        return r;
    }

    public Orientation getOrientation()
    {
        return j;
    }

    public double[] getPanLimits()
    {
        return s;
    }

    public float getPointSize()
    {
        return x;
    }

    public int getScalesCount()
    {
        return z;
    }

    public double getXAxisMax()
    {
        return getXAxisMax(0);
    }

    public double getXAxisMax(int i1)
    {
        return e[i1];
    }

    public double getXAxisMin()
    {
        return getXAxisMin(0);
    }

    public double getXAxisMin(int i1)
    {
        return d[i1];
    }

    public int getXLabels()
    {
        return h;
    }

    public android.graphics.Paint.Align getXLabelsAlign()
    {
        return A;
    }

    public float getXLabelsAngle()
    {
        return u;
    }

    public int getXLabelsColor()
    {
        return G;
    }

    public float getXLabelsPadding()
    {
        return C;
    }

    public String getXTextLabel(Double double1)
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = (String)k.get(double1);
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public Double[] getXTextLabelLocations()
    {
        this;
        JVM INSTR monitorenter ;
        Double adouble[] = (Double[])k.keySet().toArray(new Double[0]);
        this;
        JVM INSTR monitorexit ;
        return adouble;
        Exception exception;
        exception;
        throw exception;
    }

    public String getXTitle()
    {
        return a;
    }

    public android.graphics.Paint.Align getYAxisAlign(int i1)
    {
        return F[i1];
    }

    public double getYAxisMax()
    {
        return getYAxisMax(0);
    }

    public double getYAxisMax(int i1)
    {
        return g[i1];
    }

    public double getYAxisMin()
    {
        return getYAxisMin(0);
    }

    public double getYAxisMin(int i1)
    {
        return f[i1];
    }

    public int getYLabels()
    {
        return i;
    }

    public android.graphics.Paint.Align getYLabelsAlign(int i1)
    {
        return B[i1];
    }

    public float getYLabelsAngle()
    {
        return v;
    }

    public int getYLabelsColor(int i1)
    {
        return H[i1];
    }

    public float getYLabelsPadding()
    {
        return D;
    }

    public float getYLabelsVerticalPadding()
    {
        return E;
    }

    public String getYTextLabel(Double double1)
    {
        return getYTextLabel(double1, 0);
    }

    public String getYTextLabel(Double double1, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = (String)((Map)l.get(Integer.valueOf(i1))).get(double1);
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public Double[] getYTextLabelLocations()
    {
        return getYTextLabelLocations(0);
    }

    public Double[] getYTextLabelLocations(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        Double adouble[] = (Double[])((Map)l.get(Integer.valueOf(i1))).keySet().toArray(new Double[0]);
        this;
        JVM INSTR monitorexit ;
        return adouble;
        Exception exception;
        exception;
        throw exception;
    }

    public String getYTitle()
    {
        return getYTitle(0);
    }

    public String getYTitle(int i1)
    {
        return b[i1];
    }

    public double getZoomInLimitX()
    {
        return L;
    }

    public double getZoomInLimitY()
    {
        return M;
    }

    public double[] getZoomLimits()
    {
        return t;
    }

    public void initAxesRange(int i1)
    {
        b = new String[i1];
        B = new android.graphics.Paint.Align[i1];
        F = new android.graphics.Paint.Align[i1];
        H = new int[i1];
        d = new double[i1];
        e = new double[i1];
        f = new double[i1];
        g = new double[i1];
        for (int j1 = 0; j1 < i1; j1++)
        {
            H[j1] = 0xffcccccc;
            initAxesRangeForScale(j1);
        }

    }

    public void initAxesRangeForScale(int i1)
    {
        d[i1] = 1.7976931348623157E+308D;
        e[i1] = -1.7976931348623157E+308D;
        f[i1] = 1.7976931348623157E+308D;
        g[i1] = -1.7976931348623157E+308D;
        double ad[] = new double[4];
        ad[0] = d[i1];
        ad[1] = e[i1];
        ad[2] = f[i1];
        ad[3] = g[i1];
        w.put(Integer.valueOf(i1), ad);
        b[i1] = "";
        l.put(Integer.valueOf(i1), new HashMap());
        B[i1] = android.graphics.Paint.Align.CENTER;
        F[i1] = android.graphics.Paint.Align.LEFT;
    }

    public boolean isInitialRangeSet()
    {
        return isInitialRangeSet(0);
    }

    public boolean isInitialRangeSet(int i1)
    {
        return w.get(Integer.valueOf(i1)) != null;
    }

    public boolean isMaxXSet()
    {
        return isMaxXSet(0);
    }

    public boolean isMaxXSet(int i1)
    {
        return e[i1] != -1.7976931348623157E+308D;
    }

    public boolean isMaxYSet()
    {
        return isMaxYSet(0);
    }

    public boolean isMaxYSet(int i1)
    {
        return g[i1] != -1.7976931348623157E+308D;
    }

    public boolean isMinXSet()
    {
        return isMinXSet(0);
    }

    public boolean isMinXSet(int i1)
    {
        return d[i1] != 1.7976931348623157E+308D;
    }

    public boolean isMinYSet()
    {
        return isMinYSet(0);
    }

    public boolean isMinYSet(int i1)
    {
        return f[i1] != 1.7976931348623157E+308D;
    }

    public boolean isPanEnabled()
    {
        return isPanXEnabled() || isPanYEnabled();
    }

    public boolean isPanXEnabled()
    {
        return m;
    }

    public boolean isPanYEnabled()
    {
        return n;
    }

    public boolean isXRoundedLabels()
    {
        return I;
    }

    public boolean isZoomEnabled()
    {
        return isZoomXEnabled() || isZoomYEnabled();
    }

    public boolean isZoomXEnabled()
    {
        return o;
    }

    public boolean isZoomYEnabled()
    {
        return p;
    }

    public void removeXTextLabel(double d1)
    {
        this;
        JVM INSTR monitorenter ;
        k.remove(Double.valueOf(d1));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void removeYTextLabel(double d1)
    {
        removeYTextLabel(d1, 0);
    }

    public void removeYTextLabel(double d1, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        ((Map)l.get(Integer.valueOf(i1))).remove(Double.valueOf(d1));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setAxisTitleTextSize(float f1)
    {
        c = f1;
    }

    public void setBarSpacing(double d1)
    {
        q = d1;
    }

    public void setBarWidth(float f1)
    {
        K = f1;
    }

    public void setChartValuesTextSize(float f1)
    {
        SimpleSeriesRenderer asimpleseriesrenderer[] = getSeriesRenderers();
        int i1 = asimpleseriesrenderer.length;
        for (int j1 = 0; j1 < i1; j1++)
        {
            asimpleseriesrenderer[j1].setChartValuesTextSize(f1);
        }

    }

    public void setDisplayChartValues(boolean flag)
    {
        SimpleSeriesRenderer asimpleseriesrenderer[] = getSeriesRenderers();
        int i1 = asimpleseriesrenderer.length;
        for (int j1 = 0; j1 < i1; j1++)
        {
            asimpleseriesrenderer[j1].setDisplayChartValues(flag);
        }

    }

    public void setGridColor(int i1)
    {
        y = i1;
    }

    public void setInitialRange(double ad[])
    {
        setInitialRange(ad, 0);
    }

    public void setInitialRange(double ad[], int i1)
    {
        w.put(Integer.valueOf(i1), ad);
    }

    public void setLabelFormat(NumberFormat numberformat)
    {
        J = numberformat;
    }

    public void setMarginsColor(int i1)
    {
        r = i1;
    }

    public void setOrientation(Orientation orientation)
    {
        j = orientation;
    }

    public void setPanEnabled(boolean flag)
    {
        setPanEnabled(flag, flag);
    }

    public void setPanEnabled(boolean flag, boolean flag1)
    {
        m = flag;
        n = flag1;
    }

    public void setPanLimits(double ad[])
    {
        s = ad;
    }

    public void setPointSize(float f1)
    {
        x = f1;
    }

    public void setRange(double ad[])
    {
        setRange(ad, 0);
    }

    public void setRange(double ad[], int i1)
    {
        setXAxisMin(ad[0], i1);
        setXAxisMax(ad[1], i1);
        setYAxisMin(ad[2], i1);
        setYAxisMax(ad[3], i1);
    }

    public void setXAxisMax(double d1)
    {
        setXAxisMax(d1, 0);
    }

    public void setXAxisMax(double d1, int i1)
    {
        if (!isMaxXSet(i1))
        {
            ((double[])w.get(Integer.valueOf(i1)))[1] = d1;
        }
        e[i1] = d1;
    }

    public void setXAxisMin(double d1)
    {
        setXAxisMin(d1, 0);
    }

    public void setXAxisMin(double d1, int i1)
    {
        if (!isMinXSet(i1))
        {
            ((double[])w.get(Integer.valueOf(i1)))[0] = d1;
        }
        d[i1] = d1;
    }

    public void setXLabels(int i1)
    {
        h = i1;
    }

    public void setXLabelsAlign(android.graphics.Paint.Align align)
    {
        A = align;
    }

    public void setXLabelsAngle(float f1)
    {
        u = f1;
    }

    public void setXLabelsColor(int i1)
    {
        G = i1;
    }

    public void setXLabelsPadding(float f1)
    {
        C = f1;
    }

    public void setXRoundedLabels(boolean flag)
    {
        I = flag;
    }

    public void setXTitle(String s1)
    {
        a = s1;
    }

    public void setYAxisAlign(android.graphics.Paint.Align align, int i1)
    {
        F[i1] = align;
    }

    public void setYAxisMax(double d1)
    {
        setYAxisMax(d1, 0);
    }

    public void setYAxisMax(double d1, int i1)
    {
        if (!isMaxYSet(i1))
        {
            ((double[])w.get(Integer.valueOf(i1)))[3] = d1;
        }
        g[i1] = d1;
    }

    public void setYAxisMin(double d1)
    {
        setYAxisMin(d1, 0);
    }

    public void setYAxisMin(double d1, int i1)
    {
        if (!isMinYSet(i1))
        {
            ((double[])w.get(Integer.valueOf(i1)))[2] = d1;
        }
        f[i1] = d1;
    }

    public void setYLabels(int i1)
    {
        i = i1;
    }

    public void setYLabelsAlign(android.graphics.Paint.Align align)
    {
        setYLabelsAlign(align, 0);
    }

    public void setYLabelsAlign(android.graphics.Paint.Align align, int i1)
    {
        B[i1] = align;
    }

    public void setYLabelsAngle(float f1)
    {
        v = f1;
    }

    public void setYLabelsColor(int i1, int j1)
    {
        H[i1] = j1;
    }

    public void setYLabelsPadding(float f1)
    {
        D = f1;
    }

    public void setYLabelsVerticalPadding(float f1)
    {
        E = f1;
    }

    public void setYTitle(String s1)
    {
        setYTitle(s1, 0);
    }

    public void setYTitle(String s1, int i1)
    {
        b[i1] = s1;
    }

    public void setZoomEnabled(boolean flag, boolean flag1)
    {
        o = flag;
        p = flag1;
    }

    public void setZoomInLimitX(double d1)
    {
        L = d1;
    }

    public void setZoomInLimitY(double d1)
    {
        M = d1;
    }

    public void setZoomLimits(double ad[])
    {
        t = ad;
    }

    private class Orientation extends Enum
    {

        public static final Orientation HORIZONTAL;
        public static final Orientation VERTICAL;
        private static final Orientation b[];
        private int a;

        public static Orientation valueOf(String s1)
        {
            return (Orientation)Enum.valueOf(org/achartengine/renderer/XYMultipleSeriesRenderer$Orientation, s1);
        }

        public static Orientation[] values()
        {
            return (Orientation[])b.clone();
        }

        public int getAngle()
        {
            return a;
        }

        static 
        {
            HORIZONTAL = new Orientation("HORIZONTAL", 0, 0);
            VERTICAL = new Orientation("VERTICAL", 1, 90);
            Orientation aorientation[] = new Orientation[2];
            aorientation[0] = HORIZONTAL;
            aorientation[1] = VERTICAL;
            b = aorientation;
        }

        private Orientation(String s1, int i1, int j1)
        {
            super(s1, i1);
            a = 0;
            a = j1;
        }
    }

}
