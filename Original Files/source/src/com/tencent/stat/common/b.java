// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.common;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.stat.StatConfig;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat.common:
//            StatCommonHelper, a

class b
{

    String a;
    String b;
    DisplayMetrics c;
    int d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    int l;

    private b(Context context)
    {
        b = "1.0.0";
        d = android.os.Build.VERSION.SDK_INT;
        e = Build.MODEL;
        f = Build.MANUFACTURER;
        g = Locale.getDefault().getLanguage();
        l = 0;
        c = StatCommonHelper.getDisplayMetrics(context);
        a = StatCommonHelper.getCurAppVersion(context);
        h = StatConfig.getInstallChannel(context);
        i = StatCommonHelper.getSimOperator(context);
        j = TimeZone.getDefault().getID();
        l = StatCommonHelper.hasRootAccess(context);
        k = StatCommonHelper.getExternalStorageInfo(context);
    }

    b(Context context, a a1)
    {
        this(context);
    }

    void a(JSONObject jsonobject)
    {
        jsonobject.put("sr", (new StringBuilder()).append(c.widthPixels).append("*").append(c.heightPixels).toString());
        StatCommonHelper.jsonPut(jsonobject, "av", a);
        StatCommonHelper.jsonPut(jsonobject, "ch", h);
        StatCommonHelper.jsonPut(jsonobject, "mf", f);
        StatCommonHelper.jsonPut(jsonobject, "sv", b);
        StatCommonHelper.jsonPut(jsonobject, "ov", Integer.toString(d));
        jsonobject.put("os", 1);
        StatCommonHelper.jsonPut(jsonobject, "op", i);
        StatCommonHelper.jsonPut(jsonobject, "lg", g);
        StatCommonHelper.jsonPut(jsonobject, "md", e);
        StatCommonHelper.jsonPut(jsonobject, "tz", j);
        if (l != 0)
        {
            jsonobject.put("jb", l);
        }
        StatCommonHelper.jsonPut(jsonobject, "sd", k);
    }
}
