// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.InputStream;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            f

class g
    implements ImageDownloader
{

    private final ImageDownloader a;

    public g(ImageDownloader imagedownloader)
    {
        a = imagedownloader;
    }

    public InputStream getStream(String s, Object obj)
    {
        switch (f.a[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ofUri(s).ordinal()])
        {
        default:
            return a.getStream(s, obj);

        case 1: // '\001'
        case 2: // '\002'
            throw new IllegalStateException();
        }
    }
}
