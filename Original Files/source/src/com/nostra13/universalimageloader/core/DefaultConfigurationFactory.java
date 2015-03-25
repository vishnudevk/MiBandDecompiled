// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.content.Context;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            a

public class DefaultConfigurationFactory
{

    public DefaultConfigurationFactory()
    {
    }

    private static File a(Context context)
    {
        File file = StorageUtils.getCacheDirectory(context, false);
        File file1 = new File(file, "uil-images");
        if (file1.exists() || file1.mkdir())
        {
            file = file1;
        }
        return file;
    }

    private static ThreadFactory a(int i, String s)
    {
        return new a(i, s);
    }

    public static BitmapDisplayer createBitmapDisplayer()
    {
        return new SimpleBitmapDisplayer();
    }

    public static DiskCache createDiskCache(Context context, FileNameGenerator filenamegenerator, long l, int i)
    {
        File file = a(context);
        if (l > 0L || i > 0)
        {
            LruDiscCache lrudisccache = new LruDiscCache(StorageUtils.getIndividualCacheDirectory(context), filenamegenerator, l, i);
            lrudisccache.setReserveCacheDir(file);
            return lrudisccache;
        } else
        {
            return new UnlimitedDiscCache(StorageUtils.getCacheDirectory(context), file, filenamegenerator);
        }
    }

    public static Executor createExecutor(int i, int j, QueueProcessingType queueprocessingtype)
    {
        boolean flag;
        Object obj;
        BlockingQueue blockingqueue;
        if (queueprocessingtype == QueueProcessingType.LIFO)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj = new LIFOLinkedBlockingDeque();
        } else
        {
            obj = new LinkedBlockingQueue();
        }
        blockingqueue = (BlockingQueue)obj;
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, blockingqueue, a(j, "uil-pool-"));
    }

    public static FileNameGenerator createFileNameGenerator()
    {
        return new HashCodeFileNameGenerator();
    }

    public static ImageDecoder createImageDecoder(boolean flag)
    {
        return new BaseImageDecoder(flag);
    }

    public static ImageDownloader createImageDownloader(Context context)
    {
        return new BaseImageDownloader(context);
    }

    public static MemoryCache createMemoryCache(int i)
    {
        if (i == 0)
        {
            i = (int)(Runtime.getRuntime().maxMemory() / 8L);
        }
        return new LruMemoryCache(i);
    }

    public static Executor createTaskDistributor()
    {
        return Executors.newCachedThreadPool(a(5, "uil-pool-d-"));
    }
}
