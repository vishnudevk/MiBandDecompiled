// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.weiyun:
//            RecordManager

class l
    implements IUiListener
{

    final IUiListener a;
    final RecordManager b;

    l(RecordManager recordmanager, IUiListener iuilistener)
    {
        b = recordmanager;
        a = iuilistener;
        super();
    }

    public void onCancel()
    {
        a.onCancel();
    }

    public void onComplete(Object obj)
    {
        JSONObject jsonobject = (JSONObject)obj;
        if (jsonobject.getInt("ret") == 0)
        {
            String s = jsonobject.getJSONObject("data").getString("value");
            a.onComplete(Util.hexToString(s));
            return;
        }
        try
        {
            a.onError(new UiError(-4, jsonobject.toString(), null));
            return;
        }
        catch (JSONException jsonexception)
        {
            a.onError(new UiError(-4, jsonexception.getMessage(), null));
        }
        return;
    }

    public void onError(UiError uierror)
    {
        a.onError(uierror);
    }
}
