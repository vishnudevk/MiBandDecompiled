// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.HttpUtils;

public class UserInfo extends BaseApi
{

    public static final String GRAPH_OPEN_ID = "oauth2.0/m_me";

    public UserInfo(Context context, QQAuth qqauth, QQToken qqtoken)
    {
        super(context, qqauth, qqtoken);
    }

    public UserInfo(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
    }

    public void getOpenId(IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "oauth2.0/m_me", bundle, "GET", temprequestlistener);
    }

    public void getTenPayAddr(IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        bundle.putString("ver", "1");
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "cft_info/get_tenpay_addr", bundle, "GET", temprequestlistener);
    }

    public void getUserInfo(IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "user/get_simple_userinfo", bundle, "GET", temprequestlistener);
    }

    public void getVipUserInfo(IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "user/get_vip_info", bundle, "GET", temprequestlistener);
    }

    public void getVipUserRichInfo(IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "user/get_vip_rich_info", bundle, "GET", temprequestlistener);
    }
}
