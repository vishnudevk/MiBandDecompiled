// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.typeface;


public final class MIUITextStyle extends Enum
    implements TypefaceManager.TextStyle
{

    public static final MIUITextStyle BOLD;
    public static final MIUITextStyle LIGHT;
    public static final MIUITextStyle NORMAL;
    private static final MIUITextStyle c[];
    private String a;
    private String b;

    private MIUITextStyle(String s, int i, String s1, String s2)
    {
        super(s, i);
        a = s1;
        b = s2;
    }

    public static MIUITextStyle valueOf(String s)
    {
        return (MIUITextStyle)Enum.valueOf(cn/com/smartdevices/bracelet/chart/typeface/MIUITextStyle, s);
    }

    public static MIUITextStyle[] values()
    {
        return (MIUITextStyle[])c.clone();
    }

    public String getFontName()
    {
        return b;
    }

    public String getName()
    {
        return a;
    }

    static 
    {
        NORMAL = new MIUITextStyle("NORMAL", 0, "miui", "fonts/MIUI/MIUI-Normal.ttf");
        LIGHT = new MIUITextStyle("LIGHT", 1, "miui-light", "fonts/MIUI/MIUI-Light.ttf");
        BOLD = new MIUITextStyle("BOLD", 2, "miui-bold", "fonts/MIUI/MIUI-Bold.ttf");
        MIUITextStyle amiuitextstyle[] = new MIUITextStyle[3];
        amiuitextstyle[0] = NORMAL;
        amiuitextstyle[1] = LIGHT;
        amiuitextstyle[2] = BOLD;
        c = amiuitextstyle;
    }
}
