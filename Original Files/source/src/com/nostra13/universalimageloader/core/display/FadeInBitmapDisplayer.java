// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

// Referenced classes of package com.nostra13.universalimageloader.core.display:
//            BitmapDisplayer

public class FadeInBitmapDisplayer
    implements BitmapDisplayer
{

    private final int a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    public FadeInBitmapDisplayer(int i)
    {
        this(i, true, true, true);
    }

    public FadeInBitmapDisplayer(int i, boolean flag, boolean flag1, boolean flag2)
    {
        a = i;
        b = flag;
        c = flag1;
        d = flag2;
    }

    public static void animate(View view, int i)
    {
        if (view != null)
        {
            AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
            alphaanimation.setDuration(i);
            alphaanimation.setInterpolator(new DecelerateInterpolator());
            view.startAnimation(alphaanimation);
        }
    }

    public void display(Bitmap bitmap, ImageAware imageaware, LoadedFrom loadedfrom)
    {
        imageaware.setImageBitmap(bitmap);
        if (b && loadedfrom == LoadedFrom.NETWORK || c && loadedfrom == LoadedFrom.DISC_CACHE || d && loadedfrom == LoadedFrom.MEMORY_CACHE)
        {
            animate(imageaware.getWrappedView(), a);
        }
    }
}
