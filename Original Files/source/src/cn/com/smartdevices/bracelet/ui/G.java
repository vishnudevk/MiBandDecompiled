// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BindWeixinActivityNew

class G extends BleCallBack
{

    final BindWeixinActivityNew b;

    G(BindWeixinActivityNew bindweixinactivitynew)
    {
        b = bindweixinactivitynew;
        super();
    }

    public void onFailed(Object obj)
    {
        super.onFailed(obj);
        BindWeixinActivityNew.c(b);
    }

    public void onFinish(Object obj)
    {
        super.onFinish(obj);
        if (((Boolean)obj).booleanValue())
        {
            BindWeixinActivityNew.g(b).sendEmptyMessage(0);
            return;
        } else
        {
            BindWeixinActivityNew.c(b);
            return;
        }
    }

    public void onStart()
    {
        super.onStart();
        BindWeixinActivityNew.f(b);
    }
}
