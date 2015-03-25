// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;

public class PayReq extends BaseReq
{

    private static final String a = "MicroMsg.PaySdk.PayReq";
    private static final int b = 1024;
    public String appId;
    public String extData;
    public String nonceStr;
    public Options options;
    public String packageValue;
    public String partnerId;
    public String prepayId;
    public String sign;
    public String timeStamp;

    public PayReq()
    {
    }

    public boolean checkArgs()
    {
        if (appId == null || appId.length() == 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid appId");
            return false;
        }
        if (partnerId == null || partnerId.length() == 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid partnerId");
            return false;
        }
        if (prepayId == null || prepayId.length() == 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid prepayId");
            return false;
        }
        if (nonceStr == null || nonceStr.length() == 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid nonceStr");
            return false;
        }
        if (timeStamp == null || timeStamp.length() == 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid timeStamp");
            return false;
        }
        if (packageValue == null || packageValue.length() == 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid packageValue");
            return false;
        }
        if (sign == null || sign.length() == 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid sign");
            return false;
        }
        if (extData != null && extData.length() > 1024)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, extData length too long");
            return false;
        } else
        {
            return true;
        }
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        appId = bundle.getString("_wxapi_payreq_appid");
        partnerId = bundle.getString("_wxapi_payreq_partnerid");
        prepayId = bundle.getString("_wxapi_payreq_prepayid");
        nonceStr = bundle.getString("_wxapi_payreq_noncestr");
        timeStamp = bundle.getString("_wxapi_payreq_timestamp");
        packageValue = bundle.getString("_wxapi_payreq_packagevalue");
        sign = bundle.getString("_wxapi_payreq_sign");
        extData = bundle.getString("_wxapi_payreq_extdata");
        options = new Options();
        options.fromBundle(bundle);
    }

    public int getType()
    {
        return 5;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putString("_wxapi_payreq_appid", appId);
        bundle.putString("_wxapi_payreq_partnerid", partnerId);
        bundle.putString("_wxapi_payreq_prepayid", prepayId);
        bundle.putString("_wxapi_payreq_noncestr", nonceStr);
        bundle.putString("_wxapi_payreq_timestamp", timeStamp);
        bundle.putString("_wxapi_payreq_packagevalue", packageValue);
        bundle.putString("_wxapi_payreq_sign", sign);
        bundle.putString("_wxapi_payreq_extdata", extData);
        if (options != null)
        {
            options.toBundle(bundle);
        }
    }

    private class Options
    {

        public static final int INVALID_FLAGS = -1;
        public String callbackClassName;
        public int callbackFlags;

        public void fromBundle(Bundle bundle)
        {
            callbackClassName = bundle.getString("_wxapi_payoptions_callback_classname");
            callbackFlags = bundle.getInt("_wxapi_payoptions_callback_flags", -1);
        }

        public void toBundle(Bundle bundle)
        {
            bundle.putString("_wxapi_payoptions_callback_classname", callbackClassName);
            bundle.putInt("_wxapi_payoptions_callback_flags", callbackFlags);
        }

        public Options()
        {
            callbackFlags = -1;
        }
    }

}
