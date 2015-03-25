// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.a.a.c;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.open:
//            SocialApiIml

class k
    implements IUiListener
{

    final SocialApiIml a;
    private IUiListener b;
    private String c;
    private String d;
    private Bundle e;

    k(SocialApiIml socialapiiml, IUiListener iuilistener, String s, String s1, Bundle bundle)
    {
        a = socialapiiml;
        super();
        b = iuilistener;
        c = s;
        d = s1;
        e = bundle;
    }

    public void onCancel()
    {
        b.onCancel();
    }

    public void onComplete(Object obj)
    {
        JSONObject jsonobject = (JSONObject)obj;
        String s1 = jsonobject.getString("encry_token");
        String s = s1;
_L2:
        e.putString("encrytoken", s);
        SocialApiIml.a(a, SocialApiIml.b(a), c, e, d, b);
        if (TextUtils.isEmpty(s))
        {
            Log.d("miles", "The token get from qq or qzone is empty. Write temp token to localstorage.");
            a.writeEncryToken(com.tencent.open.SocialApiIml.c(a));
        }
        return;
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        com.tencent.a.a.c.a("openSDK_LOG", "OpenApi, EncrytokenListener() onComplete error", jsonexception);
        s = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onError(UiError uierror)
    {
        com.tencent.a.a.c.b("openSDK_LOG", (new StringBuilder()).append("OpenApi, EncryptTokenListener() onError").append(uierror.errorMessage).toString());
        b.onError(uierror);
    }
}
