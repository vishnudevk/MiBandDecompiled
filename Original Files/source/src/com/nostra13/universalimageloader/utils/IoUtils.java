// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IoUtils
{

    public static final int CONTINUE_LOADING_PERCENTAGE = 75;
    public static final int DEFAULT_BUFFER_SIZE = 32768;

    private IoUtils()
    {
    }

    private static boolean a(CopyListener copylistener, int i, int j)
    {
        return copylistener != null && !copylistener.onBytesCopied(i, j) && (i * 100) / j < 75;
    }

    public static void closeSilently(Closeable closeable)
    {
        try
        {
            closeable.close();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public static boolean copyStream(InputStream inputstream, OutputStream outputstream, CopyListener copylistener)
    {
        return copyStream(inputstream, outputstream, copylistener, 32768);
    }

    public static boolean copyStream(InputStream inputstream, OutputStream outputstream, CopyListener copylistener, int i)
    {
        int j = inputstream.available();
        byte abyte0[] = new byte[i];
        if (a(copylistener, 0, j))
        {
            return false;
        }
        int k = 0;
        do
        {
            int l = inputstream.read(abyte0, 0, i);
            if (l != -1)
            {
                outputstream.write(abyte0, 0, l);
                k += l;
                if (a(copylistener, k, j))
                {
                    return false;
                }
            } else
            {
                outputstream.flush();
                return true;
            }
        } while (true);
    }

    public static void readAndCloseStream(InputStream inputstream)
    {
        byte abyte0[] = new byte[32768];
        int i;
        do
        {
            i = inputstream.read(abyte0, 0, 32768);
        } while (i != -1);
        closeSilently(inputstream);
        return;
        IOException ioexception;
        ioexception;
        closeSilently(inputstream);
        return;
        Exception exception;
        exception;
        closeSilently(inputstream);
        throw exception;
    }

    private class CopyListener
    {

        public abstract boolean onBytesCopied(int i, int j);
    }

}
