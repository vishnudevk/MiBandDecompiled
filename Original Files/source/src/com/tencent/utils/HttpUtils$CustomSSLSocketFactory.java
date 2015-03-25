// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class a extends SSLSocketFactory
{

    private SSLContext a;

    public Socket createSocket()
    {
        return a.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
    {
        return a.getSocketFactory().createSocket(socket, s, i, flag);
    }

    public (KeyStore keystore)
    {
        super(keystore);
        a = SSLContext.getInstance("TLS");
         ;
        try
        {
             = new t>();
        }
        catch (Exception exception)
        {
             = null;
        }
        a.init(null, new TrustManager[] {
            
        }, null);
    }
}
