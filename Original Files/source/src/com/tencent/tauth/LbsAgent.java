// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import android.content.Context;
import com.tencent.b.a.a.a;

// Referenced classes of package com.tencent.tauth:
//            SosoLocationListener

public class LbsAgent
{

    private static final String a = "OpenSdk";
    private static final String b = "WQMPF-XMH66-ISQXP-OIGMM-BNL7M";
    private SosoLocationListener c;

    public LbsAgent()
    {
    }

    public void removeUpdate()
    {
        com.tencent.b.a.a.a.a().b();
        c = null;
    }

    public void requestLocationUpdate(Context context, OnGetLocationListener ongetlocationlistener)
    {
        c = new SosoLocationListener(ongetlocationlistener);
        com.tencent.b.a.a.a.a().a(context, c);
    }

    public boolean verifyRegCode()
    {
        return com.tencent.b.a.a.a.a().a("OpenSdk", "WQMPF-XMH66-ISQXP-OIGMM-BNL7M");
    }
}
