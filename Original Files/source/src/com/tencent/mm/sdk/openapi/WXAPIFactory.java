// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.content.Context;
import com.tencent.mm.sdk.b.a;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            WXMsgListenerApiImplV10, d, IWXMsgListenAPI, IWXAPI

public class WXAPIFactory
{

    private static final String a = "MicroMsg.PaySdk.WXFactory";

    private WXAPIFactory()
    {
        throw new RuntimeException((new StringBuilder()).append(getClass().getSimpleName()).append(" should not be instantiated").toString());
    }

    public static IWXMsgListenAPI createMsgListenerAPI(Context context, String s, boolean flag)
    {
        com.tencent.mm.sdk.b.a.c("MicroMsg.PaySdk.WXFactory", (new StringBuilder("createMsgListenerAPI, appId = ")).append(s).append(", checkSignature = ").append(flag).toString());
        return new WXMsgListenerApiImplV10(context, s, flag);
    }

    public static IWXAPI createWXAPI(Context context, String s)
    {
        return createWXAPI(context, s, false);
    }

    public static IWXAPI createWXAPI(Context context, String s, boolean flag)
    {
        com.tencent.mm.sdk.b.a.c("MicroMsg.PaySdk.WXFactory", (new StringBuilder("createWXAPI, appId = ")).append(s).append(", checkSignature = ").append(flag).toString());
        return new d(context, s, flag);
    }
}
