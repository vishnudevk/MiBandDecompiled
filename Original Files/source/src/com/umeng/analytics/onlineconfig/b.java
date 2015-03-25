// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.onlineconfig;

import java.util.Locale;
import org.json.JSONObject;
import u.aly.bj;
import u.aly.bq;

public class b extends bq
{

    public JSONObject a;
    boolean b;
    int c;
    int d;
    String e;
    private final String f = "config_update";
    private final String g = "report_policy";
    private final String h = "online_params";
    private final String i = "last_config_time";
    private final String j = "report_interval";

    public b(JSONObject jsonobject)
    {
        super(jsonobject);
        a = null;
        b = false;
        c = -1;
        d = -1;
        if (jsonobject == null)
        {
            return;
        } else
        {
            a(jsonobject);
            a();
            return;
        }
    }

    private void a()
    {
        if (c < 0 || c > 6)
        {
            c = 1;
        }
    }

    private void a(JSONObject jsonobject)
    {
        if (!jsonobject.has("config_update"))
        {
            break MISSING_BLOCK_LABEL_109;
        }
        if (jsonobject.getString("config_update").toLowerCase(Locale.US).equals("no"))
        {
            return;
        }
        if (!jsonobject.has("report_policy"))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        c = jsonobject.getInt("report_policy");
        d = 1000 * jsonobject.optInt("report_interval");
        e = jsonobject.optString("last_config_time");
_L1:
        Exception exception;
        a = jsonobject.optJSONObject("online_params");
        b = true;
        return;
        try
        {
            bj.e("MobclickAgent", " online config fetch no report policy");
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            bj.e("MobclickAgent", "fail to parce online config response", exception);
            return;
        }
          goto _L1
    }
}
