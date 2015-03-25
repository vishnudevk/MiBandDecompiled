// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.BraceletImageLoader;
import cn.com.smartdevices.bracelet.Debug;
import com.nostra13.universalimageloader.core.assist.ImageSize;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, bY

public class ShowImageActivity extends SystemBarTintActivity
{

    private ImageView a;
    private Uri b;
    private Bitmap c;

    public ShowImageActivity()
    {
        a = null;
        b = null;
        c = null;
    }

    static Bitmap a(ShowImageActivity showimageactivity, Bitmap bitmap)
    {
        showimageactivity.c = bitmap;
        return bitmap;
    }

    static ImageView a(ShowImageActivity showimageactivity)
    {
        return showimageactivity.a;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b = getIntent().getData();
        Debug.i("WPJ", (new StringBuilder()).append("URI:").append(b.toString()).toString());
        setContentView(0x7f030014);
        a = (ImageView)findViewById(0x7f0a008f);
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        ImageSize imagesize = new ImageSize(displaymetrics.widthPixels, displaymetrics.heightPixels);
        BraceletImageLoader.getInstance().loadImageAsync(b.toString(), imagesize, new bY(this));
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (c != null)
        {
            c.recycle();
            c = null;
        }
    }
}
