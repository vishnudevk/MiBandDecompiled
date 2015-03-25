// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseResp;

public class fromBundle extends BaseResp
{

    private static final String a = "MicroMsg.SDK.SendAuth.Resp";
    private static final int b = 1024;
    public String code;
    public String country;
    public String lang;
    public String state;
    public String url;

    public boolean checkArgs()
    {
        if (state != null && state.length() > 1024)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.SendAuth.Resp", "checkArgs fail, state is invalid");
            return false;
        } else
        {
            return true;
        }
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        code = bundle.getString("_wxapi_sendauth_resp_token");
        state = bundle.getString("_wxapi_sendauth_resp_state");
        url = bundle.getString("_wxapi_sendauth_resp_url");
        lang = bundle.getString("_wxapi_sendauth_resp_lang");
        country = bundle.getString("_wxapi_sendauth_resp_country");
    }

    public int getType()
    {
        return 1;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putString("_wxapi_sendauth_resp_token", code);
        bundle.putString("_wxapi_sendauth_resp_state", state);
        bundle.putString("_wxapi_sendauth_resp_url", url);
        bundle.putString("_wxapi_sendauth_resp_lang", lang);
        bundle.putString("_wxapi_sendauth_resp_country", country);
    }

    public ()
    {
    }

    public (Bundle bundle)
    {
        fromBundle(bundle);
    }
}
