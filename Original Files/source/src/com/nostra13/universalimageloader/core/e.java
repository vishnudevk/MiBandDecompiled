// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            d

class e extends SimpleImageLoadingListener
{

    private Bitmap a;

    private e()
    {
    }

    e(d d)
    {
        this();
    }

    public Bitmap a()
    {
        return a;
    }

    public void onLoadingComplete(String s, View view, Bitmap bitmap)
    {
        a = bitmap;
    }
}
