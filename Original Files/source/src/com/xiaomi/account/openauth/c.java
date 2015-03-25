// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account.openauth;

import android.accounts.Account;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.auth.XiaomiAuthUtil;

// Referenced classes of package com.xiaomi.account.openauth:
//            AuthorizeHelper, XiaomiOAuthorize, d

class c
    implements Runnable
{

    private final Activity a;
    private final long b;
    private final String c;
    private final String d;
    private final Bundle e;
    private final int f;
    private final Account g[];

    c(Activity activity, long l, String s, String s1, Bundle bundle, int i, 
            Account aaccount[])
    {
        a = activity;
        b = l;
        c = s;
        d = s1;
        e = bundle;
        f = i;
        g = aaccount;
        super();
    }

    public void run()
    {
        if (!XiaomiAuthUtil.isServiceSupport(a))
        {
            AuthorizeHelper.startAuthorizeActivityForResult(a, b, c, d, e.getString("scope"), e.getString("state"), f);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra_client_id", String.valueOf(b));
        bundle.putString("extra_redirect_uri", c);
        bundle.putString("extra_response_type", d);
        if (e != null)
        {
            bundle.putAll(e);
        }
        Bundle bundle1 = XiaomiAuthUtil.getAccessToken(a, g[0], bundle);
        if (bundle1.getInt("extra_error_code") == 0 && XiaomiOAuthorize.a() != null)
        {
            a.runOnUiThread(new d(this, bundle1));
            return;
        }
        if (bundle1.getInt("extra_error_code") == -1001)
        {
            Intent intent = (Intent)bundle1.getParcelable("extra_intent");
            a.startActivityForResult(intent, f);
            return;
        } else
        {
            AuthorizeHelper.startAuthorizeActivityForResult(a, b, c, d, e.getString("scope"), e.getString("state"), f);
            return;
        }
    }
}
