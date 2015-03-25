// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class MLExtraInfo
{

    public String action;
    public int availableVersion;
    public String extraUri;

    public MLExtraInfo()
    {
        action = "";
        extraUri = "";
        availableVersion = 0;
    }

    public void parseFromJson(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_46;
        }
        JSONObject jsonobject = new JSONObject(s);
        action = jsonobject.optString("action");
        extraUri = jsonobject.optString("extraUri");
        availableVersion = jsonobject.optInt("availableVersion");
        return;
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        return;
    }

    public String toJson()
    {
        JSONObject jsonobject = new JSONObject();
        String s;
        try
        {
            jsonobject.put("action", action);
            jsonobject.put("extraUri", extraUri);
            jsonobject.put("availableVersion", availableVersion);
            s = jsonobject.toString();
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return "";
        }
        return s;
    }
}
