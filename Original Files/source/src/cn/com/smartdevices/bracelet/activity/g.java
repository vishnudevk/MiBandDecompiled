// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import com.xiaomi.account.openauth.AuthorizeApi;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            LoginActivity

class g extends AsyncTask
{

    final LoginActivity a;

    g(LoginActivity loginactivity)
    {
        a = loginactivity;
        super();
    }

    protected transient String a(Void avoid[])
    {
        String s;
        try
        {
            s = AuthorizeApi.doHttpGet(a, LoginActivity.b(), a.a.longValue(), a.j, a.f, a.g);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return "";
        }
        return s;
    }

    protected void a(String s)
    {
        super.onPostExecute(s);
        Debug.i("LoginActivity", (new StringBuilder()).append("get user phone: ").append(s).toString());
        LoginActivity.a(a, WebRes.parseXiaoMiUserPhone(s));
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }
}
