// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.t;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Weibo extends BaseApi
{

    public Weibo(Context context, QQAuth qqauth, QQToken qqtoken)
    {
        super(context, qqauth, qqtoken);
    }

    public Weibo(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
    }

    public void atFriends(int i, IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        bundle.putString("reqnum", (new StringBuilder()).append(i).append("").toString());
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "friends/get_intimate_friends_weibo", bundle, "GET", temprequestlistener);
    }

    public void deleteText(String s, IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        bundle.putString("id", s);
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "t/del_t", bundle, "POST", temprequestlistener);
    }

    public void getWeiboInfo(IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "user/get_info", bundle, "GET", temprequestlistener);
    }

    public void nickTips(String s, int i, IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        if (s == null)
        {
            s = "";
        }
        bundle.putString("match", s);
        bundle.putString("reqnum", (new StringBuilder()).append(i).append("").toString());
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "friends/match_nick_tips_weibo", bundle, "GET", temprequestlistener);
    }

    public void sendPicText(String s, String s1, IUiListener iuilistener)
    {
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        FileInputStream fileinputstream;
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        fileinputstream = new FileInputStream(s1);
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[1024];
_L1:
        int i = fileinputstream.read(abyte0);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            }
            catch (IOException ioexception)
            {
                temprequestlistener.onIOException(ioexception);
                return;
            }
        }
          goto _L1
        byte abyte1[];
        bytearrayoutputstream.close();
        fileinputstream.close();
        abyte1 = bytearrayoutputstream.toByteArray();
        Bundle bundle = composeCGIParams();
        if (s == null)
        {
            s = "";
        }
        bundle.putString("content", s);
        bundle.putByteArray("pic", abyte1);
        HttpUtils.requestAsync(mToken, mContext, "t/add_pic_t", bundle, "POST", temprequestlistener);
        return;
    }

    public void sendText(String s, IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        if (s == null)
        {
            s = "";
        }
        bundle.putString("content", s);
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "t/add_t", bundle, "POST", temprequestlistener);
    }
}
