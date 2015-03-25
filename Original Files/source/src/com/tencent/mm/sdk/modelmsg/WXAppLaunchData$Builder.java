// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;

// Referenced classes of package com.tencent.mm.sdk.modelmsg:
//            WXAppLaunchData

public class _cls9
{

    public static WXAppLaunchData fromBundle(Bundle bundle)
    {
        WXAppLaunchData wxapplaunchdata = new WXAppLaunchData();
        wxapplaunchdata.launchType = bundle.getInt("_wxapplaunchdata_launchType");
        wxapplaunchdata.message = bundle.getString("_wxapplaunchdata_message");
        return wxapplaunchdata;
    }

    public static Bundle toBundle(WXAppLaunchData wxapplaunchdata)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("_wxapplaunchdata_launchType", wxapplaunchdata.launchType);
        bundle.putString("_wxapplaunchdata_message", wxapplaunchdata.message);
        return bundle;
    }

    public _cls9()
    {
    }
}
