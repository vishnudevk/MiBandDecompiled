// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ShareUtils
{

    public ShareUtils()
    {
    }

    public static Bitmap compressBitmap(Bitmap bitmap, int i, int j, android.graphics.Bitmap.Config config)
    {
        int k = bitmap.getWidth();
        int l = bitmap.getHeight();
        if (k < i && l < i)
        {
            return bitmap;
        } else
        {
            Rect rect = new Rect(0, 0, k, l);
            Rect rect1 = new Rect(0, 0, i, j);
            Bitmap bitmap1 = Bitmap.createBitmap(i, j, config);
            (new Canvas(bitmap1)).drawBitmap(bitmap, rect, rect1, new Paint());
            return bitmap1;
        }
    }

    public static Bitmap compressBitmapWithNoDistortion(Bitmap bitmap, int i, int j, android.graphics.Bitmap.Config config)
    {
        int k = bitmap.getWidth();
        int l = bitmap.getHeight();
        if (k < i && l < i)
        {
            return bitmap;
        }
        double d;
        if ((double)k / (double)i > (double)l / (double)j)
        {
            d = (double)k / (double)i;
        } else
        {
            d = (double)l / (double)j;
        }
        return compressBitmap(bitmap, (int)((double)k / d), (int)((double)l / d), config);
    }

    public static void createDirForNewFile(String s)
    {
        File file = new File(s.substring(0, s.lastIndexOf("/")));
        if (!file.exists())
        {
            file.mkdirs();
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable)
    {
        if (drawable == null)
        {
            return null;
        }
        int i = drawable.getIntrinsicWidth();
        int j = drawable.getIntrinsicHeight();
        android.graphics.Bitmap.Config config;
        Bitmap bitmap;
        Canvas canvas;
        if (drawable.getOpacity() != -1)
        {
            config = android.graphics.Bitmap.Config.ARGB_8888;
        } else
        {
            config = android.graphics.Bitmap.Config.RGB_565;
        }
        bitmap = Bitmap.createBitmap(i, j, config);
        canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static File getTmpImgFile()
    {
        File file;
        boolean flag;
        file = new File(new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "miliaoshare"), "images");
        if (file.isDirectory())
        {
            break MISSING_BLOCK_LABEL_45;
        }
        flag = file.mkdirs();
        File file2;
        file2 = null;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        File file1;
        try
        {
            file1 = new File(file, "sharedSourceImgTmp.jpg");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        file2 = file1;
        return file2;
    }

    public static boolean saveBitmap(Bitmap bitmap, String s)
    {
        return saveBitmap(bitmap, s, android.graphics.Bitmap.CompressFormat.PNG, 100);
    }

    public static boolean saveBitmap(Bitmap bitmap, String s, android.graphics.Bitmap.CompressFormat compressformat, int i)
    {
        FileOutputStream fileoutputstream = null;
        FileOutputStream fileoutputstream1;
        createDirForNewFile(s);
        File file = new File(s);
        if (!file.exists())
        {
            file.createNewFile();
        }
        fileoutputstream1 = new FileOutputStream(file);
        boolean flag = bitmap.compress(compressformat, i, fileoutputstream1);
        Exception exception1;
        Exception exception;
        IOException ioexception1;
        if (fileoutputstream1 != null)
        {
            try
            {
                fileoutputstream1.close();
            }
            catch (IOException ioexception4)
            {
                return flag;
            }
        }
        return flag;
        ioexception1;
_L4:
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (IOException ioexception2) { }
        }
        return false;
        exception;
        fileoutputstream1 = null;
        exception1 = exception;
_L2:
        if (fileoutputstream1 != null)
        {
            try
            {
                fileoutputstream1.close();
            }
            catch (IOException ioexception) { }
        }
        throw exception1;
        exception1;
        if (true) goto _L2; else goto _L1
_L1:
        IOException ioexception3;
        ioexception3;
        fileoutputstream = fileoutputstream1;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
