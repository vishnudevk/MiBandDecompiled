// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler, AsyncHttpClient

public abstract class FileAsyncHttpResponseHandler extends AsyncHttpResponseHandler
{

    static final boolean a = false;
    private static final String b = "FileAsyncHttpResponseHandler";
    protected final File mFile;

    public FileAsyncHttpResponseHandler(Context context)
    {
        mFile = getTemporaryFile(context);
    }

    public FileAsyncHttpResponseHandler(File file)
    {
        if (!a && file == null)
        {
            throw new AssertionError();
        } else
        {
            mFile = file;
            return;
        }
    }

    public boolean deleteTargetFile()
    {
        return getTargetFile() != null && getTargetFile().delete();
    }

    protected byte[] getResponseData(HttpEntity httpentity)
    {
        int i;
        InputStream inputstream;
        long l;
        FileOutputStream fileoutputstream;
        i = 0;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        inputstream = httpentity.getContent();
        l = httpentity.getContentLength();
        fileoutputstream = new FileOutputStream(getTargetFile());
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        byte abyte0[] = new byte[4096];
_L1:
        int j = inputstream.read(abyte0);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_113;
        }
        i += j;
        fileoutputstream.write(abyte0, 0, j);
        sendProgressMessage(i, (int)l);
          goto _L1
        Exception exception;
        exception;
        AsyncHttpClient.silentCloseInputStream(inputstream);
        fileoutputstream.flush();
        AsyncHttpClient.silentCloseOutputStream(fileoutputstream);
        throw exception;
        AsyncHttpClient.silentCloseInputStream(inputstream);
        fileoutputstream.flush();
        AsyncHttpClient.silentCloseOutputStream(fileoutputstream);
        return null;
    }

    protected File getTargetFile()
    {
        if (!a && mFile == null)
        {
            throw new AssertionError();
        } else
        {
            return mFile;
        }
    }

    protected File getTemporaryFile(Context context)
    {
        if (!a && context == null)
        {
            throw new AssertionError();
        }
        File file;
        try
        {
            file = File.createTempFile("temp_", "_handled", context.getCacheDir());
        }
        catch (Throwable throwable)
        {
            Log.e("FileAsyncHttpResponseHandler", "Cannot create temporary file", throwable);
            return null;
        }
        return file;
    }

    public abstract void onFailure(int i, Header aheader[], Throwable throwable, File file);

    public final void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        onFailure(i, aheader, throwable, getTargetFile());
    }

    public abstract void onSuccess(int i, Header aheader[], File file);

    public final void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        onSuccess(i, aheader, getTargetFile());
    }

    static 
    {
        boolean flag;
        if (!com/loopj/android/http/FileAsyncHttpResponseHandler.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
