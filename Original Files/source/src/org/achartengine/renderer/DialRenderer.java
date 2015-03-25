// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.renderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package org.achartengine.renderer:
//            DefaultRenderer

public class DialRenderer extends DefaultRenderer
{

    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private List g;

    public DialRenderer()
    {
        a = 330D;
        b = 30D;
        c = 1.7976931348623157E+308D;
        d = -1.7976931348623157E+308D;
        e = 1.7976931348623157E+308D;
        f = 1.7976931348623157E+308D;
        g = new ArrayList();
    }

    public double getAngleMax()
    {
        return b;
    }

    public double getAngleMin()
    {
        return a;
    }

    public double getMajorTicksSpacing()
    {
        return f;
    }

    public double getMaxValue()
    {
        return d;
    }

    public double getMinValue()
    {
        return c;
    }

    public double getMinorTicksSpacing()
    {
        return e;
    }

    public Type getVisualTypeForIndex(int i)
    {
        if (i < g.size())
        {
            return (Type)g.get(i);
        } else
        {
            return Type.NEEDLE;
        }
    }

    public boolean isMaxValueSet()
    {
        return d != -1.7976931348623157E+308D;
    }

    public boolean isMinValueSet()
    {
        return c != 1.7976931348623157E+308D;
    }

    public void setAngleMax(double d1)
    {
        b = d1;
    }

    public void setAngleMin(double d1)
    {
        a = d1;
    }

    public void setMajorTicksSpacing(double d1)
    {
        f = d1;
    }

    public void setMaxValue(double d1)
    {
        d = d1;
    }

    public void setMinValue(double d1)
    {
        c = d1;
    }

    public void setMinorTicksSpacing(double d1)
    {
        e = d1;
    }

    public void setVisualTypes(Type atype[])
    {
        g.clear();
        g.addAll(Arrays.asList(atype));
    }

    private class Type extends Enum
    {

        public static final Type ARROW;
        public static final Type NEEDLE;
        private static final Type a[];

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(org/achartengine/renderer/DialRenderer$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])a.clone();
        }

        static 
        {
            NEEDLE = new Type("NEEDLE", 0);
            ARROW = new Type("ARROW", 1);
            Type atype[] = new Type[2];
            atype[0] = NEEDLE;
            atype[1] = ARROW;
            a = atype;
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }

}
