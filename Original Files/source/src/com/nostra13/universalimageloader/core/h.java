// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.InputStream;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            f

class h
    implements ImageDownloader
{

    private final ImageDownloader a;

    public h(ImageDownloader imagedownloader)
    {
        a = imagedownloader;
    }

    public InputStream getStream(String s, Object obj)
    {
        InputStream inputstream = a.getStream(s, obj);
        switch (f.a[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ofUri(s).ordinal()])
        {
        default:
            return inputstream;

        case 1: // '\001'
        case 2: // '\002'
            return new FlushedInputStream(inputstream);
        }
    }
}
