// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.view.CustomToast;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BindWeixinActivity

class z extends Handler
{

    final BindWeixinActivity a;

    z(BindWeixinActivity bindweixinactivity)
    {
        a = bindweixinactivity;
        super();
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            BindWeixinActivity.a(a);
            return;

        case 1: // '\001'
            BindWeixinActivity.b(a);
            return;

        case 2: // '\002'
            CustomToast.makeText(a, 0x7f0d0026, 0).show();
            BindWeixinActivity.c(a);
            return;

        case 3: // '\003'
            BindWeixinActivity.d(a);
            BindWeixinActivity.c(a);
            return;

        case 4: // '\004'
            CustomToast.makeText(a, (new StringBuilder()).append(a.getString(0x7f0d002c)).append(a.getString(0x7f0d001a)).toString(), 0).show();
            BindWeixinActivity.a(a, 1);
            BindWeixinActivity.e(a).setEnabled(false);
            return;

        case 5: // '\005'
            BindWeixinActivity.f(a);
            break;
        }
        BindWeixinActivity.e(a).setEnabled(true);
    }
}
