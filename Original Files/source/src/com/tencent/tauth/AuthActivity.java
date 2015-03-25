// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.connect.auth.AuthDialog;
import com.tencent.connect.auth.AuthMap;
import com.tencent.utils.TemporaryStorage;
import com.tencent.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.tauth:
//            IUiListener, UiError

public class AuthActivity extends Activity
{

    private static final String a = "action";
    private static final String b = "shareToQQ";
    private static final String c = "shareToQzone";

    public AuthActivity()
    {
    }

    private void a(Uri uri)
    {
        if (uri == null || uri.toString().equals(""))
        {
            finish();
            return;
        }
        String s = uri.toString();
        Bundle bundle = Util.decodeUrl(s.substring(1 + s.indexOf("#")));
        String s1 = bundle.getString("action");
        if (s1 == null)
        {
            a(bundle, s);
            return;
        }
        if (s1.equals("shareToQQ") || s1.equals("shareToQzone"))
        {
            a(bundle);
            return;
        } else
        {
            a(bundle, s);
            return;
        }
    }

    private void a(Bundle bundle)
    {
        IUiListener iuilistener;
        String s;
        String s1;
        Object obj = TemporaryStorage.get(bundle.getString("action"));
        if (obj == null)
        {
            finish();
            return;
        }
        iuilistener = (IUiListener)obj;
        s = bundle.getString("result");
        s1 = bundle.getString("response");
        if (!s.equals("cancel")) goto _L2; else goto _L1
_L1:
        iuilistener.onCancel();
_L4:
        finish();
        return;
_L2:
        if (s.equals("error"))
        {
            iuilistener.onError(new UiError(-6, "unknown error", (new StringBuilder()).append(s1).append("").toString()));
        } else
        if (s.equals("complete"))
        {
            String s2;
            if (s1 == null)
            {
                s2 = "{\"ret\": 0}";
            } else
            {
                s2 = s1;
            }
            try
            {
                iuilistener.onComplete(new JSONObject(s2));
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
                iuilistener.onError(new UiError(-4, "json error", (new StringBuilder()).append(s2).append("").toString()));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Bundle bundle, String s)
    {
        AuthMap authmap = AuthMap.getInstance();
        String s1 = bundle.getString("serial");
        com.tencent.connect.auth.AuthMap.Auth auth = authmap.get(s1);
        if (auth != null)
        {
            if (s.indexOf("://cancel") != -1)
            {
                auth.listener.onCancel();
                auth.dialog.dismiss();
            } else
            {
                String s2 = bundle.getString("access_token");
                if (s2 != null)
                {
                    bundle.putString("access_token", authmap.decode(s2, auth.key));
                }
                String s3 = Util.encodeUrl(bundle);
                JSONObject jsonobject = Util.decodeUrlToJson(new JSONObject(), s3);
                String s4 = jsonobject.optString("cb");
                if (!"".equals(s4))
                {
                    auth.dialog.callJs(s4, jsonobject.toString());
                } else
                {
                    auth.listener.onComplete(jsonobject);
                    auth.dialog.dismiss();
                }
            }
            authmap.remove(s1);
        }
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a(getIntent().getData());
    }
}
