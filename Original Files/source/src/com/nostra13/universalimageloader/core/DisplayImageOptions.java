// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            c

public final class DisplayImageOptions
{

    private final int a;
    private final int b;
    private final int c;
    private final Drawable d;
    private final Drawable e;
    private final Drawable f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final ImageScaleType j;
    private final android.graphics.BitmapFactory.Options k;
    private final int l;
    private final boolean m;
    private final Object n;
    private final BitmapProcessor o;
    private final BitmapProcessor p;
    private final BitmapDisplayer q;
    private final Handler r;
    private final boolean s;

    private DisplayImageOptions(Builder builder)
    {
        a = Builder.a(builder);
        b = Builder.b(builder);
        c = Builder.c(builder);
        d = Builder.d(builder);
        e = Builder.e(builder);
        f = Builder.f(builder);
        g = Builder.g(builder);
        h = Builder.h(builder);
        i = Builder.i(builder);
        j = Builder.j(builder);
        k = Builder.k(builder);
        l = Builder.l(builder);
        m = Builder.m(builder);
        n = Builder.n(builder);
        o = Builder.o(builder);
        p = Builder.p(builder);
        q = Builder.q(builder);
        r = Builder.r(builder);
        s = Builder.s(builder);
    }

    DisplayImageOptions(Builder builder, c c1)
    {
        this(builder);
    }

    static int a(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.a;
    }

    static int b(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.b;
    }

    static int c(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.c;
    }

    public static DisplayImageOptions createSimple()
    {
        return (new Builder()).build();
    }

    static Drawable d(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.d;
    }

    static Drawable e(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.e;
    }

    static Drawable f(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.f;
    }

    static boolean g(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.g;
    }

    static boolean h(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.h;
    }

    static boolean i(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.i;
    }

    static ImageScaleType j(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.j;
    }

    static android.graphics.BitmapFactory.Options k(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.k;
    }

    static int l(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.l;
    }

    static boolean m(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.m;
    }

    static Object n(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.n;
    }

    static BitmapProcessor o(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.o;
    }

    static BitmapProcessor p(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.p;
    }

    static BitmapDisplayer q(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.q;
    }

    static Handler r(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.r;
    }

    static boolean s(DisplayImageOptions displayimageoptions)
    {
        return displayimageoptions.s;
    }

    boolean a()
    {
        return s;
    }

    public android.graphics.BitmapFactory.Options getDecodingOptions()
    {
        return k;
    }

    public int getDelayBeforeLoading()
    {
        return l;
    }

    public BitmapDisplayer getDisplayer()
    {
        return q;
    }

    public Object getExtraForDownloader()
    {
        return n;
    }

    public Handler getHandler()
    {
        return r;
    }

    public Drawable getImageForEmptyUri(Resources resources)
    {
        if (b != 0)
        {
            return resources.getDrawable(b);
        } else
        {
            return e;
        }
    }

    public Drawable getImageOnFail(Resources resources)
    {
        if (c != 0)
        {
            return resources.getDrawable(c);
        } else
        {
            return f;
        }
    }

    public Drawable getImageOnLoading(Resources resources)
    {
        if (a != 0)
        {
            return resources.getDrawable(a);
        } else
        {
            return d;
        }
    }

    public ImageScaleType getImageScaleType()
    {
        return j;
    }

    public BitmapProcessor getPostProcessor()
    {
        return p;
    }

    public BitmapProcessor getPreProcessor()
    {
        return o;
    }

    public boolean isCacheInMemory()
    {
        return h;
    }

    public boolean isCacheOnDisk()
    {
        return i;
    }

    public boolean isConsiderExifParams()
    {
        return m;
    }

    public boolean isResetViewBeforeLoading()
    {
        return g;
    }

    public boolean shouldDelayBeforeLoading()
    {
        return l > 0;
    }

    public boolean shouldPostProcess()
    {
        return p != null;
    }

    public boolean shouldPreProcess()
    {
        return o != null;
    }

    public boolean shouldShowImageForEmptyUri()
    {
        return e != null || b != 0;
    }

    public boolean shouldShowImageOnFail()
    {
        return f != null || c != 0;
    }

    public boolean shouldShowImageOnLoading()
    {
        return d != null || a != 0;
    }

    private class Builder
    {

        private int a;
        private int b;
        private int c;
        private Drawable d;
        private Drawable e;
        private Drawable f;
        private boolean g;
        private boolean h;
        private boolean i;
        private ImageScaleType j;
        private android.graphics.BitmapFactory.Options k;
        private int l;
        private boolean m;
        private Object n;
        private BitmapProcessor o;
        private BitmapProcessor p;
        private BitmapDisplayer q;
        private Handler r;
        private boolean s;

        static int a(Builder builder)
        {
            return builder.a;
        }

        static int b(Builder builder)
        {
            return builder.b;
        }

        static int c(Builder builder)
        {
            return builder.c;
        }

        static Drawable d(Builder builder)
        {
            return builder.d;
        }

        static Drawable e(Builder builder)
        {
            return builder.e;
        }

        static Drawable f(Builder builder)
        {
            return builder.f;
        }

        static boolean g(Builder builder)
        {
            return builder.g;
        }

        static boolean h(Builder builder)
        {
            return builder.h;
        }

        static boolean i(Builder builder)
        {
            return builder.i;
        }

        static ImageScaleType j(Builder builder)
        {
            return builder.j;
        }

        static android.graphics.BitmapFactory.Options k(Builder builder)
        {
            return builder.k;
        }

        static int l(Builder builder)
        {
            return builder.l;
        }

        static boolean m(Builder builder)
        {
            return builder.m;
        }

        static Object n(Builder builder)
        {
            return builder.n;
        }

        static BitmapProcessor o(Builder builder)
        {
            return builder.o;
        }

        static BitmapProcessor p(Builder builder)
        {
            return builder.p;
        }

        static BitmapDisplayer q(Builder builder)
        {
            return builder.q;
        }

        static Handler r(Builder builder)
        {
            return builder.r;
        }

        static boolean s(Builder builder)
        {
            return builder.s;
        }

        Builder a(boolean flag)
        {
            s = flag;
            return this;
        }

        public Builder bitmapConfig(android.graphics.Bitmap.Config config)
        {
            if (config == null)
            {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            } else
            {
                k.inPreferredConfig = config;
                return this;
            }
        }

        public DisplayImageOptions build()
        {
            return new DisplayImageOptions(this, null);
        }

        public Builder cacheInMemory()
        {
            h = true;
            return this;
        }

        public Builder cacheInMemory(boolean flag)
        {
            h = flag;
            return this;
        }

        public Builder cacheOnDisc()
        {
            return cacheOnDisk(true);
        }

        public Builder cacheOnDisc(boolean flag)
        {
            return cacheOnDisk(flag);
        }

        public Builder cacheOnDisk(boolean flag)
        {
            i = flag;
            return this;
        }

        public Builder cloneFrom(DisplayImageOptions displayimageoptions)
        {
            a = DisplayImageOptions.a(displayimageoptions);
            b = DisplayImageOptions.b(displayimageoptions);
            c = DisplayImageOptions.c(displayimageoptions);
            d = DisplayImageOptions.d(displayimageoptions);
            e = DisplayImageOptions.e(displayimageoptions);
            f = DisplayImageOptions.f(displayimageoptions);
            g = DisplayImageOptions.g(displayimageoptions);
            h = DisplayImageOptions.h(displayimageoptions);
            i = DisplayImageOptions.i(displayimageoptions);
            j = DisplayImageOptions.j(displayimageoptions);
            k = DisplayImageOptions.k(displayimageoptions);
            l = DisplayImageOptions.l(displayimageoptions);
            m = DisplayImageOptions.m(displayimageoptions);
            n = DisplayImageOptions.n(displayimageoptions);
            o = DisplayImageOptions.o(displayimageoptions);
            p = DisplayImageOptions.p(displayimageoptions);
            q = DisplayImageOptions.q(displayimageoptions);
            r = DisplayImageOptions.r(displayimageoptions);
            s = DisplayImageOptions.s(displayimageoptions);
            return this;
        }

        public Builder considerExifParams(boolean flag)
        {
            m = flag;
            return this;
        }

        public Builder decodingOptions(android.graphics.BitmapFactory.Options options)
        {
            if (options == null)
            {
                throw new IllegalArgumentException("decodingOptions can't be null");
            } else
            {
                k = options;
                return this;
            }
        }

        public Builder delayBeforeLoading(int i1)
        {
            l = i1;
            return this;
        }

        public Builder displayer(BitmapDisplayer bitmapdisplayer)
        {
            if (bitmapdisplayer == null)
            {
                throw new IllegalArgumentException("displayer can't be null");
            } else
            {
                q = bitmapdisplayer;
                return this;
            }
        }

        public Builder extraForDownloader(Object obj)
        {
            n = obj;
            return this;
        }

        public Builder handler(Handler handler1)
        {
            r = handler1;
            return this;
        }

        public Builder imageScaleType(ImageScaleType imagescaletype)
        {
            j = imagescaletype;
            return this;
        }

        public Builder postProcessor(BitmapProcessor bitmapprocessor)
        {
            p = bitmapprocessor;
            return this;
        }

        public Builder preProcessor(BitmapProcessor bitmapprocessor)
        {
            o = bitmapprocessor;
            return this;
        }

        public Builder resetViewBeforeLoading()
        {
            g = true;
            return this;
        }

        public Builder resetViewBeforeLoading(boolean flag)
        {
            g = flag;
            return this;
        }

        public Builder showImageForEmptyUri(int i1)
        {
            b = i1;
            return this;
        }

        public Builder showImageForEmptyUri(Drawable drawable)
        {
            e = drawable;
            return this;
        }

        public Builder showImageOnFail(int i1)
        {
            c = i1;
            return this;
        }

        public Builder showImageOnFail(Drawable drawable)
        {
            f = drawable;
            return this;
        }

        public Builder showImageOnLoading(int i1)
        {
            a = i1;
            return this;
        }

        public Builder showImageOnLoading(Drawable drawable)
        {
            d = drawable;
            return this;
        }

        public Builder showStubImage(int i1)
        {
            a = i1;
            return this;
        }

        public Builder()
        {
            a = 0;
            b = 0;
            c = 0;
            d = null;
            e = null;
            f = null;
            g = false;
            h = false;
            i = false;
            j = ImageScaleType.IN_SAMPLE_POWER_OF_2;
            k = new android.graphics.BitmapFactory.Options();
            l = 0;
            m = false;
            n = null;
            o = null;
            p = null;
            q = DefaultConfigurationFactory.createBitmapDisplayer();
            r = null;
            s = false;
            k.inPurgeable = true;
            k.inInputShareable = true;
        }
    }

}
