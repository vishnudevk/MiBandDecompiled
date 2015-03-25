// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.content.Context;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import java.util.concurrent.Executor;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            DefaultConfigurationFactory, DisplayImageOptions, ImageLoaderConfiguration

public class e
{

    public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE;
    public static final int DEFAULT_THREAD_POOL_SIZE = 3;
    public static final int DEFAULT_THREAD_PRIORITY = 4;
    private static final String a = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
    private static final String b = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
    private static final String c = "memoryCache() and memoryCacheSize() calls overlap each other";
    private static final String d = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
    private DisplayImageOptions A;
    private boolean B;
    private Context e;
    private int f;
    private int g;
    private int h;
    private int i;
    private BitmapProcessor j;
    private Executor k;
    private Executor l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private boolean q;
    private QueueProcessingType r;
    private int s;
    private long t;
    private int u;
    private MemoryCache v;
    private DiskCache w;
    private FileNameGenerator x;
    private ImageDownloader y;
    private ImageDecoder z;

    static Context a(e e1)
    {
        return e1.e;
    }

    private void a()
    {
        if (k == null)
        {
            k = DefaultConfigurationFactory.createExecutor(o, p, r);
        } else
        {
            m = true;
        }
        if (l == null)
        {
            l = DefaultConfigurationFactory.createExecutor(o, p, r);
        } else
        {
            n = true;
        }
        if (w == null)
        {
            if (x == null)
            {
                x = DefaultConfigurationFactory.createFileNameGenerator();
            }
            w = DefaultConfigurationFactory.createDiskCache(e, x, t, u);
        }
        if (v == null)
        {
            v = DefaultConfigurationFactory.createMemoryCache(s);
        }
        if (q)
        {
            v = new FuzzyKeyMemoryCache(v, MemoryCacheUtils.createFuzzyKeyComparator());
        }
        if (y == null)
        {
            y = DefaultConfigurationFactory.createImageDownloader(e);
        }
        if (z == null)
        {
            z = DefaultConfigurationFactory.createImageDecoder(B);
        }
        if (A == null)
        {
            A = DisplayImageOptions.createSimple();
        }
    }

    static int b(A a1)
    {
        return a1.f;
    }

    static int c(f f1)
    {
        return f1.g;
    }

    static int d(g g1)
    {
        return g1.h;
    }

    static int e(h h1)
    {
        return h1.i;
    }

    static BitmapProcessor f(i i1)
    {
        return i1.j;
    }

    static Executor g(j j1)
    {
        return j1.k;
    }

    static Executor h(k k1)
    {
        return k1.l;
    }

    static int i(l l1)
    {
        return l1.o;
    }

    static int j(o o1)
    {
        return o1.p;
    }

    static QueueProcessingType k(p p1)
    {
        return p1.r;
    }

    static DiskCache l(r r1)
    {
        return r1.w;
    }

    static MemoryCache m(w w1)
    {
        return w1.v;
    }

    static DisplayImageOptions n(v v1)
    {
        return v1.A;
    }

    static ImageDownloader o(A a1)
    {
        return a1.y;
    }

    static ImageDecoder p(y y1)
    {
        return y1.z;
    }

    static boolean q(z z1)
    {
        return z1.m;
    }

    static boolean r(m m1)
    {
        return m1.n;
    }

    static boolean s(n n1)
    {
        return n1.B;
    }

    public ImageLoaderConfiguration build()
    {
        a();
        return new ImageLoaderConfiguration(this, null);
    }

    public a defaultDisplayImageOptions(DisplayImageOptions displayimageoptions)
    {
        A = displayimageoptions;
        return this;
    }

    public A denyCacheImageMultipleSizesInMemory()
    {
        q = true;
        return this;
    }

    public q discCache(DiskCache diskcache)
    {
        return diskCache(diskcache);
    }

    public diskCache discCacheExtraOptions(int i1, int j1, BitmapProcessor bitmapprocessor)
    {
        return diskCacheExtraOptions(i1, j1, bitmapprocessor);
    }

    public diskCacheExtraOptions discCacheFileCount(int i1)
    {
        return diskCacheFileCount(i1);
    }

    public diskCacheFileCount discCacheFileNameGenerator(FileNameGenerator filenamegenerator)
    {
        return diskCacheFileNameGenerator(filenamegenerator);
    }

    public diskCacheFileNameGenerator discCacheSize(int i1)
    {
        return diskCacheSize(i1);
    }

    public diskCacheSize diskCache(DiskCache diskcache)
    {
        if (t > 0L || u > 0)
        {
            L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
        }
        if (x != null)
        {
            L.w("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
        }
        w = diskcache;
        return this;
    }

    public w diskCacheExtraOptions(int i1, int j1, BitmapProcessor bitmapprocessor)
    {
        h = i1;
        i = j1;
        j = bitmapprocessor;
        return this;
    }

    public j diskCacheFileCount(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("maxFileCount must be a positive number");
        }
        if (w != null)
        {
            L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
        }
        u = i1;
        return this;
    }

    public u diskCacheFileNameGenerator(FileNameGenerator filenamegenerator)
    {
        if (w != null)
        {
            L.w("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
        }
        x = filenamegenerator;
        return this;
    }

    public x diskCacheSize(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }
        if (w != null)
        {
            L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
        }
        t = i1;
        return this;
    }

    public t imageDecoder(ImageDecoder imagedecoder)
    {
        z = imagedecoder;
        return this;
    }

    public z imageDownloader(ImageDownloader imagedownloader)
    {
        y = imagedownloader;
        return this;
    }

    public y memoryCache(MemoryCache memorycache)
    {
        if (s != 0)
        {
            L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
        }
        v = memorycache;
        return this;
    }

    public v memoryCacheExtraOptions(int i1, int j1)
    {
        f = i1;
        g = j1;
        return this;
    }

    public g memoryCacheSize(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("memoryCacheSize must be a positive number");
        }
        if (v != null)
        {
            L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
        }
        s = i1;
        return this;
    }

    public s memoryCacheSizePercentage(int i1)
    {
        if (i1 <= 0 || i1 >= 100)
        {
            throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
        }
        if (v != null)
        {
            L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
        }
        s = (int)((float)Runtime.getRuntime().maxMemory() * ((float)i1 / 100F));
        return this;
    }

    public s taskExecutor(Executor executor)
    {
        if (o != 3 || p != 4 || r != DEFAULT_TASK_PROCESSING_TYPE)
        {
            L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        k = executor;
        return this;
    }

    public k taskExecutorForCachedImages(Executor executor)
    {
        if (o != 3 || p != 4 || r != DEFAULT_TASK_PROCESSING_TYPE)
        {
            L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        l = executor;
        return this;
    }

    public l tasksProcessingOrder(QueueProcessingType queueprocessingtype)
    {
        if (k != null || l != null)
        {
            L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        r = queueprocessingtype;
        return this;
    }

    public r threadPoolSize(int i1)
    {
        if (k != null || l != null)
        {
            L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        o = i1;
        return this;
    }

    public o threadPriority(int i1)
    {
        if (k != null || l != null)
        {
            L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        if (i1 < 1)
        {
            p = 1;
            return this;
        }
        if (i1 > 10)
        {
            p = 10;
            return this;
        } else
        {
            p = i1;
            return this;
        }
    }

    public p writeDebugLogs()
    {
        B = true;
        return this;
    }

    static 
    {
        DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
    }

    public (Context context)
    {
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        j = null;
        k = null;
        l = null;
        m = false;
        n = false;
        o = 3;
        p = 4;
        q = false;
        r = DEFAULT_TASK_PROCESSING_TYPE;
        s = 0;
        t = 0L;
        u = 0;
        v = null;
        w = null;
        x = null;
        y = null;
        A = null;
        B = false;
        e = context.getApplicationContext();
    }
}
