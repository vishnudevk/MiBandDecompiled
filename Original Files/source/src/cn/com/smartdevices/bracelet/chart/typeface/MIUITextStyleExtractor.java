// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.typeface;


// Referenced classes of package cn.com.smartdevices.bracelet.chart.typeface:
//            MIUITextStyle

public class MIUITextStyleExtractor extends TypefaceManager.TextStyleExtractor
{

    private static final MIUITextStyleExtractor a = new MIUITextStyleExtractor();

    public MIUITextStyleExtractor()
    {
    }

    public static TypefaceManager.TextStyleExtractor getInstance()
    {
        return a;
    }

    public TypefaceManager.TextStyle[] getTextStyles()
    {
        return MIUITextStyle.values();
    }

}
