// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

// Referenced classes of package com.loopj.android.http:
//            ResponseHandlerInterface, AsyncHttpClient, f

public abstract class AsyncHttpResponseHandler
    implements ResponseHandlerInterface
{

    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    private static final String LOG_TAG = "AsyncHttpResponseHandler";
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE;
    private Handler handler;
    private Header requestHeaders[];
    private URI requestURI;
    private String responseCharset;
    private boolean useSynchronousMode;

    public AsyncHttpResponseHandler()
    {
        responseCharset = "UTF-8";
        requestURI = null;
        requestHeaders = null;
        setUseSynchronousMode(false);
    }

    public String getCharset()
    {
        if (responseCharset == null)
        {
            return "UTF-8";
        } else
        {
            return responseCharset;
        }
    }

    public Header[] getRequestHeaders()
    {
        return requestHeaders;
    }

    public URI getRequestURI()
    {
        return requestURI;
    }

    byte[] getResponseData(HttpEntity httpentity)
    {
        InputStream inputstream;
        long l;
        ByteArrayBuffer bytearraybuffer;
        long l1;
        int i = 4096;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        inputstream = httpentity.getContent();
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        l = httpentity.getContentLength();
        if (l > 0x7fffffffL)
        {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        byte abyte0[];
        int j;
        int k;
        int i1;
        if (l > 0L)
        {
            i = (int)l;
        }
        bytearraybuffer = new ByteArrayBuffer(i);
        abyte0 = new byte[4096];
        j = 0;
_L2:
        k = inputstream.read(abyte0);
        if (k == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (Thread.currentThread().isInterrupted())
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = j + k;
        bytearraybuffer.append(abyte0, 0, k);
        if (l <= 0L)
        {
            l1 = 1L;
        } else
        {
            l1 = l;
        }
        sendProgressMessage(i1, (int)l1);
        j = i1;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        try
        {
            AsyncHttpClient.silentCloseInputStream(inputstream);
            return bytearraybuffer.toByteArray();
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            System.gc();
        }
        break MISSING_BLOCK_LABEL_177;
        exception;
        AsyncHttpClient.silentCloseInputStream(inputstream);
        throw exception;
        throw new IOException("File too large to fit into available memory");
        return null;
    }

    public boolean getUseSynchronousMode()
    {
        return useSynchronousMode;
    }

    protected void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            Object aobj3[] = (Object[])(Object[])message.obj;
            if (aobj3 != null && aobj3.length >= 3)
            {
                onSuccess(((Integer)aobj3[0]).intValue(), (Header[])(Header[])aobj3[1], (byte[])(byte[])aobj3[2]);
                return;
            } else
            {
                Log.e("AsyncHttpResponseHandler", "SUCCESS_MESSAGE didn't got enough params");
                return;
            }

        case 1: // '\001'
            Object aobj2[] = (Object[])(Object[])message.obj;
            if (aobj2 != null && aobj2.length >= 4)
            {
                onFailure(((Integer)aobj2[0]).intValue(), (Header[])(Header[])aobj2[1], (byte[])(byte[])aobj2[2], (Throwable)aobj2[3]);
                return;
            } else
            {
                Log.e("AsyncHttpResponseHandler", "FAILURE_MESSAGE didn't got enough params");
                return;
            }

        case 2: // '\002'
            onStart();
            return;

        case 3: // '\003'
            onFinish();
            return;

        case 4: // '\004'
            Object aobj1[] = (Object[])(Object[])message.obj;
            if (aobj1 != null && aobj1.length >= 2)
            {
                try
                {
                    onProgress(((Integer)aobj1[0]).intValue(), ((Integer)aobj1[1]).intValue());
                    return;
                }
                catch (Throwable throwable)
                {
                    Log.e("AsyncHttpResponseHandler", "custom onProgress contains an error", throwable);
                }
                return;
            } else
            {
                Log.e("AsyncHttpResponseHandler", "PROGRESS_MESSAGE didn't got enough params");
                return;
            }

        case 5: // '\005'
            Object aobj[] = (Object[])(Object[])message.obj;
            if (aobj != null && aobj.length == 1)
            {
                onRetry(((Integer)aobj[0]).intValue());
                return;
            } else
            {
                Log.e("AsyncHttpResponseHandler", "RETRY_MESSAGE didn't get enough params");
                return;
            }

        case 6: // '\006'
            onCancel();
            return;
        }
    }

    protected Message obtainMessage(int i, Object obj)
    {
        if (handler == null)
        {
            Message message = Message.obtain();
            if (message != null)
            {
                message.what = i;
                message.obj = obj;
            }
            return message;
        } else
        {
            return Message.obtain(handler, i, obj);
        }
    }

    public void onCancel()
    {
        Log.d("AsyncHttpResponseHandler", "Request got cancelled");
    }

    public abstract void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable);

    public void onFinish()
    {
    }

    public void onProgress(int i, int j)
    {
        Object aobj[] = new Object[3];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        double d;
        if (j > 0)
        {
            d = 100D * ((1.0D * (double)i) / (double)j);
        } else
        {
            d = -1D;
        }
        aobj[2] = Double.valueOf(d);
        Log.v("AsyncHttpResponseHandler", String.format("Progress %d from %d (%2.0f%%)", aobj));
    }

    public void onRetry(int i)
    {
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(i);
        Log.d("AsyncHttpResponseHandler", String.format("Request retry no. %d", aobj));
    }

    public void onStart()
    {
    }

    public abstract void onSuccess(int i, Header aheader[], byte abyte0[]);

    protected void postRunnable(Runnable runnable)
    {
label0:
        {
            if (runnable != null)
            {
                if (!getUseSynchronousMode() && handler != null)
                {
                    break label0;
                }
                runnable.run();
            }
            return;
        }
        handler.post(runnable);
    }

    public final void sendCancelMessage()
    {
        sendMessage(obtainMessage(6, null));
    }

    public final void sendFailureMessage(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Object aobj[] = new Object[4];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = aheader;
        aobj[2] = abyte0;
        aobj[3] = throwable;
        sendMessage(obtainMessage(1, ((Object) (aobj))));
    }

    public final void sendFinishMessage()
    {
        sendMessage(obtainMessage(3, null));
    }

    protected void sendMessage(Message message)
    {
        if (getUseSynchronousMode() || handler == null)
        {
            handleMessage(message);
        } else
        if (!Thread.currentThread().isInterrupted())
        {
            handler.sendMessage(message);
            return;
        }
    }

    public final void sendProgressMessage(int i, int j)
    {
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        sendMessage(obtainMessage(4, ((Object) (aobj))));
    }

    public void sendResponseMessage(HttpResponse httpresponse)
    {
        StatusLine statusline;
        byte abyte0[];
label0:
        {
            if (!Thread.currentThread().isInterrupted())
            {
                statusline = httpresponse.getStatusLine();
                abyte0 = getResponseData(httpresponse.getEntity());
                if (!Thread.currentThread().isInterrupted())
                {
                    if (statusline.getStatusCode() < 300)
                    {
                        break label0;
                    }
                    sendFailureMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), abyte0, new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()));
                }
            }
            return;
        }
        sendSuccessMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), abyte0);
    }

    public final void sendRetryMessage(int i)
    {
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(i);
        sendMessage(obtainMessage(5, ((Object) (aobj))));
    }

    public final void sendStartMessage()
    {
        sendMessage(obtainMessage(2, null));
    }

    public final void sendSuccessMessage(int i, Header aheader[], byte abyte0[])
    {
        Object aobj[] = new Object[3];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = aheader;
        aobj[2] = abyte0;
        sendMessage(obtainMessage(0, ((Object) (aobj))));
    }

    public void setCharset(String s)
    {
        responseCharset = s;
    }

    public void setRequestHeaders(Header aheader[])
    {
        requestHeaders = aheader;
    }

    public void setRequestURI(URI uri)
    {
        requestURI = uri;
    }

    public void setUseSynchronousMode(boolean flag)
    {
        if (!flag && Looper.myLooper() == null)
        {
            flag = true;
            Log.w("AsyncHttpResponseHandler", "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
        }
        if (flag || handler != null) goto _L2; else goto _L1
_L1:
        handler = new f(this);
_L4:
        useSynchronousMode = flag;
        return;
_L2:
        if (flag && handler != null)
        {
            handler = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
