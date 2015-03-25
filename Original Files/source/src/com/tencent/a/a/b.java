// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.a;

import android.text.format.Time;
import android.util.Log;

public final class b
{

    public static final b a = new b();

    public b()
    {
    }

    public final String a(int i)
    {
        switch (i)
        {
        default:
            return "-";

        case 2: // '\002'
            return "D";

        case 4: // '\004'
            return "I";

        case 8: // '\b'
            return "W";

        case 16: // '\020'
            return "E";

        case 1: // '\001'
            return "V";

        case 32: // ' '
            return "A";
        }
    }

    public String a(int i, Thread thread, long l, String s, String s1, Throwable throwable)
    {
        long l1 = l % 1000L;
        Time time = new Time();
        time.set(l);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(a(i)).append('/').append(time.format("%Y-%m-%d %H:%M:%S")).append('.');
        if (l1 < 10L)
        {
            stringbuilder.append("00");
        } else
        if (l1 < 100L)
        {
            stringbuilder.append('0');
        }
        stringbuilder.append(l1).append(' ').append('[');
        if (thread == null)
        {
            stringbuilder.append("N/A");
        } else
        {
            stringbuilder.append(thread.getName());
        }
        stringbuilder.append(']').append('[').append(s).append(']').append(' ').append(s1).append('\n');
        if (throwable != null)
        {
            stringbuilder.append("* Exception : \n").append(Log.getStackTraceString(throwable)).append('\n');
        }
        return stringbuilder.toString();
    }

}
