// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public abstract class BaseDiscCache
    implements DiskCache
{

    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final android.graphics.Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String a = " argument must be not null";
    private static final String b = ".tmp";
    protected int bufferSize;
    protected final File cacheDir;
    protected android.graphics.Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    protected final File reserveCacheDir;

    public BaseDiscCache(File file)
    {
        this(file, null);
    }

    public BaseDiscCache(File file, File file1)
    {
        this(file, file1, DefaultConfigurationFactory.createFileNameGenerator());
    }

    public BaseDiscCache(File file, File file1, FileNameGenerator filenamegenerator)
    {
        bufferSize = 32768;
        compressFormat = DEFAULT_COMPRESS_FORMAT;
        compressQuality = 100;
        if (file == null)
        {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (filenamegenerator == null)
        {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        } else
        {
            cacheDir = file;
            reserveCacheDir = file1;
            fileNameGenerator = filenamegenerator;
            return;
        }
    }

    public void clear()
    {
        File afile[] = cacheDir.listFiles();
        if (afile != null)
        {
            int i = afile.length;
            for (int j = 0; j < i; j++)
            {
                afile[j].delete();
            }

        }
    }

    public void close()
    {
    }

    public File get(String s)
    {
        return getFile(s);
    }

    public File getDirectory()
    {
        return cacheDir;
    }

    protected File getFile(String s)
    {
        String s1 = fileNameGenerator.generate(s);
        File file = cacheDir;
        if (!cacheDir.exists() && !cacheDir.mkdirs() && reserveCacheDir != null && (reserveCacheDir.exists() || reserveCacheDir.mkdirs()))
        {
            file = reserveCacheDir;
        }
        return new File(file, s1);
    }

    public boolean remove(String s)
    {
        return getFile(s).delete();
    }

    public boolean save(String s, Bitmap bitmap)
    {
        File file;
        File file1;
        BufferedOutputStream bufferedoutputstream;
        file = getFile(s);
        file1 = new File((new StringBuilder()).append(file.getAbsolutePath()).append(".tmp").toString());
        bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file1), bufferSize);
        boolean flag = bitmap.compress(compressFormat, compressQuality, bufferedoutputstream);
        boolean flag1 = flag;
        IoUtils.closeSilently(bufferedoutputstream);
        if (flag1 && !file1.renameTo(file))
        {
            flag1 = false;
        }
        if (!flag1)
        {
            file1.delete();
        }
        bitmap.recycle();
        return flag1;
        Exception exception;
        exception;
        IoUtils.closeSilently(bufferedoutputstream);
        file1.delete();
        throw exception;
    }

    public boolean save(String s, InputStream inputstream, com.nostra13.universalimageloader.utils.IoUtils.CopyListener copylistener)
    {
        File file;
        File file1;
        file = getFile(s);
        file1 = new File((new StringBuilder()).append(file.getAbsolutePath()).append(".tmp").toString());
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file1), bufferSize);
        boolean flag1 = IoUtils.copyStream(inputstream, bufferedoutputstream, copylistener, bufferSize);
        boolean flag = flag1;
        IoUtils.closeSilently(bufferedoutputstream);
        IoUtils.closeSilently(inputstream);
        if (flag && !file1.renameTo(file))
        {
            flag = false;
        }
        if (!flag)
        {
            file1.delete();
        }
        return flag;
        Exception exception;
        exception;
        IoUtils.closeSilently(bufferedoutputstream);
        throw exception;
        Exception exception1;
        exception1;
        flag = false;
_L2:
        IoUtils.closeSilently(inputstream);
        if (flag && !file1.renameTo(file))
        {
            flag = false;
        }
        if (!flag)
        {
            file1.delete();
        }
        throw exception1;
        exception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setBufferSize(int i)
    {
        bufferSize = i;
    }

    public void setCompressFormat(android.graphics.Bitmap.CompressFormat compressformat)
    {
        compressFormat = compressformat;
    }

    public void setCompressQuality(int i)
    {
        compressQuality = i;
    }

    static 
    {
        DEFAULT_COMPRESS_FORMAT = android.graphics.Bitmap.CompressFormat.PNG;
    }
}
