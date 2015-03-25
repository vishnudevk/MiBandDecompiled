// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.location.LocationListener;

// Referenced classes of package com.amap.api.location:
//            AMapLocation

public interface AMapLocationListener
    extends LocationListener
{

    public abstract void onLocationChanged(AMapLocation amaplocation);
}
