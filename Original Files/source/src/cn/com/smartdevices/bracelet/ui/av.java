// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            HealthGoalsActivity

class av extends AsyncHttpResponseHandler
{

    final PersonInfo a;
    final HealthGoalsActivity b;

    av(HealthGoalsActivity healthgoalsactivity, PersonInfo personinfo)
    {
        b = healthgoalsactivity;
        a = personinfo;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        a.setNeedSyncServer(2);
        Keeper.keepPersonInfo(a);
        String s = Utils.getStringFromBytes(abyte0);
        Debug.i("HealthGoalsActivity", (new StringBuilder()).append("fail, statusCode=").append(i).append(", content=").append(s).toString());
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s = Utils.getStringFromBytes(abyte0);
        WebStatus webstatus = WebRes.getWebStatus(s);
        Debug.i("HealthGoalsActivity", (new StringBuilder()).append("statusCode=").append(i).append(", content=").append(s).toString());
        if (webstatus.success())
        {
            HealthGoalsActivity.a(b).clearNeedSyncServer();
        } else
        {
            a.setNeedSyncServer(2);
        }
        Keeper.keepPersonInfo(a);
    }
}
