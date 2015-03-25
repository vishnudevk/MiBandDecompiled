// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;

import java.text.DateFormat;
import java.util.Calendar;

public final class status
{

    public int charges;
    public final Calendar lastCharge;
    public final int level;
    public final int status;

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append((new StringBuilder()).append("[[[ ").append(getClass().getSimpleName()).append(" ]]]").toString());
        stringbuilder.append((new StringBuilder()).append("\n       level: ").append(level).append("%").toString());
        stringbuilder.append((new StringBuilder()).append("\n  lastCharge: ").append(DateFormat.getDateTimeInstance().format(lastCharge.getTime())).toString());
        stringbuilder.append((new StringBuilder()).append("\n     charges: ").append(charges).toString());
        stringbuilder.append((new StringBuilder()).append("\n      status: ").append(Integer.toHexString(status)).toString());
        return stringbuilder.toString();
    }

    public (int i, Calendar calendar, int j, int k)
    {
        level = i;
        lastCharge = calendar;
        charges = j;
        status = k;
    }
}
