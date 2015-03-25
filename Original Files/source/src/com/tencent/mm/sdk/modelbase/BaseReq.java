// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelbase;

import android.os.Bundle;

public abstract class BaseReq
{

    public String openId;
    public String transaction;

    public BaseReq()
    {
    }

    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle)
    {
        transaction = bundle.getString("_wxapi_basereq_transaction");
        openId = bundle.getString("_wxapi_basereq_openid");
    }

    public abstract int getType();

    public void toBundle(Bundle bundle)
    {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putString("_wxapi_basereq_transaction", transaction);
        bundle.putString("_wxapi_basereq_openid", openId);
    }
}
