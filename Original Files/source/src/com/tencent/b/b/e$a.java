// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.location.Location;

// Referenced classes of package com.tencent.b.b:
//            e

public final class b
    implements Cloneable
{

    private Location a;
    private long b;
    private int c;

    public final boolean a()
    {
        while (a == null || c > 0 && c < 3 || System.currentTimeMillis() - b > 30000L) 
        {
            return false;
        }
        return true;
    }

    public final Location b()
    {
        return a;
    }

    public final Object clone()
    {
        ation ation;
        try
        {
            ation = (ation)super.clone();
        }
        catch (Exception exception)
        {
            ation = null;
        }
        if (a != null)
        {
            ation.a = new Location(a);
        }
        return ation;
    }

    public ation(e e, Location location, int i, int j, int k, long l)
    {
        a = null;
        b = 0L;
        c = 0;
        if (location != null)
        {
            a = new Location(location);
            c = j;
            b = l;
        }
    }
}
