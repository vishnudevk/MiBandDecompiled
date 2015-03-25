// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.a.a.c;

// Referenced classes of package com.tencent.tauth:
//            LocationApi, LbsAgent

class a extends Handler
{

    final LocationApi a;

    a(LocationApi locationapi, Looper looper)
    {
        a = locationapi;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 101 104: default 36
    //                   101 110
    //                   102 36
    //                   103 42
    //                   104 89;
           goto _L1 _L2 _L1 _L3 _L4
_L1:
        super.handleMessage(message);
        return;
_L3:
        c.b("openSDK_LOG", "location: verify sosocode success.");
        LocationApi.b(a).requestLocationUpdate(LocationApi.a(a), a);
        com.tencent.tauth.LocationApi.c(a).sendEmptyMessageDelayed(101, 10000L);
        continue; /* Loop/switch isn't completed */
_L4:
        c.b("openSDK_LOG", "location: verify sosocode failed.");
        LocationApi.a(a, -14, "\u5B9A\u4F4D\u5931\u8D25\uFF0C\u9A8C\u8BC1\u5B9A\u4F4D\u7801\u9519\u8BEF\uFF01");
        continue; /* Loop/switch isn't completed */
_L2:
        c.b("openSDK_LOG", "location: get location timeout.");
        LocationApi.a(a, -13, "\u5B9A\u4F4D\u8D85\u65F6\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\u6216\u68C0\u67E5\u7F51\u7EDC\u72B6\u51B5\uFF01");
        if (true) goto _L1; else goto _L5
_L5:
    }
}
