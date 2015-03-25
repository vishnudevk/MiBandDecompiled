// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;


// Referenced classes of package org.achartengine.chart:
//            PointStyle

class b
{

    static final int a[];

    static 
    {
        a = new int[PointStyle.values().length];
        try
        {
            a[PointStyle.X.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[PointStyle.CIRCLE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[PointStyle.TRIANGLE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[PointStyle.SQUARE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[PointStyle.DIAMOND.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[PointStyle.POINT.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5)
        {
            return;
        }
    }
}
