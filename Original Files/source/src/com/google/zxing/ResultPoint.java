// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;


public class ResultPoint
{

    private final float a;
    private final float b;

    public ResultPoint(float f, float f1)
    {
        a = f;
        b = f1;
    }

    private static float a(ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2)
    {
        float f = resultpoint1.a;
        float f1 = resultpoint1.b;
        return (resultpoint2.a - f) * (resultpoint.b - f1) - (resultpoint2.b - f1) * (resultpoint.a - f);
    }

    public static float distance(ResultPoint resultpoint, ResultPoint resultpoint1)
    {
        float f = resultpoint.a - resultpoint1.a;
        float f1 = resultpoint.b - resultpoint1.b;
        return (float)Math.sqrt(f * f + f1 * f1);
    }

    public static void orderBestPatterns(ResultPoint aresultpoint[])
    {
        float f = distance(aresultpoint[0], aresultpoint[1]);
        float f1 = distance(aresultpoint[1], aresultpoint[2]);
        float f2 = distance(aresultpoint[0], aresultpoint[2]);
        ResultPoint resultpoint;
        ResultPoint resultpoint1;
        ResultPoint resultpoint2;
        if (f1 >= f && f1 >= f2)
        {
            resultpoint = aresultpoint[0];
            resultpoint1 = aresultpoint[1];
            resultpoint2 = aresultpoint[2];
        } else
        if (f2 >= f1 && f2 >= f)
        {
            resultpoint = aresultpoint[1];
            resultpoint1 = aresultpoint[0];
            resultpoint2 = aresultpoint[2];
        } else
        {
            resultpoint = aresultpoint[2];
            resultpoint1 = aresultpoint[0];
            resultpoint2 = aresultpoint[1];
        }
        if (a(resultpoint1, resultpoint, resultpoint2) >= 0.0F)
        {
            ResultPoint resultpoint3 = resultpoint2;
            resultpoint2 = resultpoint1;
            resultpoint1 = resultpoint3;
        }
        aresultpoint[0] = resultpoint2;
        aresultpoint[1] = resultpoint;
        aresultpoint[2] = resultpoint1;
    }

    public boolean equals(Object obj)
    {
        boolean flag = obj instanceof ResultPoint;
        boolean flag1 = false;
        if (flag)
        {
            ResultPoint resultpoint = (ResultPoint)obj;
            int i = a != resultpoint.a;
            flag1 = false;
            if (i == 0)
            {
                int j = b != resultpoint.b;
                flag1 = false;
                if (j == 0)
                {
                    flag1 = true;
                }
            }
        }
        return flag1;
    }

    public final float getX()
    {
        return a;
    }

    public final float getY()
    {
        return b;
    }

    public int hashCode()
    {
        return 31 * Float.floatToIntBits(a) + Float.floatToIntBits(b);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(25);
        stringbuilder.append('(');
        stringbuilder.append(a);
        stringbuilder.append(',');
        stringbuilder.append(b);
        stringbuilder.append(')');
        return stringbuilder.toString();
    }
}
