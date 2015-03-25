// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.openauth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.xiaomi.channel.openauth:
//            AuthorizeHelper, APP2SDKReceiver

class b
    implements Runnable
{

    private final Activity a;
    private final APP2SDKReceiver b;
    private final long c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final int h;

    b(Activity activity, APP2SDKReceiver app2sdkreceiver, long l, String s, String s1, String s2, 
            String s3, int i)
    {
        a = activity;
        b = app2sdkreceiver;
        c = l;
        d = s;
        e = s1;
        f = s2;
        g = s3;
        h = i;
        super();
    }

    public void run()
    {
        a.unregisterReceiver(b);
        Intent intent = AuthorizeHelper.a(a);
        AuthorizeHelper.a();
        Bundle bundle = new Bundle();
        bundle.putString("client_id", String.valueOf(c));
        bundle.putString("redirect_uri", d);
        bundle.putString("response_type", e);
        bundle.putString("scope", f);
        bundle.putString("state", g);
        intent.putExtra("url_param", bundle);
        a.startActivityForResult(intent, h);
    }
}
