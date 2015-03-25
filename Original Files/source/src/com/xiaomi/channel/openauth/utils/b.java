// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.openauth.utils;

import android.util.Log;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class b
    implements X509TrustManager
{

    private X509Certificate a[];

    b()
    {
    }

    public void checkClientTrusted(X509Certificate ax509certificate[], String s)
    {
        if (a == null)
        {
            a = ax509certificate;
            Log.v("openauth", "init at checkClientTrusted.");
        }
    }

    public void checkServerTrusted(X509Certificate ax509certificate[], String s)
    {
        if (a == null)
        {
            a = ax509certificate;
            Log.v("openauth", "init at checkServerTrusted");
        }
    }

    public X509Certificate[] getAcceptedIssuers()
    {
        return null;
    }
}
