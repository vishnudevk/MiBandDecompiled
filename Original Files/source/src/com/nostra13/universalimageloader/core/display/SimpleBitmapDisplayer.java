// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

// Referenced classes of package com.nostra13.universalimageloader.core.display:
//            BitmapDisplayer

public final class SimpleBitmapDisplayer
    implements BitmapDisplayer
{

    public SimpleBitmapDisplayer()
    {
    }

    public void display(Bitmap bitmap, ImageAware imageaware, LoadedFrom loadedfrom)
    {
        imageaware.setImageBitmap(bitmap);
    }
}
