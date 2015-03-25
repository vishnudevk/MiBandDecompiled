// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class BitmapHelper
{

    public BitmapHelper()
    {
    }

    public static int getSampleSizeAutoFitToScreen(int i, int j, int k, int l)
    {
        if (j == 0 || i == 0)
        {
            return 1;
        } else
        {
            return Math.min(Math.max(k / i, l / j), Math.max(l / i, k / j));
        }
    }

    public static int getSampleSizeOfNotTooLarge(Rect rect)
    {
        double d = (2D * ((double)rect.width() * (double)rect.height())) / 5242880D;
        if (d >= 1.0D)
        {
            return (int)d;
        } else
        {
            return 1;
        }
    }

    public static boolean makesureSizeNotTooLarge(Rect rect)
    {
        return 2 * (rect.width() * rect.height()) <= 0x500000;
    }

    public static boolean verifyBitmap(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return false;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (!(inputstream instanceof BufferedInputStream))
        {
            inputstream = new BufferedInputStream(inputstream);
        }
        BitmapFactory.decodeStream(inputstream, null, options);
        try
        {
            inputstream.close();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        return options.outHeight > 0 && options.outWidth > 0;
    }

    public static boolean verifyBitmap(String s)
    {
        boolean flag;
        try
        {
            flag = verifyBitmap(((InputStream) (new FileInputStream(s))));
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            filenotfoundexception.printStackTrace();
            return false;
        }
        return flag;
    }

    public static boolean verifyBitmap(byte abyte0[])
    {
        return verifyBitmap(((InputStream) (new ByteArrayInputStream(abyte0))));
    }
}
