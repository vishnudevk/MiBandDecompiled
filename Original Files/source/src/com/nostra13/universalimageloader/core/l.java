// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            i, ImageLoaderConfiguration, k, DisplayImageOptions, 
//            n, m, p, o, 
//            b

final class l
    implements com.nostra13.universalimageloader.utils.IoUtils.CopyListener, Runnable
{

    private static final String f = "ImageLoader is paused. Waiting...  [%s]";
    private static final String g = ".. Resume loading [%s]";
    private static final String h = "Delay %d ms before loading...  [%s]";
    private static final String i = "Start display image task [%s]";
    private static final String j = "Image already is loading. Waiting... [%s]";
    private static final String k = "...Get cached bitmap from memory after waiting. [%s]";
    private static final String l = "Load image from network [%s]";
    private static final String m = "Load image from disk cache [%s]";
    private static final String n = "Resize image in disk cache [%s]";
    private static final String o = "PreProcess image before caching in memory [%s]";
    private static final String p = "PostProcess image before displaying [%s]";
    private static final String q = "Cache image in memory [%s]";
    private static final String r = "Cache image on disk [%s]";
    private static final String s = "Process image before cache on disk [%s]";
    private static final String t = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String u = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String v = "Task was interrupted [%s]";
    private static final String w = "Pre-processor returned null [%s]";
    private static final String x = "Post-processor returned null [%s]";
    private static final String y = "Bitmap processor for disk cache returned null [%s]";
    private final k A;
    private final Handler B;
    private final ImageLoaderConfiguration C;
    private final ImageDownloader D;
    private final ImageDownloader E;
    private final ImageDownloader F;
    private final ImageDecoder G;
    private final String H;
    private final ImageSize I;
    private final boolean J;
    private LoadedFrom K;
    final String a;
    final ImageAware b;
    final DisplayImageOptions c;
    final ImageLoadingListener d;
    final ImageLoadingProgressListener e;
    private final i z;

    public l(i i1, k k1, Handler handler)
    {
        K = LoadedFrom.NETWORK;
        z = i1;
        A = k1;
        B = handler;
        C = i1.a;
        D = C.p;
        E = C.s;
        F = C.t;
        G = C.q;
        a = k1.a;
        H = k1.b;
        b = k1.c;
        I = k1.d;
        c = k1.e;
        d = k1.f;
        e = k1.g;
        J = c.a();
    }

    private Bitmap a(String s1)
    {
        ViewScaleType viewscaletype = b.getScaleType();
        ImageDecodingInfo imagedecodinginfo = new ImageDecodingInfo(H, s1, a, I, viewscaletype, h(), c);
        return G.decode(imagedecodinginfo);
    }

    static ImageLoaderConfiguration a(l l1)
    {
        return l1.C;
    }

    private void a(com.nostra13.universalimageloader.core.assist.FailReason.FailType failtype, Throwable throwable)
    {
        if (J || p() || j())
        {
            return;
        } else
        {
            a(((Runnable) (new n(this, failtype, throwable))), false, B, z);
            return;
        }
    }

    static void a(Runnable runnable, boolean flag, Handler handler, i i1)
    {
        if (flag)
        {
            runnable.run();
            return;
        }
        if (handler == null)
        {
            i1.a(runnable);
            return;
        } else
        {
            handler.post(runnable);
            return;
        }
    }

    private boolean a(int i1, int j1)
    {
        File file = C.o.get(a);
        if (file != null && file.exists())
        {
            ImageSize imagesize = new ImageSize(i1, j1);
            DisplayImageOptions displayimageoptions = (new DisplayImageOptions.Builder()).cloneFrom(c).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
            ImageDecodingInfo imagedecodinginfo = new ImageDecodingInfo(H, com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), a, imagesize, ViewScaleType.FIT_INSIDE, h(), displayimageoptions);
            Bitmap bitmap = G.decode(imagedecodinginfo);
            if (bitmap != null && C.f != null)
            {
                Object aobj[] = new Object[1];
                aobj[0] = H;
                L.d("Process image before cache on disk [%s]", aobj);
                bitmap = C.f.process(bitmap);
                if (bitmap == null)
                {
                    Object aobj1[] = new Object[1];
                    aobj1[0] = H;
                    L.e("Bitmap processor for disk cache returned null [%s]", aobj1);
                }
            }
            Bitmap bitmap1 = bitmap;
            if (bitmap1 != null)
            {
                boolean flag = C.o.save(a, bitmap1);
                bitmap1.recycle();
                return flag;
            }
        }
        return false;
    }

    private boolean b()
    {
        AtomicBoolean atomicboolean;
        atomicboolean = z.d();
        if (!atomicboolean.get())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        Object obj = z.e();
        obj;
        JVM INSTR monitorenter ;
        if (!atomicboolean.get())
        {
            break MISSING_BLOCK_LABEL_84;
        }
        Object aobj[] = new Object[1];
        aobj[0] = H;
        L.d("ImageLoader is paused. Waiting...  [%s]", aobj);
        z.e().wait();
        Object aobj2[] = new Object[1];
        aobj2[0] = H;
        L.d(".. Resume loading [%s]", aobj2);
        return j();
        InterruptedException interruptedexception;
        interruptedexception;
        Object aobj1[] = new Object[1];
        aobj1[0] = H;
        L.e("Task was interrupted [%s]", aobj1);
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean b(int i1, int j1)
    {
        if (J || p() || j())
        {
            return false;
        }
        if (e != null)
        {
            a(new m(this, i1, j1), false, B, z);
        }
        return true;
    }

    private boolean c()
    {
        if (c.shouldDelayBeforeLoading())
        {
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(c.getDelayBeforeLoading());
            aobj[1] = H;
            L.d("Delay %d ms before loading...  [%s]", aobj);
            try
            {
                Thread.sleep(c.getDelayBeforeLoading());
            }
            catch (InterruptedException interruptedexception)
            {
                Object aobj1[] = new Object[1];
                aobj1[0] = H;
                L.e("Task was interrupted [%s]", aobj1);
                return true;
            }
            return j();
        } else
        {
            return false;
        }
    }

    private Bitmap d()
    {
        File file = C.o.get(a);
        if (file == null) goto _L2; else goto _L1
_L1:
        if (!file.exists()) goto _L2; else goto _L3
_L3:
        Bitmap bitmap1;
        Object aobj1[] = new Object[1];
        aobj1[0] = H;
        L.d("Load image from disk cache [%s]", aobj1);
        K = LoadedFrom.DISC_CACHE;
        i();
        bitmap1 = a(com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()));
        Bitmap bitmap = bitmap1;
_L12:
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        String s1;
        File file1;
        Object aobj[] = new Object[1];
        aobj[0] = H;
        L.d("Load image from network [%s]", aobj);
        K = LoadedFrom.NETWORK;
        s1 = a;
        if (!c.isCacheOnDisk() || !e())
        {
            break MISSING_BLOCK_LABEL_188;
        }
        file1 = C.o.get(a);
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        s1 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE.wrap(file1.getAbsolutePath());
        i();
        bitmap = a(s1);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        a(com.nostra13.universalimageloader.core.assist.FailReason.FailType.DECODING_ERROR, ((Throwable) (null)));
        return bitmap;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        bitmap = null;
_L10:
        a(com.nostra13.universalimageloader.core.assist.FailReason.FailType.NETWORK_DENIED, ((Throwable) (null)));
        return bitmap;
        p p1;
        p1;
        throw p1;
        IOException ioexception;
        ioexception;
        IOException ioexception1;
        bitmap = null;
        ioexception1 = ioexception;
_L9:
        L.e(ioexception1);
        a(com.nostra13.universalimageloader.core.assist.FailReason.FailType.IO_ERROR, ioexception1);
        return bitmap;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        OutOfMemoryError outofmemoryerror1;
        bitmap = null;
        outofmemoryerror1 = outofmemoryerror;
_L7:
        L.e(outofmemoryerror1);
        a(com.nostra13.universalimageloader.core.assist.FailReason.FailType.OUT_OF_MEMORY, outofmemoryerror1);
        return bitmap;
        Throwable throwable;
        throwable;
        Throwable throwable1;
        bitmap = null;
        throwable1 = throwable;
_L5:
        L.e(throwable1);
        a(com.nostra13.universalimageloader.core.assist.FailReason.FailType.UNKNOWN, throwable1);
        return bitmap;
        throwable1;
        if (true) goto _L5; else goto _L4
_L4:
        outofmemoryerror1;
        if (true) goto _L7; else goto _L6
_L6:
        ioexception1;
        if (true) goto _L9; else goto _L8
_L8:
        IllegalStateException illegalstateexception1;
        illegalstateexception1;
        if (true) goto _L10; else goto _L2
_L2:
        bitmap = null;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private boolean e()
    {
        Object aobj[] = new Object[1];
        aobj[0] = H;
        L.d("Cache image on disk [%s]", aobj);
        boolean flag;
        int i1;
        int j1;
        Object aobj1[];
        try
        {
            flag = f();
        }
        catch (IOException ioexception)
        {
            L.e(ioexception);
            return false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        i1 = C.d;
        j1 = C.e;
        if (i1 <= 0 && j1 <= 0)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        aobj1 = new Object[1];
        aobj1[0] = H;
        L.d("Resize image in disk cache [%s]", aobj1);
        a(i1, j1);
        return flag;
    }

    private boolean f()
    {
        java.io.InputStream inputstream = h().getStream(a, c.getExtraForDownloader());
        return C.o.save(a, inputstream, this);
    }

    private void g()
    {
        if (J || p())
        {
            return;
        } else
        {
            a(new o(this), false, B, z);
            return;
        }
    }

    private ImageDownloader h()
    {
        if (z.f())
        {
            return E;
        }
        if (z.g())
        {
            return F;
        } else
        {
            return D;
        }
    }

    private void i()
    {
        k();
        m();
    }

    private boolean j()
    {
        return l() || n();
    }

    private void k()
    {
        if (l())
        {
            throw new p(this);
        } else
        {
            return;
        }
    }

    private boolean l()
    {
        if (b.isCollected())
        {
            Object aobj[] = new Object[1];
            aobj[0] = H;
            L.d("ImageAware was collected by GC. Task is cancelled. [%s]", aobj);
            return true;
        } else
        {
            return false;
        }
    }

    private void m()
    {
        if (n())
        {
            throw new p(this);
        } else
        {
            return;
        }
    }

    private boolean n()
    {
        String s1 = z.a(b);
        boolean flag;
        if (!H.equals(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            Object aobj[] = new Object[1];
            aobj[0] = H;
            L.d("ImageAware is reused for another image. Task is cancelled. [%s]", aobj);
            return true;
        } else
        {
            return false;
        }
    }

    private void o()
    {
        if (p())
        {
            throw new p(this);
        } else
        {
            return;
        }
    }

    private boolean p()
    {
        if (Thread.interrupted())
        {
            Object aobj[] = new Object[1];
            aobj[0] = H;
            L.d("Task was interrupted [%s]", aobj);
            return true;
        } else
        {
            return false;
        }
    }

    String a()
    {
        return a;
    }

    public boolean onBytesCopied(int i1, int j1)
    {
        return b(i1, j1);
    }

    public void run()
    {
        ReentrantLock reentrantlock;
        while (b() || c()) 
        {
            return;
        }
        reentrantlock = A.h;
        Object aobj[] = new Object[1];
        aobj[0] = H;
        L.d("Start display image task [%s]", aobj);
        if (reentrantlock.isLocked())
        {
            Object aobj7[] = new Object[1];
            aobj7[0] = H;
            L.d("Image already is loading. Waiting... [%s]", aobj7);
        }
        reentrantlock.lock();
        Bitmap bitmap;
        i();
        bitmap = (Bitmap)C.n.get(H);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        if (!bitmap.isRecycled())
        {
            break MISSING_BLOCK_LABEL_394;
        }
        Bitmap bitmap1 = d();
        bitmap = bitmap1;
        if (bitmap == null)
        {
            reentrantlock.unlock();
            return;
        }
        i();
        o();
        if (!c.shouldPreProcess())
        {
            break MISSING_BLOCK_LABEL_212;
        }
        Object aobj4[] = new Object[1];
        aobj4[0] = H;
        L.d("PreProcess image before caching in memory [%s]", aobj4);
        bitmap = c.getPreProcessor().process(bitmap);
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        Object aobj5[] = new Object[1];
        aobj5[0] = H;
        L.e("Pre-processor returned null [%s]", aobj5);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        if (c.isCacheInMemory())
        {
            Object aobj3[] = new Object[1];
            aobj3[0] = H;
            L.d("Cache image in memory [%s]", aobj3);
            C.n.put(H, bitmap);
        }
_L2:
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        if (!c.shouldPostProcess())
        {
            break MISSING_BLOCK_LABEL_345;
        }
        Object aobj1[] = new Object[1];
        aobj1[0] = H;
        L.d("PostProcess image before displaying [%s]", aobj1);
        bitmap = c.getPostProcessor().process(bitmap);
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        Object aobj2[] = new Object[1];
        aobj2[0] = H;
        L.e("Post-processor returned null [%s]", aobj2);
        i();
        o();
        reentrantlock.unlock();
        a(new b(bitmap, A, z, K), J, B, z);
        return;
        K = LoadedFrom.MEMORY_CACHE;
        Object aobj6[] = new Object[1];
        aobj6[0] = H;
        L.d("...Get cached bitmap from memory after waiting. [%s]", aobj6);
        if (true) goto _L2; else goto _L1
_L1:
        p p1;
        p1;
        g();
        reentrantlock.unlock();
        return;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }
}
