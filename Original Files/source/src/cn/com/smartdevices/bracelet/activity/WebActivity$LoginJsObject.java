// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.content.Intent;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebRes;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            WebActivity

public class a
{

    final WebActivity a;

    public void callback(String s, String s1)
    {
        Debug.i("WPJ", (new StringBuilder()).append("uid:").append(s).append(",security:").append(s1).toString());
    }

    public void setUserInfo(String s, String s1, String s2, String s3, String s4, String s5)
    {
        boolean flag = true;
        Debug.i("WebActivity", (new StringBuilder()).append("uid:").append(s).append(",security:").append(s1).append(",iconUrl:").append(s2).append(",nick name:").append(s3).append(",has bind:").append(s4).toString());
        Keeper.keepLoginData(Long.parseLong(s), s1);
        Intent intent;
        if (Integer.parseInt(s4) != flag)
        {
            flag = false;
        }
        if (flag)
        {
            Debug.i("WebActivity", (new StringBuilder()).append("userInfo=").append(s5).toString());
            PersonInfo personinfo = Keeper.readPersonInfo();
            WebRes.parseBindedUserInfo(s5, personinfo);
            personinfo.uid = Long.parseLong(s);
            Keeper.keepPersonInfo(personinfo);
        }
        intent = new Intent();
        intent.putExtra("miliao_icon_url", s2);
        intent.putExtra("miliao_nick_name", s3);
        intent.putExtra("miliao_has_binded", flag);
        a.setResult(3, intent);
        a.finish();
    }

    public (WebActivity webactivity)
    {
        a = webactivity;
        super();
    }
}
