// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

// Referenced classes of package com.loopj.android.http:
//            Base64OutputStream, ResponseHandlerInterface, AsyncHttpClient

class v
    implements HttpEntity
{

    private static final String a = "JsonStreamerEntity";
    private static final UnsupportedOperationException b = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final int c = 4096;
    private static final StringBuilder e = new StringBuilder(128);
    private static final byte f[] = "true".getBytes();
    private static final byte g[] = "false".getBytes();
    private static final byte h[] = "null".getBytes();
    private static final byte i[] = a("name");
    private static final byte j[] = a("type");
    private static final byte k[] = a("contents");
    private static final byte l[] = a("_elapsed");
    private static final Header m = new BasicHeader("Content-Type", "application/json");
    private static final Header n = new BasicHeader("Content-Encoding", "gzip");
    private final byte d[] = new byte[4096];
    private final Map o = new HashMap();
    private final Header p;
    private final ResponseHandlerInterface q;

    public v(ResponseHandlerInterface responsehandlerinterface, boolean flag)
    {
        q = responsehandlerinterface;
        Header header;
        if (flag)
        {
            header = n;
        } else
        {
            header = null;
        }
        p = header;
    }

    private void a(OutputStream outputstream)
    {
        outputstream.write(34);
    }

    private void a(OutputStream outputstream, RequestParams.FileWrapper filewrapper)
    {
        a(outputstream, filewrapper.file.getName(), filewrapper.contentType);
        int i1 = (int)filewrapper.file.length();
        FileInputStream fileinputstream = new FileInputStream(filewrapper.file);
        Base64OutputStream base64outputstream = new Base64OutputStream(outputstream, 18);
        int j1 = 0;
        do
        {
            int k1 = fileinputstream.read(d);
            if (k1 != -1)
            {
                base64outputstream.write(d, 0, k1);
                j1 += k1;
                q.sendProgressMessage(j1, i1);
            } else
            {
                AsyncHttpClient.silentCloseOutputStream(base64outputstream);
                a(outputstream);
                AsyncHttpClient.silentCloseInputStream(fileinputstream);
                return;
            }
        } while (true);
    }

    private void a(OutputStream outputstream, RequestParams.StreamWrapper streamwrapper)
    {
        a(outputstream, streamwrapper.name, streamwrapper.contentType);
        Base64OutputStream base64outputstream = new Base64OutputStream(outputstream, 18);
        do
        {
            int i1 = streamwrapper.inputStream.read(d);
            if (i1 == -1)
            {
                break;
            }
            base64outputstream.write(d, 0, i1);
        } while (true);
        AsyncHttpClient.silentCloseOutputStream(base64outputstream);
        a(outputstream);
        if (streamwrapper.autoClose)
        {
            AsyncHttpClient.silentCloseInputStream(streamwrapper.inputStream);
        }
    }

    private void a(OutputStream outputstream, String s, String s1)
    {
        outputstream.write(i);
        outputstream.write(58);
        outputstream.write(a(s));
        outputstream.write(44);
        outputstream.write(j);
        outputstream.write(58);
        outputstream.write(a(s1));
        outputstream.write(44);
        outputstream.write(k);
        outputstream.write(58);
        outputstream.write(34);
    }

    static byte[] a(String s)
    {
        int i1;
        int j1;
        if (s == null)
        {
            return h;
        }
        e.append('"');
        i1 = s.length();
        j1 = -1;
_L10:
        int k1;
        char c1;
        k1 = j1 + 1;
        if (k1 >= i1)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        c1 = s.charAt(k1);
        c1;
        JVM INSTR lookupswitch 7: default 112
    //                   8: 232
    //                   9: 280
    //                   10: 256
    //                   12: 244
    //                   13: 268
    //                   34: 205
    //                   92: 220;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break; /* Loop/switch isn't completed */
_L7:
        e.append("\\\"");
_L11:
        j1 = k1;
        if (true) goto _L10; else goto _L9
_L9:
        e.append("\\\\");
          goto _L11
_L2:
        e.append("\\b");
          goto _L11
_L5:
        e.append("\\f");
          goto _L11
_L4:
        e.append("\\n");
          goto _L11
_L6:
        e.append("\\r");
          goto _L11
_L3:
        e.append("\\t");
          goto _L11
_L1:
        if ((c1 < 0 || c1 > '\037') && (c1 < '\177' || c1 > '\237') && (c1 < '\u2000' || c1 > '\u20FF'))
        {
            break MISSING_BLOCK_LABEL_310;
        }
        String s1 = Integer.toHexString(c1);
        e.append("\\u");
        int l1 = 4 - s1.length();
        for (int i2 = 0; i2 < l1; i2++)
        {
            e.append('0');
        }

        e.append(s1.toUpperCase(Locale.US));
        break; /* Loop/switch isn't completed */
        e.append(c1);
          goto _L11
        e.append('"');
        byte abyte0[] = e.toString().getBytes();
        e.setLength(0);
        return abyte0;
        Exception exception;
        exception;
        e.setLength(0);
        throw exception;
    }

    public void a(String s, Object obj)
    {
        o.put(s, obj);
    }

    public void consumeContent()
    {
    }

    public InputStream getContent()
    {
        throw b;
    }

    public Header getContentEncoding()
    {
        return p;
    }

    public long getContentLength()
    {
        return -1L;
    }

    public Header getContentType()
    {
        return m;
    }

    public boolean isChunked()
    {
        return false;
    }

    public boolean isRepeatable()
    {
        return false;
    }

    public boolean isStreaming()
    {
        return false;
    }

    public void writeTo(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        long l1 = System.currentTimeMillis();
        if (p != null)
        {
            outputstream = new GZIPOutputStream(outputstream, 4096);
        }
        outputstream.write(123);
        Iterator iterator = o.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Object obj = o.get(s);
            if (obj != null)
            {
                outputstream.write(a(s));
                outputstream.write(58);
                boolean flag = obj instanceof RequestParams.FileWrapper;
                if (flag || (obj instanceof RequestParams.StreamWrapper))
                {
                    outputstream.write(123);
                    if (flag)
                    {
                        a(outputstream, (RequestParams.FileWrapper)obj);
                    } else
                    {
                        a(outputstream, (RequestParams.StreamWrapper)obj);
                    }
                    outputstream.write(125);
                } else
                if (obj instanceof Boolean)
                {
                    byte abyte0[];
                    if (((Boolean)obj).booleanValue())
                    {
                        abyte0 = f;
                    } else
                    {
                        abyte0 = g;
                    }
                    outputstream.write(abyte0);
                } else
                if (obj instanceof Long)
                {
                    outputstream.write((new StringBuilder()).append(((Number)obj).longValue()).append("").toString().getBytes());
                } else
                if (obj instanceof Double)
                {
                    outputstream.write((new StringBuilder()).append(((Number)obj).doubleValue()).append("").toString().getBytes());
                } else
                if (obj instanceof Float)
                {
                    outputstream.write((new StringBuilder()).append(((Number)obj).floatValue()).append("").toString().getBytes());
                } else
                if (obj instanceof Integer)
                {
                    outputstream.write((new StringBuilder()).append(((Number)obj).intValue()).append("").toString().getBytes());
                } else
                {
                    outputstream.write(obj.toString().getBytes());
                }
                outputstream.write(44);
            }
        } while (true);
        outputstream.write(l);
        outputstream.write(58);
        long l2 = System.currentTimeMillis() - l1;
        outputstream.write((new StringBuilder()).append(l2).append("}").toString().getBytes());
        Log.i("JsonStreamerEntity", (new StringBuilder()).append("Uploaded JSON in ").append(Math.floor(l2 / 1000L)).append(" seconds").toString());
        outputstream.flush();
        AsyncHttpClient.silentCloseOutputStream(outputstream);
    }

}
