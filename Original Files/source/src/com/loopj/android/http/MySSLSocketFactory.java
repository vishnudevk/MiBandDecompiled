// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

// Referenced classes of package com.loopj.android.http:
//            x

public class MySSLSocketFactory extends SSLSocketFactory
{

    SSLContext a;

    public MySSLSocketFactory(KeyStore keystore)
    {
        super(keystore);
        a = SSLContext.getInstance("TLS");
        x x1 = new x(this);
        a.init(null, new TrustManager[] {
            x1
        }, null);
    }

    public static SSLSocketFactory getFixedSocketFactory()
    {
        MySSLSocketFactory mysslsocketfactory;
        try
        {
            mysslsocketfactory = new MySSLSocketFactory(getKeystore());
            mysslsocketfactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return SSLSocketFactory.getSocketFactory();
        }
        return mysslsocketfactory;
    }

    public static KeyStore getKeystore()
    {
        KeyStore keystore1 = KeyStore.getInstance(KeyStore.getDefaultType());
        KeyStore keystore = keystore1;
        keystore.load(null, null);
        return keystore;
        Throwable throwable;
        throwable;
        Throwable throwable1;
        keystore = null;
        throwable1 = throwable;
_L2:
        throwable1.printStackTrace();
        return keystore;
        throwable1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static KeyStore getKeystoreOfCA(InputStream inputstream)
    {
        BufferedInputStream bufferedinputstream = null;
        BufferedInputStream bufferedinputstream1;
        CertificateFactory certificatefactory;
        certificatefactory = CertificateFactory.getInstance("X.509");
        bufferedinputstream1 = new BufferedInputStream(inputstream);
        java.security.cert.Certificate certificate1 = certificatefactory.generateCertificate(bufferedinputstream1);
        java.security.cert.Certificate certificate;
        KeyStore keystore1;
        certificate = certificate1;
        String s;
        if (bufferedinputstream1 != null)
        {
            try
            {
                bufferedinputstream1.close();
            }
            catch (IOException ioexception2)
            {
                ioexception2.printStackTrace();
            }
        }
_L1:
        s = KeyStore.getDefaultType();
        keystore1 = KeyStore.getInstance(s);
        keystore1.load(null, null);
        keystore1.setCertificateEntry("ca", certificate);
        return keystore1;
        CertificateException certificateexception;
        certificateexception;
        bufferedinputstream1 = null;
_L6:
        certificateexception.printStackTrace();
        if (bufferedinputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        bufferedinputstream1.close();
        certificate = null;
          goto _L1
        IOException ioexception1;
        ioexception1;
        ioexception1.printStackTrace();
        certificate = null;
          goto _L1
        Exception exception;
        exception;
_L5:
        if (bufferedinputstream != null)
        {
            try
            {
                bufferedinputstream.close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        throw exception;
        Exception exception1;
        exception1;
        KeyStore keystore;
        Exception exception2;
        keystore = null;
        exception2 = exception1;
_L3:
        exception2.printStackTrace();
        return keystore;
        Exception exception3;
        exception3;
        keystore = keystore1;
        exception2 = exception3;
        if (true) goto _L3; else goto _L2
_L2:
        exception;
        bufferedinputstream = bufferedinputstream1;
        if (true) goto _L5; else goto _L4
_L4:
        certificateexception;
          goto _L6
    }

    public static DefaultHttpClient getNewHttpClient(KeyStore keystore)
    {
        DefaultHttpClient defaulthttpclient;
        try
        {
            MySSLSocketFactory mysslsocketfactory = new MySSLSocketFactory(keystore);
            SchemeRegistry schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeregistry.register(new Scheme("https", mysslsocketfactory, 443));
            BasicHttpParams basichttpparams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
            defaulthttpclient = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
        }
        catch (Exception exception)
        {
            return new DefaultHttpClient();
        }
        return defaulthttpclient;
    }

    public Socket createSocket()
    {
        return a.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
    {
        return a.getSocketFactory().createSocket(socket, s, i, flag);
    }

    public void fixHttpsURLConnection()
    {
        HttpsURLConnection.setDefaultSSLSocketFactory(a.getSocketFactory());
    }
}
