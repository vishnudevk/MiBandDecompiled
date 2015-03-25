// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import android.os.Bundle;

// Referenced classes of package com.tencent.utils:
//            OpenConfig, HttpUtils, Util

class d extends Thread
{

    final Bundle a;
    final OpenConfig b;

    d(OpenConfig openconfig, Bundle bundle)
    {
        b = openconfig;
        a = bundle;
        super();
    }

    public void run()
    {
        try
        {
            org.json.JSONObject jsonobject = Util.parseJson(HttpUtils.openUrl2(OpenConfig.a(b), "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", a).response);
            OpenConfig.a(b, jsonobject);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        OpenConfig.a(b, 0);
    }
}
