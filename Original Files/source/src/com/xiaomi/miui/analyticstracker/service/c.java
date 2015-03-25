// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.service;

import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.xiaomi.miui.analyticstracker.service:
//            b, DispatcherHelper

class c
    implements b
{

    final DispatcherHelper a;

    private c(DispatcherHelper dispatcherhelper)
    {
        a = dispatcherhelper;
        super();
    }

    public JSONArray a()
    {
        JSONArray jsonarray;
        try
        {
            jsonarray = new JSONArray("[{\"app_name\": \"com.example.android_for_test\",\"servers\": [{\"server_name\": \"xiaomi\", \"app_id\": \"Example\"}],\"items\": [{\"id_regex\": \".*\", \"policy\": \"normal\"}]}]");
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return null;
        }
        return jsonarray;
    }
}
