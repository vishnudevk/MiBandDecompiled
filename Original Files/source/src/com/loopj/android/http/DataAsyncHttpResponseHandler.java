// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.util.ByteArrayBuffer;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler, AsyncHttpClient

public abstract class DataAsyncHttpResponseHandler extends AsyncHttpResponseHandler
{

    protected static final int PROGRESS_DATA_MESSAGE = 6;
    private static final String a = "DataAsyncHttpResponseHandler";

    public DataAsyncHttpResponseHandler()
    {
    }

    public static byte[] copyOfRange(byte abyte0[], int i, int j)
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        int k = abyte0.length;
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            int l = j - i;
            int i1 = Math.min(l, k - i);
            byte abyte1[] = new byte[l];
            System.arraycopy(abyte0, i, abyte1, 0, i1);
            return abyte1;
        }
    }

    byte[] getResponseData(HttpEntity httpentity)
    {
        byte abyte0[];
        InputStream inputstream;
        long l;
        abyte0 = null;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        inputstream = httpentity.getContent();
        abyte0 = null;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        l = httpentity.getContentLength();
        if (l > 0x7fffffffL)
        {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        if (l < 0L)
        {
            l = 4096L;
        }
        ByteArrayBuffer bytearraybuffer = new ByteArrayBuffer((int)l);
        byte abyte1[] = new byte[4096];
_L1:
        int i = inputstream.read(abyte1);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_149;
        }
        bytearraybuffer.append(abyte1, 0, i);
        sendProgressDataMessage(copyOfRange(abyte1, 0, i));
          goto _L1
        Exception exception;
        exception;
        try
        {
            AsyncHttpClient.silentCloseInputStream(inputstream);
            throw exception;
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            System.gc();
        }
        throw new IOException("File too large to fit into available memory");
        byte abyte2[];
        AsyncHttpClient.silentCloseInputStream(inputstream);
        abyte2 = bytearraybuffer.toByteArray();
        abyte0 = abyte2;
        return abyte0;
    }

    protected void handleMessage(Message message)
    {
        super.handleMessage(message);
        Object aobj[];
        switch (message.what)
        {
        default:
            return;

        case 6: // '\006'
            aobj = (Object[])(Object[])message.obj;
            break;
        }
        if (aobj != null && aobj.length >= 1)
        {
            try
            {
                onProgressData((byte[])(byte[])aobj[0]);
                return;
            }
            catch (Throwable throwable)
            {
                Log.e("DataAsyncHttpResponseHandler", "custom onProgressData contains an error", throwable);
            }
            return;
        } else
        {
            Log.e("DataAsyncHttpResponseHandler", "PROGRESS_DATA_MESSAGE didn't got enough params");
            return;
        }
    }

    public void onProgressData(byte abyte0[])
    {
    }

    public final void sendProgressDataMessage(byte abyte0[])
    {
        sendMessage(obtainMessage(6, ((Object) (new Object[] {
            abyte0
        }))));
    }
}
