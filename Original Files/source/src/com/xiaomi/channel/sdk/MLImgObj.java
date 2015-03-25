// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.graphics.Bitmap;

// Referenced classes of package com.xiaomi.channel.sdk:
//            ShareUtils

public class MLImgObj
{

    static final int a = 0x200000;
    final int b = 356;
    final int c = 356;
    private final Bitmap d;
    public String filePath;
    public long mImgSize;

    public MLImgObj(Bitmap bitmap)
    {
        mImgSize = 0x200000L;
        d = bitmap;
    }

    public Bitmap getCompressBmp()
    {
        if (d == null)
        {
            return null;
        }
        int i = d.getWidth();
        int j = d.getHeight();
        long l = i * j;
        if (l <= mImgSize)
        {
            return d;
        } else
        {
            double d1 = Math.sqrt(l / mImgSize);
            return ShareUtils.compressBitmapWithNoDistortion(d, (int)((double)i / d1), (int)((double)j / d1), android.graphics.Bitmap.Config.ARGB_8888);
        }
    }

    public Bitmap getImgBmp()
    {
        return d;
    }
}
