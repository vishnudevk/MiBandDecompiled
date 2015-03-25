// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.weiyun:
//            RecordManager

class n
    implements IUiListener
{

    final IUiListener a;
    final RecordManager b;

    n(RecordManager recordmanager, IUiListener iuilistener)
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
        ArrayList arraylist;
        JSONObject jsonobject1;
        if (jsonobject.getInt("ret") != 0)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        arraylist = new ArrayList();
        jsonobject1 = jsonobject.getJSONObject("data");
        if (jsonobject1.isNull("keys")) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray = jsonobject1.getJSONArray("keys");
        int i = 0;
_L3:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(Util.hexToString(jsonarray.getJSONObject(i).getString("key")));
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        try
        {
            a.onComplete(arraylist);
            return;
        }
        catch (JSONException jsonexception)
        {
            a.onError(new UiError(-4, jsonexception.getMessage(), null));
        }
        break MISSING_BLOCK_LABEL_152;
        a.onError(new UiError(-4, jsonobject.toString(), null));
        return;
    }

    public void onError(UiError uierror)
    {
        a.onError(uierror);
    }
}
