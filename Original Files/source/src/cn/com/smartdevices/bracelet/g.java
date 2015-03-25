// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            Debug, Utils, BraceletImageLoader, Keeper

final class g extends AsyncHttpResponseHandler
{

    final PersonInfo a;

    g(PersonInfo personinfo)
    {
        a = personinfo;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Debug.i("Utils", (new StringBuilder()).append("Sync person info to server fail : ").append(abyte0).append(", statusCode ").append(i).append(", error").toString());
        throwable.printStackTrace();
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s = Utils.getStringFromBytes(abyte0);
        Debug.i("Utils", (new StringBuilder()).append("update person info onSuccess:").append(i).append(",content:").append(s).toString());
        String s1 = a.avatarUrl;
        if (WebRes.parseAvatar(s, a).success())
        {
            Debug.i("Utils", (new StringBuilder()).append("update avatar onSuccess:").append(i).append(", avatarUrl=").append(a.avatarUrl).toString());
            BraceletImageLoader.getInstance().removeImageCache(s1);
        }
        a.clearNeedSyncServer();
        Keeper.keepPersonInfo(a);
    }
}
