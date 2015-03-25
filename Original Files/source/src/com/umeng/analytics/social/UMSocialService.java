// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;

import android.content.Context;
import android.util.Log;

// Referenced classes of package com.umeng.analytics.social:
//            a, q, f, UMPlatformData

public abstract class UMSocialService
{

    public UMSocialService()
    {
    }

    private static transient void a(Context context, b b, String s, UMPlatformData aumplatformdata[])
    {
        if (aumplatformdata == null) goto _L2; else goto _L1
_L1:
        int i = aumplatformdata.length;
        int j = 0;
          goto _L3
_L4:
        if (!aumplatformdata[j].isValid())
        {
            throw new a("parameter is not valid.");
        }
        j++;
        continue; /* Loop/switch isn't completed */
_L2:
        try
        {
            (new q(f.a(context, s, aumplatformdata), b, aumplatformdata)).execute(new Void[0]);
            return;
        }
        catch (a a1)
        {
            Log.e("MobclickAgent", "unable send event.", a1);
            return;
        }
        catch (Exception exception)
        {
            Log.e("MobclickAgent", "", exception);
        }
        return;
_L3:
        if (j < i) goto _L4; else goto _L2
    }

    public static transient void share(Context context, String s, UMPlatformData aumplatformdata[])
    {
        a(context, null, s, aumplatformdata);
    }

    public static transient void share(Context context, UMPlatformData aumplatformdata[])
    {
        a(context, null, null, aumplatformdata);
    }
}
