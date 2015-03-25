// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;

import android.os.AsyncTask;
import android.text.TextUtils;
import org.json.JSONObject;

// Referenced classes of package com.umeng.analytics.social:
//            c, d, UMPlatformData

class q extends AsyncTask
{

    String a;
    String b;
    UMSocialService.b c;
    UMPlatformData d[];

    public q(String as[], UMSocialService.b b1, UMPlatformData aumplatformdata[])
    {
        a = as[0];
        b = as[1];
        c = b1;
        d = aumplatformdata;
    }

    protected transient d a(Void avoid[])
    {
        String s;
        JSONObject jsonobject;
        int i;
        int j;
        d d1;
        String s1;
        String s2;
        if (TextUtils.isEmpty(b))
        {
            s = com.umeng.analytics.social.c.a(a);
        } else
        {
            s = com.umeng.analytics.social.c.a(a, b);
        }
        try
        {
            jsonobject = new JSONObject(s);
            i = jsonobject.optInt("st");
        }
        catch (Exception exception)
        {
            return new d(-99, exception);
        }
        if (i == 0)
        {
            j = -404;
        } else
        {
            j = i;
        }
        d1 = new d(j);
        s1 = jsonobject.optString("msg");
        if (!TextUtils.isEmpty(s1))
        {
            d1.a(s1);
        }
        s2 = jsonobject.optString("data");
        if (!TextUtils.isEmpty(s2))
        {
            d1.b(s2);
        }
        return d1;
    }

    protected void a(d d1)
    {
        if (c != null)
        {
            c.a(d1, d);
        }
    }

    protected transient Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((d)obj);
    }

    protected void onPreExecute()
    {
        if (c != null)
        {
            c.a();
        }
    }
}
