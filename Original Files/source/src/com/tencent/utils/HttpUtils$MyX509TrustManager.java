// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class a
    implements X509TrustManager
{

    X509TrustManager a;

    public void checkClientTrusted(X509Certificate ax509certificate[], String s)
    {
        try
        {
            a.checkClientTrusted(ax509certificate, s);
            return;
        }
        catch (CertificateException certificateexception)
        {
            return;
        }
    }

    public void checkServerTrusted(X509Certificate ax509certificate[], String s)
    {
        try
        {
            a.checkServerTrusted(ax509certificate, s);
            return;
        }
        catch (CertificateException certificateexception)
        {
            return;
        }
    }

    public X509Certificate[] getAcceptedIssuers()
    {
        return a.getAcceptedIssuers();
    }

    ()
    {
        KeyStore keystore;
        KeyStore keystore1;
        try
        {
            keystore1 = KeyStore.getInstance("JKS");
        }
        catch (Exception exception)
        {
            keystore = null;
            continue;
        }
        keystore = keystore1;
        do
        {
            TrustManager[] _tmp = new TrustManager[0];
            TrustManager atrustmanager[];
            int i;
            if (keystore != null)
            {
                keystore.load(new FileInputStream("trustedCerts"), "passphrase".toCharArray());
                TrustManagerFactory trustmanagerfactory1 = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
                trustmanagerfactory1.init(keystore);
                atrustmanager = trustmanagerfactory1.getTrustManagers();
            } else
            {
                TrustManagerFactory trustmanagerfactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustmanagerfactory.init((KeyStore)null);
                atrustmanager = trustmanagerfactory.getTrustManagers();
            }
            i = 0;
            do
            {
                if (i >= atrustmanager.length)
                {
                    break;
                }
                if (atrustmanager[i] instanceof X509TrustManager)
                {
                    a = (X509TrustManager)atrustmanager[i];
                    return;
                }
                i++;
            } while (true);
            throw new Exception("Couldn't initialize");
        } while (true);
    }
}
