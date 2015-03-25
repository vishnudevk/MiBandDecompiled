// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account.openauth.utils;

import android.util.Log;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class a
    implements HostnameVerifier
{

    a()
    {
    }

    public boolean verify(String s, SSLSession sslsession)
    {
        Log.v("openauth", "WARNING: Hostname is not matched for cert.");
        return true;
    }
}
