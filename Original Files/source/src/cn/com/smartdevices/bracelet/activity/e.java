// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.os.AsyncTask;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.LoginInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import com.xiaomi.account.openauth.AuthorizeApi;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            LoginActivity, f

class e extends AsyncTask
{

    final LoginActivity a;

    e(LoginActivity loginactivity)
    {
        a = loginactivity;
        super();
    }

    protected transient String a(Void avoid[])
    {
        String s;
        try
        {
            s = AuthorizeApi.doHttpGet(a, LoginActivity.a(), a.a.longValue(), a.j, a.f, a.g);
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
        Debug.i("LoginActivity", (new StringBuilder()).append("getXiaoMiUserInfo: ").append(s).toString());
        if ("".equals(s) || s == null)
        {
            LoginActivity.g(a);
            CustomToast.makeText(a, 0x7f0d00e2, 1).show();
            return;
        }
        int j = (new JSONObject(s)).getInt("code");
        int i = j;
_L2:
        if (i == 21308)
        {
            LoginActivity.g(a);
            Debug.i("LoginActivity", (new StringBuilder()).append("code =").append(i).toString());
            CustomToast.makeText(a, 0x7f0d00e3, 1).show();
            return;
        }
        break; /* Loop/switch isn't completed */
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        i = -1;
        if (true) goto _L2; else goto _L1
_L1:
        WebRes.parseXiaoMiUserProfile(LoginActivity.h(a), s);
        if (LoginActivity.h(a).miid == null || LoginActivity.h(a).miid.length() <= 0)
        {
            Debug.fi("LoginActivity", "Login miid is empty!");
            CustomToast.makeText(a, 0x7f0d00e2, 1).show();
            return;
        } else
        {
            PersonInfo personinfo = Keeper.readPersonInfo();
            personinfo.nickname = LoginActivity.h(a).miliaoNick;
            Keeper.keepPersonInfo(personinfo);
            WebAPI.sendLoginResult(LoginActivity.h(a), Keeper.readDeviceId(), new f(this));
            return;
        }
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
