// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BindWeixinActivity

class A extends BleCallBack
{

    final BindWeixinActivity b;

    A(BindWeixinActivity bindweixinactivity)
    {
        b = bindweixinactivity;
        super();
    }

    public void onFailed(Object obj)
    {
        super.onFailed(obj);
        BindWeixinActivity.i(b);
    }

    public void onFinish(Object obj)
    {
        super.onFinish(obj);
        if (((Boolean)obj).booleanValue())
        {
            BindWeixinActivity.h(b).sendEmptyMessage(0);
            return;
        } else
        {
            BindWeixinActivity.i(b);
            return;
        }
    }

    public void onStart()
    {
        super.onStart();
        BindWeixinActivity.g(b);
    }
}
