// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseResp;

public class PayResp extends BaseResp
{

    public String extData;
    public String prepayId;
    public String returnKey;

    public PayResp()
    {
    }

    public PayResp(Bundle bundle)
    {
        fromBundle(bundle);
    }

    public boolean checkArgs()
    {
        return true;
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        prepayId = bundle.getString("_wxapi_payresp_prepayid");
        returnKey = bundle.getString("_wxapi_payresp_returnkey");
        extData = bundle.getString("_wxapi_payresp_extdata");
    }

    public int getType()
    {
        return 5;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putString("_wxapi_payresp_prepayid", prepayId);
        bundle.putString("_wxapi_payresp_returnkey", returnKey);
        bundle.putString("_wxapi_payresp_extdata", extData);
    }
}
