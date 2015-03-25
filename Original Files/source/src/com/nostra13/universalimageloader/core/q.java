// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            k, b, DisplayImageOptions, l, 
//            i

final class q
    implements Runnable
{

    private static final String a = "PostProcess image before displaying [%s]";
    private final i b;
    private final Bitmap c;
    private final k d;
    private final Handler e;

    public q(i i, Bitmap bitmap, k k1, Handler handler)
    {
        b = i;
        c = bitmap;
        d = k1;
        e = handler;
    }

    public void run()
    {
        Object aobj[] = new Object[1];
        aobj[0] = d.b;
        L.d("PostProcess image before displaying [%s]", aobj);
        l.a(new b(d.e.getPostProcessor().process(c), d, b, LoadedFrom.MEMORY_CACHE), d.e.a(), e, b);
    }
}
