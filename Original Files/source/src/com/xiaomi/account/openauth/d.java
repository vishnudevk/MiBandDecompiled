// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account.openauth;

import android.os.Bundle;

// Referenced classes of package com.xiaomi.account.openauth:
//            XiaomiOAuthorize, c

class d
    implements Runnable
{

    final c a;
    private final Bundle b;

    d(c c, Bundle bundle)
    {
        a = c;
        b = bundle;
        super();
    }

    public void run()
    {
        Bundle bundle = new Bundle();
        bundle.putString("access_token", b.getString("extra_access_token"));
        bundle.putString("token_type", b.getString("extra_token_type"));
        bundle.putString("expires_in", String.valueOf(b.getInt("extra_expires_in")));
        bundle.putString("mac_key", b.getString("extra_mac_key"));
        bundle.putString("mac_algorithm", b.getString("extra_mac_algorithm"));
        XiaomiOAuthorize.a().onGetAccessTokenDirectly(bundle);
    }
}
