// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.weiyun:
//            a, IDownLoadFileCallBack, FileManager

class b extends Handler
{

    final FileManager a;
    final a b;

    b(a a1, Looper looper, FileManager filemanager)
    {
        b = a1;
        a = filemanager;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 64
    //                   1 270
    //                   2 295;
           goto _L1 _L2 _L3 _L4
_L1:
        com.tencent.weiyun.a.a(b).onError(new UiError(message.what, (String)message.obj, null));
        return;
_L2:
        JSONObject jsonobject = (JSONObject)message.obj;
        int j = jsonobject.getInt("ret");
        if (j != 0)
        {
            try
            {
                com.tencent.weiyun.a.a(b).onError(new UiError(j, jsonobject.toString(), null));
                return;
            }
            catch (JSONException jsonexception)
            {
                com.tencent.weiyun.a.a(b).onError(new UiError(-4, jsonexception.getMessage(), null));
            }
            return;
        }
        JSONObject jsonobject1 = jsonobject.getJSONObject("data");
        com.tencent.weiyun.a.a(b, jsonobject1.getString("dl_encrypt_url"));
        com.tencent.weiyun.a.b(b, jsonobject1.getString("dl_cookie_name"));
        com.tencent.weiyun.a.c(b, jsonobject1.getString("dl_cookie_value"));
        com.tencent.weiyun.a.a(b, jsonobject1.getInt("dl_svr_port"));
        com.tencent.weiyun.a.d(b, jsonobject1.getString("dl_svr_host"));
        if (jsonobject1.has("dl_thumb_size"))
        {
            com.tencent.weiyun.a.e(b, jsonobject1.getString("dl_thumb_size"));
        }
        com.tencent.weiyun.a.a(b).onDownloadStart();
        com.tencent.weiyun.a.b(b);
        return;
_L3:
        int i = Integer.parseInt((String)message.obj);
        com.tencent.weiyun.a.a(b).onDownloadProgress(i);
        return;
_L4:
        com.tencent.weiyun.a.a(b).onDownloadSuccess(com.tencent.weiyun.a.c(b));
        return;
    }
}
