// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.view.Util;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            BraceletImageLoader

public class a
    implements BitmapDisplayer
{

    final BraceletImageLoader a;

    public void display(Bitmap bitmap, ImageAware imageaware, LoadedFrom loadedfrom)
    {
        if (!(imageaware instanceof ImageViewAware))
        {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        Bitmap bitmap1 = Util.clipToRoundBitmap(bitmap);
        ImageView imageview = (ImageView)imageaware.getWrappedView();
        if (bitmap1 == null || imageview == null)
        {
            return;
        } else
        {
            imageview.setBackground(new BitmapDrawable(imageview.getResources(), bitmap1));
            return;
        }
    }

    public (BraceletImageLoader braceletimageloader)
    {
        a = braceletimageloader;
        super();
    }
}
