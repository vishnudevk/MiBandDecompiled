// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.nostra13.universalimageloader.utils:
//            L

public final class StorageUtils
{

    private static final String a = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String b = "uil-images";

    private StorageUtils()
    {
    }

    private static File a(Context context)
    {
        File file;
label0:
        {
            file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
            if (!file.exists())
            {
                if (file.mkdirs())
                {
                    break label0;
                }
                L.w("Unable to create external cache directory", new Object[0]);
                file = null;
            }
            return file;
        }
        try
        {
            (new File(file, ".nomedia")).createNewFile();
        }
        catch (IOException ioexception)
        {
            L.i("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            return file;
        }
        return file;
    }

    private static boolean b(Context context)
    {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static File getCacheDirectory(Context context)
    {
        return getCacheDirectory(context, true);
    }

    public static File getCacheDirectory(Context context, boolean flag)
    {
        File file = null;
        if (flag)
        {
            boolean flag1 = "mounted".equals(Environment.getExternalStorageState());
            file = null;
            if (flag1)
            {
                boolean flag2 = b(context);
                file = null;
                if (flag2)
                {
                    file = a(context);
                }
            }
        }
        if (file == null)
        {
            file = context.getCacheDir();
        }
        if (file == null)
        {
            String s = (new StringBuilder()).append("/data/data/").append(context.getPackageName()).append("/cache/").toString();
            L.w("Can't define system cache directory! '%s' will be used.", new Object[] {
                s
            });
            file = new File(s);
        }
        return file;
    }

    public static File getIndividualCacheDirectory(Context context)
    {
        File file = getCacheDirectory(context);
        File file1 = new File(file, "uil-images");
        if (!file1.exists() && !file1.mkdir())
        {
            return file;
        } else
        {
            return file1;
        }
    }

    public static File getOwnCacheDirectory(Context context, String s)
    {
        boolean flag = "mounted".equals(Environment.getExternalStorageState());
        File file = null;
        if (flag)
        {
            boolean flag1 = b(context);
            file = null;
            if (flag1)
            {
                file = new File(Environment.getExternalStorageDirectory(), s);
            }
        }
        if (file == null || !file.exists() && !file.mkdirs())
        {
            file = context.getCacheDir();
        }
        return file;
    }
}
