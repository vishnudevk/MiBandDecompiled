// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.xiaomi.market.sdk:
//            w, XiaomiUpdateAgent, a, s, 
//            q, u, c, j, 
//            h, g, UpdateResponse, XiaomiUpdateListener, 
//            v, Patcher

class t extends AsyncTask
{

    private t()
    {
    }

    t(t t1)
    {
        this();
    }

    private w a(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            Log.e("MarketUpdateAgent", "update info json obj null");
            return null;
        }
        w w1 = new w();
        try
        {
            w1.a = jsonobject.getString("host");
            w1.b = jsonobject.getInt("fitness");
            w1.c = jsonobject.getString("updateLog");
            w1.d = jsonobject.getInt("versionCode");
            w1.e = jsonobject.getString("versionName");
            w1.f = jsonobject.getString("apk");
            w1.g = jsonobject.getString("apkHash");
            w1.h = jsonobject.getLong("apkSize");
            w1.l = jsonobject.optInt("source", 0);
            if (XiaomiUpdateAgent.d())
            {
                w1.i = jsonobject.getString("diffFile");
                w1.j = jsonobject.getString("diffFileHash");
                w1.k = jsonobject.getLong("diffFileSize");
            }
        }
        catch (JSONException jsonexception)
        {
            Log.e("MarketUpdateAgent", (new StringBuilder("get update info failed : ")).append(jsonexception.toString()).toString());
            Log.e("MarketUpdateAgent", (new StringBuilder("original content : ")).append(jsonobject.toString()).toString());
            return null;
        }
        return w1;
    }

    static void a()
    {
        c();
    }

    private String b()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("screenSize", (new StringBuilder(String.valueOf(a.b))).append("*").append(a.c).toString());
            jsonobject.put("resolution", a.d);
            jsonobject.put("density", a.e);
            jsonobject.put("touchScreen", a.f);
            jsonobject.put("glEsVersion", a.g);
            jsonobject.put("feature", a.h);
            jsonobject.put("library", a.i);
            jsonobject.put("glExtension", a.j);
            jsonobject.put("sdk", a.k);
            jsonobject.put("version", a.l);
            jsonobject.put("release", a.m);
            jsonobject.put("imei", a.n);
        }
        catch (JSONException jsonexception)
        {
            return "";
        }
        return jsonobject.toString();
    }

    private static void c()
    {
        if ((XiaomiUpdateAgent.b() instanceof Activity) && ((Activity)XiaomiUpdateAgent.b()).isFinishing())
        {
            Log.e("MarketUpdateAgent", "activity not running!");
            return;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(XiaomiUpdateAgent.b());
        Context context = XiaomiUpdateAgent.b();
        int i = s.a(XiaomiUpdateAgent.b().getPackageName(), "string", "xiaomi_update_dialog_title");
        Object aobj[] = new Object[1];
        aobj[0] = XiaomiUpdateAgent.c().aU;
        android.app.AlertDialog.Builder builder1 = builder.setTitle(context.getString(i, aobj));
        String s1;
        if (TextUtils.isEmpty(XiaomiUpdateAgent.f().i))
        {
            Context context2 = XiaomiUpdateAgent.b();
            int l = s.a(XiaomiUpdateAgent.b().getPackageName(), "string", "xiaomi_update_dialog_message");
            Object aobj2[] = new Object[2];
            aobj2[0] = XiaomiUpdateAgent.f().e;
            aobj2[1] = s.a(XiaomiUpdateAgent.f().h, XiaomiUpdateAgent.b());
            s1 = context2.getString(l, aobj2);
        } else
        {
            Context context1 = XiaomiUpdateAgent.b();
            int k = s.a(XiaomiUpdateAgent.b().getPackageName(), "string", "xiaomi_update_dialog_message_diff");
            Object aobj1[] = new Object[2];
            aobj1[0] = XiaomiUpdateAgent.f().e;
            aobj1[1] = s.a(XiaomiUpdateAgent.f().k, XiaomiUpdateAgent.b());
            s1 = context1.getString(k, aobj1);
        }
        builder1.setMessage(s1).setNegativeButton(0x1040000, null).setPositiveButton(0x104000a, new u()).show();
    }

    protected transient Integer a(Void avoid[])
    {
        if (!s.c(XiaomiUpdateAgent.b()))
        {
            return Integer.valueOf(3);
        }
        if (!s.d(XiaomiUpdateAgent.b()) && XiaomiUpdateAgent.e())
        {
            return Integer.valueOf(2);
        }
        com.xiaomi.market.sdk.a.a(XiaomiUpdateAgent.b());
        XiaomiUpdateAgent.a(XiaomiUpdateAgent.a(XiaomiUpdateAgent.b()));
        if (XiaomiUpdateAgent.c() == null)
        {
            return Integer.valueOf(5);
        }
        c c1 = new c(j.V);
        c1.getClass();
        h h1 = new h(c1);
        h1.d("info", b());
        h1.d("packageName", XiaomiUpdateAgent.c().packageName);
        h1.d("versionCode", (new StringBuilder(String.valueOf(XiaomiUpdateAgent.c().versionCode))).toString());
        h1.d("apkHash", XiaomiUpdateAgent.c().aW);
        h1.d("signature", XiaomiUpdateAgent.c().aV);
        h1.d("clientId", a.o);
        h1.d("sdk", String.valueOf(a.k));
        h1.d("os", a.l);
        h1.d("la", a.p);
        h1.d("co", a.q);
        h1.d("xiaomiSDKVersion", "0");
        if (g.I == c1.h())
        {
            JSONObject jsonobject = c1.e();
            if (s.b)
            {
                Log.d("MarketUpdateAgent", jsonobject.toString());
            }
            XiaomiUpdateAgent.a(a(jsonobject));
            if (XiaomiUpdateAgent.f() != null)
            {
                Log.i("MarketUpdateAgent", XiaomiUpdateAgent.f().toString());
                int i;
                if (XiaomiUpdateAgent.f().b == 0)
                {
                    i = 0;
                } else
                {
                    i = 1;
                }
                return Integer.valueOf(i);
            }
        }
        return Integer.valueOf(4);
    }

    protected void a(Integer integer)
    {
        if (!XiaomiUpdateAgent.g())
        {
            UpdateResponse updateresponse = new UpdateResponse();
            if (integer.intValue() == 0)
            {
                updateresponse.updateLog = XiaomiUpdateAgent.f().c;
                updateresponse.versionCode = XiaomiUpdateAgent.f().d;
                updateresponse.versionName = XiaomiUpdateAgent.f().e;
                updateresponse.path = com.xiaomi.market.sdk.c.c(XiaomiUpdateAgent.f().a, XiaomiUpdateAgent.f().f);
            }
            if (XiaomiUpdateAgent.h() != null)
            {
                XiaomiUpdateAgent.h().onUpdateReturned(integer.intValue(), updateresponse);
            }
            return;
        }
        switch (integer.intValue())
        {
        default:
            return;

        case 0: // '\0'
            (new v(null)).execute(new Void[0]);
            break;
        }
    }

    protected transient Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Integer)obj);
    }

    protected void onPreExecute()
    {
        Log.d("MarketUpdateAgent", "start to check update");
        if (!XiaomiUpdateAgent.d())
        {
            XiaomiUpdateAgent.a(Patcher.o());
        }
    }
}
