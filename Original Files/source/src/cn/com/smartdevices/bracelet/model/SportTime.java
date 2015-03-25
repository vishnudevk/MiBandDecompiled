// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public class SportTime
{

    int day;
    int hour;
    int min;
    int mon;
    int year;

    public SportTime(int i, int j, int k, int l, int i1)
    {
        year = i;
        mon = j;
        day = k;
        hour = l;
        min = i1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("20").append(year).append("\u5E74").append(mon).append("\u6708").append(day).append("\u65E5").append(hour).append("\u65F6").append(min).append("\u5206").toString();
    }
}
