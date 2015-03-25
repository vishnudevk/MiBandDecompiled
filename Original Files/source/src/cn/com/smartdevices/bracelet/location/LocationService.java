// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.location;


// Referenced classes of package cn.com.smartdevices.bracelet.location:
//            LocationOption, LocationListener

public interface LocationService
{

    public abstract void optionLocationService(LocationOption locationoption);

    public abstract void registerLocationListener(LocationListener locationlistener);

    public abstract void startLocation();

    public abstract void stopLocation();
}
