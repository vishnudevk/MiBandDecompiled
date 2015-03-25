// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.HttpUtils;
import com.tencent.utils.Util;

// Referenced classes of package com.tencent.weiyun:
//            o, j, k, l, 
//            m, n

public class RecordManager extends BaseApi
{

    public RecordManager(Context context, QQAuth qqauth, QQToken qqtoken)
    {
        super(context, qqauth, qqtoken);
    }

    public RecordManager(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
    }

    public void checkRecord(String s, IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, new o(this, iuilistener));
        bundle.putString("key", Util.toHexString(s));
        HttpUtils.requestAsync(mToken, mContext, "https://graph.qq.com/weiyun/check_record", bundle, "GET", temprequestlistener);
    }

    public void createRecord(String s, String s1, IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, new j(this, iuilistener));
        bundle.putString("key", Util.toHexString(s));
        bundle.putByteArray("value", Util.toHexString(s1).getBytes());
        HttpUtils.requestAsync(mToken, mContext, "https://graph.qq.com/weiyun/create_record", bundle, "POST", temprequestlistener);
    }

    public void deleteRecord(String s, IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, new k(this, iuilistener));
        bundle.putString("key", Util.toHexString(s));
        HttpUtils.requestAsync(mToken, mContext, "https://graph.qq.com/weiyun/delete_record", bundle, "GET", temprequestlistener);
    }

    public void getRecord(String s, IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, new l(this, iuilistener));
        bundle.putString("key", Util.toHexString(s));
        HttpUtils.requestAsync(mToken, mContext, "https://graph.qq.com/weiyun/get_record", bundle, "GET", temprequestlistener);
    }

    public void modifyRecord(String s, String s1, IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, new m(this, iuilistener));
        bundle.putString("key", Util.toHexString(s));
        bundle.putByteArray("value", Util.toHexString(s1).getBytes());
        HttpUtils.requestAsync(mToken, mContext, "https://graph.qq.com/weiyun/modify_record", bundle, "POST", temprequestlistener);
    }

    public void queryAllRecord(IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, new n(this, iuilistener));
        HttpUtils.requestAsync(mToken, mContext, "https://graph.qq.com/weiyun/query_all_record", bundle, "GET", temprequestlistener);
    }
}
