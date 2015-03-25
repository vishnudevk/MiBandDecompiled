// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tauth.UiError;
import com.tencent.utils.DataConvert;
import org.json.JSONObject;

// Referenced classes of package com.tencent.weiyun:
//            f, IUploadFileCallBack, FileManager

class g extends Handler
{

    final FileManager a;
    final f b;

    g(f f1, Looper looper, FileManager filemanager)
    {
        b = f1;
        a = filemanager;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 64
    //                   1 207
    //                   2 232;
           goto _L1 _L2 _L3 _L4
_L1:
        f.a(b).onError(new UiError(message.what, (String)message.obj, null));
        return;
_L2:
        JSONObject jsonobject = (JSONObject)message.obj;
        int j = jsonobject.getInt("ret");
        if (j != 0)
        {
            try
            {
                f.a(b).onError(new UiError(j, jsonobject.toString(), null));
                return;
            }
            catch (Exception exception)
            {
                f.a(b).onError(new UiError(-4, exception.getMessage(), null));
            }
            return;
        }
        JSONObject jsonobject1 = jsonobject.getJSONObject("data");
        String s = jsonobject1.getString("csum");
        f.a(b, DataConvert.string2bytes(s));
        f.a(b, jsonobject1.getString("host"));
        f.a(b).onUploadStart();
        f.b(b);
        return;
_L3:
        int i = Integer.parseInt((String)message.obj);
        f.a(b).onUploadProgress(i);
        return;
_L4:
        f.a(b).onUploadSuccess();
        return;
    }
}
