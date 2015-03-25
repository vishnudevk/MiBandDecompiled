// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

// Referenced classes of package android.support.v4.app:
//            j, k

public class ActivityOptionsCompat
{

    protected ActivityOptionsCompat()
    {
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context context, int i, int l)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            return new j(k.a(context, i, l));
        } else
        {
            return new ActivityOptionsCompat();
        }
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View view, int i, int l, int i1, int j1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            return new j(k.a(view, i, l, i1, j1));
        } else
        {
            return new ActivityOptionsCompat();
        }
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int l)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            return new j(k.a(view, bitmap, i, l));
        } else
        {
            return new ActivityOptionsCompat();
        }
    }

    public Bundle toBundle()
    {
        return null;
    }

    public void update(ActivityOptionsCompat activityoptionscompat)
    {
    }
}
