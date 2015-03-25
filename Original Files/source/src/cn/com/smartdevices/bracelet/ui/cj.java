// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, SystemBarTintManager

class cj
    implements Runnable
{

    final SystemBarTintActivity a;

    cj(SystemBarTintActivity systembartintactivity)
    {
        a = systembartintactivity;
        super();
    }

    public void run()
    {
        if (SystemBarTintActivity.access$000(a))
        {
            return;
        }
        try
        {
            SystemBarTintActivity.access$100(a).buildDrawingCache();
            int i = SystemBarTintActivity.access$100(a).getDrawingCache().getPixel(0, SystemBarTintActivity.access$200(a).getConfig().getStatusBarHeight());
            Log.d("DDDD", (new StringBuilder()).append("SystemStatusBar Tint Color : ").append(Integer.toHexString(i)).toString());
            SystemBarTintActivity.access$100(a).destroyDrawingCache();
            a.applyStatusBarTint(i);
            return;
        }
        catch (Exception exception)
        {
            a.applyStatusBarTint(0xff000000);
            exception.printStackTrace();
            return;
        }
    }
}
