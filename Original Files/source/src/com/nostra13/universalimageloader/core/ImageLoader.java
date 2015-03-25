// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.imageaware.NonViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            DisplayImageOptions, i, ImageLoaderConfiguration, k, 
//            q, l, e

public class ImageLoader
{

    public static final String TAG = com/nostra13/universalimageloader/core/ImageLoader.getSimpleName();
    static final String a = "Initialize ImageLoader with configuration";
    static final String b = "Destroy ImageLoader";
    static final String c = "Load image from memory cache [%s]";
    private static final String d = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
    private static final String e = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
    private static final String f = "ImageLoader must be init with configuration before using";
    private static final String g = "ImageLoader configuration can not be initialized with null";
    private static volatile ImageLoader k;
    private ImageLoaderConfiguration h;
    private i i;
    private final ImageLoadingListener j = new SimpleImageLoadingListener();

    protected ImageLoader()
    {
    }

    private static Handler a(DisplayImageOptions displayimageoptions)
    {
        Handler handler = displayimageoptions.getHandler();
        if (displayimageoptions.a())
        {
            handler = null;
        } else
        if (handler == null && Looper.myLooper() == Looper.getMainLooper())
        {
            return new Handler();
        }
        return handler;
    }

    private void a()
    {
        if (h == null)
        {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        } else
        {
            return;
        }
    }

    public static ImageLoader getInstance()
    {
        if (k != null) goto _L2; else goto _L1
_L1:
        com/nostra13/universalimageloader/core/ImageLoader;
        JVM INSTR monitorenter ;
        if (k == null)
        {
            k = new ImageLoader();
        }
        com/nostra13/universalimageloader/core/ImageLoader;
        JVM INSTR monitorexit ;
_L2:
        return k;
        Exception exception;
        exception;
        com/nostra13/universalimageloader/core/ImageLoader;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void cancelDisplayTask(ImageView imageview)
    {
        i.b(new ImageViewAware(imageview));
    }

    public void cancelDisplayTask(ImageAware imageaware)
    {
        i.b(imageaware);
    }

    public void clearDiscCache()
    {
        clearDiskCache();
    }

    public void clearDiskCache()
    {
        a();
        h.o.clear();
    }

    public void clearMemoryCache()
    {
        a();
        h.n.clear();
    }

    public void denyNetworkDownloads(boolean flag)
    {
        i.a(flag);
    }

    public void destroy()
    {
        if (h != null)
        {
            L.d("Destroy ImageLoader", new Object[0]);
        }
        stop();
        h.o.close();
        i = null;
        h = null;
    }

    public void displayImage(String s, ImageView imageview)
    {
        displayImage(s, ((ImageAware) (new ImageViewAware(imageview))), null, null, null);
    }

    public void displayImage(String s, ImageView imageview, DisplayImageOptions displayimageoptions)
    {
        displayImage(s, ((ImageAware) (new ImageViewAware(imageview))), displayimageoptions, null, null);
    }

    public void displayImage(String s, ImageView imageview, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener)
    {
        displayImage(s, imageview, displayimageoptions, imageloadinglistener, null);
    }

    public void displayImage(String s, ImageView imageview, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener, ImageLoadingProgressListener imageloadingprogresslistener)
    {
        displayImage(s, ((ImageAware) (new ImageViewAware(imageview))), displayimageoptions, imageloadinglistener, imageloadingprogresslistener);
    }

    public void displayImage(String s, ImageView imageview, ImageLoadingListener imageloadinglistener)
    {
        displayImage(s, ((ImageAware) (new ImageViewAware(imageview))), null, imageloadinglistener, null);
    }

    public void displayImage(String s, ImageAware imageaware)
    {
        displayImage(s, imageaware, null, null, null);
    }

    public void displayImage(String s, ImageAware imageaware, DisplayImageOptions displayimageoptions)
    {
        displayImage(s, imageaware, displayimageoptions, null, null);
    }

    public void displayImage(String s, ImageAware imageaware, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener)
    {
        displayImage(s, imageaware, displayimageoptions, imageloadinglistener, null);
    }

    public void displayImage(String s, ImageAware imageaware, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener, ImageLoadingProgressListener imageloadingprogresslistener)
    {
        a();
        if (imageaware == null)
        {
            throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
        }
        ImageLoadingListener imageloadinglistener1;
        DisplayImageOptions displayimageoptions1;
        ImageSize imagesize;
        String s1;
        Bitmap bitmap;
        k k1;
        l l1;
        if (imageloadinglistener == null)
        {
            imageloadinglistener1 = j;
        } else
        {
            imageloadinglistener1 = imageloadinglistener;
        }
        if (displayimageoptions == null)
        {
            displayimageoptions1 = h.r;
        } else
        {
            displayimageoptions1 = displayimageoptions;
        }
        if (TextUtils.isEmpty(s))
        {
            i.b(imageaware);
            imageloadinglistener1.onLoadingStarted(s, imageaware.getWrappedView());
            if (displayimageoptions1.shouldShowImageForEmptyUri())
            {
                imageaware.setImageDrawable(displayimageoptions1.getImageForEmptyUri(h.a));
            } else
            {
                imageaware.setImageDrawable(null);
            }
            imageloadinglistener1.onLoadingComplete(s, imageaware.getWrappedView(), null);
            return;
        }
        imagesize = ImageSizeUtils.defineTargetSizeForView(imageaware, h.a());
        s1 = MemoryCacheUtils.generateKey(s, imagesize);
        i.a(imageaware, s1);
        imageloadinglistener1.onLoadingStarted(s, imageaware.getWrappedView());
        bitmap = (Bitmap)h.n.get(s1);
        if (bitmap != null && !bitmap.isRecycled())
        {
            L.d("Load image from memory cache [%s]", new Object[] {
                s1
            });
            if (displayimageoptions1.shouldPostProcess())
            {
                k k2 = new k(s, imageaware, imagesize, s1, displayimageoptions1, imageloadinglistener1, imageloadingprogresslistener, i.a(s));
                q q1 = new q(i, bitmap, k2, a(displayimageoptions1));
                if (displayimageoptions1.a())
                {
                    q1.run();
                    return;
                } else
                {
                    i.a(q1);
                    return;
                }
            } else
            {
                displayimageoptions1.getDisplayer().display(bitmap, imageaware, LoadedFrom.MEMORY_CACHE);
                imageloadinglistener1.onLoadingComplete(s, imageaware.getWrappedView(), bitmap);
                return;
            }
        }
        if (displayimageoptions1.shouldShowImageOnLoading())
        {
            imageaware.setImageDrawable(displayimageoptions1.getImageOnLoading(h.a));
        } else
        if (displayimageoptions1.isResetViewBeforeLoading())
        {
            imageaware.setImageDrawable(null);
        }
        k1 = new k(s, imageaware, imagesize, s1, displayimageoptions1, imageloadinglistener1, imageloadingprogresslistener, i.a(s));
        l1 = new l(i, k1, a(displayimageoptions1));
        if (displayimageoptions1.a())
        {
            l1.run();
            return;
        } else
        {
            i.a(l1);
            return;
        }
    }

    public void displayImage(String s, ImageAware imageaware, ImageLoadingListener imageloadinglistener)
    {
        displayImage(s, imageaware, null, imageloadinglistener, null);
    }

    public DiskCache getDiscCache()
    {
        return getDiskCache();
    }

    public DiskCache getDiskCache()
    {
        a();
        return h.o;
    }

    public String getLoadingUriForView(ImageView imageview)
    {
        return i.a(new ImageViewAware(imageview));
    }

    public String getLoadingUriForView(ImageAware imageaware)
    {
        return i.a(imageaware);
    }

    public MemoryCache getMemoryCache()
    {
        a();
        return h.n;
    }

    public void handleSlowNetwork(boolean flag)
    {
        i.b(flag);
    }

    public void init(ImageLoaderConfiguration imageloaderconfiguration)
    {
        this;
        JVM INSTR monitorenter ;
        if (imageloaderconfiguration != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (h != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        L.d("Initialize ImageLoader with configuration", new Object[0]);
        i = new i(imageloaderconfiguration);
        h = imageloaderconfiguration;
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        L.w("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
          goto _L1
    }

    public boolean isInited()
    {
        return h != null;
    }

    public void loadImage(String s, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener)
    {
        loadImage(s, null, displayimageoptions, imageloadinglistener, null);
    }

    public void loadImage(String s, ImageSize imagesize, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener)
    {
        loadImage(s, imagesize, displayimageoptions, imageloadinglistener, null);
    }

    public void loadImage(String s, ImageSize imagesize, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener, ImageLoadingProgressListener imageloadingprogresslistener)
    {
        a();
        if (imagesize == null)
        {
            imagesize = h.a();
        }
        DisplayImageOptions displayimageoptions1;
        if (displayimageoptions == null)
        {
            displayimageoptions1 = h.r;
        } else
        {
            displayimageoptions1 = displayimageoptions;
        }
        displayImage(s, new NonViewAware(s, imagesize, ViewScaleType.CROP), displayimageoptions1, imageloadinglistener, imageloadingprogresslistener);
    }

    public void loadImage(String s, ImageSize imagesize, ImageLoadingListener imageloadinglistener)
    {
        loadImage(s, imagesize, null, imageloadinglistener, null);
    }

    public void loadImage(String s, ImageLoadingListener imageloadinglistener)
    {
        loadImage(s, null, null, imageloadinglistener, null);
    }

    public Bitmap loadImageSync(String s)
    {
        return loadImageSync(s, null, null);
    }

    public Bitmap loadImageSync(String s, DisplayImageOptions displayimageoptions)
    {
        return loadImageSync(s, null, displayimageoptions);
    }

    public Bitmap loadImageSync(String s, ImageSize imagesize)
    {
        return loadImageSync(s, imagesize, null);
    }

    public Bitmap loadImageSync(String s, ImageSize imagesize, DisplayImageOptions displayimageoptions)
    {
        if (displayimageoptions == null)
        {
            displayimageoptions = h.r;
        }
        DisplayImageOptions displayimageoptions1 = (new DisplayImageOptions.Builder()).cloneFrom(displayimageoptions).a(true).build();
        e e1 = new e(null);
        loadImage(s, imagesize, displayimageoptions1, e1);
        return e1.a();
    }

    public void pause()
    {
        i.a();
    }

    public void resume()
    {
        i.b();
    }

    public void stop()
    {
        i.c();
    }

}
