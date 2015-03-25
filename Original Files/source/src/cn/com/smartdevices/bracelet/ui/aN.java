// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainUIActivity

class aN
    implements MainMenuFragment.MenuListener
{

    final MainUIActivity a;

    aN(MainUIActivity mainuiactivity)
    {
        a = mainuiactivity;
        super();
    }

    public void onDismiss()
    {
        MainUIActivity.e(a, false);
        MainUIActivity.y(a).destroyDrawingCache();
        MainUIActivity.z(a).destroyDrawingCache();
    }
}
