// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.wpa;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.HttpUtils;
import java.util.List;

public class WPA extends BaseApi
{

    public WPA(Context context, QQAuth qqauth, QQToken qqtoken)
    {
        super(context, qqauth, qqtoken);
    }

    public WPA(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
    }

    public void getWPAUserOnlineState(String s, IUiListener iuilistener)
    {
        if (s == null)
        {
            try
            {
                throw new Exception("uin null");
            }
            catch (Exception exception) { }
            if (iuilistener != null)
            {
                iuilistener.onError(new UiError(-5, "\u4F20\u5165\u53C2\u6570\u6709\u8BEF!", null));
            }
            return;
        }
        if (s.length() < 5)
        {
            throw new Exception("uin length < 5");
        }
        break MISSING_BLOCK_LABEL_148;
_L3:
        int i;
        if (i >= s.length()) goto _L2; else goto _L1
_L1:
        if (!Character.isDigit(s.charAt(i)))
        {
            throw new Exception("uin not digit");
        }
        i++;
          goto _L3
_L2:
        String s1 = (new StringBuilder()).append("http://webpresence.qq.com/getonline?Type=1&").append(s).append(":").toString();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, s1, null, "GET", temprequestlistener);
        return;
        i = 0;
          goto _L3
    }

    public int startWPAConversation(String s, String s1)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (TextUtils.isEmpty(s))
        {
            return -1;
        }
        if (s.length() < 5)
        {
            return -3;
        }
        for (int i = 0; i < s.length(); i++)
        {
            if (!Character.isDigit(s.charAt(i)))
            {
                return -4;
            }
        }

        String s2 = "";
        if (!TextUtils.isEmpty(s1))
        {
            s2 = Base64.encodeToString(s1.getBytes(), 2);
        }
        intent.setData(Uri.parse(String.format("mqqwpa://im/chat?chat_type=wpa&uin=%1$s&version=1&src_type=app&attach_content=%2$s", new Object[] {
            s, s2
        })));
        PackageManager packagemanager = mContext.getPackageManager();
        if (packagemanager.queryIntentActivities(intent, 0x10000).size() > 0)
        {
            mContext.startActivity(intent);
            return 0;
        }
        intent.setData(Uri.parse("http://www.myapp.com/forward/a/45592?g_f=990935"));
        if (packagemanager.queryIntentActivities(intent, 0x10000).size() > 0)
        {
            mContext.startActivity(intent);
            return 0;
        } else
        {
            return -2;
        }
    }
}
