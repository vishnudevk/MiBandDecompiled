// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.miui.analyticstracker.Item;
import com.xiaomi.miui.analyticstracker.utils.EventUtils;
import com.xiaomi.miui.analyticstracker.utils.SysUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.xiaomi.miui.analyticstracker.service:
//            d, DispatcherManager, b

public class DispatcherHelper
{

    private static final String a = "servers";
    private static final String b = "server_name";
    private static final String c = "app_name";
    private static final String d = "probability";
    private static final String e = "version";
    private static final String f = "app_id";
    private static final String g = "items";
    private static final String h = "id_regex";
    private static final String i = "policy";
    private static final String j = "version_regex";
    private static final String k = "DispatcherHelper";
    private static final String l = "http://tracking.miui.com/danfa_log_config.json";
    private static final String m = "log_config.json";
    private static final long n = 100L;
    private static final String o = ".*";
    private static final String p = ".*";
    private static final String q = "normal";
    private DispatcherManager r;
    private b s;
    private Context t;

    public DispatcherHelper(Context context)
    {
        t = context;
        s = new d(this, null);
        r = new DispatcherManager(t);
    }

    static Context a(DispatcherHelper dispatcherhelper)
    {
        return dispatcherhelper.t;
    }

    private List a(JSONArray jsonarray, String s1, String s2, long l1)
    {
        ArrayList arraylist;
        int i1;
        int j1;
        arraylist = new ArrayList();
        i1 = jsonarray.length();
        j1 = 0;
_L2:
        if (j1 >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = jsonarray.getJSONObject(j1);
        arraylist.add(new Item(jsonobject.getString("id_regex"), jsonobject.getString("policy"), jsonobject.optString("version_regex", s2), jsonobject.optLong("probability", l1)));
        j1++;
        if (true) goto _L2; else goto _L1
        PatternSyntaxException patternsyntaxexception;
        patternsyntaxexception;
        Log.e("DispatcherHelper", (new StringBuilder()).append("Failed to compile items regex for app: ").append(s1).toString(), patternsyntaxexception);
_L1:
        return arraylist;
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        return arraylist;
    }

    private Map a(JSONArray jsonarray)
    {
        LinkedHashMap linkedhashmap;
        int i1;
        int j1;
        linkedhashmap = new LinkedHashMap();
        i1 = jsonarray.length();
        j1 = 0;
_L2:
        if (j1 >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = jsonarray.getJSONObject(j1);
        linkedhashmap.put(jsonobject.getString("server_name"), jsonobject.getString("app_id"));
        j1++;
        if (true) goto _L2; else goto _L1
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
_L1:
        return linkedhashmap;
    }

    public void dispatch()
    {
        if (!SysUtils.isWifiConnected(t) || !EventUtils.enableWrite(t)) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray = s.a();
        if (jsonarray == null) goto _L2; else goto _L3
_L3:
        int i1;
        int j1;
        i1 = jsonarray.length();
        j1 = 0;
_L13:
        if (j1 < i1 && SysUtils.isWifiConnected(t) && EventUtils.enableWrite(t)) goto _L4; else goto _L2
_L2:
        return;
_L4:
        JSONObject jsonobject;
        String s1;
        jsonobject = jsonarray.getJSONObject(j1);
        s1 = jsonobject.getString("app_name");
        if (s1.equals(t.getPackageName())) goto _L6; else goto _L5
_L6:
        long l1;
        String s2;
        l1 = 100L;
        s2 = ".*";
        long l2 = jsonobject.getLong("probability");
        l1 = l2;
_L11:
        String s3 = jsonobject.getString("version");
        s2 = s3;
_L10:
        if (!Pattern.compile(s2).matcher(android.os.Build.VERSION.INCREMENTAL).matches())
        {
            break; /* Loop/switch isn't completed */
        }
        r.switchDispatcher(a(jsonobject.getJSONArray("servers")));
        List list = a(jsonobject.getJSONArray("items"), s1, s2, l1);
        Object obj = list;
_L8:
        try
        {
            r.dispatch(((List) (obj)));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        break; /* Loop/switch isn't completed */
        JSONException jsonexception3;
        jsonexception3;
        ArrayList arraylist;
        arraylist = new ArrayList();
        arraylist.add(new Item(".*", "normal", s2, l1));
        obj = arraylist;
        if (true) goto _L8; else goto _L7
_L7:
        JSONException jsonexception2;
        break; /* Loop/switch isn't completed */
        jsonexception2;
        if (true) goto _L10; else goto _L9
_L9:
        JSONException jsonexception1;
        break; /* Loop/switch isn't completed */
        jsonexception1;
        if (true) goto _L11; else goto _L5
_L5:
        j1++;
        if (true) goto _L13; else goto _L12
_L12:
    }
}
