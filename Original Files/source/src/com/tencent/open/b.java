// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class b extends AsyncTask
{

    private static final SimpleDateFormat a;
    private a b;

    public b(a a1)
    {
        b = a1;
    }

    private int a(android.graphics.BitmapFactory.Options options, int i, int j)
    {
        int j1;
label0:
        {
            int k = options.outHeight;
            int l = options.outWidth;
            int i1 = 1;
            if (k > j || l > i)
            {
                i1 = Math.round((float)k / (float)j);
                j1 = Math.round((float)l / (float)i);
                if (i1 >= j1)
                {
                    break label0;
                }
            }
            return i1;
        }
        return j1;
    }

    private Bitmap a(Bitmap bitmap)
    {
        boolean flag = true;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
        if (bytearrayoutputstream.toByteArray().length / 1024 > 1024)
        {
            bytearrayoutputstream.reset();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 50, bytearrayoutputstream);
        }
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = flag;
        BitmapFactory.decodeStream(bytearrayinputstream, null, options);
        options.inJustDecodeBounds = false;
        int i = a(options, 320, 320);
        if (i > 0)
        {
            flag = i;
        }
        Log.i("comp", (new StringBuilder()).append("comp be=").append(flag).toString());
        options.inSampleSize = ((flag) ? 1 : 0);
        return BitmapFactory.decodeStream(new ByteArrayInputStream(bytearrayoutputstream.toByteArray()), null, options);
    }

    private String a(long l)
    {
        Date date = new Date(l);
        return a.format(date);
    }

    public static void a(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_28;
        }
        File file = new File(s);
        if (file.exists())
        {
            file.delete();
        }
        return;
        Exception exception;
        exception;
    }

    public static boolean a()
    {
        while (Environment.getExternalStorageState().equals("mounted") || (new File("/mnt/sdcard-ext")).isDirectory()) 
        {
            return true;
        }
        return false;
    }

    private String b()
    {
        String s = ".";
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            s = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else
        if ((new File("/mnt/sdcard-ext")).isDirectory())
        {
            return "/mnt/sdcard-ext";
        }
        return s;
    }

    private String b(Bitmap bitmap)
    {
        FileOutputStream fileoutputstream = null;
        String s;
        FileOutputStream fileoutputstream1;
        String s1 = (new StringBuilder()).append(a(System.currentTimeMillis())).append(".png").toString();
        String s2 = (new StringBuilder()).append(b()).append(File.separator).append(".AppCenterWebBuffer").toString();
        s = (new StringBuilder()).append(s2).append(File.separator).append(s1).toString();
        File file = new File(s2);
        if (!file.exists())
        {
            if (file.mkdirs());
        }
        File file1 = new File(s);
        if (file1.exists())
        {
            file1.delete();
        }
        file1.createNewFile();
        fileoutputstream1 = new FileOutputStream(file1);
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileoutputstream1);
        fileoutputstream1.flush();
        Exception exception;
        Exception exception1;
        if (fileoutputstream1 != null)
        {
            try
            {
                fileoutputstream1.close();
            }
            catch (IOException ioexception2)
            {
                return s;
            }
        }
        return s;
        exception1;
_L4:
        s = "";
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (IOException ioexception1)
            {
                return s;
            }
            return s;
        } else
        {
            break MISSING_BLOCK_LABEL_183;
        }
        exception;
_L2:
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (IOException ioexception) { }
        }
        throw exception;
        exception;
        fileoutputstream = fileoutputstream1;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception2;
        exception2;
        fileoutputstream = fileoutputstream1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected transient HashMap a(Bitmap abitmap[])
    {
        HashMap hashmap = new HashMap();
        Bitmap bitmap = abitmap[0];
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        if (bitmap.getWidth() <= 320 && bitmap.getHeight() <= 320) goto _L2; else goto _L1
_L1:
        String s;
        Bitmap bitmap1 = a(bitmap);
        s = b(bitmap1);
        bitmap1.recycle();
_L3:
        bitmap.recycle();
        hashmap.put("ResultType", Integer.valueOf(1));
        hashmap.put("ResultValue", s);
        return hashmap;
_L2:
        String s1 = b(bitmap);
        s = s1;
          goto _L3
        Exception exception;
        exception;
        hashmap.put("ResultType", Integer.valueOf(0));
        hashmap.put("ResultValue", exception.getMessage());
        return hashmap;
    }

    protected void a(HashMap hashmap)
    {
        if (((Integer)hashmap.get("ResultType")).intValue() == 1)
        {
            b.a((String)hashmap.get("ResultValue"));
        } else
        {
            b.b((String)hashmap.get("ResultValue"));
        }
        super.onPostExecute(hashmap);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Bitmap[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((HashMap)obj);
    }

    static 
    {
        a = new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.CHINA);
    }

    private class a
    {

        public abstract void a(String s);

        public abstract void b(String s);
    }

}
