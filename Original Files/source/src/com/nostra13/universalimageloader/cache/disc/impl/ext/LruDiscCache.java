// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            DiskLruCache

public class LruDiscCache
    implements DiskCache
{

    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final android.graphics.Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String a = " argument must be not null";
    private static final String b = " argument must be positive number";
    protected int bufferSize;
    private File c;
    protected DiskLruCache cache;
    protected android.graphics.Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;

    public LruDiscCache(File file, FileNameGenerator filenamegenerator, long l)
    {
        this(file, filenamegenerator, l, 0);
    }

    public LruDiscCache(File file, FileNameGenerator filenamegenerator, long l, int i)
    {
        bufferSize = 32768;
        compressFormat = DEFAULT_COMPRESS_FORMAT;
        compressQuality = 100;
        if (file == null)
        {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (l < 0L)
        {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i < 0)
        {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (filenamegenerator == null)
        {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        long l1;
        int j;
        if (l == 0L)
        {
            l1 = 0x7fffffffffffffffL;
        } else
        {
            l1 = l;
        }
        if (i == 0)
        {
            j = 0x7fffffff;
        } else
        {
            j = i;
        }
        fileNameGenerator = filenamegenerator;
        a(file, c, l1, j);
    }

    private String a(String s)
    {
        return fileNameGenerator.generate(s);
    }

    private void a(File file, File file1, long l, int i)
    {
        cache = DiskLruCache.a(file, 1, 1, l, i);
_L1:
        return;
        IOException ioexception;
        ioexception;
        L.e(ioexception);
        if (file1 != null)
        {
            a(file1, null, l, i);
            return;
        }
          goto _L1
    }

    public void clear()
    {
        cache.h();
        a(cache.a(), c, cache.b(), cache.c());
        return;
        IOException ioexception;
        ioexception;
        L.e(ioexception);
        a(cache.a(), c, cache.b(), cache.c());
        return;
        Exception exception;
        exception;
        a(cache.a(), c, cache.b(), cache.c());
        throw exception;
    }

    public void close()
    {
        try
        {
            cache.close();
        }
        catch (IOException ioexception)
        {
            L.e(ioexception);
        }
        cache = null;
    }

    public File get(String s)
    {
        DiskLruCache.Snapshot snapshot1 = cache.a(a(s));
        DiskLruCache.Snapshot snapshot;
        File file;
        snapshot = snapshot1;
        file = null;
        if (snapshot != null) goto _L2; else goto _L1
_L1:
        if (snapshot != null)
        {
            snapshot.close();
        }
_L4:
        return file;
_L2:
        File file1 = snapshot.getFile(0);
        file = file1;
          goto _L1
        IOException ioexception;
        ioexception;
        snapshot = null;
_L7:
        L.e(ioexception);
        file = null;
        if (snapshot == null) goto _L4; else goto _L3
_L3:
        snapshot.close();
        return null;
        Exception exception;
        exception;
        Exception exception1;
        snapshot = null;
        exception1 = exception;
_L6:
        if (snapshot != null)
        {
            snapshot.close();
        }
        throw exception1;
        exception1;
        if (true) goto _L6; else goto _L5
_L5:
        ioexception;
          goto _L7
    }

    public File getDirectory()
    {
        return cache.a();
    }

    public boolean remove(String s)
    {
        boolean flag;
        try
        {
            flag = cache.c(a(s));
        }
        catch (IOException ioexception)
        {
            L.e(ioexception);
            return false;
        }
        return flag;
    }

    public boolean save(String s, Bitmap bitmap)
    {
        DiskLruCache.Editor editor;
        BufferedOutputStream bufferedoutputstream;
        editor = cache.b(a(s));
        if (editor == null)
        {
            return false;
        }
        bufferedoutputstream = new BufferedOutputStream(editor.newOutputStream(0), bufferSize);
        boolean flag = bitmap.compress(compressFormat, compressQuality, bufferedoutputstream);
        IoUtils.closeSilently(bufferedoutputstream);
        Exception exception;
        if (flag)
        {
            editor.commit();
            return flag;
        } else
        {
            editor.abort();
            return flag;
        }
        exception;
        IoUtils.closeSilently(bufferedoutputstream);
        throw exception;
    }

    public boolean save(String s, InputStream inputstream, com.nostra13.universalimageloader.utils.IoUtils.CopyListener copylistener)
    {
        DiskLruCache.Editor editor;
        BufferedOutputStream bufferedoutputstream;
        editor = cache.b(a(s));
        if (editor == null)
        {
            return false;
        }
        bufferedoutputstream = new BufferedOutputStream(editor.newOutputStream(0), bufferSize);
        boolean flag = IoUtils.copyStream(inputstream, bufferedoutputstream, copylistener, bufferSize);
        IoUtils.closeSilently(bufferedoutputstream);
        if (flag)
        {
            editor.commit();
            return flag;
        } else
        {
            editor.abort();
            return flag;
        }
        Exception exception;
        exception;
        IoUtils.closeSilently(bufferedoutputstream);
        editor.abort();
        throw exception;
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

    public void setReserveCacheDir(File file)
    {
        c = file;
    }

    static 
    {
        DEFAULT_COMPRESS_FORMAT = android.graphics.Bitmap.CompressFormat.PNG;
    }
}
