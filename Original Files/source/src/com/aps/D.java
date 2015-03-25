// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;


// Referenced classes of package com.aps:
//            ai

final class D
    implements android.location.GpsStatus.NmeaListener
{

    private ai a;

    private D(ai ai1)
    {
        a = ai1;
        super();
    }

    D(ai ai1, byte byte0)
    {
        this(ai1);
    }

    public final void onNmeaReceived(long l, String s)
    {
        try
        {
            ai.c(a, l);
            ai.a(a, s);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
