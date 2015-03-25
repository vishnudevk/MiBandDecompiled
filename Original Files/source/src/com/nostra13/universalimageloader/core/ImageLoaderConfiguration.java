// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;
import java.util.concurrent.Executor;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            g, h, DisplayImageOptions, f

public final class ImageLoaderConfiguration
{

    final Resources a;
    final int b;
    final int c;
    final int d;
    final int e;
    final BitmapProcessor f;
    final Executor g;
    final Executor h;
    final boolean i;
    final boolean j;
    final int k;
    final int l;
    final QueueProcessingType m;
    final MemoryCache n;
    final DiskCache o;
    final ImageDownloader p;
    final ImageDecoder q;
    final DisplayImageOptions r;
    final ImageDownloader s;
    final ImageDownloader t;

    private ImageLoaderConfiguration(Builder builder)
    {
        a = Builder.a(builder).getResources();
        b = Builder.b(builder);
        c = Builder.c(builder);
        d = Builder.d(builder);
        e = Builder.e(builder);
        f = Builder.f(builder);
        g = Builder.g(builder);
        h = Builder.h(builder);
        k = Builder.i(builder);
        l = Builder.j(builder);
        m = Builder.k(builder);
        o = Builder.l(builder);
        n = Builder.m(builder);
        r = Builder.n(builder);
        p = Builder.o(builder);
        q = Builder.p(builder);
        i = Builder.q(builder);
        j = Builder.r(builder);
        s = new g(p);
        t = new h(p);
        L.writeDebugLogs(Builder.s(builder));
    }

    ImageLoaderConfiguration(Builder builder, f f1)
    {
        this(builder);
    }

    public static ImageLoaderConfiguration createDefault(Context context)
    {
        return (new Builder(context)).build();
    }

    ImageSize a()
    {
        DisplayMetrics displaymetrics = a.getDisplayMetrics();
        int i1 = b;
        if (i1 <= 0)
        {
            i1 = displaymetrics.widthPixels;
        }
        int j1 = c;
        if (j1 <= 0)
        {
            j1 = displaymetrics.heightPixels;
        }
        return new ImageSize(i1, j1);
    }

    private class Builder
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

        static Context a(Builder builder)
        {
            return builder.e;
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

        static int b(Builder builder)
        {
            return builder.f;
        }

        static int c(Builder builder)
        {
            return builder.g;
        }

        static int d(Builder builder)
        {
            return builder.h;
        }

        static int e(Builder builder)
        {
            return builder.i;
        }

        static BitmapProcessor f(Builder builder)
        {
            return builder.j;
        }

        static Executor g(Builder builder)
        {
            return builder.k;
        }

        static Executor h(Builder builder)
        {
            return builder.l;
        }

        static int i(Builder builder)
        {
            return builder.o;
        }

        static int j(Builder builder)
        {
            return builder.p;
        }

        static QueueProcessingType k(Builder builder)
        {
            return builder.r;
        }

        static DiskCache l(Builder builder)
        {
            return builder.w;
        }

        static MemoryCache m(Builder builder)
        {
            return builder.v;
        }

        static DisplayImageOptions n(Builder builder)
        {
            return builder.A;
        }

        static ImageDownloader o(Builder builder)
        {
            return builder.y;
        }

        static ImageDecoder p(Builder builder)
        {
            return builder.z;
        }

        static boolean q(Builder builder)
        {
            return builder.m;
        }

        static boolean r(Builder builder)
        {
            return builder.n;
        }

        static boolean s(Builder builder)
        {
            return builder.B;
        }

        public ImageLoaderConfiguration build()
        {
            a();
            return new ImageLoaderConfiguration(this, null);
        }

        public Builder defaultDisplayImageOptions(DisplayImageOptions displayimageoptions)
        {
            A = displayimageoptions;
            return this;
        }

        public Builder denyCacheImageMultipleSizesInMemory()
        {
            q = true;
            return this;
        }

        public Builder discCache(DiskCache diskcache)
        {
            return diskCache(diskcache);
        }

        public Builder discCacheExtraOptions(int i1, int j1, BitmapProcessor bitmapprocessor)
        {
            return diskCacheExtraOptions(i1, j1, bitmapprocessor);
        }

        public Builder discCacheFileCount(int i1)
        {
            return diskCacheFileCount(i1);
        }

        public Builder discCacheFileNameGenerator(FileNameGenerator filenamegenerator)
        {
            return diskCacheFileNameGenerator(filenamegenerator);
        }

        public Builder discCacheSize(int i1)
        {
            return diskCacheSize(i1);
        }

        public Builder diskCache(DiskCache diskcache)
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

        public Builder diskCacheExtraOptions(int i1, int j1, BitmapProcessor bitmapprocessor)
        {
            h = i1;
            i = j1;
            j = bitmapprocessor;
            return this;
        }

        public Builder diskCacheFileCount(int i1)
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

        public Builder diskCacheFileNameGenerator(FileNameGenerator filenamegenerator)
        {
            if (w != null)
            {
                L.w("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
            }
            x = filenamegenerator;
            return this;
        }

        public Builder diskCacheSize(int i1)
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

        public Builder imageDecoder(ImageDecoder imagedecoder)
        {
            z = imagedecoder;
            return this;
        }

        public Builder imageDownloader(ImageDownloader imagedownloader)
        {
            y = imagedownloader;
            return this;
        }

        public Builder memoryCache(MemoryCache memorycache)
        {
            if (s != 0)
            {
                L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
            }
            v = memorycache;
            return this;
        }

        public Builder memoryCacheExtraOptions(int i1, int j1)
        {
            f = i1;
            g = j1;
            return this;
        }

        public Builder memoryCacheSize(int i1)
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

        public Builder memoryCacheSizePercentage(int i1)
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

        public Builder taskExecutor(Executor executor)
        {
            if (o != 3 || p != 4 || r != DEFAULT_TASK_PROCESSING_TYPE)
            {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            k = executor;
            return this;
        }

        public Builder taskExecutorForCachedImages(Executor executor)
        {
            if (o != 3 || p != 4 || r != DEFAULT_TASK_PROCESSING_TYPE)
            {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            l = executor;
            return this;
        }

        public Builder tasksProcessingOrder(QueueProcessingType queueprocessingtype)
        {
            if (k != null || l != null)
            {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            r = queueprocessingtype;
            return this;
        }

        public Builder threadPoolSize(int i1)
        {
            if (k != null || l != null)
            {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            o = i1;
            return this;
        }

        public Builder threadPriority(int i1)
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

        public Builder writeDebugLogs()
        {
            B = true;
            return this;
        }

        static 
        {
            DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
        }

        public Builder(Context context)
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

}
