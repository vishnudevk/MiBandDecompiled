// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import android.location.Location;
import com.tencent.a.a.c;
import com.tencent.b.a.a.b;
import com.tencent.b.a.a.d;

public class SosoLocationListener extends b
{

    private LbsAgent.OnGetLocationListener a;

    public SosoLocationListener(LbsAgent.OnGetLocationListener ongetlocationlistener)
    {
        super(1, 0, 0, 8);
        a = ongetlocationlistener;
    }

    public void onLocationDataUpdate(byte abyte0[], int i)
    {
        super.onLocationDataUpdate(abyte0, i);
        c.c("openSDK_LOG", (new StringBuilder()).append("location: onLocationDataUpdate = ").append(abyte0).toString());
    }

    public void onLocationUpdate(d d1)
    {
        c.c("openSDK_LOG", (new StringBuilder()).append("location: onLocationUpdate = ").append(d1).toString());
        super.onLocationUpdate(d1);
        if (d1 != null)
        {
            Location location = new Location("passive");
            location.setLatitude(d1.b);
            location.setLongitude(d1.c);
            if (a != null)
            {
                a.onLocationUpdate(location);
                return;
            }
        }
    }

    public void onStatusUpdate(int i)
    {
        c.c("openSDK_LOG", (new StringBuilder()).append("location: onStatusUpdate = ").append(i).toString());
        super.onStatusUpdate(i);
    }
}
