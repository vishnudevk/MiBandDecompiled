// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            e, LoginActivity

class f extends AsyncHttpResponseHandler
{

    final e a;

    f(e e1)
    {
        a = e1;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        String s = Utils.getStringFromBytes(abyte0);
        Debug.fi("LoginActivity", (new StringBuilder()).append("fail, content =").append(s).append(" statusCode=").append(i).toString());
        LoginActivity.i(a.a);
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s;
        WebStatus webstatus;
        s = Utils.getStringFromBytes(abyte0);
        Debug.i("LoginActivity", (new StringBuilder()).append("login result content =").append(s).toString());
        webstatus = WebRes.getWebStatus(s);
        if (webstatus.success()) goto _L2; else goto _L1
_L1:
        CustomToast.makeText(a.a, (new StringBuilder()).append(a.a.getString(0x7f0d00e2)).append("\uFF0C").append(a.a.getString(0x7f0d0091)).append(":").append(webstatus.code).toString(), 1).show();
        LoginActivity.g(a.a);
        Debug.fi("LoginActivity", (new StringBuilder()).append("Login webstatus fail, code = ").append(webstatus.code).toString());
_L4:
        return;
_L2:
        JSONObject jsonobject;
        Long long1;
        boolean flag;
        PersonInfo personinfo;
        try
        {
            jsonobject = (new JSONObject(s)).optJSONObject("data");
        }
        catch (Exception exception)
        {
            Debug.fi("LoginActivity", (new StringBuilder()).append("Catched exception: ").append(exception).toString());
            exception.printStackTrace();
            LoginActivity.i(a.a);
            return;
        }
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        long1 = Long.valueOf(Long.parseLong(jsonobject.optString("userid")));
        String s1 = jsonobject.optString("security");
        Keeper.keepLoginData(long1.longValue(), s1);
        if (jsonobject.optString("hasBinded").equals("1"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        personinfo = Keeper.readPersonInfo();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        personinfo = WebRes.parseBindedUserInfo(jsonobject.toString(), personinfo);
        personinfo.uid = long1.longValue();
        Keeper.keepPersonInfo(personinfo);
        LoginActivity.a(a.a, flag);
        return;
    }
}
