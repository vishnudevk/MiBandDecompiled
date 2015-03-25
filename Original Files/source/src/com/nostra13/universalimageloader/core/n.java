// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            l, DisplayImageOptions, ImageLoaderConfiguration

class n
    implements Runnable
{

    final com.nostra13.universalimageloader.core.assist.FailReason.FailType a;
    final Throwable b;
    final l c;

    n(l l1, com.nostra13.universalimageloader.core.assist.FailReason.FailType failtype, Throwable throwable)
    {
        c = l1;
        a = failtype;
        b = throwable;
        super();
    }

    public void run()
    {
        if (c.c.shouldShowImageOnFail())
        {
            c.b.setImageDrawable(c.c.getImageOnFail(l.a(c).a));
        }
        c.d.onLoadingFailed(c.a, c.b.getWrappedView(), new FailReason(a, b));
    }
}
