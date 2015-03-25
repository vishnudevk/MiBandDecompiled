// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.sdk.b.a;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            IWXMsgListenAPI, c

public class WXMsgListenerApiImplV10
    implements IWXMsgListenAPI
{

    private static final String a = "MicroMsg.SDK.WXMsgListenerApiImplV10";
    private static final String b = "content://com.tencent.mm.sdk.comm.provider/registerMsgListener";
    private Context c;
    private String d;
    private boolean e;

    WXMsgListenerApiImplV10(Context context, String s, boolean flag)
    {
        e = false;
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXMsgListenerApiImplV10", (new StringBuilder("<init>, appId = ")).append(s).append(", checkSignature = ").append(flag).toString());
        c = context;
        d = s;
        e = flag;
    }

    public boolean isWXAppSupportMsgListener()
    {
        return false;
    }

    public boolean registerMsgListener(String s, long l, long l1, int i)
    {
        if (!com.tencent.mm.sdk.openapi.c.a(c, "com.tencent.mm", e))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMsgListenerApiImplV10", "register app failed for wechat app signature check failed");
            return false;
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXMsgListenerApiImplV10", (new StringBuilder("registerMsgListener, appId = ")).append(s).toString());
        if (s != null)
        {
            d = s;
        }
        Cursor cursor = c.getContentResolver().query(Uri.parse((new StringBuilder("content://com.tencent.mm.sdk.comm.provider/registerMsgListener?appid=")).append(s).append("&op=1&scene=").append(l).append("&msgType=").append(l1).append("&msgState=").append(i).toString()), null, null, null, null);
        if (cursor != null)
        {
            cursor.close();
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXMsgListenerApiImplV10", "register done");
            return true;
        } else
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMsgListenerApiImplV10", "register failed");
            return false;
        }
    }

    public boolean unregisterMsgListener()
    {
        Cursor cursor = c.getContentResolver().query(Uri.parse((new StringBuilder("content://com.tencent.mm.sdk.comm.provider/registerMsgListener?appid=")).append(d).append("&op=2").toString()), null, null, null, null);
        if (cursor != null)
        {
            cursor.close();
            return true;
        } else
        {
            return false;
        }
    }
}
