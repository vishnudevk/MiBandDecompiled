// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            l

class m
    implements Runnable
{

    final int a;
    final int b;
    final l c;

    m(l l1, int i, int j)
    {
        c = l1;
        a = i;
        b = j;
        super();
    }

    public void run()
    {
        c.e.onProgressUpdate(c.a, c.b.getWrappedView(), a, b);
    }
}
