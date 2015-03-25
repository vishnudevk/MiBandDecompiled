// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.common;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat.common:
//            StatCommonHelper, b

public class Env
{

    static b a;
    private static JSONObject d = null;
    Integer b;
    String c;

    public Env(Context context)
    {
        b = null;
        c = null;
        a(context);
        b = StatCommonHelper.getTelephonyNetworkType(context.getApplicationContext());
        c = StatCommonHelper.getLinkedWay(context);
    }

    static b a(Context context)
    {
        if (a == null)
        {
            a = new b(context.getApplicationContext(), null);
        }
        return a;
    }

    public static void appendEnvAttr(Context context, Map map)
    {
        if (map != null)
        {
            if (d == null)
            {
                d = new JSONObject();
            }
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                d.put((String)entry.getKey(), entry.getValue());
            }
        }
    }

    public void encode(JSONObject jsonobject)
    {
        JSONObject jsonobject1 = new JSONObject();
        if (a != null)
        {
            a.a(jsonobject1);
        }
        StatCommonHelper.jsonPut(jsonobject1, "cn", c);
        if (b != null)
        {
            jsonobject1.put("tn", b);
        }
        jsonobject.put("ev", jsonobject1);
        if (d != null && d.length() > 0)
        {
            jsonobject.put("eva", d);
        }
    }

}
