// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.weiyun:
//            RecordManager

class o
    implements IUiListener
{

    final IUiListener a;
    final RecordManager b;

    o(RecordManager recordmanager, IUiListener iuilistener)
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
            a.onComplete(Boolean.TRUE);
            return;
        }
        try
        {
            a.onComplete(Boolean.FALSE);
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
