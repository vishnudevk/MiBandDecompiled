// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;

public class fromBundle extends BaseReq
{

    private static final String a = "MicroMsg.SDK.SendAuth.Req";
    private static final int b = 1024;
    public String scope;
    public String state;

    public boolean checkArgs()
    {
        if (scope == null || scope.length() == 0 || scope.length() > 1024)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, scope is invalid");
            return false;
        }
        if (state != null && state.length() > 1024)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, state is invalid");
            return false;
        } else
        {
            return true;
        }
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        scope = bundle.getString("_wxapi_sendauth_req_scope");
        state = bundle.getString("_wxapi_sendauth_req_state");
    }

    public int getType()
    {
        return 1;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putString("_wxapi_sendauth_req_scope", scope);
        bundle.putString("_wxapi_sendauth_req_state", state);
    }

    public ()
    {
    }

    public (Bundle bundle)
    {
        fromBundle(bundle);
    }
}
