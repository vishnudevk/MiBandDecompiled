// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.xiaomi.market.sdk:
//            XiaomiUpdateAgent, s, w, q, 
//            m

class u
    implements android.content.DialogInterface.OnClickListener
{

    u()
    {
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (s.b(XiaomiUpdateAgent.b()) && XiaomiUpdateAgent.f().l != 1)
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(XiaomiUpdateAgent.c().packageName).toString()));
            intent.setClassName("com.xiaomi.market", "com.xiaomi.market.ui.AppDetailActivity");
            XiaomiUpdateAgent.b().startActivity(intent);
            return;
        } else
        {
            m.i(XiaomiUpdateAgent.b()).a(XiaomiUpdateAgent.c(), XiaomiUpdateAgent.f());
            return;
        }
    }
}
