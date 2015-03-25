// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainUIActivity

class aL
    implements Runnable
{

    final Handler a;
    final MainUIActivity b;

    aL(MainUIActivity mainuiactivity, Handler handler)
    {
        b = mainuiactivity;
        a = handler;
        super();
    }

    public void run()
    {
        MainUIActivity.w(b);
        b.listAnim();
        a.removeCallbacks(this);
    }
}
