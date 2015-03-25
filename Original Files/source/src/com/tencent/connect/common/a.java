// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.common:
//            BaseApi

class a extends Handler
{

    final BaseApi a;
    final BaseApi.TempRequestListener b;

    a(BaseApi.TempRequestListener temprequestlistener, Looper looper, BaseApi baseapi)
    {
        b = temprequestlistener;
        a = baseapi;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        if (message.what == 0)
        {
            BaseApi.TempRequestListener.a(b).onComplete((JSONObject)message.obj);
            return;
        } else
        {
            BaseApi.TempRequestListener.a(b).onError(new UiError(message.what, (String)message.obj, null));
            return;
        }
    }
}
