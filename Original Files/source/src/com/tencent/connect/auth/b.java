// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.os.Handler;
import android.os.Message;
import com.tencent.a.a.c;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.auth:
//            AuthAgent

class b extends Handler
{

    final AuthAgent a;

    b(AuthAgent authagent)
    {
        a = authagent;
        super();
    }

    public void handleMessage(Message message)
    {
        c.b("openSDK_LOG", (new StringBuilder()).append("OpenUi, handleMessage msg.what = ").append(message.what).append("").toString());
        if (message.what != 0)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        int j = Integer.parseInt(((JSONObject)message.obj).getString("ret"));
        int i = j;
_L1:
        JSONException jsonexception;
        if (i == 0)
        {
            AuthAgent.g(a).onComplete((JSONObject)message.obj);
            return;
        } else
        {
            AuthAgent.e(a);
            return;
        }
        jsonexception;
        jsonexception.printStackTrace();
        AuthAgent.e(a);
        i = 0;
          goto _L1
        AuthAgent.g(a).onError(new UiError(message.what, (String)message.obj, null));
        return;
    }
}
