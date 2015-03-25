// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

// Referenced classes of package com.loopj.android.http:
//            ResponseHandlerInterface, B, AsyncHttpClient

class A
    implements HttpEntity
{

    private static final String a = "SimpleMultipartEntity";
    private static final String b = "\r\n";
    private static final byte c[] = "\r\n".getBytes();
    private static final byte d[] = "Content-Transfer-Encoding: binary\r\n".getBytes();
    private static final char e[] = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final String f;
    private final byte g[];
    private final byte h[];
    private boolean i;
    private final List j = new ArrayList();
    private final ByteArrayOutputStream k = new ByteArrayOutputStream();
    private final ResponseHandlerInterface l;
    private int m;
    private int n;

    public A(ResponseHandlerInterface responsehandlerinterface)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Random random = new Random();
        for (int i1 = 0; i1 < 30; i1++)
        {
            stringbuilder.append(e[random.nextInt(e.length)]);
        }

        f = stringbuilder.toString();
        g = (new StringBuilder()).append("--").append(f).append("\r\n").toString().getBytes();
        h = (new StringBuilder()).append("--").append(f).append("--").append("\r\n").toString().getBytes();
        l = responsehandlerinterface;
    }

    private String a(String s)
    {
        if (s == null)
        {
            s = "application/octet-stream";
        }
        return s;
    }

    private void a(int i1)
    {
        m = i1 + m;
        l.sendProgressMessage(m, n);
    }

    static void a(A a1, int i1)
    {
        a1.a(i1);
    }

    static byte[] a()
    {
        return d;
    }

    static byte[] a(A a1)
    {
        return a1.g;
    }

    static byte[] a(A a1, String s)
    {
        return a1.b(s);
    }

    static byte[] a(A a1, String s, String s1)
    {
        return a1.b(s, s1);
    }

    static byte[] b()
    {
        return c;
    }

    private byte[] b(String s)
    {
        return (new StringBuilder()).append("Content-Type: ").append(a(s)).append("\r\n").toString().getBytes();
    }

    private byte[] b(String s, String s1)
    {
        return (new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\"; filename=\"").append(s1).append("\"").append("\r\n").toString().getBytes();
    }

    private byte[] c(String s)
    {
        return (new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\"").append("\r\n").toString().getBytes();
    }

    public void a(String s, File file)
    {
        a(s, file, null);
    }

    public void a(String s, File file, String s1)
    {
        j.add(new B(this, s, file, a(s1)));
    }

    public void a(String s, String s1)
    {
        a(s, s1, "text/plain; charset=UTF-8");
    }

    public void a(String s, String s1, InputStream inputstream, String s2)
    {
        k.write(g);
        k.write(b(s, s1));
        k.write(b(s2));
        k.write(d);
        k.write(c);
        byte abyte0[] = new byte[4096];
        do
        {
            int i1 = inputstream.read(abyte0);
            if (i1 != -1)
            {
                k.write(abyte0, 0, i1);
            } else
            {
                k.write(c);
                k.flush();
                AsyncHttpClient.silentCloseOutputStream(k);
                return;
            }
        } while (true);
    }

    public void a(String s, String s1, String s2)
    {
        try
        {
            k.write(g);
            k.write(c(s));
            k.write(b(s2));
            k.write(c);
            k.write(s1.getBytes());
            k.write(c);
            return;
        }
        catch (IOException ioexception)
        {
            Log.e("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", ioexception);
        }
    }

    public void a(boolean flag)
    {
        i = flag;
    }

    public void consumeContent()
    {
        if (isStreaming())
        {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        } else
        {
            return;
        }
    }

    public InputStream getContent()
    {
        throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
    }

    public Header getContentEncoding()
    {
        return null;
    }

    public long getContentLength()
    {
        long l1 = k.size();
        Iterator iterator = j.iterator();
        long l2;
        long l3;
        for (l2 = l1; iterator.hasNext(); l2 += l3)
        {
            l3 = ((B)iterator.next()).a();
            if (l3 < 0L)
            {
                return -1L;
            }
        }

        return l2 + (long)h.length;
    }

    public Header getContentType()
    {
        return new BasicHeader("Content-Type", (new StringBuilder()).append("multipart/form-data; boundary=").append(f).toString());
    }

    public boolean isChunked()
    {
        return false;
    }

    public boolean isRepeatable()
    {
        return i;
    }

    public boolean isStreaming()
    {
        return false;
    }

    public void writeTo(OutputStream outputstream)
    {
        m = 0;
        n = (int)getContentLength();
        k.writeTo(outputstream);
        a(k.size());
        for (Iterator iterator = j.iterator(); iterator.hasNext(); ((B)iterator.next()).a(outputstream)) { }
        outputstream.write(h);
        a(h.length);
    }

}
