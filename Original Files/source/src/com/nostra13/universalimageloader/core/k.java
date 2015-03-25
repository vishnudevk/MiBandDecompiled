// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            DisplayImageOptions

final class k
{

    final String a;
    final String b;
    final ImageAware c;
    final ImageSize d;
    final DisplayImageOptions e;
    final ImageLoadingListener f;
    final ImageLoadingProgressListener g;
    final ReentrantLock h;

    public k(String s, ImageAware imageaware, ImageSize imagesize, String s1, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener, ImageLoadingProgressListener imageloadingprogresslistener, 
            ReentrantLock reentrantlock)
    {
        a = s;
        c = imageaware;
        d = imagesize;
        e = displayimageoptions;
        f = imageloadinglistener;
        g = imageloadingprogresslistener;
        h = reentrantlock;
        b = s1;
    }
}
