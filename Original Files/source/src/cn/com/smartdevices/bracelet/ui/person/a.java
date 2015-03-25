// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui.person;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet.ui.person:
//            PersonInfoSetSportGoalActivity

class a extends AsyncHttpResponseHandler
{

    final PersonInfo a;
    final PersonInfoSetSportGoalActivity b;

    a(PersonInfoSetSportGoalActivity personinfosetsportgoalactivity, PersonInfo personinfo)
    {
        b = personinfosetsportgoalactivity;
        a = personinfo;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        String s = Utils.getStringFromBytes(abyte0);
        Debug.i("PersonInfoSetSportGoalActivity", (new StringBuilder()).append("statusCode=").append(i).append(", content=").append(s).toString());
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s = Utils.getStringFromBytes(abyte0);
        if (WebRes.getWebStatus(s).success())
        {
            a.clearNeedSyncServer();
            Keeper.keepPersonInfo(a);
            return;
        } else
        {
            Debug.i("PersonInfoSetSportGoalActivity", (new StringBuilder()).append("statusCode=").append(i).append(", content=").append(s).toString());
            return;
        }
    }
}
