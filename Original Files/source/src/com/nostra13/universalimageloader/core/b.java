// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.utils.L;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            k, DisplayImageOptions, i

final class b
    implements Runnable
{

    private static final String a = "Display image in ImageAware (loaded from %1$s) [%2$s]";
    private static final String b = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String c = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private final Bitmap d;
    private final String e;
    private final ImageAware f;
    private final String g;
    private final BitmapDisplayer h;
    private final ImageLoadingListener i;
    private final i j;
    private final LoadedFrom k;

    public b(Bitmap bitmap, k k1, i l, LoadedFrom loadedfrom)
    {
        d = bitmap;
        e = k1.a;
        f = k1.c;
        g = k1.b;
        h = k1.e.getDisplayer();
        i = k1.f;
        j = l;
        k = loadedfrom;
    }

    private boolean a()
    {
        String s = j.a(f);
        return !g.equals(s);
    }

    public void run()
    {
        if (f.isCollected())
        {
            Object aobj2[] = new Object[1];
            aobj2[0] = g;
            L.d("ImageAware was collected by GC. Task is cancelled. [%s]", aobj2);
            i.onLoadingCancelled(e, f.getWrappedView());
            return;
        }
        if (a())
        {
            Object aobj1[] = new Object[1];
            aobj1[0] = g;
            L.d("ImageAware is reused for another image. Task is cancelled. [%s]", aobj1);
            i.onLoadingCancelled(e, f.getWrappedView());
            return;
        } else
        {
            Object aobj[] = new Object[2];
            aobj[0] = k;
            aobj[1] = g;
            L.d("Display image in ImageAware (loaded from %1$s) [%2$s]", aobj);
            h.display(d, f, k);
            j.b(f);
            i.onLoadingComplete(e, f.getWrappedView(), d);
            return;
        }
    }
}
