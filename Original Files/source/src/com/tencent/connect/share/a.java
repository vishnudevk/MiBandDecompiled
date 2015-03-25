// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.utils.AsynLoadImgBack;
import com.tencent.utils.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package com.tencent.connect.share:
//            f, e, h, g

public class a
{

    public a()
    {
    }

    public static final int a(android.graphics.BitmapFactory.Options options, int i, int j)
    {
        int k = b(options, i, j);
        int l;
        if (k <= 8)
        {
            for (l = 1; l < k; l <<= 1) { }
        } else
        {
            l = 8 * ((k + 7) / 8);
        }
        return l;
    }

    private static Bitmap a(Bitmap bitmap, int i)
    {
        Matrix matrix = new Matrix();
        int j = bitmap.getWidth();
        int k = bitmap.getHeight();
        float f1;
        if (j <= k)
        {
            j = k;
        }
        f1 = (float)i / (float)j;
        matrix.postScale(f1, f1);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static final Bitmap a(String s, int i)
    {
        Bitmap bitmap;
        if (TextUtils.isEmpty(s))
        {
            bitmap = null;
        } else
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(s, options);
            int j = options.outWidth;
            int k = options.outHeight;
            if (options.mCancel || options.outWidth == -1 || options.outHeight == -1)
            {
                return null;
            }
            if (j <= k)
            {
                j = k;
            }
            options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
            if (j > i)
            {
                options.inSampleSize = a(options, -1, i * i);
            }
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(s, options);
            if (bitmap == null)
            {
                return null;
            }
            int l = options.outWidth;
            int i1 = options.outHeight;
            if (l <= i1)
            {
                l = i1;
            }
            if (l > i)
            {
                return a(bitmap, i);
            }
        }
        return bitmap;
    }

    protected static final String a(Bitmap bitmap, String s, String s1)
    {
        String s2;
        File file1;
        File file = new File(s);
        if (!file.exists())
        {
            file.mkdirs();
        }
        s2 = s + s1;
        file1 = new File(s2);
        if (file1.exists())
        {
            file1.delete();
        }
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        FileOutputStream fileoutputstream = new FileOutputStream(file1);
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, fileoutputstream);
        fileoutputstream.flush();
        fileoutputstream.close();
        bitmap.recycle();
        return s2;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        filenotfoundexception.printStackTrace();
_L2:
        return null;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static final void a(Context context, String s, AsynLoadImgBack asynloadimgback)
    {
        Log.d("AsynScaleCompressImage", "scaleCompressImage");
        if (TextUtils.isEmpty(s))
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
            (new Thread(new f(s, new e(context.getMainLooper(), asynloadimgback)))).start();
            return;
        }
    }

    public static final void a(Context context, ArrayList arraylist, AsynLoadImgBack asynloadimgback)
    {
        Log.d("AsynScaleCompressImage", "batchScaleCompressImage");
        if (arraylist == null)
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
            (new Thread(new h(arraylist, new g(context.getMainLooper(), asynloadimgback)))).start();
            return;
        }
    }

    static boolean a(String s, int i, int j)
    {
        return b(s, i, j);
    }

    private static int b(android.graphics.BitmapFactory.Options options, int i, int j)
    {
        double d = options.outWidth;
        double d1 = options.outHeight;
        int k;
        int l;
        if (j == -1)
        {
            k = 1;
        } else
        {
            k = (int)Math.ceil(Math.sqrt((d * d1) / (double)j));
        }
        if (i == -1)
        {
            l = 128;
        } else
        {
            l = (int)Math.min(Math.floor(d / (double)i), Math.floor(d1 / (double)i));
        }
        if (l >= k)
        {
            if (j == -1 && i == -1)
            {
                return 1;
            }
            if (i != -1)
            {
                return l;
            }
        }
        return k;
    }

    private static final boolean b(String s, int i, int j)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(s, options);
        int k = options.outWidth;
        int l = options.outHeight;
        if (options.mCancel || options.outWidth == -1 || options.outHeight == -1)
        {
            return false;
        }
        int i1;
        if (k > l)
        {
            i1 = k;
        } else
        {
            i1 = l;
        }
        if (k >= l)
        {
            k = l;
        }
        Log.d("AsynScaleCompressImage", (new StringBuilder()).append("longSide=").append(i1).append("shortSide=").append(k).toString());
        options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        return i1 > j || k > i;
    }
}
