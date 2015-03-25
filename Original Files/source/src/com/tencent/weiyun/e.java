// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.weiyun:
//            WeiyunFile, IGetFileListListener, FileManager

class e
    implements IUiListener
{

    final FileManager a;
    private IGetFileListListener b;

    public e(FileManager filemanager, IGetFileListListener igetfilelistlistener)
    {
        a = filemanager;
        super();
        b = igetfilelistlistener;
    }

    public void onCancel()
    {
    }

    public void onComplete(Object obj)
    {
        JSONObject jsonobject = (JSONObject)obj;
        ArrayList arraylist;
        JSONObject jsonobject1;
        arraylist = new ArrayList();
        jsonobject1 = jsonobject.getJSONObject("data");
        if (jsonobject1.isNull("content")) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray = jsonobject1.getJSONArray("content");
        int i = 0;
_L3:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject2 = jsonarray.getJSONObject(i);
        arraylist.add(new WeiyunFile(jsonobject2.getString("file_id"), jsonobject2.getString("file_name"), jsonobject2.getString("file_ctime"), jsonobject2.getInt("file_size")));
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        try
        {
            b.onComplete(arraylist);
            return;
        }
        catch (JSONException jsonexception)
        {
            b.onError(new UiError(-4, "\u670D\u52A1\u5668\u8FD4\u56DE\u6570\u636E\u683C\u5F0F\u6709\u8BEF!", jsonobject.toString()));
        }
        return;
    }

    public void onError(UiError uierror)
    {
        b.onError(uierror);
    }
}
