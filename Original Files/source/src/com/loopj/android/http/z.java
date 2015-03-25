// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class z
    implements HttpRequestRetryHandler
{

    private static final HashSet a;
    private static final HashSet b;
    private final int c;
    private final int d;

    public z(int i, int j)
    {
        c = i;
        d = j;
    }

    static void a(Class class1)
    {
        a.add(class1);
    }

    static void b(Class class1)
    {
        b.add(class1);
    }

    protected boolean a(HashSet hashset, Throwable throwable)
    {
        for (Iterator iterator = hashset.iterator(); iterator.hasNext();)
        {
            if (((Class)iterator.next()).isInstance(throwable))
            {
                return true;
            }
        }

        return false;
    }

    public boolean retryRequest(IOException ioexception, int i, HttpContext httpcontext)
    {
        boolean flag;
        boolean flag1;
        flag = true;
        Boolean boolean1 = (Boolean)httpcontext.getAttribute("http.request_sent");
        if (boolean1 != null && boolean1.booleanValue())
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        if (i <= c) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        if (flag && (HttpUriRequest)httpcontext.getAttribute("http.request") == null)
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (!a(a, ioexception))
        {
            if (a(b, ioexception))
            {
                flag = false;
            } else
            if (flag1);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (flag)
        {
            SystemClock.sleep(d);
        } else
        {
            ioexception.printStackTrace();
        }
        return flag;
    }

    static 
    {
        a = new HashSet();
        b = new HashSet();
        a.add(org/apache/http/NoHttpResponseException);
        a.add(java/net/UnknownHostException);
        a.add(java/net/SocketException);
        b.add(java/io/InterruptedIOException);
        b.add(javax/net/ssl/SSLException);
    }
}
