// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.a.a.c;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.utils.HttpUtils;
import com.tencent.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.tauth:
//            LbsAgent, a, IUiListener, e, 
//            c, b

public class LocationApi extends BaseApi
    implements LbsAgent.OnGetLocationListener
{

    private static final String a = "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_getnear.cgi";
    private static final String b = "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_delete.cgi";
    private static final int c = 101;
    private static final int d = 103;
    private static final int e = 104;
    private static final String f = "search_nearby";
    private static final String g = "delete_location";
    private static final String h = "id_search_nearby";
    private static final String i = "id_delete_location";
    private static final int j = 1;
    private HandlerThread k;
    private Handler l;
    private Handler m;
    private LbsAgent n;
    private Bundle o;
    private IUiListener p;

    public LocationApi(Context context, QQAuth qqauth, QQToken qqtoken)
    {
        super(context, qqauth, qqtoken);
        a();
    }

    public LocationApi(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
        a();
    }

    static Context a(LocationApi locationapi)
    {
        return locationapi.mContext;
    }

    private void a()
    {
        n = new LbsAgent();
        k = new HandlerThread("get_location");
        k.start();
        l = new Handler(k.getLooper());
        m = new a(this, mContext.getMainLooper());
    }

    private void a(int i1, String s)
    {
        n.removeUpdate();
        if (p == null)
        {
            return;
        }
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("ret", i1);
            jsonobject.put("errMsg", s);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        p.onComplete(jsonobject);
    }

    private void a(Location location)
    {
        com.tencent.a.a.c.b("openSDK_LOG", (new StringBuilder()).append("location: search mParams: ").append(o).toString());
        Bundle bundle;
        String s;
        String s1;
        e e1;
        if (o != null)
        {
            bundle = new Bundle(o);
            bundle.putAll(composeCGIParams());
        } else
        {
            bundle = composeCGIParams();
        }
        s = String.valueOf(location.getLatitude());
        s1 = String.valueOf(location.getLongitude());
        bundle.putString("appid", mToken.getAppId());
        if (!bundle.containsKey("latitude"))
        {
            bundle.putString("latitude", s);
        }
        if (!bundle.containsKey("longitude"))
        {
            bundle.putString("longitude", s1);
        }
        if (!bundle.containsKey("page"))
        {
            bundle.putString("page", String.valueOf(1));
        }
        bundle.putString("encrytoken", Util.encrypt((new StringBuilder()).append("tencent&sdk&qazxc***14969%%").append(mToken.getAccessToken()).append(mToken.getAppId()).append(mToken.getOpenId()).append("qzone3.4").toString()));
        com.tencent.a.a.c.b("openSDK_LOG", (new StringBuilder()).append("location: search params: ").append(bundle).toString());
        e1 = new e(this, p);
        HttpUtils.requestAsync(mToken, mContext, "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_getnear.cgi", bundle, "GET", e1);
    }

    static void a(LocationApi locationapi, int i1, String s)
    {
        locationapi.a(i1, s);
    }

    private transient void a(String s, String as[])
    {
        l.post(new com.tencent.tauth.c(this, as, s));
    }

    static LbsAgent b(LocationApi locationapi)
    {
        return locationapi.n;
    }

    static Handler c(LocationApi locationapi)
    {
        return locationapi.m;
    }

    private void c()
    {
        n.removeUpdate();
    }

    static Context d(LocationApi locationapi)
    {
        return locationapi.mContext;
    }

    private boolean d()
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)mContext.getSystemService("connectivity");
        if (connectivitymanager != null)
        {
            NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
            return networkinfo != null && networkinfo.isAvailable();
        } else
        {
            return false;
        }
    }

    static QQToken e(LocationApi locationapi)
    {
        return locationapi.mToken;
    }

    private JSONObject e()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("ret", -9);
            jsonobject.put("errMsg", "\u7F51\u7EDC\u8FDE\u63A5\u5F02\u5E38\uFF0C\u8BF7\u68C0\u67E5\u540E\u91CD\u8BD5!");
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    public void deleteLocation(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        if (!d())
        {
            if (iuilistener != null)
            {
                iuilistener.onComplete(e());
            }
            return;
        }
        Bundle bundle1;
        e e1;
        if (bundle != null)
        {
            bundle1 = new Bundle(bundle);
            bundle1.putAll(composeCGIParams());
        } else
        {
            bundle1 = composeCGIParams();
        }
        bundle1.putString("appid", mToken.getAppId());
        bundle1.putString("timestamp", String.valueOf(System.currentTimeMillis()));
        bundle1.putString("encrytoken", Util.encrypt((new StringBuilder()).append("tencent&sdk&qazxc***14969%%").append(mToken.getAccessToken()).append(mToken.getAppId()).append(mToken.getOpenId()).append("qzone3.4").toString()));
        com.tencent.a.a.c.b("openSDK_LOG", (new StringBuilder()).append("location: delete params: ").append(bundle1).toString());
        e1 = new e(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_delete.cgi", bundle1, "GET", e1);
        a("delete_location", new String[] {
            "success"
        });
    }

    public void onLocationUpdate(Location location)
    {
        a(location);
        c();
        m.removeMessages(101);
    }

    public void searchNearby(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        if (!d())
        {
            if (iuilistener != null)
            {
                iuilistener.onComplete(e());
            }
            return;
        } else
        {
            o = bundle;
            p = iuilistener;
            l.post(new b(this));
            return;
        }
    }
}
