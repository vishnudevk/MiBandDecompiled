// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.tencent.utils:
//            b, a, AsynLoadImgBack, Util

public class AsynLoadImg
{

    private static String d;
    Activity a;
    private String b;
    private AsynLoadImgBack c;
    private long e;
    private Handler f;
    private Runnable g;

    public AsynLoadImg(Activity activity)
    {
        g = new b(this);
        a = activity;
        f = new a(this, activity.getMainLooper());
    }

    static AsynLoadImgBack a(AsynLoadImg asynloadimg)
    {
        return asynloadimg.c;
    }

    static String a()
    {
        return d;
    }

    static String b(AsynLoadImg asynloadimg)
    {
        return asynloadimg.b;
    }

    static Handler c(AsynLoadImg asynloadimg)
    {
        return asynloadimg.f;
    }

    static long d(AsynLoadImg asynloadimg)
    {
        return asynloadimg.e;
    }

    public static Bitmap getbitmap(String s)
    {
        Log.v("AsynLoadImg", (new StringBuilder()).append("getbitmap:").append(s).toString());
        Bitmap bitmap;
        try
        {
            HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
            httpurlconnection.setDoInput(true);
            httpurlconnection.connect();
            InputStream inputstream = httpurlconnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputstream);
            inputstream.close();
            Log.v("AsynLoadImg", (new StringBuilder()).append("image download finished.").append(s).toString());
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            Log.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
        return bitmap;
    }

    public void save(String s, AsynLoadImgBack asynloadimgback)
    {
        Log.v("AsynLoadImg", "--save---");
        if (s == null || s.equals(""))
        {
            asynloadimgback.saved(1, null);
            return;
        }
        if (!Util.hasSDCard())
        {
            asynloadimgback.saved(2, null);
            return;
        } else
        {
            d = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/tmp/").toString();
            e = System.currentTimeMillis();
            b = s;
            c = asynloadimgback;
            (new Thread(g)).start();
            return;
        }
    }

    public boolean saveFile(Bitmap bitmap, String s)
    {
        String s1 = d;
        try
        {
            File file = new File(s1);
            if (!file.exists())
            {
                file.mkdir();
            }
            String s2 = (new StringBuilder()).append(s1).append(s).toString();
            Log.v("AsynLoadImg", (new StringBuilder()).append("saveFile:").append(s).toString());
            BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(new File(s2)));
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, bufferedoutputstream);
            bufferedoutputstream.flush();
            bufferedoutputstream.close();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            Log.v("AsynLoadImg", "saveFile bmp fail---");
            return false;
        }
        return true;
    }
}
