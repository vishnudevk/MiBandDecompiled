// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

// Referenced classes of package com.loopj.android.http:
//            FileAsyncHttpResponseHandler

public abstract class RangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler
{

    private static final String b = "RangeFileAsyncHttpResponseHandler";
    private long c;
    private boolean d;

    public RangeFileAsyncHttpResponseHandler(File file)
    {
        super(file);
        c = 0L;
        d = false;
    }

    protected byte[] getResponseData(HttpEntity httpentity)
    {
        InputStream inputstream;
        long l;
        FileOutputStream fileoutputstream;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        inputstream = httpentity.getContent();
        l = httpentity.getContentLength() + c;
        fileoutputstream = new FileOutputStream(getTargetFile(), d);
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        byte abyte0[] = new byte[4096];
_L1:
        int i;
        if (c >= l)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_138;
        }
        c = c + (long)i;
        fileoutputstream.write(abyte0, 0, i);
        sendProgressMessage((int)c, (int)l);
          goto _L1
        Exception exception;
        exception;
        inputstream.close();
        fileoutputstream.flush();
        fileoutputstream.close();
        throw exception;
        inputstream.close();
        fileoutputstream.flush();
        fileoutputstream.close();
        return null;
    }

    public void sendResponseMessage(HttpResponse httpresponse)
    {
        if (Thread.currentThread().isInterrupted()) goto _L2; else goto _L1
_L1:
        StatusLine statusline = httpresponse.getStatusLine();
        if (statusline.getStatusCode() != 416) goto _L4; else goto _L3
_L3:
        if (!Thread.currentThread().isInterrupted())
        {
            sendSuccessMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), null);
        }
_L2:
        return;
_L4:
        if (statusline.getStatusCode() < 300)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (Thread.currentThread().isInterrupted()) goto _L2; else goto _L5
_L5:
        sendFailureMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), null, new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()));
        return;
        if (Thread.currentThread().isInterrupted()) goto _L2; else goto _L6
_L6:
        Header header = httpresponse.getFirstHeader("Content-Range");
        if (header == null)
        {
            d = false;
            c = 0L;
        } else
        {
            Log.v("RangeFileAsyncHttpResponseHandler", (new StringBuilder()).append("Content-Rnage: ").append(header.getValue()).toString());
        }
        sendSuccessMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), getResponseData(httpresponse.getEntity()));
        return;
    }

    public void updateRequestHeaders(HttpUriRequest httpurirequest)
    {
        if (mFile.exists() && mFile.canWrite())
        {
            c = mFile.length();
        }
        if (c > 0L)
        {
            d = true;
            httpurirequest.setHeader("Range", (new StringBuilder()).append("bytes=").append(c).append("-").toString());
        }
    }
}
