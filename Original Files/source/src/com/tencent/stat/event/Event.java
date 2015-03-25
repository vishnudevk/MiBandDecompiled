// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.event;

import android.content.Context;
import android.util.Log;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatStore;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.User;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat.event:
//            EventType

public abstract class Event
{

    protected String appkey;
    protected Context ctx;
    protected int sessionId;
    protected long timestamp;
    protected User user;

    Event(Context context, int i)
    {
        user = null;
        ctx = context;
        appkey = StatConfig.getAppKey(context);
        timestamp = System.currentTimeMillis() / 1000L;
        sessionId = i;
        user = StatStore.getInstance(context).getUser(context);
    }

    public boolean encode(JSONObject jsonobject)
    {
        boolean flag;
        try
        {
            StatCommonHelper.jsonPut(jsonobject, "ky", appkey);
            jsonobject.put("et", getType().GetIntValue());
            jsonobject.put("ui", user.getUid());
            StatCommonHelper.jsonPut(jsonobject, "mc", user.getMac());
            jsonobject.put("si", sessionId);
            jsonobject.put("ts", timestamp);
            flag = onEncode(jsonobject);
        }
        catch (JSONException jsonexception)
        {
            Log.e("Event", "Failed to encode", jsonexception);
            return false;
        }
        return flag;
    }

    public Context getContext()
    {
        return ctx;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public abstract EventType getType();

    public abstract boolean onEncode(JSONObject jsonobject);

    public String toJsonString()
    {
        JSONObject jsonobject = new JSONObject();
        encode(jsonobject);
        return jsonobject.toString();
    }
}
