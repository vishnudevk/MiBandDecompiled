// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.typeface;


public abstract class 
{

    public  getTextStyle(String s)
    {
         a[] = getTextStyles();
        int i = a.length;
        for (int j = 0; j < i; j++)
        {
              = a[j];
            if (.getTextStyles().equals(s))
            {
                return ;
            }
        }

        return null;
    }

    public abstract getTextStyles[] getTextStyles();

    public ()
    {
    }
}
