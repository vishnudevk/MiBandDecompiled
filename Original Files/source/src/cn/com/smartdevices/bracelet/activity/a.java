// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.Utils;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            LoginActivity

class a extends Handler
{

    final LoginActivity a;

    a(LoginActivity loginactivity)
    {
        a = loginactivity;
        super();
    }

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 256: 
            Utils.showProgressDialog(a, 0x7f0d01df);
            break;
        }
    }
}
