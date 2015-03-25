// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.text.TextUtils;
import com.tencent.a.a.c;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.auth:
//            AuthAgent

class a
    implements IUiListener
{

    final AuthAgent a;

    a(AuthAgent authagent)
    {
        a = authagent;
        super();
    }

    public void onCancel()
    {
    }

    public void onComplete(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        AuthAgent.e(a);
_L4:
        a.writeEncryToken(AuthAgent.f(a));
        return;
_L2:
        JSONObject jsonobject = (JSONObject)obj;
        String s1 = jsonobject.getString("encry_token");
        String s = s1;
_L5:
        JSONException jsonexception;
        if (!TextUtils.isEmpty(s))
        {
            c.b("openSDK_LOG", "OpenUi, EncrytokenListener() onComplete validToken");
            AuthAgent.a(a, s);
        } else
        {
            c.b("openSDK_LOG", "OpenUi, EncrytokenListener() onComplete relogin");
            AuthAgent.e(a);
        }
        if (true) goto _L4; else goto _L3
_L3:
        jsonexception;
        jsonexception.printStackTrace();
        c.a("openSDK_LOG", "OpenUi, EncrytokenListener() onComplete error", jsonexception);
        s = null;
          goto _L5
    }

    public void onError(UiError uierror)
    {
        c.b("openSDK_LOG", "AuthAgent, EncrytokenListener() onError relogin");
        AuthAgent.e(a);
    }
}
