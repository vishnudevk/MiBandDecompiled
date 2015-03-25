// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.utils.DiskCacheUtils;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import java.io.File;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            BraceletApp

public class BraceletImageLoader
{

    private static BraceletImageLoader c = null;
    private static Drawable d = null;
    private DisplayImageOptions a;
    private ImageLoader b;

    private BraceletImageLoader(Context context)
    {
        a = null;
        b = null;
        a(context);
    }

    private void a(Context context)
    {
        File file = new File(((BraceletApp)context).getStoragePath());
        com.nostra13.universalimageloader.core.ImageLoaderConfiguration imageloaderconfiguration = (new com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder(context)).threadPriority(5).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).memoryCache(new LruMemoryCache(0x400000)).memoryCacheSize(0x400000).discCache(new UnlimitedDiscCache(file)).discCacheSize(0x3200000).discCacheFileCount(1000).writeDebugLogs().build();
        b = ImageLoader.getInstance();
        b.init(imageloaderconfiguration);
        a = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheInMemory(true).cacheOnDisc(true).build();
    }

    public static BraceletImageLoader getInstance()
    {
        return c;
    }

    public static void init(Context context)
    {
        c = new BraceletImageLoader(context);
        d = context.getResources().getDrawable(0x7f02005a);
    }

    public void displayImage(String s, ImageView imageview)
    {
        b.displayImage(s, imageview, a);
    }

    public void displayImage(String s, ImageView imageview, ImageLoadingListener imageloadinglistener)
    {
        b.displayImage(s, imageview, a, imageloadinglistener);
    }

    public void displayRoundImage(String s, ImageView imageview)
    {
        DisplayImageOptions displayimageoptions = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheInMemory(true).cacheOnDisc(true).displayer(new RoundBitmapDisplayer()).build();
        b.displayImage(s, imageview, displayimageoptions);
    }

    public File getDiscCache(String s)
    {
        return DiskCacheUtils.findInCache(s, b.getDiscCache());
    }

    public List getMemoryCache(String s)
    {
        return MemoryCacheUtils.findCachedBitmapsForImageUri(s, b.getMemoryCache());
    }

    public void loadImageAsync(String s, ImageSize imagesize, ImageLoadingListener imageloadinglistener)
    {
        b.loadImage(s, imagesize, imageloadinglistener);
    }

    public void loadImageAsync(String s, ImageLoadingListener imageloadinglistener)
    {
        b.loadImage(s, imageloadinglistener);
    }

    public void loadImageAsyncOnDisc(String s, ImageLoadingListener imageloadinglistener)
    {
        DisplayImageOptions displayimageoptions = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheInMemory(false).cacheOnDisc(true).build();
        b.loadImage(s, displayimageoptions, imageloadinglistener);
    }

    public Bitmap loadImageSync(String s)
    {
        return b.loadImageSync(s);
    }

    public Bitmap loadImageSync(String s, ImageSize imagesize)
    {
        return b.loadImageSync(s, imagesize);
    }

    public void removeImageCache(String s)
    {
        MemoryCacheUtils.removeFromCache(s, b.getMemoryCache());
        DiskCacheUtils.removeFromCache(s, b.getDiscCache());
    }


    private class RoundBitmapDisplayer
        implements BitmapDisplayer
    {

        final BraceletImageLoader a;

        public void display(Bitmap bitmap, ImageAware imageaware, LoadedFrom loadedfrom)
        {
            if (!(imageaware instanceof ImageViewAware))
            {
                throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
            }
            Bitmap bitmap1 = Util.clipToRoundBitmap(bitmap);
            ImageView imageview = (ImageView)imageaware.getWrappedView();
            if (bitmap1 == null || imageview == null)
            {
                return;
            } else
            {
                imageview.setBackground(new BitmapDrawable(imageview.getResources(), bitmap1));
                return;
            }
        }

        public RoundBitmapDisplayer()
        {
            a = BraceletImageLoader.this;
            super();
        }
    }

}
