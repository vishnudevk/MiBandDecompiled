// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            l

class o
    implements Runnable
{

    final l a;

    o(l l1)
    {
        a = l1;
        super();
    }

    public void run()
    {
        a.d.onLoadingCancelled(a.a, a.b.getWrappedView());
    }
}
