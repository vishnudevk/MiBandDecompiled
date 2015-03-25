// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.webapi;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.ShareBackgroundItem;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet.webapi:
//            BaseRes, WebStatus

public class ShareBackgroundRes extends BaseRes
{

    public ShareBackgroundRes()
    {
    }

    public Object parse(String s)
    {
        ShareBackgroundItem sharebackgrounditem = new ShareBackgroundItem();
        JSONObject jsonobject;
        WebStatus webstatus;
        jsonobject = new JSONObject(s);
        webstatus = getWebStatus(jsonobject);
        if (!webstatus.isAuthInvalid()) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject1 = jsonobject.getJSONObject("data");
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        JSONObject jsonobject2 = jsonobject1.getJSONObject("list");
        boolean flag;
        if (jsonobject2 != null)
        {
            try
            {
                sharebackgrounditem.reachedBgUrl = jsonobject2.getString("reach");
                sharebackgrounditem.unReachedBgUrl = jsonobject2.getString("unreach");
            }
            catch (JSONException jsonexception)
            {
                Debug.i(TAG, jsonexception.getMessage());
            }
        }
        break MISSING_BLOCK_LABEL_113;
_L2:
        if (flag = webstatus.success()) goto _L1; else goto _L3
_L3:
        return webstatus;
        return sharebackgrounditem;
    }
}
