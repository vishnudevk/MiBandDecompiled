// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.webapi;

import cn.com.smartdevices.bracelet.Debug;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet.webapi:
//            WebStatus

public abstract class BaseRes
{

    protected String TAG;

    public BaseRes()
    {
        TAG = "BaseRes";
    }

    public WebStatus getWebStatus(String s)
    {
        Debug.i(TAG, (new StringBuilder()).append("getWebStatus:").append(s).toString());
        WebStatus webstatus = new WebStatus();
        try
        {
            JSONObject jsonobject = new JSONObject(s);
            webstatus.code = jsonobject.getInt("code");
            webstatus.message = jsonobject.getString("message");
        }
        catch (JSONException jsonexception)
        {
            webstatus.code = 2;
            Debug.i(TAG, jsonexception.getMessage());
            return webstatus;
        }
        return webstatus;
    }

    public WebStatus getWebStatus(JSONObject jsonobject)
    {
        WebStatus webstatus = new WebStatus();
        try
        {
            webstatus.code = jsonobject.getInt("code");
            webstatus.message = jsonobject.getString("message");
        }
        catch (JSONException jsonexception)
        {
            webstatus.code = 2;
            Debug.i(TAG, jsonexception.getMessage());
            return webstatus;
        }
        return webstatus;
    }

    public abstract Object parse(String s);
}
