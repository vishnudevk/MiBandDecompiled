// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.b.e;

// Referenced classes of package com.tencent.mm.sdk.a.a:
//            b

public final class a
{

    public static boolean a(Context context, a a1)
    {
        if (context == null || a1 == null)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        }
        if (e.c(a1.g))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        }
        boolean flag = e.c(a1.f);
        String s = null;
        if (!flag)
        {
            s = (new StringBuilder()).append(a1.f).append(".permission.MM_MESSAGE").toString();
        }
        Intent intent = new Intent(a1.g);
        if (a1.e != null)
        {
            intent.putExtras(a1.e);
        }
        String s1 = context.getPackageName();
        intent.putExtra("_mmessage_sdkVersion", 0x22010003);
        intent.putExtra("_mmessage_appPackage", s1);
        intent.putExtra("_mmessage_content", a1.d);
        intent.putExtra("_mmessage_checksum", b.a(a1.d, 0x22010003, s1));
        context.sendBroadcast(intent, s);
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessage", (new StringBuilder("send mm message, intent=")).append(intent).append(", perm=").append(s).toString());
        return true;
    }

    private class a
    {

        public String d;
        public Bundle e;
        public String f;
        public String g;

        public a()
        {
        }
    }

}
