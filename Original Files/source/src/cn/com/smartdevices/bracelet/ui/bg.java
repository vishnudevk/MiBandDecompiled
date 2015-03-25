// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            PersonInfoFragment

class bg extends AsyncHttpResponseHandler
{

    final PersonInfoFragment a;

    bg(PersonInfoFragment personinfofragment)
    {
        a = personinfofragment;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        String s = Utils.getStringFromBytes(abyte0);
        Debug.i("WPJ", (new StringBuilder()).append("onFailure statusCode:").append(i).append(",content:").append(s).toString());
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s = Utils.getStringFromBytes(abyte0);
        Debug.i("PersonInfoFragment", (new StringBuilder()).append("get person info onSuccess statusCode:").append(i).append(",content:").append(s).toString());
        if (!WebRes.parseUserInfo(s, PersonInfoFragment.a(a)).success())
        {
            return;
        }
        Debug.i("PersonInfoFragment", (new StringBuilder()).append("person info :").append(PersonInfoFragment.a(a).toString()).toString());
        if (PersonInfoFragment.a(a).uid == Keeper.readLoginData().uid)
        {
            Keeper.keepPersonInfo(PersonInfoFragment.a(a));
        }
        PersonInfoFragment.b(a);
    }
}
