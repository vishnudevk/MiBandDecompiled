// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.e;

public final class a
{

    public static boolean a(Context context, a a1)
    {
        if (context == null || a1 == null)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        }
        if (e.c(a1.b))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", (new StringBuilder("send fail, invalid targetPkgName, targetPkgName = ")).append(a1.b).toString());
            return false;
        }
        if (e.c(a1.c))
        {
            a1.c = (new StringBuilder()).append(a1.b).append(".wxapi.WXEntryActivity").toString();
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", (new StringBuilder("send, targetPkgName = ")).append(a1.b).append(", targetClassName = ").append(a1.c).toString());
        Intent intent = new Intent();
        intent.setClassName(a1.b, a1.c);
        if (a1.e != null)
        {
            intent.putExtras(a1.e);
        }
        String s = context.getPackageName();
        intent.putExtra("_mmessage_sdkVersion", 0x22010003);
        intent.putExtra("_mmessage_appPackage", s);
        intent.putExtra("_mmessage_content", a1.d);
        intent.putExtra("_mmessage_checksum", b.a(a1.d, 0x22010003, s));
        if (a1.flags == -1)
        {
            intent.addFlags(0x10000000).addFlags(0x8000000);
        } else
        {
            intent.setFlags(a1.flags);
        }
        try
        {
            context.startActivity(intent);
        }
        catch (Exception exception)
        {
            Object aobj[] = new Object[1];
            aobj[0] = exception.getMessage();
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", aobj);
            return false;
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", (new StringBuilder("send mm message, intent=")).append(intent).toString());
        return true;
    }

    private class a
    {

        public String b;
        public String c;
        public String d;
        public Bundle e;
        public int flags;

        public a()
        {
            flags = -1;
        }
    }

}
