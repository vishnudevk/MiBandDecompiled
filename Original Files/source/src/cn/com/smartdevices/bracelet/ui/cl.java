// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Utils;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            UnBindActivity

class cl
    implements Runnable
{

    final UnBindActivity a;

    cl(UnBindActivity unbindactivity)
    {
        a = unbindactivity;
        super();
    }

    public void run()
    {
        Utils.hideProgressDialog(a);
        a.finish();
    }
}
