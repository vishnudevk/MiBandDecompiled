// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;


class a
{

    static final int a[];

    static 
    {
        a = new int[org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.values().length];
        try
        {
            a[org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ALL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.BELOW.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.ABOVE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4)
        {
            return;
        }
    }
}
